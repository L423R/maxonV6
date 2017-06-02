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
    private static PrepDao prepDao = null;
    private static RaspDao raspDao = null;
    private static NprDao nprDao = null;
    private static NagrRabDao nagrRabDao = null;
    private static GodDao godDao = null;
    private static StavkiDao stavkiDao = null;

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

    public PrepDao getPrepDao(){
        if (prepDao==null)
            prepDao = new PrepDaoImpl();
        return prepDao;
    }

    public RaspDao getRaspDao(){
        if (raspDao==null)
            raspDao = new RaspDaoImpl();
        return raspDao;
    }

    public NprDao getNprDao(){
        if (nprDao==null)
            nprDao = new NprDaoImpl();
        return nprDao;
    }

    public NagrRabDao getNagrRabDao(){
        if(nagrRabDao==null)
            nagrRabDao = new NagrRabDaoImpl();
        return nagrRabDao;
    }

    public GodDao getGodDao(){
        if (godDao==null)
            godDao = new GodDaoImpl();
        return godDao;
    }

    public StavkiDao getStavkiDao(){
        if (stavkiDao==null)
            stavkiDao = new StavkiDaoImpl();
        return stavkiDao;
    }
}
