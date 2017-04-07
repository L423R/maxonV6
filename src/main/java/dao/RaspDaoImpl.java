package dao;

import entities.GroupsEntity;
import entities.RaspEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public class RaspDaoImpl extends DaoImpl implements RaspDao {
    @Override
    public List<RaspEntity> getCurrRaspForGr(Date date1, Date date2, GroupsEntity groupsEntity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List list = null;
        try{

            Timestamp timestamp1 = new Timestamp(date1.getTime());
            Timestamp timestamp2 = new Timestamp(date2.getTime());


            list = session.createQuery("from RaspEntity r where r.кодГруп =:КодГруп and r.датаЗан between :start and :end ")
                    .setParameter("КодГруп",groupsEntity)
                    .setParameter("start",timestamp1)
                    .setParameter("end",timestamp2)
                    .list();

            transaction.commit();


        }catch (Throwable t) {
            System.out.println("error");
            t.printStackTrace();
            transaction.rollback();
        }finally {
            // закрытие сессии
            session.close();
        }

        return list;
    }
}
