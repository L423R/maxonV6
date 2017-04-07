package frames.tabbedPanels.docsFrames.slovFrames;

import entities.NprEntity;
import utils.ButtonsMenu;
import utils.NewCache;
import utils.SlovFactory;
import utils.TableFactory;

import javax.swing.*;
import java.util.List;

/**
 * Created by Maxon on 07.04.2017.
 */
public class NprFrame {
    private SlovFactory slovFactory;

    public NprFrame() {

        String[] head = {"Код","Наименование"};
        int[] widths = {40,200};
        String text = "Введите/Откорректируйте сведения о квалификации НПР";

        List<NprEntity> list = NewCache.getCache().getNprEntities();

        TableFactory factory = new TableFactory(head,widths,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    NprEntity entity = (NprEntity) list.get(i);
                    mas[i][0] = entity.getId();
                    mas[i][1] = entity.getНаимНпр();
                }
            }
        };

        JTable table = factory.getTable();

        ButtonsMenu menu = new ButtonsMenu(table,list) {
            @Override
            public Object getEntity() {
                NprEntity entity = new NprEntity();
                int selectedRow = table.getSelectedRow();
                entity.setId((Integer) model.getValueAt(selectedRow,0));
                entity.setНаимНпр((String) model.getValueAt(selectedRow,1));
                return entity;
            }
        };

        slovFactory = new SlovFactory(text,factory,menu);
    }
    public void close(){
        slovFactory.dispose();
    }
}
