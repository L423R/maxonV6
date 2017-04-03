package utils;

import entities.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Maxon on 23.03.2017.
 */
public class Cache {
    private static List<DateSemEntity> dateSemEntityList;
    private static List<DiscEntity> discEntityList;
    private static List<KafEntity> kafEntityList;
    private static List<ProgsEntity> progsEntityList;
    private static List<NapravlEntity> napravlEntityList;
    private static List<MetodistsEntity> metodistsEntityList;
    private static List<GroupsEntity> groupsEntityList;
    private static List<NprEntity> nprEntityList;
    private static List<StavkiEntity> stavkiEntityList;
    private static List<PrepsEntity> prepsEntityList;
    private static List<RaspEntity> raspEntityList;
    private static Session session;
    private static Transaction transaction=null;

    public static void load() {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            // выполнение запросов
            dateSemEntityList = getDateSemList();
            discEntityList = getDiscList();
            kafEntityList = getKafList();
            progsEntityList = getProgsList();
            napravlEntityList = getNapravlList();
            metodistsEntityList = getMethodistsList();
            groupsEntityList = getGroupsList();
            nprEntityList = getNprList();
            stavkiEntityList = getStavkiList();
            prepsEntityList = getPrepsList();
            raspEntityList = getRaspList();


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
    }

    private static List<DiscEntity> getDiscList()
    {
        List<DiscEntity> list = session.createQuery("from DiscEntity").list();
        return list;
    }

    private static List<KafEntity> getKafList() {
        List<KafEntity> list = session.createQuery("from KafEntity").list();
        return list;
    }

    private static List<ProgsEntity> getProgsList()
    {
        List<ProgsEntity> list = session.createQuery("from ProgsEntity").list();

        return list;
    }

    private static List<NapravlEntity> getNapravlList()
    {
        List<NapravlEntity> list = session.createQuery("from NapravlEntity ").list();

        return list;
    }

    private static List<MetodistsEntity> getMethodistsList()
    {
        List<MetodistsEntity> list = session.createQuery("from MetodistsEntity ").list();
        return list;
    }

    private static List<GroupsEntity> getGroupsList()
    {
        List<GroupsEntity> list = session.createQuery("from GroupsEntity ").list();
        return list;
    }

    private static List<DateSemEntity> getDateSemList()
    {
        List<DateSemEntity> list = session.createQuery("from DateSemEntity").list();
        return list;
    }

    private static List<NprEntity> getNprList()
    {
        List list = session.createQuery("from NprEntity ").list();
        return list;
    }

    private static List<StavkiEntity> getStavkiList()
    {
        List list = session.createQuery("from StavkiEntity").list();
        return list;
    }

    private static List<PrepsEntity> getPrepsList()
    {
        List list = session.createQuery("from PrepsEntity ").list();
        return list;
    }

    private static List<RaspEntity> getRaspList()
    {
        List list = session.createQuery("from RaspEntity").list();
        return list;
    }

    public static List<DateSemEntity> getDateSemEntityList() {
        return dateSemEntityList;
    }

    public static List<DiscEntity> getDiscEntityList() {
        return discEntityList;
    }

    public static List<KafEntity> getKafEntityList() {
        return kafEntityList;
    }

    public static List<ProgsEntity> getProgsEntityList() {
        return progsEntityList;
    }

    public static List<NapravlEntity> getNapravlEntityList() {
        return napravlEntityList;
    }

    public static List<MetodistsEntity> getMetodistsEntityList() {
        return metodistsEntityList;
    }

    public static List<GroupsEntity> getGroupsEntityList() {
        return groupsEntityList;
    }

    public static List<NprEntity> getNprEntityList() {
        return nprEntityList;
    }

    public static List<StavkiEntity> getStavkiEntityList() {
        return stavkiEntityList;
    }

    public static List<PrepsEntity> getPrepsEntityList() {
        return prepsEntityList;
    }

    public static List<RaspEntity> getRaspEntityList() {
        return raspEntityList;
    }
}
