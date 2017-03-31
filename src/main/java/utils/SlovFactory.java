package utils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Maxon on 22.02.2017.
 */
public class SlovFactory extends JFrame {
    String [] head;
    int[] widths;
    List<?> entities;
    Container contentPane;
    int width;
    TableFactory tableFactory;
    int height=500;
    ButtonsMenu menu;


    public SlovFactory(String text, TableFactory tableFactory, ButtonsMenu menu) {
        this.tableFactory= tableFactory;
        //this.head = tableFactory.getHead();
        this.widths = tableFactory.getWidths();
        this.entities = tableFactory.getList();


        width=getSumWidth();
        setSize(width, height);
        Font font = new Font("Verdana",Font.BOLD,15);
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(Color.ORANGE);
        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));


        contentPane.add(label);

        JTable table = tableFactory.getTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(width-30, height-200));

        contentPane.add(scrollPane);
        if (menu!=null) {
            this.menu = menu;
            this.menu.setPreferredSize(new Dimension(width, 150));
            contentPane.add(this.menu);
        }

        setVisible(true);
    }

    private int getSumWidth()
    {
        int sum=0;
        for (int i = 0; i < widths.length; i++) {
            sum+=widths[i];
        }
        return sum+50;
    }


}
