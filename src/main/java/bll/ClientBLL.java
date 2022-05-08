package bll;

import bll.validators.EmailValidator;
import bll.validators.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import model.Client;
import dao.ClientDAO;

public class ClientBLL {
    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());

        clientDAO = new ClientDAO();
    }

    public List<Validator<Client>> getValidators() {
        return validators;
    }

    public Client insertClient(Client c) {
        Client cl = clientDAO.insert(c);
        if (cl == null) {
            throw new NoSuchElementException("Couldn't insert client. ");
        }else
            System.out.println("Clientul adaugat: id: "+ cl.getId()+" nume: "+cl.getName()+" address: "+cl.getAddress()+" email: "+cl.getEmail());
        return cl;
    }

    public Client updateClient(Client c) {
        Client cl = clientDAO.update(c);
        if (cl == null) {
            throw new NoSuchElementException("Couldn't update client. ");
        }else
            System.out.println("Clientul actualizat: id: "+ cl.getId()+" nume: "+cl.getName()+" address: "+cl.getAddress()+" email: "+cl.getEmail());
        return cl;
    }

    public int deleteClient(int id) {
        int deletedClientId = clientDAO.delete(id);
        if (deletedClientId == 0) {
            throw new NoSuchElementException("Couldn't delete client. ");
        }else
            System.out.println("Clientul a fost sters cu succes.");
        return deletedClientId;
    }

    public List<String> getColumnNames(){
        return clientDAO.getColumnNames();
    }

    public List<Client> getRows(){
        return clientDAO.findAll();
    }

}
