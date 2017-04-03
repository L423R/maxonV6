package models;

import entities.*;


import java.util.Date;

/**
 * Created by Maxon on 21.02.2017.
 */
public class MainModel {
    private Date date1;
    private Date date2;
    private DateSemEntity entity;

    public MainModel(Date date1, Date date2, DateSemEntity entity) {
        this.date1 = date1;
        this.date2 = date2;
        this.entity = entity;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public DateSemEntity getEntity() {
        return entity;
    }

    public void setEntity(DateSemEntity entity) {
        this.entity = entity;
    }

}
