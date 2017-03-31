package models;

import frames.tabbedPanels.prepFrames.FirstButtonFrame;
import frames.tabbedPanels.prepFrames.SecondButtonFrame;
import frames.tabbedPanels.prepFrames.ThirdButtonFrame;

/**
 * Created by Maxon on 25.03.2017.
 */
public class PrepModel {

    private SecondButtonFrame secondButtonFrame;
    private ThirdButtonFrame thirdButtonFrame;
    private FirstButtonFrame firstButtonFrame;

    public ThirdButtonFrame getThirdButtonFrame() {
        return thirdButtonFrame;
    }

    public void setThirdButtonFrame(ThirdButtonFrame thirdButtonFrame) {
        this.thirdButtonFrame = thirdButtonFrame;
    }

    public FirstButtonFrame getFirstButtonFrame() {
        return firstButtonFrame;
    }

    public void setFirstButtonFrame(FirstButtonFrame firstButtonFrame) {
        this.firstButtonFrame = firstButtonFrame;
    }

    public SecondButtonFrame getSecondButtonFrame() {
        return secondButtonFrame;
    }

    public void setSecondButtonFrame(SecondButtonFrame secondButtonFrame) {
        this.secondButtonFrame = secondButtonFrame;
    }
}
