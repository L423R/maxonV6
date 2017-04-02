package models;

import frames.tabbedPanels.prepFrames.FirstPrepFrame;
import frames.tabbedPanels.prepFrames.SecondPrepFrame;
import frames.tabbedPanels.prepFrames.ThirdPrepFrame;

/**
 * Created by Maxon on 25.03.2017.
 */
public class PrepModel {

    private SecondPrepFrame secondPrepFrame;
    private ThirdPrepFrame thirdPrepFrame;
    private FirstPrepFrame firstPrepFrame;

    public ThirdPrepFrame getThirdPrepFrame() {
        return thirdPrepFrame;
    }

    public void setThirdPrepFrame(ThirdPrepFrame thirdPrepFrame) {
        this.thirdPrepFrame = thirdPrepFrame;
    }

    public FirstPrepFrame getFirstPrepFrame() {
        return firstPrepFrame;
    }

    public void setFirstPrepFrame(FirstPrepFrame firstPrepFrame) {
        this.firstPrepFrame = firstPrepFrame;
    }

    public SecondPrepFrame getSecondPrepFrame() {
        return secondPrepFrame;
    }

    public void setSecondPrepFrame(SecondPrepFrame secondPrepFrame) {
        this.secondPrepFrame = secondPrepFrame;
    }
}
