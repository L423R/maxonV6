package frames.tabbedPanels.raspFrames.slovFrames;

import dao.DiscEntity;
import dao.GroupsEntity;
import dao.PrepsEntity;
import dao.RaspEntity;
import models.MainModel;
import org.jdesktop.swingx.table.DatePickerCellEditor;
import utils.ButtonsMenu;
import utils.Cache;
import utils.SlovFactory;
import utils.TableFactory;

import javax.swing.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxon on 07.03.2017.
 */
public class RaspFrame {
    private SlovFactory slovFactory;
    public RaspFrame(Date date1, Date date2, final GroupsEntity groupsEntity) {
        String[] head = {"Дата","НачЗан","Час","ТипЗан","День","Наименование Дисциплины","Препод","ТипОпл","Ставка","Пр.Опл","Примечание"};
        int[] widths = {100,50,25,80,80,300,120,80,80,40,120};
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM yyyy");
        String text = "Расписание занятий группы на интервале с "+simpleDateFormat.format(date1)+" по "+simpleDateFormat.format(date2);
        final List<DiscEntity> discEntityList = Cache.getDiscEntityList();
        final List<PrepsEntity> prepsEntityList = Cache.getPrepsEntityList();
        List<RaspEntity> raspEntityList = Cache.getRaspEntityList();
        List list = new ArrayList();

        for (RaspEntity entity:raspEntityList)
        {
            Timestamp timestamp1 = entity.getДатаЗан();
            if (timestamp1!=null) {
                long time1 = date1.getTime();
                long time2 = date2.getTime();
                long time3 = timestamp1.getTime();
                if ((entity.getКодГруп().getId()==groupsEntity.getId()) && (time1<=time3) &&(time2>=time3)) {
                list.add(entity);
                }
            }
        }

        TableFactory factory = new TableFactory(head,widths,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    RaspEntity entity = (RaspEntity) list.get(i);
                    //mas[i][0] = entity.getId();
                    mas[i][0] = entity.getДатаЗан();
                    String format = new SimpleDateFormat("HH:mm").format(new Date(entity.getНачЗан().getTime()));
                    mas[i][1] = format;
                    mas[i][2] = entity.getКолЧас();
                    mas[i][3] = entity.getТипЗан();
                    mas[i][4] = entity.getДень();
                    mas[i][5] = entity.getКодДисц().getНаимДисц();
                    mas[i][6] = entity.getКодПреп().getФамилия()+" "+entity.getКодПреп().getИмя();
                    mas[i][7] = entity.getТипСтуд();
                    mas[i][8] = entity.getСтавка();
                    mas[i][9] = entity.getПрОпл();
                    mas[i][10] = entity.getПримеч();
                }
            }
        };

        final JTable table = factory.getTable();

        ArrayList<String> discNames = new ArrayList<String>();

        for (DiscEntity entity : discEntityList)
        {
            discNames.add(entity.getНаимДисц());
        }

        ArrayList<String> prepNames = new ArrayList<String>();

        for (PrepsEntity entity: prepsEntityList)
            prepNames.add(entity.getФамилия()+" "+entity.getИмя());

        final JComboBox disc = new JComboBox(discNames.toArray());

        final JComboBox preps = new JComboBox(prepNames.toArray());

        String[] nach = {"10:10","11:50","14:00","15:40","17:20","19:00","20:40"};

        Object[] on = {(byte)2,(byte)4,(byte)6,(byte)8};

        String[] day ={"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье",};

        String[] tipZ = {"","Начало","Занятие","Экзамен","Зачет","Курс.Раб","Экз+Кур.Р","Зач+Кур.Р","Зач с ОЦ"};

        JComboBox nachalo = new JComboBox(nach);
        JComboBox chasbI = new JComboBox(on);
        JComboBox days = new JComboBox(day);
        JComboBox tipOpl = new JComboBox(new String[]{"Бакалавр","Магистр"});
        JComboBox tip = new JComboBox(tipZ);


        DefaultCellEditor editor2 = new DefaultCellEditor(nachalo);
        DefaultCellEditor editor3 = new DefaultCellEditor(chasbI);
        DefaultCellEditor editor4 = new DefaultCellEditor(tip);
        DefaultCellEditor editor5 = new DefaultCellEditor(days);
        DefaultCellEditor editor6 = new DefaultCellEditor(disc);
        DefaultCellEditor editor7 = new DefaultCellEditor(preps);
        DefaultCellEditor editor8 = new DefaultCellEditor(tipOpl);
        table.getColumnModel().getColumn(1).setCellEditor(editor2);
        table.getColumnModel().getColumn(2).setCellEditor(editor3);
        table.getColumnModel().getColumn(3).setCellEditor(editor4);
        table.getColumnModel().getColumn(4).setCellEditor(editor5);
        table.getColumnModel().getColumn(5).setCellEditor(editor6);
        table.getColumnModel().getColumn(6).setCellEditor(editor7);
        table.getColumnModel().getColumn(7).setCellEditor(editor8);

        DatePickerCellEditor datePickerCellEditor = new DatePickerCellEditor();
        table.getColumnModel().getColumn(0).setCellEditor(datePickerCellEditor);


        ButtonsMenu menu = new ButtonsMenu(table,raspEntityList) {
            @Override
            public Object getEntity() {
                RaspEntity entity = new RaspEntity();
                int selectedRow = table.getSelectedRow();
               // entity.setId((Integer) model.getValueAt(selectedRow,0));
                entity.setКодГруп(groupsEntity);
                entity.setСеместр((byte) groupsEntity.getCurrSem());
                Date date = (Date) model.getValueAt(selectedRow,0);
                entity.setДатаЗан(new Timestamp(date.getTime()));
                entity.setНачЗан(Timestamp.valueOf("2017-01-13 "+model.getValueAt(selectedRow,1)+":00"));
                entity.setКолЧас((Byte) model.getValueAt(selectedRow,2));
                entity.setТипЗан((String) model.getValueAt(selectedRow,3));
                entity.setДень((String) model.getValueAt(selectedRow,4));
                entity.setКодДисц(discEntityList.get(disc.getSelectedIndex()));
                entity.setКодПреп(prepsEntityList.get(preps.getSelectedIndex()));
                entity.setТипСтуд((String) model.getValueAt(selectedRow,7));
                entity.setСтавка((Double) model.getValueAt(selectedRow,8));
                entity.setПрОпл((Boolean) model.getValueAt(selectedRow,9));
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
