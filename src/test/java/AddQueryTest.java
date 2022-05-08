import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import model.*;
import bll.*;
public class AddQueryTest {
    //Insert Client Test
    @Test
    public void insertClientTest() {

        Client c1=new Client("Alexandra","adresaAlexandra", "dummyaddressAlexandra@yahoo.com");
        ClientBLL clientBLL=new ClientBLL();
        try{
        clientBLL.getValidators().get(0).validate(c1);
        Client c2=clientBLL.insertClient(c1);
        assertTrue(c1.equalClient(c2),"The result of the insert query is correct.");
    }catch(IllegalArgumentException exception){
        System.out.println("Adresa de email nu este buna! ");
    }
    }

    //Insert Gresita Client Test
    @Test
    public void insertClientTestWrong() {

        Client c1=new Client("Alexandra","adresaAlexandra", "dummyaddressAlexandrayaho");
        ClientBLL clientBLL=new ClientBLL();
        try {
            clientBLL.getValidators().get(0).validate(c1);
            Client c2=clientBLL.insertClient(c1);
            assertTrue(c1.equalClient(c2),"The result of the insert query is correct.");
        }catch(IllegalArgumentException exception){
            System.out.println("Adresa de email nu este buna! ");
        }

    }

    //Insert Product Test
    @Test
    public void insertProductTest() {

        Product p1=new Product("Calculator",15);
        ProductBLL productBLL=new ProductBLL();
        //poate pentru min quantity
        //try{
            //productBLL.getValidators().get(0).validate(p1);
            Product c2=productBLL.insertProduct(p1);
            assertTrue(p1.equalProduct(c2),"The result of the insert query is correct.");
       // }catch(IllegalArgumentException exception){
        //    System.out.println("Adresa de email nu este buna! ");
        //}
    }

    //Stergere Client Test
    @Test
    public void deleteClientTest() {

        ClientBLL clientBLL=new ClientBLL();;
            int ok=clientBLL.deleteClient(2);
            assertTrue(ok!=0,"The result of the delete query is correct.");
    }

    //Actualizare Client Test
    public void updateClientTest() {

        Client c=new Client(3,"Sofia","adresa","dummyemailaddress@yahoo.com");
        ClientBLL clientBLL=new ClientBLL();;
        Client ok=clientBLL.updateClient(c);
        assertTrue(ok!=null,"The result of the update query is correct.");
    }

}
