package utils;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Maxon on 22.02.2017.
 */
public abstract class TableFactory {

    protected Object[][] mas;
    private String[] head;
    private int[] widths;
    private JTable table;
    protected List<?> list;

    public TableFactory(String[] head, int[] widths, List<?> list) {
        this.head = head;
        this.widths = widths;
        this.list = list;
        this.mas = new Object[this.list.size()][head.length];
        fillMas();
        if (head.length>widths.length)
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        init();

    }

    public abstract void fillMas();


    private void init()
    {
        DefaultTableModel tableModel = new DefaultTableModel(mas,head){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                Object o = mas[0][columnIndex];
                if (o==null)
                    return String.class;
                return o.getClass();
            }


        };

        table = new JTable(tableModel)
        {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                JComponent jc = (JComponent)c;

                //  Color row based on a cell value
                //  Alternate row color

                if (!isRowSelected(row))
                {

                }// c.setBackground(row % 2 == 0 ? getBackground() : Color.LIGHT_GRAY);
                else
                    jc.setBorder(new MatteBorder(1, 1, 1, 1, Color.RED) );


                //  Use bold font on selected row

                return c;
            }
        };
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
        table.setRowSorter(sorter);

        /*Color color = UIManager.getColor("Table.gridColor");
        Color color1 = Color.RED;
        MatteBorder border = new MatteBorder(1, 1, 1, 1, color1);
        table.setBorder(border);*/

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = table.getColumnModel();
        Enumeration<TableColumn> e = columnModel.getColumns();
        int count=0;
        while ( e.hasMoreElements() ) {
            TableColumn column = e.nextElement();
            //System.out.println(column.getClass().getClass().toString());
            int width = widths[count];
            column.setPreferredWidth(width);
            count++;
        }
    }

    public JTable getTable() {
        return table;
    }

    public String[] getHead() {
        return head;
    }

    public int[] getWidths() {
        return widths;
    }

    public List<?> getList() {
        return list;
    }
}
