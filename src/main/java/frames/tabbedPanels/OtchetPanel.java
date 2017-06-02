package frames.tabbedPanels;

import frames.tabbedPanels.otchetFrames.ZapFrame;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Maxon on 22.05.2017.
 */
public class OtchetPanel extends JPanel {
    private SlovPanel slovPanel;

    public OtchetPanel() {
        setPreferredSize(new Dimension(570,290));

        add(new SlovPanel());
    }

    public class SlovPanel extends JPanel{
        public SlovPanel() {
            setPreferredSize(new Dimension(300,280));
            setLayout(new FlowLayout(FlowLayout.CENTER));
            Dimension dimension = new Dimension(250,30);
            Font font = new Font("Courier", Font.BOLD,10);
            MatteBorder mb = new MatteBorder(1, 0, 0, 0, Color.BLACK);
            TitledBorder tb = new TitledBorder(mb, "Отчеты", TitledBorder.CENTER, TitledBorder.TOP);
            setBorder(tb);


            JButton button1 = new JButton("ЗП преподавателей на интервале");
            JButton button2 = new JButton("ЗП преподавателей прошлый семестр");
            JButton button3 = new JButton("ЗП преподавателей за месяц");





            button1.setPreferredSize(dimension);
            button2.setPreferredSize(dimension);
            button3.setPreferredSize(dimension);


            button1.setFont(font);
            button2.setFont(font);
            button3.setFont(font);


            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ZapFrame();
                }
            });





            add(button1);
            add(button2);
            add(button3);

        }
    }
}
