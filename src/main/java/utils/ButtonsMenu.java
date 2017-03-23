package utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Maxon on 22.02.2017.
 */
public abstract class ButtonsMenu extends JPanel {

    public DefaultTableModel model;
    List entities;
    private int count;

    public ButtonsMenu(final JTable table, final List entities) {
         model = (DefaultTableModel) table.getModel();
         this.entities = entities;
         count = model.getRowCount();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton button1 = new JButton("Удалить");
        JButton button2 = new JButton("Добавить");
        JButton button3 = new JButton("Сохранить выбранную строчку");



        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                model.removeRow(selectedRow);

                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                try{
                    Object o = entities.get(selectedRow);
                    System.out.println(o.toString());
                    session.delete(o);
                    transaction.commit();
                    boolean remove = entities.remove(o);
                    System.out.println(remove);
                }catch (Throwable t) {
                    transaction.rollback();
                }finally {
                    // закрытие сессии
                    session.close();
                }
            }
        });


        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();

                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                try{
                    // Object o = entities.get(selectedRow);
                    //o.

                    Object o = getEntity();
                    session.saveOrUpdate(o);
                    transaction.commit();
                    System.out.println(selectedRow+" "+entities.size());
                    if (selectedRow>=count) {
                        entities.add(o);
                        count++;
                        System.out.println("new");
                    }
                    System.out.println("kaef");
                }catch (Throwable t) {
                    System.out.println("error");
                    t.printStackTrace();
                    transaction.rollback();
                }finally {
                    // закрытие сессии
                    session.close();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
                int columnCount = defaultTableModel.getColumnCount();
                Object[] objects = new Object[columnCount];
                String s ="";
                for (int i = 0; i < columnCount; i++) {
                    Class<?> columnClass = defaultTableModel.getColumnClass(i);
                    Object ob=null;
                    String simpleName = columnClass.getName();
                    System.out.println(simpleName);

                    if (columnClass == Float.class || columnClass == Double.class || columnClass == Byte.class || columnClass == Integer.class || columnClass == Short.class || columnClass == Long.class)
                    {
                        System.out.println("NUMBER");
                        ob = 0;
                    }else if (columnClass == Timestamp.class)
                    {
                        System.out.println("TIMESTAMP");
                        ob = null;
                    }else if (columnClass == Boolean.class)
                    {
                        System.out.println("BOOLEAN");
                        ob = false;
                    }else if (columnClass == String.class)
                    {
                        System.out.println("STRING");
                        ob = "";
                    }

                    objects[i] = ob;

                }
                defaultTableModel.addRow(objects);
               //entities.add(new Object());
            }
        });

        add(button2);
        add(button3);
        add(button1);
    }
    public abstract Object getEntity();

}
