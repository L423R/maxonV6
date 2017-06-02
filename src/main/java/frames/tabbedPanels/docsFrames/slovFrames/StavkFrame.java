package frames.tabbedPanels.docsFrames.slovFrames;

import entities.NprEntity;
import entities.StavkiEntity;
import utils.DaoFactory;
import utils.NewCache;
import utils.SlovFactory;
import utils.TableFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 08.04.2017.
 */
public class StavkFrame {
    private SlovFactory slovFactory;

    public StavkFrame(int index) {

        String[] head = {"Код","Наименование","ЕдИзм","КодВида","НПР","Специалист","Магистр","Примеч"};
        int[] widths = {40,350,60,30,100,60,60,100};
        String text = "Введите/Откорректируйте ставки группы: \"Сопровождение курса в СДО\"";

        List<StavkiEntity> list = DaoFactory.getDaoFactory().getStavkiDao().getStavkiByVid(index);
        List<NprEntity> nprEntities = NewCache.getCache().getNprEntities();

        List names = new ArrayList();

        switch (index){
            case 3:
                names.add(nprEntities.get(8));
                names.add(nprEntities.get(9));
                break;
            case 4:
                names.add(nprEntities.get(7));
                names.add(nprEntities.get(10));
                break;
            case 5:
                names.add(nprEntities.get(7));
                names.add(nprEntities.get(10));
                break;
            default:
                for (NprEntity entity:nprEntities)
                    names.add(entity.getНаимНпр());
                break;
        }


        TableFactory factory = new TableFactory(head,widths,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                     StavkiEntity entity = (StavkiEntity) list.get(i);
                     mas[i][0] = entity.getId();
                     mas[i][1] = entity.getНаимСтав();
                     mas[i][2] = entity.getЕдИзм();
                     mas[i][3] = entity.getКодВида();
                     mas[i][4] = entity.getКодНпр().getНаимНпр();
                     mas[i][5] = entity.getСтавкаСпец();
                     mas[i][5] = entity.getСтавкаМаг();
                }
            }
        };


        JComboBox comboBox = new JComboBox(names.toArray());

        DefaultCellEditor editor  = new DefaultCellEditor(comboBox);

        JTable table = factory.getTable();
        table.getColumnModel().getColumn(4).setCellEditor(editor);

        slovFactory = new SlovFactory(text,factory,null);
    }
    public void close(){
        slovFactory.dispose();
    }
}
