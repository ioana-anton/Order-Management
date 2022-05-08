package bll;

import dao.OrderDAO;
import model.Comanda;

import java.util.NoSuchElementException;

public class OrderBLL {
    private OrderDAO orderDAO;

    public OrderBLL() {
        orderDAO = new OrderDAO();
    }

    public Comanda insertOrder(Comanda c) {
        Comanda cl = orderDAO.insert(c);
        if (cl == null) {
            throw new NoSuchElementException("Couldn't insert order. ");
        }else
            System.out.println("Comanda adaugata: id: "+ cl.getId()+" idClient: "+cl.getIdClient());
        return cl;
    }
}
