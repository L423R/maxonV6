package frames.tabbedPanels.raspFrames.slovFrames;

import dao.DiscEntity;
import dao.KafEntity;
import utils.ButtonsMenu;
import utils.Cache;
import utils.SlovFactory;
import utils.TableFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 22.02.2017.
 */
public class DiscFrame {
    private SlovFactory slovFactory;
    public DiscFrame() {
        String[] head = { "Код", "НаимДисц", "НаимКаф", "Ранг"};
        int[] widths = {39,400,400,40};
        String text = "Введите/Откорректируйте дисциплины обучения";
        List<DiscEntity> list = Cache.getDiscEntityList();
        final List<KafEntity> entities1 = Cache.getKafEntityList();

        TableFactory factory = new TableFactory(head,widths,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    DiscEntity entity = (DiscEntity) list.get(i);
                    mas[i][0] = entity.getId();
                    mas[i][1] = entity.getНаимДисц();
                    mas[i][2] = entity.getКодКаф().getНаимКаф();
                    mas[i][3] = entity.getКодКаф().getРангКаф();
                }
            }
        };
        final JTable table = factory.getTable();
        final DefaultTableModel model = (DefaultTableModel) table.getModel();

        ArrayList<String> list1 = new ArrayList();
        for (Object x: entities1)
        {
            KafEntity kafEntity = (KafEntity) x;
            list1.add(kafEntity.getНаимКаф());

        }
        Object[] objects = list1.toArray();
        final JComboBox comboBox = new JComboBox(objects);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow>-1) {
                    int selectedIndex = comboBox.getSelectedIndex();
                    KafEntity kafEntity = entities1.get(selectedIndex);
                    model.setValueAt(kafEntity.getРангКаф(), selectedRow, 3);
                }
            }
        });
        final DefaultCellEditor editor = new DefaultCellEditor(comboBox);
        table.getColumnModel().getColumn(2).setCellEditor(editor);



        ButtonsMenu menu = new ButtonsMenu(table,list) {
            @Override
            public Object getEntity() {
                DiscEntity entity = new DiscEntity();
                int selectedRow = table.getSelectedRow();
                entity.setId((Integer) model.getValueAt(selectedRow,0));
                entity.setНаимДисц((String) model.getValueAt(selectedRow,1));
                JComboBox box = (JComboBox) editor.getComponent();
                int index = box.getSelectedIndex();
                KafEntity kafEntity = entities1.get(index);
                System.out.println(kafEntity.getНаимКаф());
                entity.setКодКаф(kafEntity);
                return entity;
            }
        };

        slovFactory = new SlovFactory(text,factory,menu);
    }

    public void close()
    {
        slovFactory.dispose();
    }
}
