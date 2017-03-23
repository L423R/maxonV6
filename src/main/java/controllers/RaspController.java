package controllers;

import frames.tabbedPanels.raspFrames.CorrRaspFrame;
import frames.tabbedPanels.raspFrames.FormRaspFrame;
import frames.tabbedPanels.raspFrames.TirGrFrame;
import frames.tabbedPanels.raspFrames.slovFrames.*;
import models.RaspModel;

import java.util.Date;


/**
 * Created by Maxon on 23.03.2017.
 */
public class RaspController {

    private RaspModel model;

    public RaspController(RaspModel model) {
        this.model = model;
    }

    public Date getDateStart(){
        return model.getDate1();
    }

    public Date getDateEnd(){
        return model.getDate2();
    }

    public void ShowDiscFrame(){
        DiscFrame frame = model.getDiscFrame();
        if (frame!=null)
            frame.close();
        model.setDiscFrame(new DiscFrame());
    }

    public void ShowKafFrame(){
        KafFrame frame = model.getKafFrame();
        if (frame!=null)
            frame.close();
        model.setKafFrame(new KafFrame());
    }

    public void ShowProgsFrame(){
        ProgsFrame frame = model.getProgsFrame();
        if (frame!=null)
            frame.close();
        model.setProgsFrame(new ProgsFrame());
    }

    public void ShowGroupsFrame(){
        GroupsFrame frame = model.getGroupsFrame();
        if (frame!=null)
            frame.close();
        model.setGroupsFrame(new GroupsFrame());
    }

    public void ShowNapravlFrame(){
        NapravlFrame frame = model.getNapravlFrame();
        if (frame!=null)
            frame.close();
        model.setNapravlFrame(new NapravlFrame());
    }

    public void ShowMethodistsFrame(){
        MethodistsFrame frame = model.getMethodistsFrame();
        if (frame!=null)
            frame.close();
        model.setMethodistsFrame(new MethodistsFrame());
    }

    public void ShowFormRaspFrame(){
        FormRaspFrame frame = model.getFormRaspFrame();
        if (frame!=null)
            frame.dispose();
        model.setFormRaspFrame(new FormRaspFrame(this));
    }

    public void showCorrRaspFrame(){
        CorrRaspFrame frame = model.getCorrRaspFrame();
        if (frame!=null)
            frame.dispose();
        model.setCorrRaspFrame(new CorrRaspFrame());
    }

    public void showTirGrFrame(){
        TirGrFrame frame = model.getTirGrFrame();
        if (frame!=null)
            frame.dispose();
        model.setTirGrFrame(new TirGrFrame());
    }
}
