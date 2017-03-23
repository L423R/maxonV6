package models;

import frames.tabbedPanels.raspFrames.CorrRaspFrame;
import frames.tabbedPanels.raspFrames.FormRaspFrame;
import frames.tabbedPanels.raspFrames.TirGrFrame;
import frames.tabbedPanels.raspFrames.slovFrames.*;

import java.util.Date;

/**
 * Created by Maxon on 23.03.2017.
 */
public class RaspModel {
    private Date date1;
    private Date date2;

    private DiscFrame discFrame;
    private KafFrame kafFrame;
    private ProgsFrame progsFrame;
    private GroupsFrame groupsFrame;
    private NapravlFrame napravlFrame;
    private MethodistsFrame methodistsFrame;
    private FormRaspFrame formRaspFrame;
    private CorrRaspFrame corrRaspFrame;
    private TirGrFrame tirGrFrame;


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

    public DiscFrame getDiscFrame() {
        return discFrame;
    }

    public void setDiscFrame(DiscFrame discFrame) {
        this.discFrame = discFrame;
    }

    public KafFrame getKafFrame() {
        return kafFrame;
    }

    public void setKafFrame(KafFrame kafFrame) {
        this.kafFrame = kafFrame;
    }

    public ProgsFrame getProgsFrame() {
        return progsFrame;
    }

    public void setProgsFrame(ProgsFrame progsFrame) {
        this.progsFrame = progsFrame;
    }

    public GroupsFrame getGroupsFrame() {
        return groupsFrame;
    }

    public void setGroupsFrame(GroupsFrame groupsFrame) {
        this.groupsFrame = groupsFrame;
    }

    public NapravlFrame getNapravlFrame() {
        return napravlFrame;
    }

    public void setNapravlFrame(NapravlFrame napravlFrame) {
        this.napravlFrame = napravlFrame;
    }

    public MethodistsFrame getMethodistsFrame() {
        return methodistsFrame;
    }

    public void setMethodistsFrame(MethodistsFrame methodistsFrame) {
        this.methodistsFrame = methodistsFrame;
    }

    public FormRaspFrame getFormRaspFrame() {
        return formRaspFrame;
    }

    public void setFormRaspFrame(FormRaspFrame formRaspFrame) {
        this.formRaspFrame = formRaspFrame;
    }

    public CorrRaspFrame getCorrRaspFrame() {
        return corrRaspFrame;
    }

    public void setCorrRaspFrame(CorrRaspFrame corrRaspFrame) {
        this.corrRaspFrame = corrRaspFrame;
    }

    public TirGrFrame getTirGrFrame() {
        return tirGrFrame;
    }

    public void setTirGrFrame(TirGrFrame tirGrFrame) {
        this.tirGrFrame = tirGrFrame;
    }
}
