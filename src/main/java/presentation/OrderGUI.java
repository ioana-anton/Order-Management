package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderGUI extends JFrame {
    private JPanel mainPanel=new JPanel();

    private JTextField client=new JTextField();
    private JTextField produs1=new JTextField();
    private JTextField produs2=new JTextField();
    private JTextField produs3=new JTextField();
    private JTextField produs1Q=new JTextField("Cantitate");
    private JTextField produs2Q=new JTextField("Cantitate");
    private JTextField produs3Q=new JTextField("Cantitate");

    private JButton confirm=new JButton("Confirm");

    public OrderGUI(){

        JPanel middlePanel=new JPanel();
        JPanel westPanel=new JPanel();
        JPanel eastPanel=new JPanel();

        JPanel clientP=new JPanel();
        JPanel produs1P=new JPanel();
        JPanel produs2P=new JPanel();
        JPanel produs3P=new JPanel();
        JPanel confirmP=new JPanel();

        JLabel clientL=new JLabel("Client ID: ");
        JLabel produs1L=new JLabel("Produs 1: ");
        JLabel produs2L=new JLabel("Produs 2: ");
        JLabel produs3L=new JLabel("Produs 3: ");

        middlePanel.setLayout(new BoxLayout(middlePanel,BoxLayout.Y_AXIS));
        middlePanel.setPreferredSize(new Dimension(300,300));

        westPanel.setPreferredSize(new Dimension(150,600));

        eastPanel.setPreferredSize(new Dimension(150,600));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(600,600));

        clientP.setPreferredSize(new Dimension(300,20));
        produs1P.setPreferredSize(new Dimension(300,20));
        produs2P.setPreferredSize(new Dimension(300,20));
        produs3P.setPreferredSize(new Dimension(300,20));
        confirmP.setPreferredSize(new Dimension(70,20));

        client.setPreferredSize(new Dimension(230,20));
        produs1.setPreferredSize(new Dimension(230,20));
        produs2.setPreferredSize(new Dimension(230,20));
        produs3.setPreferredSize(new Dimension(230,20));
        produs1Q.setPreferredSize(new Dimension(230,20));
        produs2Q.setPreferredSize(new Dimension(230,20));
        produs3Q.setPreferredSize(new Dimension(230,20));
        confirm.setPreferredSize(new Dimension(230,20));

        clientL.setPreferredSize(new Dimension(50,20));
        produs1L.setPreferredSize(new Dimension(50,20));
        produs2L.setPreferredSize(new Dimension(50,20));
        produs3L.setPreferredSize(new Dimension(50,20));

        clientP.add(clientL);
        clientP.add(client);

        produs1P.add(produs1L);
        produs1P.add(produs1);
        produs1P.add(produs1Q);

        produs2P.add(produs2L);
        produs2P.add(produs2);
        produs2P.add(produs2Q);

        produs3P.add(produs3L);
        produs3P.add(produs3);
        produs3P.add(produs3Q);

        confirmP.add(confirm);

        middlePanel.add(Box.createRigidArea(new Dimension(300,70)));
        middlePanel.add(clientP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(produs1P);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(produs2P);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(produs3P);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(confirmP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,70)));

        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(middlePanel,BorderLayout.CENTER);
        mainPanel.add(eastPanel,BorderLayout.EAST);

        // ************* //
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Make Order");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getProduct1Text(){
        return produs1.getText();
    }
    public String getProduct2Text(){
        return produs2.getText();
    }
    public String getProduct3Text(){
        return produs3.getText();
    }
    public String getProduct1QText(){
        return produs1Q.getText();
    }
    public String getProduct2QText(){
        return produs2Q.getText();
    }
    public String getProduct3QText(){
        return produs3Q.getText();
    }

    public String getClientIdText(){
        return client.getText();
    }

    public void addOrderSubmitListener(ActionListener e){
        confirm.addActionListener(e);
    }
}
