package dao;

import entities.GroupsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public class GroupDaoImpl extends DaoImpl implements GroupDao {
    @Override
    public List getOpenGr(Date date1,Date date2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List list = null;
        try{

            Timestamp timestamp1 = new Timestamp(date1.getTime());
            Timestamp timestamp2 = new Timestamp(date2.getTime());


            list = session.createQuery("from GroupsEntity g where g.датаЗакр=null and g.датаОткр between :start and :end ")
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

    @Override
    public Object[] getNamesGr(List<GroupsEntity> list) {
        List names = new ArrayList();
        for (GroupsEntity entity:list)
        names.add(entity.getCurrName());
        return names.toArray();
    }

    @Override
    public List getOpenGrClone(Date date1, Date date2, GroupsEntity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List list = null;
        try{

            Timestamp timestamp1 = new Timestamp(date1.getTime());
            Timestamp timestamp2 = new Timestamp(date2.getTime());


            list = session.createQuery("from GroupsEntity g where g.датаЗакр=null and g.кодПрогр=:kodProg and g.датаОткр between :start and :end ")
                    .setParameter("kodProg",entity.getКодПрогр())
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
