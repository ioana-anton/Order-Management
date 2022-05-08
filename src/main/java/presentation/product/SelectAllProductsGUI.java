package presentation.product;

import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SelectAllProductsGUI extends JFrame {
    private DefaultTableModel model=new DefaultTableModel();
    private JTable t;
    private Container cnt = this.getContentPane();
    private java.util.List<String> columnNames; //coloane
    private java.util.List<Product> rows; //randuri

    public SelectAllProductsGUI(java.util.List<String> columnNames, List<Product> rows){
        this.columnNames=columnNames;
        this.rows=rows;

        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));

        for(String s:columnNames)
            model.addColumn(s);

        for(Product p: rows)
            model.addRow(p.toStringArray());

        t=new JTable(model);

        JScrollPane pg =new JScrollPane(t);
        cnt.add(pg);
        this.pack();

    }

}
