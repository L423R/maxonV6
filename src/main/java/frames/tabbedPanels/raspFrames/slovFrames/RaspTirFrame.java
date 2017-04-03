package frames.tabbedPanels.raspFrames.slovFrames;

import entities.GroupsEntity;
import entities.RaspEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import utils.SlovFactory;
import utils.TableFactory;

import javax.swing.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxon on 10.03.2017.
 */
public class RaspTirFrame {
    private SlovFactory slovFactory;
    public RaspTirFrame(Date date1, Date date2, GroupsEntity groupsEntity, String t) throws Throwable {
        String[] head = {"Дата","НачЗан","Час","ТипЗан","Наименование Дисциплины","Препод","Ставка","Аудит","Примечание","Оборуд-е"};
        int[] widhts = {80,50,30,70,200,120,80,50,140,80};
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM yyyy");
        String text = "Расписание занятий группы - "+t+" на интервале с "+simpleDateFormat.format(date1)+" по "+simpleDateFormat.format(date2);
        /*List<RaspEntity> raspEntityList = model.getRaspEntityList();
        List list = new ArrayList();

        for (RaspEntity entity : raspEntityList)
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
        }*/
        List list = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            Timestamp timestamp1 = new Timestamp(date1.getTime());
            Timestamp timestamp2 = new Timestamp(date2.getTime());

            list = session.createQuery("from RaspEntity where КодГруп =:КодГруп and ДатаЗан between :start and :end ")
                    .setParameter("КодГруп",groupsEntity)
                    .setParameter("start",timestamp1)
                    .setParameter("end",timestamp2)
                    .list();

            transaction.commit();

        } finally {
            // закрытие сессии
            session.close();
        }

        TableFactory factory = new TableFactory(head,widhts,list) {
            @Override
            public void fillMas() {
                for (int i = 0; i < mas.length; i++) {
                    RaspEntity entity = (RaspEntity) list.get(i);
                    mas[i][0] = entity.getДатаЗан();
                    String format = new SimpleDateFormat("HH:mm").format(new Date(entity.getНачЗан().getTime()));
                    mas[i][1] = format;
                    mas[i][2] = entity.getКолЧас();
                    mas[i][3] = entity.getТипЗан();
                    mas[i][4] = entity.getКодДисц().getНаимДисц();
                    mas[i][5] = entity.getКодПреп().getФамилия()+" "+entity.getКодПреп().getИмя();
                    mas[i][6] = entity.getСтавка();
                    mas[i][7] = entity.getАудит();
                    mas[i][8] = entity.getПримеч();
                    mas[i][9] = entity.getОборуд();
                }
            }
        };

        JTable table = factory.getTable();
        table.setEnabled(false);

        slovFactory = new SlovFactory(text,factory,null);
    }

    public void close(){
        slovFactory.dispose();
    }

}
