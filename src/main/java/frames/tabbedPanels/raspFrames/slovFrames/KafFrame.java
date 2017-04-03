package frames.tabbedPanels.raspFrames.slovFrames;

import entities.KafEntity;
import utils.*;

import javax.swing.*;
import java.util.List;

/**
 * Created by Maxon on 22.02.2017.
 */
public class KafFrame {
    private SlovFactory slovFactory;
    public KafFrame() {

        String[] head = {"Код","НаименованиеКафедры","Ранг"};
        int[] widths = {40,500,40};
        String text = "Введите/Откорректируйте наименования кафедр";
        List<KafEntity> list = NewCache.getCache().getKafEntities();


        TableFactory factory = new TableFactory(head,widths,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    KafEntity entity = (KafEntity) list.get(i);
                    mas[i][0] = entity.getКодКаф();
                    mas[i][1] = entity.getНаимКаф();
                    mas[i][2] = entity.getРангКаф();
                }
            }
        };
        final JTable table = factory.getTable();
        ButtonsMenu menu = new ButtonsMenu(table,list) {
            @Override
            public Object getEntity() {
                KafEntity entity = new KafEntity();
                int selectedRow = table.getSelectedRow();
                entity.setКодКаф((Integer) model.getValueAt(selectedRow,0));
                entity.setНаимКаф((String) model.getValueAt(selectedRow,1));
                entity.setРангКаф((Short) model.getValueAt(selectedRow,2));
                return entity;
            }
        };

        slovFactory = new SlovFactory(text,factory,menu);

    }

    public void close(){
        slovFactory.dispose();
    }
}
