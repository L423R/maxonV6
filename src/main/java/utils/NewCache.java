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
}
