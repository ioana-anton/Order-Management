package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame{

    private JPanel mainPanel=new JPanel();

    private JButton insert= new JButton("Adaugare client");
    private JButton update= new JButton("Modificare client");
    private JButton delete= new JButton("Stergere client");
    private JButton select= new JButton("Afisare clienti");

    public ClientGUI(){

        JPanel middlePanel=new JPanel();
        JPanel westPanel=new JPanel();
        JPanel eastPanel=new JPanel();

        JPanel insertP=new JPanel();
        JPanel updateP=new JPanel();
        JPanel deleteP=new JPanel();
        JPanel selectP= new JPanel();

        middlePanel.setLayout(new BoxLayout(middlePanel,BoxLayout.Y_AXIS));
        middlePanel.setPreferredSize(new Dimension(300,300));

        westPanel.setPreferredSize(new Dimension(150,600));

        eastPanel.setPreferredSize(new Dimension(150,600));

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(600,600));

        insertP.setPreferredSize(new Dimension(300,40));
        updateP.setPreferredSize(new Dimension(300,40));
        deleteP.setPreferredSize(new Dimension(300,40));
        selectP.setPreferredSize(new Dimension(300,40));

        insert.setPreferredSize(new Dimension(300,40));
        update.setPreferredSize(new Dimension(300,40));
        delete.setPreferredSize(new Dimension(300,40));
        select.setPreferredSize(new Dimension(300,40));

        insertP.add(insert);
        updateP.add(update);
        deleteP.add(delete);
        selectP.add(select);

        middlePanel.add(Box.createRigidArea(new Dimension(300,80)));
        middlePanel.add(insertP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(updateP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(deleteP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,10)));
        middlePanel.add(selectP);
        middlePanel.add(Box.createRigidArea(new Dimension(300,80)));

        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(middlePanel,BorderLayout.CENTER);
        mainPanel.add(eastPanel,BorderLayout.EAST);

        // ************* //
        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Client Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addInsertClientGUIListener(ActionListener e){
        insert.addActionListener(e);
    }

    public void addUpdateClientGUIListener(ActionListener e){
        update.addActionListener(e);
    }

    public void addDeleteClientGUIListener(ActionListener e){
        delete.addActionListener(e);
    }

    public void addSelectAllClientsGUIListener(ActionListener e){
        select.addActionListener(e);
    }

}
