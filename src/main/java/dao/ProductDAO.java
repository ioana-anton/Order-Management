package dao;

import connection.ConnectionFactory;
import model.Product;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

public class ProductDAO extends AbstractDAO<Product>{

    private String createQuantityUpdateQuery(Product p) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE product SET quantity="+p.getQuantity()+" WHERE id="+p.getId());
        return sb.toString();
    }

    public Product updateQuantity(Product p) {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createQuantityUpdateQuery(p);
        int ok = -1;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            ok = statement.executeUpdate();
            return p;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Product DAO:updateQuantity " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
