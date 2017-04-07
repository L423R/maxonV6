package dao;

import entities.GroupsEntity;
import entities.RaspEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by Maxon on 03.04.2017.
 */
public interface RaspDao extends Dao {
    List<RaspEntity> getCurrRaspForGr(Date date1, Date date2, GroupsEntity groupsEntity);
}
