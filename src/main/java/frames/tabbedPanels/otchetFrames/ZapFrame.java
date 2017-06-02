package frames.tabbedPanels.otchetFrames;

import org.jdesktop.swingx.JXDatePicker;
import reports.FirstReports;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Maxon on 22.05.2017.
 */
public class ZapFrame extends JFrame {
    private JXDatePicker picker1;
    private JXDatePicker picker2;
    private InterPanel interPanel ;
    private FirstReports firstReports;

    public static void main(String[] args) {
        new ZapFrame();
    }

    public ZapFrame() throws HeadlessException {
        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Заработная плата преподавателей");
        title.setFont(font);
        setBounds(500,0,500,300);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));




        interPanel = new InterPanel();
        contentPane.add(title);
        contentPane.add(interPanel);
        //contentPane.add();
        setVisible(true);
    }


    public class InterPanel extends JPanel
    {
        public InterPanel() {
            setPreferredSize(new Dimension(400,60));
            setLayout(new FlowLayout());
            MatteBorder mb = new MatteBorder(1, 1, 1, 1, Color.BLACK);
            TitledBorder tb = new TitledBorder(mb, "Задайте интервал", TitledBorder.CENTER, TitledBorder.TOP);
            setBorder(tb);

            JLabel label1 = new JLabel("с");
            picker1 = new JXDatePicker();
            JLabel label2 = new JLabel("по");
            picker2 = new JXDatePicker();
            JButton button = new JButton("OK");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    firstReports = new FirstReports();
                }
            });



            add(label1);
            add(picker1);
            add(label2);
            add(picker2);
            add(button);

        }


    }
}
