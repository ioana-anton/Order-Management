package presentation.product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeleteProductGUI extends JFrame {
    private JPanel middlePanel=new JPanel();

    private JTextField id=new JTextField();

    private JButton confirm=new JButton("Confirm");

    public DeleteProductGUI(){


        JPanel idP=new JPanel();
        JPanel confirmP=new JPanel();

        JLabel idL=new JLabel("ID: ");


        middlePanel.setLayout(new BoxLayout(middlePanel,BoxLayout.Y_AXIS));
        middlePanel.setPreferredSize(new Dimension(300,300));


        idP.setPreferredSize(new Dimension(300,20));
        confirmP.setPreferredSize(new Dimension(70,20));

        id.setPreferredSize(new Dimension(230,20));
        confirm.setPreferredSize(new Dimension(230,20));

        idL.setPreferredSize(new Dimension(50,20));

        idP.add(idL);
        idP.add(id);

        confirmP.add(confirm);

        middlePanel.add(Box.createRigidArea(new Dimension(300,70)));
        middlePanel.add(idP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(confirmP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,70)));

        // ************* //
        this.setContentPane(middlePanel);
        this.pack();
        this.setTitle("Delete Product");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addProductDeleteListener(ActionListener e){
        confirm.addActionListener(e);
    }
    public String getIdText(){
        return id.getText();
    }
}
