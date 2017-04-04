package tests;

import entities.DiscEntity;
import entities.KafEntity;
import entities.PrepsEntity;
import utils.NewCache;

import java.util.Collection;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public class testPrep {
    public static void main(String[] args) {
        List<DiscEntity> discEntities = NewCache.getCache().getDiscEntities();

        DiscEntity entity = discEntities.get(1);
        KafEntity kafEntity = entity.getКодКаф();
        Collection<PrepsEntity> prepsList = kafEntity.getPrepsList();

        for (PrepsEntity p:prepsList)
            System.out.println(p.getИмя()+"  "+p.getФамилия());


    }
}
