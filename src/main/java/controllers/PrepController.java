package controllers;

import frames.tabbedPanels.prepFrames.FirstButtonFrame;
import frames.tabbedPanels.prepFrames.SecondButtonFrame;
import frames.tabbedPanels.prepFrames.ThirdButtonFrame;
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
        ThirdButtonFrame frame = model.getThirdButtonFrame();
        if (frame!=null)
            frame.close();
        model.setThirdButtonFrame(new ThirdButtonFrame());
    }

    public void showFirstButtonFrame(){
        FirstButtonFrame frame = model.getFirstButtonFrame();
        if (frame!=null)
            frame.dispose();
        model.setFirstButtonFrame(new FirstButtonFrame());
    }

    public void showSecondButtonFrame(){
        SecondButtonFrame frame = model.getSecondButtonFrame();
        if (frame!=null)
            frame.dispose();
        model.setSecondButtonFrame(new SecondButtonFrame());
    }
}
