package frames.tabbedPanels.raspFrames.slovFrames;

import entities.MetodistsEntity;
import utils.*;

import javax.swing.*;
import java.util.List;

/**
 * Created by Maxon on 01.03.2017.
 */
public class MethodistsFrame {
    private SlovFactory slovFactory;
    public MethodistsFrame() {
        String[] head = {"Код","Фамилия","Имя","Отчество","Контакт"};
        int[] widths = {39,100,100,100,300};
        String text = "Введите/Откорректируйте методистов";
        List<MetodistsEntity> list = NewCache.getCache().getMetodistsEntities();
        TableFactory factory = new TableFactory(head,widths,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    MetodistsEntity entity = (MetodistsEntity) list.get(i);
                    mas[i][0] = entity.getId();
                    mas[i][1] = entity.getФамилия();
                    mas[i][2] = entity.getИмя();
                    mas[i][3] = entity.getОтчество();
                    mas[i][4] = entity.getКонтМет();
                }
            }
        };

        final JTable table = factory.getTable();

        ButtonsMenu menu = new ButtonsMenu(table,list) {
            @Override
            public Object getEntity() {
                MetodistsEntity entity = new MetodistsEntity();
                int selectedRow = table.getSelectedRow();
                entity.setId((Integer) model.getValueAt(selectedRow,0));
                entity.setФамилия((String) model.getValueAt(selectedRow,1));
                entity.setИмя((String) model.getValueAt(selectedRow,2));
                entity.setОтчество((String) model.getValueAt(selectedRow,3));
                entity.setКонтМет((String) model.getValueAt(selectedRow,4));
                return entity;
            }
        };

        slovFactory = new SlovFactory(text,factory,menu);
    }

    public void close() {
        slovFactory.dispose();
    }
}
