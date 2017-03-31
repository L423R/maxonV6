package frames.tabbedPanels.prepFrames;

import dao.PrepsEntity;
import utils.ButtonsMenu;
import utils.Cache;
import utils.SlovFactory;
import utils.TableFactory;

import javax.swing.*;
import java.util.*;
import java.util.List;

/**
 * Created by Maxon on 30.03.2017.
 */
public class ThirdButtonFrame {
    private SlovFactory slovFactory;
    public ThirdButtonFrame()  {
        String[] head = {"ид","Арх","Фамилия","Имя","Отчество","ДатаРож","Индекс","Адресс","Телефон"};
        String text = "Список преподавателей (АРХИВ)";
        int[] widths = {40,40,150,100,150,80,100,120,100};
        List<PrepsEntity> list = Cache.getPrepsEntityList();
        List<PrepsEntity> prepsEntityList = new ArrayList<>();
        for (PrepsEntity entity: list)
        {
            if (entity.getПрАрх())
                prepsEntityList.add(entity);
        }

        TableFactory factory = new TableFactory(head,widths,prepsEntityList) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    PrepsEntity entity = (PrepsEntity) list.get(i);

                    mas[i][0] = entity.getId();
                    mas[i][1] = entity.getПрАрх();
                    mas[i][2] = entity.getФамилия();
                    mas[i][3] = entity.getИмя();
                    mas[i][4] = entity.getОтчество();
                    mas[i][5] = entity.getДатаРожд();
                    mas[i][6] = entity.getИндекс();
                    mas[i][7] = entity.getАдрес();
                    mas[i][8] = entity.getТелефон();
                }
            }
        };

        JTable table = factory.getTable();

        ButtonsMenu menu = new ButtonsMenu(table,prepsEntityList) {
            @Override
            public Object getEntity() {
                int selectedRow = table.getSelectedRow();
                PrepsEntity entity = prepsEntityList.get(selectedRow);
                entity.setПрАрх((Boolean) model.getValueAt(selectedRow,1));
                return entity;
            }
        };

        slovFactory = new SlovFactory(text,factory,menu);

    }
    public void close(){
        slovFactory.dispose();
    }
}
