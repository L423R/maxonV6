package utils;

import dao.*;

/**
 * Created by Maxon on 03.04.2017.
 */
public class DaoFactory {

    private static DaoFactory daoFactory = null;

    private static DateSemDao dateSemDao = null;
    private static DiscDao discDao = null;
    private static KafDao kafDao = null;
    private static ProgDao progDao = null;
    private static MethodistDao metodistDao = null;
    private static GroupDao groupDao = null;
    private static NapravlDao napravlDao = null;

    private DaoFactory() {
    }

    public static synchronized DaoFactory getDaoFactory() {
        if (daoFactory==null)
            daoFactory = new DaoFactory();
        return daoFactory;
    }

    public DateSemDao getDateSemDao() {
        if (dateSemDao==null)
            dateSemDao = new DateSemDaoImpl();
        return dateSemDao;
    }

    public DiscDao getDiscDao(){
        if (discDao==null)
            discDao = new DiscDaoImpl();
        return discDao;
    }

    public KafDao getKafDao(){
        if (kafDao==null)
            kafDao = new KafDaoImpl();
        return kafDao;
    }

    public ProgDao getProgDao(){
        if (progDao==null)
            progDao = new ProgDaoImpl();
        return progDao;
    }

    public MethodistDao getMetodistDao(){
        if (metodistDao ==null)
            metodistDao = new MetodistDaoImpl();
        return metodistDao;
    }

    public GroupDao getGroupDao(){
        if (groupDao==null)
            groupDao = new GroupDaoImpl();
        return groupDao;
    }

    public NapravlDao getNapravlDao(){
        if (napravlDao==null)
            napravlDao = new NapravlDaoImpl();
        return napravlDao;
    }
}
