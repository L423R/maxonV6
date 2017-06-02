package frames.tabbedPanels.docsFrames.slovFrames;

import entities.NagrRabEntity;
import utils.ButtonsMenu;
import utils.NewCache;
import utils.SlovFactory;
import utils.TableFactory;

import javax.swing.*;
import java.util.List;

/**
 * Created by Maxon on 08.04.2017.
 */
public class NagrRabFrame {
    private SlovFactory slovFactory;

    public NagrRabFrame() {
        String[] head = {"Код","Наименование"};
        int[] widths = {40,350};
        String text = "Введите/Откорректируйте  группы видов УПН/УПР";

        List<NagrRabEntity> list = NewCache.getCache().getNagrRabEntities();

        TableFactory factory = new TableFactory(head,widths,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    NagrRabEntity entity = (NagrRabEntity) list.get(i);
                    mas[i][0] = entity.getId();
                    mas[i][1] = entity.getName();
                }
            }
        };

        JTable table = factory.getTable();

        ButtonsMenu menu = new ButtonsMenu(table,list) {
            @Override
            public Object getEntity() {
                NagrRabEntity entity = new NagrRabEntity();
                int selectedRow = table.getSelectedRow();
                entity.setId((Integer) model.getValueAt(selectedRow,0));
                entity.setName((String) model.getValueAt(selectedRow,1));
                return entity;
            }
        };
        slovFactory = new SlovFactory(text,factory,menu);
    }

    public void close(){
        slovFactory.dispose();
    }
}
