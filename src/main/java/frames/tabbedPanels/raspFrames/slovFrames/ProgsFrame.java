package frames.tabbedPanels.raspFrames.slovFrames;

import dao.NapravlEntity;
import dao.ProgsEntity;
import models.MainModel;
import utils.ButtonsMenu;
import utils.Cache;
import utils.SlovFactory;
import utils.TableFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 01.03.2017.
 */
public class ProgsFrame {
    private SlovFactory slovFactory;
    public ProgsFrame() {
        String[] head = {"Код", "Направление","Профиль","ФормаОбуч","Квалифик","Срок","Примечание"};
        int[] widths= {39,150,150,100,100,50,200};
        String text ="Введите/Откорректируйте  программы обучения";
        List<ProgsEntity> list= Cache.getProgsEntityList();
        final List<NapravlEntity> napravlEntities = Cache.getNapravlEntityList();

        TableFactory factory = new TableFactory(head,widths,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    ProgsEntity entity = (ProgsEntity) list.get(i);
                    mas[i][0] = entity.getId();
                    mas[i][1] = entity.getNapralv().getНаимНапр();
                    mas[i][2] = entity.getПрофПрогр();
                    mas[i][3] = entity.getФормаОбуч();
                    mas[i][4] = entity.getКвалифик();
                    mas[i][5] = entity.getПланСрок();
                    mas[i][6] = entity.getПримеч();
                }
            }
        };
        final JTable table = factory.getTable();
        ArrayList<String> list1 = new ArrayList<String>();
        for (Object x: napravlEntities)
        {
            NapravlEntity napravlEntity = (NapravlEntity) x;
            list1.add(napravlEntity.getНаимНапр());
        }

        Object[] objects = list1.toArray();

        JComboBox comboBox = new JComboBox(objects);
        final DefaultCellEditor editor = new DefaultCellEditor(comboBox);
        table.getColumnModel().getColumn(1).setCellEditor(editor);

        ButtonsMenu menu = new ButtonsMenu(table,list) {
            @Override
            public Object getEntity() {
                ProgsEntity entity = new ProgsEntity();
                int selectedRow = table.getSelectedRow();
                entity.setId((Integer) model.getValueAt(selectedRow,0));
                JComboBox box = (JComboBox) editor.getComponent();
                int index = box.getSelectedIndex();
                NapravlEntity napravlEntity = napravlEntities.get(index);
                entity.setNapralv(napravlEntity);
                entity.setКвалифик((String) model.getValueAt(selectedRow,4));
                entity.setПрофПрогр((String) model.getValueAt(selectedRow,2));
                entity.setФормаОбуч((String) model.getValueAt(selectedRow,3));
                entity.setПланСрок((String) model.getValueAt(selectedRow,5));
                entity.setПримеч((String) model.getValueAt(selectedRow,6));
                return entity;
            }
        };

        slovFactory = new SlovFactory(text,factory,menu);
    }

    public void close(){
        slovFactory.dispose();
    }
}
