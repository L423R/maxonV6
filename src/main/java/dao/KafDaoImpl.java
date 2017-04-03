package dao;

import entities.KafEntity;
import utils.NewCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public class KafDaoImpl extends DaoImpl implements KafDao {

    @Override
    public Object[] getKafNames() {
        //List list = super.getList("from KafEntity");
        List<KafEntity> list = NewCache.getCache().getKafEntities();
        ArrayList<String> list1 = new ArrayList();
        for (Object x: list)
        {
            KafEntity kafEntity = (KafEntity) x;
            list1.add(kafEntity.getНаимКаф());

        }
        Object[] objects = list1.toArray();
        return objects;
    }
}
