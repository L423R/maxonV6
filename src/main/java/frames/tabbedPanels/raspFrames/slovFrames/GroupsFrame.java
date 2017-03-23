package frames.tabbedPanels.raspFrames.slovFrames;

import dao.GroupsEntity;
import dao.MetodistsEntity;
import dao.ProgsEntity;
import models.MainModel;
import utils.*;

import javax.swing.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 01.03.2017.
 */
public class GroupsFrame {
    private SlovFactory slovFactory;

    public GroupsFrame() {
        String[] head = {"Код","","СокрНг","ДатаОткр","Программа","Напр","Проф","Методист","ДатаЗакр","Х-Эксп","Примечание"};
        int[] widths = {40,40,40,80,500,30,30,80,80,40,150};
        String text = "Введите/Откорректируйте сведения о группах";

        final List<ProgsEntity> progsEntityList = Cache.getProgsEntityList();
        final List<MetodistsEntity> metodistsEntityList = Cache.getMetodistsEntityList();
        List<GroupsEntity> list = Cache.getGroupsEntityList();

        TableFactory factory = new TableFactory(head,widths,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    GroupsEntity entity = (GroupsEntity) list.get(i);
                    mas[i][0] = entity.getId();
                    String ss = "kek";
                    mas[i][1] = ss;
                    mas[i][2] = entity.getСокрНг();
                    mas[i][3] = entity.getДатаОткр();
                    ProgsEntity progsEntity = entity.getКодПрогр();
                    String prog = progsEntity.getId()+" "+progsEntity.getНаим()+" / "+progsEntity.getПрофПрогр()+" / "+progsEntity.getФормаОбуч()+"-"+
                            progsEntity.getПланСрок()+"-"+progsEntity.getКвалифик()+" / "+progsEntity.getПримеч();
                    mas[i][4] = prog;
                    mas[i][5] = entity.getРасшПрог();
                    mas[i][6] = entity.getПрофПрог();
                    mas[i][7] = entity.getКодМет().getФамилия();
                    mas[i][8] = entity.getДатаЗакр();
                    mas[i][9] = entity.getПрЭксп();
                    mas[i][10] = entity.getПримеч();
                }
            }
        };

        final JTable table = factory.getTable();
       // DefaultTableModel model = (DefaultTableModel) table.getModel();

        ArrayList<String> progName = new ArrayList<String>();

        for (ProgsEntity progsEntity : progsEntityList)
        {
            String s = progsEntity.getПримеч();
            if (s==null)
                s= "";
            String prog = progsEntity.getId()+" |"+progsEntity.getНаим()+" / "+progsEntity.getПрофПрогр()+" / "+progsEntity.getФормаОбуч()+"-"+
                    progsEntity.getПланСрок()+"-"+progsEntity.getКвалифик()+" / "+ s;
            progName.add(prog);
        }

        ArrayList<String> metodistName = new ArrayList<String>();

        for (MetodistsEntity metodistsEntity : metodistsEntityList)
        {
            String s = metodistsEntity.getФамилия();
            metodistName.add(s);
        }

        Object[] progOb = progName.toArray();
        Object[] metodistOb = metodistName.toArray();

        JComboBox comboBox1 = new JComboBox(progOb);
        JComboBox comboBox2 = new JComboBox(metodistOb);

        final DefaultCellEditor editor1 = new DefaultCellEditor(comboBox1);
        final DefaultCellEditor editor2 = new DefaultCellEditor(comboBox2);
        table.getColumnModel().getColumn(4).setCellEditor(editor1);
        table.getColumnModel().getColumn(7).setCellEditor(editor2);

        DateCellEditor dateCellEditor1 = new DateCellEditor();
        table.getColumnModel().getColumn(3).setCellEditor(dateCellEditor1);

        DateCellEditor dateCellEditor2 = new DateCellEditor();
        table.getColumnModel().getColumn(8).setCellEditor(dateCellEditor2);

        ButtonsMenu menu = new ButtonsMenu(table,list) {
            @Override
            public Object getEntity() {
                GroupsEntity entity = new GroupsEntity();
                int selectedRow = table.getSelectedRow();
                entity.setId((Integer) model.getValueAt(selectedRow,0));
                entity.setСокрНг((String) model.getValueAt(selectedRow,2));
                JComboBox box1 = (JComboBox) editor1.getComponent();
                int index1 = box1.getSelectedIndex();
                entity.setКодПрогр(progsEntityList.get(index1));
                JComboBox box2 = (JComboBox) editor2.getComponent();
                int index2 = box2.getSelectedIndex();
                entity.setКодМет(metodistsEntityList.get(index2));
                entity.setРасшПрог((String) model.getValueAt(selectedRow,5));
                entity.setПрофПрог((String) model.getValueAt(selectedRow,6));
                entity.setДатаОткр((Timestamp) model.getValueAt(selectedRow,3));
                entity.setДатаЗакр((Timestamp) model.getValueAt(selectedRow,8));
                entity.setПрЭксп((Boolean) model.getValueAt(selectedRow,9));
                entity.setПримеч((String) model.getValueAt(selectedRow,10));
                return entity;
            }
        };

        slovFactory = new SlovFactory(text,factory,menu);
    }

    public void close(){
        slovFactory.dispose();
    }
}
