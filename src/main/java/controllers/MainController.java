package controllers;

import entities.DateSemEntity;
import frames.MainFrame;
import models.MainModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import utils.InitCache;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxon on 18.03.2017.
 */
public class MainController {

    private MainModel model;

    public MainModel getModel() {
        return model;
    }

    public void setModel(MainModel model) {
        this.model = model;
    }


    public Date getDateStart()
    {

        return new Date(model.getEntity().getНачСем().getTime());
    }

    public Date getDateEnd()
    {
        return new Date(model.getEntity().getКонСем().getTime());
    }

    /*public Object[] getSems()
    {
        ArrayList names = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction= null;
        try {
            transaction = session.beginTransaction();
            // выполнение запросов

            List<DateSemEntity> list = session.createQuery("from DateSemEntity").list();
            transaction.commit();
            for (DateSemEntity entity:list)
                names.add(entity.getНаимСем());
        }
        catch (RuntimeException e) {
            if (transaction != null) {
                // откат транзакции
                transaction.rollback();
            }
            throw e;
        }
        finally {
            // закрытие сессии
            session.close();
        }
        return names.toArray();
    }*/


    public void startMainFrame(Date date1, Date date2, int index) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction= null;
        DateSemEntity entity;
        try {
            transaction = session.beginTransaction();
            // выполнение запросов

            entity = (DateSemEntity) session.get(DateSemEntity.class,index+1);
            transaction.commit();

        }
        catch (RuntimeException e) {
            if (transaction != null) {
                // откат транзакции
                transaction.rollback();
            }
            throw e;
        }
        finally {
            // закрытие сессии
            session.close();
        }
        System.out.println(entity.getНаимСем());
        //MainModel model = new MainModel(date1,date2,entity);
       // InitCache.init();
        model = new MainModel(date1,date2,entity);
        MainFrame mainFrame = new MainFrame(this);
        mainFrame.setVisible(true);
    }
}
