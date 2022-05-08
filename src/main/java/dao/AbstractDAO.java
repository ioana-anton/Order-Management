package dao;

import java.beans.*;
import java.lang.*;
import java.lang.reflect.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

import connection.ConnectionFactory;

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO(){

        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    private String createSelectAllQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * @use Echivalentul lui SELECT * FROM ;
     * @return O lista cu toate obiectele din tabel
     * @throws SQLException
     */
    public List<T> findAll() {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     *
     * @param id
     * @use Utilizat pentru gasirea unui obiect in tabel dupa id
     * @return
     * @throws SQLException
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();

        try {
            while (resultSet.next()) {
                T instance = type.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    Object value = resultSet.getObject(field.getName());
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String createInsertQuery(T t) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(type.getSimpleName());//numele tabelului
        sb.append(" (");
        int i = 0;
        for (Field field : type.getDeclaredFields()) {
            if (i != 0)
                sb.append(field.getName() + ",");
            else i = 1;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(") VALUES (");
        i = 0;
        try {
            for (Field field : type.getDeclaredFields()) {
                if (i != 0) {
                    field.setAccessible(true);
                    Object value = field.get(t);
                    if(field.getType().toString().compareToIgnoreCase("class java.lang.String")==0)
                     sb.append("\"" + value + "\",");
                    else
                        sb.append(value+",");
                } else i = 1;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        System.out.println(sb);
        return sb.toString();
    }

    private String createSelectMaxId(T t) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT max(id) FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     *
     * @param t
     * @use Gasirea ultimului id din tabel
     * @return maxId
     */
    private int findMaxId(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectMaxId(t);
        int id = 0;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next())
                id = resultSet.getInt(1);
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return 0;
    }


    /**
     * @param t
     * @use metoda pentru inserarea unui nou rand in tabel
     * @return se returneaza obiectul inserat cu succes sau nu in caz de eroare
     * @throws SQLException
     */
    public T insert(T t) {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createInsertQuery(t);
        int ok = -1;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            ok = statement.executeUpdate();
            if (ok > 0) {
                int id = findMaxId(t);
                for (Field field : type.getDeclaredFields()) {
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(t, id);
                    break;
                }
            }
            return t;
        } catch (SQLException | IntrospectionException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }


    private String createUpdateQuery(T t) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE " + type.getSimpleName() + " SET ");
        int i = 0;
        int id=0;
        try {
            for (Field field : type.getDeclaredFields()) {
                if (i != 0) {
                    field.setAccessible(true);
                    if(field.getType().toString().compareToIgnoreCase("class java.lang.String")==0)
                    sb.append(field.getName() + "= \"" + field.get(t)+"\",");
                    else
                        sb.append(field.getName() + "= " + field.get(t)+",");
                } else{
                    field.setAccessible(true);
                    id=field.getInt(t);
                    i = 1;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" WHERE id="+id);
        return sb.toString();
    }


    /**
     *
     * @param t
     * @use utilizat pentru a modifica un rand din tabela
     * @return se va returna obiectul modificat sau null in caz de eroare
     * @throws SQLException
     */
    public T update(T t) {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createUpdateQuery(t);
        int ok = -1;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            ok = statement.executeUpdate();
            return t;
        } catch (SQLException  e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private String createDeleteQuery(int id){
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM "+type.getSimpleName()+" WHERE id="+id);
        return sb.toString();
    }

    /**
     *
     * @param id
     * @use Stergerea unui rand din tabel, dupa id
     * @return cate randuri au fost modificate; 0= esec
     * @throws SQLException
     */
    public int delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery(id);
        int ok;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            ok = statement.executeUpdate();
            return ok;
        } catch (SQLException  e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return 0;
    }

    /**
     * @use metoda prin care se construieste header ul tabelului pentru a fi afisat in JTable
     * @return
     */
    public List<String> getColumnNames(){
        List<String> columnNames=new ArrayList<String>();
        for(Field field:type.getDeclaredFields()){
            columnNames.add(field.getName());
        }
        return columnNames;
    }
}
