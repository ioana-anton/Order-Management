package start;

import presentation.client.DeleteClientGUI;
import presentation.client.InsertClientGUI;
import presentation.*;
import presentation.client.UpdateClientGUI;
import presentation.product.DeleteProductGUI;
import presentation.product.InsertProductGUI;
import presentation.product.UpdateProductGUI;

public class Start {
    public static void main(String[] args) {
        HomepageGUI homepageGUI=new HomepageGUI();

        //client GUI
        ClientGUI clientGUI=new ClientGUI();
        InsertClientGUI insertGui=new InsertClientGUI();
        UpdateClientGUI updateClientGUI=new UpdateClientGUI();
        DeleteClientGUI deleteClientGUI=new DeleteClientGUI();


        //Product GUI
        InsertProductGUI insertProductGUI=new InsertProductGUI();
        UpdateProductGUI updateProductGUI=new UpdateProductGUI();
        DeleteProductGUI deleteProductGUI=new DeleteProductGUI();
        ProductGUI productGUI=new ProductGUI();

        //OrderGUI
        OrderGUI orderGUI=new OrderGUI();


        Controller controller=new Controller(homepageGUI,orderGUI,insertGui,updateClientGUI,deleteClientGUI,clientGUI,insertProductGUI,updateProductGUI,deleteProductGUI,productGUI);

        //client
        //insertGui.setVisible(true);
        //updateClientGUI.setVisible(true);
        // deleteClientGUI.setVisible(true);
        //clientGUI.setVisible(true);

        //product
       //insertProductGUI.setVisible(true);
        //updateProductGUI.setVisible(true);
       // deleteProductGUI.setVisible(true);
       // productGUI.setVisible(true);

        homepageGUI.setVisible(true);
    }
}
