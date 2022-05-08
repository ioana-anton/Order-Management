package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomepageGUI extends JFrame {

    private JPanel mainPanel=new JPanel();

    //butoanele pentru accesul la celelalte interfete
    private JButton client = new JButton("Operatii client");
    private JButton product = new JButton("Operatii produs");
    private JButton order = new JButton("Creare comanda");
    //buton de back maybe
    //sa dispara si sa apara fereastra veche

    public HomepageGUI(){

        JPanel middlePanel=new JPanel();
        JPanel westPanel=new JPanel();
        JPanel eastPanel=new JPanel();

        JPanel clientP=new JPanel();
        JPanel productP=new JPanel();
        JPanel orderP=new JPanel();

        middlePanel.setLayout(new BoxLayout(middlePanel,BoxLayout.Y_AXIS));
        middlePanel.setPreferredSize(new Dimension(300,300));

        westPanel.setPreferredSize(new Dimension(150,600));

        eastPanel.setPreferredSize(new Dimension(150,600));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(600,600));


        clientP.setPreferredSize(new Dimension(300,40));
        productP.setPreferredSize(new Dimension(300,40));
        orderP.setPreferredSize(new Dimension(300,40));

        client.setPreferredSize(new Dimension(300,40));
        product.setPreferredSize(new Dimension(300,40));
        order.setPreferredSize(new Dimension(300,40));

        clientP.add(client);
        productP.add(product);
        orderP.add(order);

        middlePanel.add(Box.createRigidArea(new Dimension(300,80)));
        middlePanel.add(clientP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(productP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(orderP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,80)));

        mainPanel.add(westPanel,BorderLayout.WEST);
        mainPanel.add(middlePanel,BorderLayout.CENTER);
        mainPanel.add(eastPanel,BorderLayout.EAST);

        // ************* //
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Home Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addClientGUIListener(ActionListener e){
        client.addActionListener(e);
    }
    public void addProductGUIListener(ActionListener e){
        product.addActionListener(e);
    }

    public void addOrderGUIListener(ActionListener e){
        order.addActionListener(e);
    }
}
