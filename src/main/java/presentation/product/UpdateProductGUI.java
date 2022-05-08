package presentation.product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UpdateProductGUI extends JFrame{
    private JPanel mainPanel=new JPanel();

    private JTextField id=new JTextField();
    private JTextField name=new JTextField();
    private JTextField quantity=new JTextField();

    private JButton confirm=new JButton("Confirm");

    public UpdateProductGUI(){

        JPanel middlePanel=new JPanel();
        JPanel westPanel=new JPanel();
        JPanel eastPanel=new JPanel();

        JPanel idP=new JPanel();
        JPanel nameP=new JPanel();
        JPanel quantityP=new JPanel();
        JPanel confirmP=new JPanel();

        JLabel idL=new JLabel("ID: ");
        JLabel nameL=new JLabel("Nume: ");
        JLabel quantityL=new JLabel("Cantitate: ");

        middlePanel.setLayout(new BoxLayout(middlePanel,BoxLayout.Y_AXIS));
        middlePanel.setPreferredSize(new Dimension(300,300));

        westPanel.setPreferredSize(new Dimension(150,600));

        eastPanel.setPreferredSize(new Dimension(150,600));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(600,600));

        idP.setPreferredSize(new Dimension(300,20));
        nameP.setPreferredSize(new Dimension(300,20));
        quantityP.setPreferredSize(new Dimension(300,20));
        confirmP.setPreferredSize(new Dimension(70,20));

        id.setPreferredSize(new Dimension(230,20));
        name.setPreferredSize(new Dimension(230,20));
        quantity.setPreferredSize(new Dimension(230,20));
        confirm.setPreferredSize(new Dimension(230,20));

        idL.setPreferredSize(new Dimension(50,20));
        nameL.setPreferredSize(new Dimension(50,20));
        quantityL.setPreferredSize(new Dimension(60,20));

        idP.add(idL);
        idP.add(id);

        nameP.add(nameL);
        nameP.add(name);

        quantityP.add(quantityL);
        quantityP.add(quantity);

        confirmP.add(confirm);

        middlePanel.add(Box.createRigidArea(new Dimension(300,70)));
        middlePanel.add(idP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(nameP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(quantityP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(confirmP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,70)));

        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(middlePanel,BorderLayout.CENTER);
        mainPanel.add(eastPanel,BorderLayout.EAST);

        // ************* //
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Insert Product");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getIdText(){
        return id.getText();
    }

    public String getNameText(){
        return name.getText();
    }

    public String getQuantityText(){
        return quantity.getText();
    }

    public void addProductUpdateListener(ActionListener e){
        confirm.addActionListener(e);
    }
}
