package dao;

import entities.ProgsEntity;
import utils.NewCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public class ProgDaoImpl extends DaoImpl implements ProgDao {

    @Override
    public Object[] getProgNames() {

        List<ProgsEntity> list = NewCache.getCache().getProgsEntities();
        ArrayList<String> progName = new ArrayList<String>();
        for (ProgsEntity progsEntity : list)
        {
            String s = progsEntity.getПримеч();
            if (s==null)
                s= "";
            String prog = progsEntity.getId()+" |"+progsEntity.getНаим()+" / "+progsEntity.getПрофПрогр()+" / "+progsEntity.getФормаОбуч()+"-"+
                    progsEntity.getПланСрок()+"-"+progsEntity.getКвалифик()+" / "+ s;
            progName.add(prog);
        }
        return progName.toArray();
    }
}
