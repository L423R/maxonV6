package dao;

import entities.NprEntity;
import utils.NewCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 07.04.2017.
 */
public class NprDaoImpl extends DaoImpl implements NprDao {
    @Override
    public Object[] getNamesNpr() {
        List<NprEntity> list = NewCache.getCache().getNprEntities();
        List names = new ArrayList();
        for (NprEntity entity: list)
            names.add(entity.getНаимНпр());
        return names.toArray();
    }
}
