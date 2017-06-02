package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Maxon on 08.04.2017.
 */
public class StavkiDaoImpl extends DaoImpl implements StavkiDao {
    @Override
    public List getStavkiByVid(int index) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List list = null;
        try{



            list = session.createQuery("from StavkiEntity s where s.кодВида=:vid ")
                    .setParameter("vid",index)
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
