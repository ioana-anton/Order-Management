package bll;

import dao.OrderProductDAO;
import model.ComandaProdus;

import java.util.NoSuchElementException;

public class OrderProductBLL {

    private OrderProductDAO orderProductDAO;

   public OrderProductBLL(){
        orderProductDAO=new OrderProductDAO();
    }

    public ComandaProdus insertProduct(ComandaProdus c) {
        ComandaProdus cl = orderProductDAO.insert(c);
        if (cl == null) {
            throw new NoSuchElementException("Couldn't insert order product. ");
        }
        return cl;
    }
}
