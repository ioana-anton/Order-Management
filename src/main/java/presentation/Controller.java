package presentation;

import bll.*;
import model.*;

import presentation.client.*;
import presentation.product.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.NoSuchElementException;

public class Controller {

    private HomepageGUI homepageGUI;
    private InsertClientGUI insertClientGUI;
    private UpdateClientGUI updateClientGUI;
    private DeleteClientGUI deleteClientGUI;
    private InsertProductGUI insertProductGUI;
    private UpdateProductGUI updateProductGUI;
    private DeleteProductGUI deleteProductGUI;
    private ClientGUI clientGUI;
    private ProductGUI productGUI;
    private OrderGUI orderGUI;
    private Client client = new Client();
    private Product product = new Product();
    private Comanda comanda = new Comanda();
    private ComandaProdus comandaprodus = new ComandaProdus();
    private ClientBLL clientBLL = new ClientBLL();
    private ProductBLL productBLL = new ProductBLL();
    private OrderBLL orderBLL = new OrderBLL();
    private OrderProductBLL orderProductBLL = new OrderProductBLL();

    public Controller(HomepageGUI homepageGUI, OrderGUI orderGUI, InsertClientGUI insertClientGUI, UpdateClientGUI updateClientGUI, DeleteClientGUI deleteClientGUI, ClientGUI clientGUI, InsertProductGUI insertProductGUI, UpdateProductGUI updateProductGUI, DeleteProductGUI deleteProductGUI, ProductGUI productGUI) {
        this.insertClientGUI = insertClientGUI;
        this.updateClientGUI = updateClientGUI;
        this.deleteClientGUI = deleteClientGUI;
        this.clientGUI = clientGUI;
        this.insertProductGUI = insertProductGUI;
        this.updateProductGUI = updateProductGUI;
        this.deleteProductGUI = deleteProductGUI;
        this.productGUI = productGUI;
        this.homepageGUI = homepageGUI;
        this.orderGUI = orderGUI;

        insertClientGUI.addClientInsertListener(new InsertClientListener());
        updateClientGUI.addClientUpdateListener(new UpdateClientListener());
        deleteClientGUI.addClientDeleteListener(new DeleteClientListener());
        clientGUI.addSelectAllClientsGUIListener(new SelectAllClientsListener());
        insertProductGUI.addProductInsertListener(new InsertProductListener());
        updateProductGUI.addProductUpdateListener(new UpdateProductListener());
        deleteProductGUI.addProductDeleteListener(new DeleteProductListener());
        productGUI.addSelectAllProductsGUIListener(new SelectAllProductsListener());
        productGUI.addInsertProductGUIListener(new InsertProductGUIListener());
        productGUI.addUpdateProductGUIListener(new UpdateProductGUIListener());
        productGUI.addDeleteProductGUIListener(new DeleteProductGUIListener());
        clientGUI.addInsertClientGUIListener(new InsertClientGUIListener());
        clientGUI.addUpdateClientGUIListener(new UpdateClientGUIListener());
        clientGUI.addDeleteClientGUIListener(new DeleteClientGUIListener());
        homepageGUI.addClientGUIListener(new ClientGUIListener());
        homepageGUI.addProductGUIListener(new ProductGUIListener());
        homepageGUI.addOrderGUIListener(new OrderGUIListener());
        orderGUI.addOrderSubmitListener(new OrderSubmitListener());
    }

    class InsertClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            client.setName(insertClientGUI.getNameText());
            client.setAddress(insertClientGUI.getAddressText());
            client.setEmail(insertClientGUI.getEmailText());

            System.out.println("Datele preluate: " + client.getName() + " " + client.getAddress() + " " + client.getEmail());
            try {
                clientBLL.insertClient(client);
            } catch (NoSuchElementException exception) {
                System.out.println("Nu s-a putut introduce clientul. ");
            }

        }
    }

    class UpdateClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            client.setId(Integer.parseInt(updateClientGUI.getIdText()));
            client.setName(updateClientGUI.getNameText());
            client.setAddress(updateClientGUI.getAddressText());
            client.setEmail(updateClientGUI.getEmailText());

            System.out.println("Datele preluate: " + client.getId() + " " + client.getName() + " " + client.getAddress() + " " + client.getEmail());
            clientBLL.updateClient(client);

        }
    }

    class DeleteClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("Datele preluate: " + Integer.parseInt(deleteClientGUI.getIdText()));
            clientBLL.deleteClient(Integer.parseInt(deleteClientGUI.getIdText()));

        }
    }

    class SelectAllClientsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<String> columnNames = clientBLL.getColumnNames();
            List<Client> rows = clientBLL.getRows();
            //System.out.println(rows.size());
            //System.out.println(columnNames.size());
            JFrame frame = new SelectAllClientsGUI(columnNames, rows);
            frame.setTitle("Client Table");
            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
    }

    class InsertProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            product.setName(insertProductGUI.getNameText());
            product.setQuantity(Integer.parseInt(insertProductGUI.getQuantityText()));

            System.out.println("Datele preluate: " + product.getName() + " " + product.getQuantity());
            productBLL.insertProduct(product);
        }
    }

    class UpdateProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            product.setId(Integer.parseInt(updateProductGUI.getIdText()));
            product.setName(updateProductGUI.getNameText());
            product.setQuantity(Integer.parseInt(updateProductGUI.getQuantityText()));

            System.out.println("Datele preluate: " + product.getId() + " " + product.getName() + " " + product.getQuantity());
            productBLL.updateProduct(product);
        }
    }

    class DeleteProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Datele preluate: " + Integer.parseInt(deleteProductGUI.getIdText()));
            productBLL.deleteProduct(Integer.parseInt(deleteProductGUI.getIdText()));
        }
    }

    class SelectAllProductsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<String> columnNames = productBLL.getColumnNames();
            List<Product> rows = productBLL.getRows();
            //System.out.println(rows.size());
            //System.out.println(columnNames.size());
            JFrame frame = new SelectAllProductsGUI(columnNames, rows);
            frame.setTitle("Product Table");
            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
    }

    class InsertProductGUIListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            insertProductGUI.setVisible(true);
        }
    }

    class UpdateProductGUIListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateProductGUI.setVisible(true);
        }
    }

    class DeleteProductGUIListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteProductGUI.setVisible(true);
        }
    }

    class InsertClientGUIListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            insertClientGUI.setVisible(true);
        }
    }

    class UpdateClientGUIListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateClientGUI.setVisible(true);
        }
    }

    class DeleteClientGUIListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteClientGUI.setVisible(true);
        }
    }

    class ClientGUIListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clientGUI.setVisible(true);
        }
    }

    class ProductGUIListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            productGUI.setVisible(true);
        }
    }

    class OrderGUIListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            orderGUI.setVisible(true);
        }
    }

    class OrderSubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            comanda.setIdClient(Integer.parseInt(orderGUI.getClientIdText()));
            orderBLL.insertOrder(comanda);

            StringBuilder content = new StringBuilder();

            content.append("Bon cu id" + comanda.getId() + "\n");

            //produs 1
            comandaprodus.setIdOrder(comanda.getId());
            comandaprodus.setIdProduct(Integer.parseInt(orderGUI.getProduct1Text()));
            comandaprodus.setQuantity(Integer.parseInt(orderGUI.getProduct1QText()));
            product = productBLL.findByIdProduct(comandaprodus.getIdProduct());
            if (product.getQuantity() < comandaprodus.getQuantity())
                JOptionPane.showMessageDialog(orderGUI, "Under stock product with id" + comandaprodus.getIdProduct(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            else {
                orderProductBLL.insertProduct(comandaprodus);
                product.setQuantity(product.getQuantity() - comandaprodus.getQuantity());
                productBLL.updateProductQuantity(product);
            }
            content.append("Produs 1: " + comandaprodus.getIdProduct() + " Cantitate: " + comandaprodus.getQuantity() + "\n");

            //produs 2
            comandaprodus.setIdProduct(Integer.parseInt(orderGUI.getProduct2Text()));
            comandaprodus.setQuantity(Integer.parseInt(orderGUI.getProduct2QText()));
            product = productBLL.findByIdProduct(comandaprodus.getIdProduct());
            if (product.getQuantity() < comandaprodus.getQuantity())
                JOptionPane.showMessageDialog(orderGUI, "Under stock product with id" + comandaprodus.getIdProduct(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            else {
                orderProductBLL.insertProduct(comandaprodus);
                product.setQuantity(product.getQuantity() - comandaprodus.getQuantity());
                productBLL.updateProductQuantity(product);
            }
            content.append("Produs 2: " + comandaprodus.getIdProduct() + " Cantitate: " + comandaprodus.getQuantity() + "\n");
            //produs 3
            comandaprodus.setIdProduct(Integer.parseInt(orderGUI.getProduct3Text()));
            comandaprodus.setQuantity(Integer.parseInt(orderGUI.getProduct3QText()));
            product = productBLL.findByIdProduct(comandaprodus.getIdProduct());
            if (product.getQuantity() < comandaprodus.getQuantity())
                JOptionPane.showMessageDialog(orderGUI, "Under stock product with id" + comandaprodus.getIdProduct(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            else {
                orderProductBLL.insertProduct(comandaprodus);
                product.setQuantity(product.getQuantity() - comandaprodus.getQuantity());
                productBLL.updateProductQuantity(product);
            }
            content.append("Produs 3: " + comandaprodus.getIdProduct() + " Cantitate: " + comandaprodus.getQuantity() + "\n");

            StringBuilder fileName = new StringBuilder();
            fileName.append("bon" + comanda.getId() + ".txt");
            File fisier = new File(fileName.toString());
            try {
                fisier.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            PrintStream fileOut = null;

            try {
                fileOut = new PrintStream(fisier.getName());
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
            System.setOut(fileOut);
            System.out.println(content);

        }

    }
}
