package bll;

import dao.ProductDAO;
import model.Client;
import model.Product;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {

    private ProductDAO productDAO;
    public ProductBLL(){
        productDAO=new ProductDAO();
    }



    public Product updateProductQuantity(Product p) {
        Product pr = productDAO.updateQuantity(p);
        if (pr == null) {
            throw new NoSuchElementException("Couldn't update product. ");
        }//else
           // System.out.println("Produsul adaugat: id: "+ pr.getId()+" nume: "+pr.getName()+" cantitate: "+pr.getQuantity());
        return pr;
    }

    public Product insertProduct(Product p) {
        Product pr = productDAO.insert(p);
        if (pr == null) {
            throw new NoSuchElementException("Couldn't insert product. ");
        }else
            System.out.println("Produsul adaugat: id: "+ pr.getId()+" nume: "+pr.getName()+" cantitate: "+pr.getQuantity());
        return pr;
    }

    public Product findByIdProduct(int id) {
        Product pr = productDAO.findById(id);
        if (pr == null) {
            throw new NoSuchElementException("Couldn't find product. ");
        }//else
           // System.out.println("Produsul adaugat: id: "+ pr.getId()+" nume: "+pr.getName()+" cantitate: "+pr.getQuantity());
        return pr;
    }

    public Product updateProduct(Product p) {
        Product pr = productDAO.update(p);
        if (pr == null) {
            throw new NoSuchElementException("Couldn't update product. ");
        }else
            System.out.println("Produsul modificat: id: "+ pr.getId()+" nume: "+pr.getName()+" cantitate: "+pr.getQuantity());
        return pr;
    }

    public int deleteProduct(int id) {
        int pr = productDAO.delete(id);
        if (pr == 0) {
            throw new NoSuchElementException("Couldn't delete product. ");
        }
        return pr;
    }

    public List<String> getColumnNames(){
        return productDAO.getColumnNames();
    }

    public List<Product> getRows(){
        return productDAO.findAll();
    }

}
