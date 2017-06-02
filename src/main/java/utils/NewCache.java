package utils;

import entities.*;

import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public class NewCache {

    private static NewCache cache = null;

    private static List<DiscEntity> discEntities = null;
    private static List<KafEntity> kafEntities = null;
    private static List<ProgsEntity> progsEntities = null;
    private static List<MetodistsEntity> metodistsEntities = null;
    private static List<GroupsEntity> groupsEntities = null;
    private static List<NapravlEntity> napravlEntities = null;
    private static List<PrepsEntity> prepsEntities = null;
    private static List<NprEntity> nprEntities = null;
    private static List<NagrRabEntity> nagrRabEntities = null;
    private static List<StavkiEntity> stavkiEntities = null;

    public static synchronized NewCache getCache() {
        if (cache==null)
            cache = new NewCache();
        return cache;
    }

    public List<DiscEntity> getDiscEntities(){
        if (discEntities==null)
          discEntities = DaoFactory.getDaoFactory().getDiscDao().getList("from DiscEntity");

        return discEntities;
    }

    public List<KafEntity> getKafEntities(){
        if (kafEntities==null)
            kafEntities = DaoFactory.getDaoFactory().getKafDao().getList("from KafEntity");
        return kafEntities;
    }

    public List<ProgsEntity> getProgsEntities(){
        if (progsEntities==null)
            progsEntities = DaoFactory.getDaoFactory().getProgDao().getList("from ProgsEntity");
        return progsEntities;
    }

    public List<MetodistsEntity> getMetodistsEntities(){
        if (metodistsEntities==null)
            metodistsEntities = DaoFactory.getDaoFactory().getMetodistDao().getList("from MetodistsEntity");
        return metodistsEntities;
    }

    public List<GroupsEntity> getGroupsEntities(){
        if (groupsEntities==null)
            groupsEntities = DaoFactory.getDaoFactory().getGroupDao().getList("from GroupsEntity");
        return groupsEntities;
    }

    public List<NapravlEntity> getNapravlEntities(){
        if (napravlEntities ==null)
            napravlEntities = DaoFactory.getDaoFactory().getNapravlDao().getList("from NapravlEntity");
        return napravlEntities;
    }

    public List<PrepsEntity> getPrepsEntities(){
        if (prepsEntities==null)
            prepsEntities = DaoFactory.getDaoFactory().getPrepDao().getList("from PrepsEntity");
        return prepsEntities;
    }

    public List<NprEntity> getNprEntities(){
        if (nprEntities==null)
            nprEntities = DaoFactory.getDaoFactory().getNprDao().getList("from NprEntity");
        return nprEntities;
    }

    public List<NagrRabEntity> getNagrRabEntities(){
        if (nagrRabEntities==null)
            nagrRabEntities = DaoFactory.getDaoFactory().getNagrRabDao().getList("from NagrRabEntity");
        return nagrRabEntities;
    }

    public List<StavkiEntity> getStavkiEntities(){
        if (stavkiEntities==null)
            stavkiEntities = DaoFactory.getDaoFactory().getStavkiDao().getList("from StavkiEntity");
        return stavkiEntities;
    }



    public void CleanDisc(){
        discEntities = null;
    }

    public void CleanKaf(){
        kafEntities = null;
    }

    public void CleanProg(){
        progsEntities = null;
    }

    public void CleanMetodist(){
        metodistsEntities = null;
    }

    public void CleanGroup(){
        groupsEntities = null;
    }

    public void CleanNapravl(){
        napravlEntities = null;
    }

    public void CleanPrep(){
        prepsEntities = null;
    }

    public void CleanNpr(){
        nprEntities = null;
    }

    public void CleanNagrRab(){
        nagrRabEntities = null;
    }

    public void CleanStavki(){
        stavkiEntities = null;
    }


}
