package controllers;

import frames.tabbedPanels.docsFrames.FirstDocsFrame;
import frames.tabbedPanels.docsFrames.SecondDocsFrame;
import frames.tabbedPanels.docsFrames.ThirdDocsFrame;
import frames.tabbedPanels.docsFrames.slovFrames.*;
import models.DocsModel;

import java.util.Date;

/**
 * Created by Maxon on 25.03.2017.
 */
public class DocsController {

    private DocsModel model;

    private Date dateStart;
    private Date dateEnd;


    public DocsController(DocsModel model) {
        this.model = model;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void showFirstFrame(){
        FirstDocsFrame frame = model.getFirstDocsFrame();
        if (frame!=null)
            frame.dispose();
        model.setFirstDocsFrame(new FirstDocsFrame(this));
    }

    public void showSecondFrame(){
        SecondDocsFrame frame = model.getSecondDocsFrame();
        if (frame!=null)
            frame.dispose();
        model.setSecondDocsFrame(new SecondDocsFrame());
    }

    public void showThirdFrame(){
        ThirdDocsFrame frame = model.getThirdDocsFrame();
        if (frame!=null)
            frame.dispose();
        model.setThirdDocsFrame(new ThirdDocsFrame());
    }

    public void showNprFrame(){
        NprFrame frame = model.getNprFrame();
        if (frame!=null)
            frame.close();
        model.setNprFrame(new NprFrame());
    }

    public void showNagrRabFrame(){
        NagrRabFrame frame = model.getNagrRabFrame();
        if (frame!=null)
            frame.close();
        model.setNagrRabFrame(new NagrRabFrame());
    }

    public void showGodFrame(){
        GodFrame frame = model.getGodFrame();
        if (frame!=null)
            frame.dispose();
        model.setGodFrame(new GodFrame());
    }

    public void showStavkiFrame(int index){
        StavkFrame frame = model.getStavkFrame();
        if (frame!=null)
            frame.close();
        model.setStavkFrame(new StavkFrame(index));
    }

    public void showStavksFrame(){
        StavksFrame frame = model.getStavksFrame();
        if (frame!=null)
            frame.dispose();
        model.setStavksFrame(new StavksFrame(this));
    }
}
