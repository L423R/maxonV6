package controllers;

import frames.tabbedPanels.prepFrames.FirstPrepFrame;
import frames.tabbedPanels.prepFrames.SecondPrepFrame;
import frames.tabbedPanels.prepFrames.ThirdPrepFrame;
import models.PrepModel;

/**
 * Created by Maxon on 25.03.2017.
 */
public class PrepController {

    private PrepModel model;

    public PrepController(PrepModel model) {
        this.model = model;
    }

    public void showThirdButtonFrame(){
        ThirdPrepFrame frame = model.getThirdPrepFrame();
        if (frame!=null)
            frame.close();
        model.setThirdPrepFrame(new ThirdPrepFrame());
    }

    public void showFirstButtonFrame(){
        FirstPrepFrame frame = model.getFirstPrepFrame();
        if (frame!=null)
            frame.dispose();
        model.setFirstPrepFrame(new FirstPrepFrame());
    }

    public void showSecondButtonFrame(){
        SecondPrepFrame frame = model.getSecondPrepFrame();
        if (frame!=null)
            frame.dispose();
        model.setSecondPrepFrame(new SecondPrepFrame());
    }
}
