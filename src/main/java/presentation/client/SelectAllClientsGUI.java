package presentation.client;

import model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SelectAllClientsGUI extends JFrame {

    private DefaultTableModel model=new DefaultTableModel();
    private JTable t;
    private Container cnt = this.getContentPane();
    private List<String> columnNames; //coloane
    private List<Client> rows; //randuri

    public SelectAllClientsGUI(List<String> columnNames, List<Client> rows){
        this.columnNames=columnNames;
        this.rows=rows;

        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));

        for(String s:columnNames)
            model.addColumn(s);

        for(Client c: rows)
            model.addRow(c.toStringArray());

        t=new JTable(model);

        JScrollPane pg =new JScrollPane(t);
        cnt.add(pg);
        this.pack();

    }

}
