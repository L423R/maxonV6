package controllers;

import frames.tabbedPanels.docsFrames.FirstDocsFrame;
import frames.tabbedPanels.docsFrames.SecondDocsFrame;
import frames.tabbedPanels.docsFrames.ThirdDocsFrame;
import frames.tabbedPanels.docsFrames.slovFrames.NprFrame;
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
}
