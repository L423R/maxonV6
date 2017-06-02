package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public class PrepDaoImpl extends DaoImpl implements PrepDao {
    @Override
    public Object[] getStepMas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<String> list = null;
        List currList = new ArrayList();
        try{



            list = session.createQuery("select p.наимСтеп from PrepsEntity p")
                    .list();

            transaction.commit();

            for (String s:list)
                if (!(currList.contains(s)))
                    currList.add(s);


        }catch (Throwable t) {
            System.out.println("error");
            t.printStackTrace();
            transaction.rollback();
        }finally {
            // закрытие сессии
            session.close();
        }


        return currList.toArray();
    }

    @Override
    public Object[] getZvanMas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<String> list = null;
        List currList = new ArrayList();
        try{



            list = session.createQuery("select p.наимЗван from PrepsEntity p")
                    .list();

            transaction.commit();

            for (String s:list)
                if (!(currList.contains(s)))
                    currList.add(s);


        }catch (Throwable t) {
            System.out.println("error");
            t.printStackTrace();
            transaction.rollback();
        }finally {
            // закрытие сессии
            session.close();
        }


        return currList.toArray();
    }

    @Override
    public Object[] getDoljnMas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<String> list = null;
        List currList = new ArrayList();
        try{



            list = session.createQuery("select p.должн from PrepsEntity p")
                    .list();

            transaction.commit();

            for (String s:list)
                    if (!(currList.contains(s)))
                        currList.add(s);

        }catch (Throwable t) {
            System.out.println("error");
            t.printStackTrace();
            transaction.rollback();
        }finally {
            // закрытие сессии
            session.close();
        }


        return currList.toArray();
    }

    @Override
    public Object[] getDoljnFdoMas() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<String> list = null;
        List currList = new ArrayList();
        try{



            list = session.createQuery("select p.должнФдо from PrepsEntity p")
                    .list();

            transaction.commit();

            for (String s:list)
                if (!(currList.contains(s)))
                    currList.add(s);

        }catch (Throwable t) {
            System.out.println("error");
            t.printStackTrace();
            transaction.rollback();
        }finally {
            // закрытие сессии
            session.close();
        }


        return currList.toArray();
    }
}
