package frames.tabbedPanels.raspFrames.slovFrames;

import entities.NapravlEntity;
import utils.*;

import javax.swing.*;
import java.util.List;

/**
 * Created by Maxon on 01.03.2017.
 */
public class NapravlFrame {

    private SlovFactory slovFactory;
    public NapravlFrame() {
        String[] head = {"Код","Наименование"};
        int[] widths = {39,150};
        String text = "Направления обучения";
        List<NapravlEntity> list = NewCache.getCache().getNapravlEntities();
        TableFactory factory = new TableFactory(head,widths,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    NapravlEntity entity = (NapravlEntity) list.get(i);
                    mas[i][0] = entity.getId();
                    mas[i][1] = entity.getНаимНапр();
                }
            }
        };
        final JTable table = factory.getTable();

        ButtonsMenu menu = new ButtonsMenu(table,list) {
            @Override
            public Object getEntity() {
                NapravlEntity entity = new NapravlEntity();
                int selectedRow = table.getSelectedRow();
                entity.setId((Integer) model.getValueAt(selectedRow,0));
                entity.setНаимНапр((String) model.getValueAt(selectedRow,1));
                return entity;
            }
        };

        slovFactory = new SlovFactory(text,factory,menu);
    }

    public void close(){
        slovFactory.dispose();
    }
}
