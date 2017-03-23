package frames;
import controllers.MainController;
import org.jdesktop.swingx.JXDatePicker;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartFrame extends JFrame {
    private JXDatePicker picker1 = new JXDatePicker();
    private JXDatePicker picker2 = new JXDatePicker();
    private JComboBox sems;

    public StartFrame(MainController controller) throws HeadlessException {
        setTitle("Start");
        setBounds(500,0,350,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        Color color1 = new Color(214,217,223);
        contentPane.setBackground(color1);

        JPanel selectSem = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sems = new JComboBox(controller.getSems());
        selectSem.add(new JLabel("Выберите текущий семестр:"));
        selectSem.add(sems);

        contentPane.add(selectSem);

        JLabel label = new JLabel("Выберите рабочий интервал");

        contentPane.add(label);

        JPanel inter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inter.add(new JLabel("с"));
        inter.add(picker1);
        inter.add(new JLabel("по"));
        inter.add(picker2);

        contentPane.add(inter);

        JButton ok = new JButton("OK");

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startMainFrame(picker1.getDate(),picker2.getDate(),sems.getSelectedIndex());
                StartFrame.this.dispose();
            }
        });

        contentPane.add(ok);
    }
}