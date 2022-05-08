package presentation.product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InsertProductGUI extends JFrame {
    private JPanel mainPanel=new JPanel();

    private JTextField name=new JTextField();
    private JTextField quantity=new JTextField();

    private JButton confirm=new JButton("Confirm");

    public InsertProductGUI(){

        JPanel middlePanel=new JPanel();
        JPanel westPanel=new JPanel();
        JPanel eastPanel=new JPanel();

        JPanel nameP=new JPanel();
        JPanel quantityP=new JPanel();
        JPanel confirmP=new JPanel();

        JLabel nameL=new JLabel("Nume: ");
        JLabel quantityL=new JLabel("Cantitate: ");

        middlePanel.setLayout(new BoxLayout(middlePanel,BoxLayout.Y_AXIS));
        middlePanel.setPreferredSize(new Dimension(300,300));

        westPanel.setPreferredSize(new Dimension(150,600));

        eastPanel.setPreferredSize(new Dimension(150,600));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(600,600));

        nameP.setPreferredSize(new Dimension(300,20));
        quantityP.setPreferredSize(new Dimension(300,20));
        confirmP.setPreferredSize(new Dimension(70,20));

        name.setPreferredSize(new Dimension(230,20));
        quantity.setPreferredSize(new Dimension(230,20));
        confirm.setPreferredSize(new Dimension(230,20));

        nameL.setPreferredSize(new Dimension(50,20));
        quantityL.setPreferredSize(new Dimension(60,20));

        nameP.add(nameL);
        nameP.add(name);

        quantityP.add(quantityL);
        quantityP.add(quantity);

        confirmP.add(confirm);

        middlePanel.add(Box.createRigidArea(new Dimension(300,70)));
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

    public String getNameText(){
        return name.getText();
    }

    public String getQuantityText(){
        return quantity.getText();
    }

    public void addProductInsertListener(ActionListener e){
        confirm.addActionListener(e);
    }
}
