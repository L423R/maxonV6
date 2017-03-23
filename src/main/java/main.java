import controllers.MainController;
import frames.StartFrame;


/**
 * Created by Maxon on 15.02.2017.
 */
public class main {
    public static void main(String[] args) {
        StartFrame start = new StartFrame(new MainController());
        start.setVisible(true);

    }
}
