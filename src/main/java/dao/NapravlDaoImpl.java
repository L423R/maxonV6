package dao;

import entities.NapravlEntity;
import utils.NewCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public class NapravlDaoImpl extends DaoImpl implements NapravlDao {
    @Override
    public Object[] getNapravlNames() {

        List<NapravlEntity> list = NewCache.getCache().getNapravlEntities();
        ArrayList<String> list1 = new ArrayList<String>();
        for (Object x: list)
        {
            NapravlEntity napravlEntity = (NapravlEntity) x;
            list1.add(napravlEntity.getНаимНапр());
        }
        return list1.toArray();
    }
}
