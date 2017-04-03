package dao;

import entities.DateSemEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public class DateSemDaoImpl extends DaoImpl implements DateSemDao {

    @Override
    public Object[] getSems()
    {
        ArrayList<String> names = new ArrayList<>();
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
    }
}
