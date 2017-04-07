package dao;

import entities.GroupsEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public interface GroupDao extends Dao {
    List getOpenGr(Date date1, Date date2);
    List getOpenGrClone(Date date1, Date date2, GroupsEntity entity);
    Object[] getNamesGr(List<GroupsEntity> list);
}
