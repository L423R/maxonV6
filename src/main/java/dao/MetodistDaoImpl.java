package dao;

import entities.MetodistsEntity;
import utils.NewCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public class MetodistDaoImpl extends DaoImpl implements MethodistDao {
    @Override
    public Object[] getMetoDistNames() {

        List<MetodistsEntity> list = NewCache.getCache().getMetodistsEntities();
        ArrayList<String> metodistName = new ArrayList<String>();
        for (MetodistsEntity metodistsEntity : list)
        {
            String s = metodistsEntity.getФамилия();
            metodistName.add(s);
        }
        return metodistName.toArray();
    }
}
