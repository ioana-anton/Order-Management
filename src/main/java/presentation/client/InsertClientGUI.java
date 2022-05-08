package presentation.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InsertClientGUI extends JFrame {

    private JPanel mainPanel=new JPanel();

    private JTextField name=new JTextField();
    private JTextField address=new JTextField();
    private JTextField email=new JTextField();

    private JButton confirm=new JButton("Confirm");

    public InsertClientGUI(){

        JPanel middlePanel=new JPanel();
        JPanel westPanel=new JPanel();
        JPanel eastPanel=new JPanel();

        JPanel nameP=new JPanel();
        JPanel addressP=new JPanel();
        JPanel emailP=new JPanel();
        JPanel confirmP=new JPanel();

        JLabel nameL=new JLabel("Nume: ");
        JLabel addressL=new JLabel("Adresa: ");
        JLabel emailL=new JLabel("Email: ");

        middlePanel.setLayout(new BoxLayout(middlePanel,BoxLayout.Y_AXIS));
        middlePanel.setPreferredSize(new Dimension(300,300));

        westPanel.setPreferredSize(new Dimension(150,600));

        eastPanel.setPreferredSize(new Dimension(150,600));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(600,600));

        nameP.setPreferredSize(new Dimension(300,20));
        addressP.setPreferredSize(new Dimension(300,20));
        emailP.setPreferredSize(new Dimension(300,20));
        confirmP.setPreferredSize(new Dimension(70,20));

        name.setPreferredSize(new Dimension(230,20));
        address.setPreferredSize(new Dimension(230,20));
        email.setPreferredSize(new Dimension(230,20));
        confirm.setPreferredSize(new Dimension(230,20));

        nameL.setPreferredSize(new Dimension(50,20));
        addressL.setPreferredSize(new Dimension(50,20));
        emailL.setPreferredSize(new Dimension(50,20));

        nameP.add(nameL);
        nameP.add(name);

        addressP.add(addressL);
        addressP.add(address);

        emailP.add(emailL);
        emailP.add(email);

        confirmP.add(confirm);

        middlePanel.add(Box.createRigidArea(new Dimension(300,70)));
        middlePanel.add(nameP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(addressP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(emailP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(confirmP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,70)));

        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(middlePanel,BorderLayout.CENTER);
        mainPanel.add(eastPanel,BorderLayout.EAST);

        // ************* //
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Insert Client");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getNameText(){
        return name.getText();
    }
    public String getAddressText(){
        return address.getText();
    }

    public String getEmailText(){
        return email.getText();
    }

   public void addClientInsertListener(ActionListener e){
        confirm.addActionListener(e);
    }
}
