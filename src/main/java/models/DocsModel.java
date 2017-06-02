package models;

import frames.tabbedPanels.docsFrames.FirstDocsFrame;
import frames.tabbedPanels.docsFrames.SecondDocsFrame;
import frames.tabbedPanels.docsFrames.ThirdDocsFrame;
import frames.tabbedPanels.docsFrames.slovFrames.*;

/**
 * Created by Maxon on 07.04.2017.
 */
public class DocsModel {

    private FirstDocsFrame firstDocsFrame;
    private SecondDocsFrame secondDocsFrame;
    private ThirdDocsFrame thirdDocsFrame;

    private NprFrame nprFrame;
    private NagrRabFrame nagrRabFrame;
    private GodFrame godFrame;
    private StavkFrame stavkFrame;
    private StavksFrame stavksFrame;

    public FirstDocsFrame getFirstDocsFrame() {
        return firstDocsFrame;
    }

    public void setFirstDocsFrame(FirstDocsFrame firstDocsFrame) {
        this.firstDocsFrame = firstDocsFrame;
    }

    public SecondDocsFrame getSecondDocsFrame() {
        return secondDocsFrame;
    }

    public void setSecondDocsFrame(SecondDocsFrame secondDocsFrame) {
        this.secondDocsFrame = secondDocsFrame;
    }

    public ThirdDocsFrame getThirdDocsFrame() {
        return thirdDocsFrame;
    }

    public void setThirdDocsFrame(ThirdDocsFrame thirdDocsFrame) {
        this.thirdDocsFrame = thirdDocsFrame;
    }

    public NprFrame getNprFrame() {
        return nprFrame;
    }

    public void setNprFrame(NprFrame nprFrame) {
        this.nprFrame = nprFrame;
    }

    public NagrRabFrame getNagrRabFrame() {
        return nagrRabFrame;
    }

    public void setNagrRabFrame(NagrRabFrame nagrRabFrame) {
        this.nagrRabFrame = nagrRabFrame;
    }

    public GodFrame getGodFrame() {
        return godFrame;
    }

    public void setGodFrame(GodFrame godFrame) {
        this.godFrame = godFrame;
    }

    public StavkFrame getStavkFrame() {
        return stavkFrame;
    }

    public void setStavkFrame(StavkFrame stavkFrame) {
        this.stavkFrame = stavkFrame;
    }

    public StavksFrame getStavksFrame() {
        return stavksFrame;
    }

    public void setStavksFrame(StavksFrame stavksFrame) {
        this.stavksFrame = stavksFrame;
    }
}
