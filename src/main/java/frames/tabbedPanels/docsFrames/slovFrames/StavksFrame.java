package frames.tabbedPanels.docsFrames.slovFrames;

import controllers.DocsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Maxon on 08.04.2017.
 */
public class StavksFrame extends JFrame {

    public static void main(String[] args) {
        new StavksFrame(null);
    }
    public StavksFrame(DocsController controller) throws HeadlessException {

        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Формирование ставок по видам УПН/УПР");
        title.setFont(font);
        setBounds(400,100,500,300);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        JPanel panel = new JPanel(new GridLayout(0,1,5,10));

        JButton button1 = new JButton("Учебно-методическое сопровождение аудиторных занятий");
        JButton button2 = new JButton("Сопровождение курса в СДО");
        JButton button3 = new JButton("Online лекции, видеоконференции, семинары");
        JButton button4 = new JButton("Разработка учебно-методических материалов");
        JButton button5 = new JButton("Руководство работами (курсовые, дипломные), программами");


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showStavkiFrame(1);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showStavkiFrame(2);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showStavkiFrame(3);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showStavkiFrame(4);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showStavkiFrame(5);
            }
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        add(title);
        add(panel);
        setVisible(true);
    }
}
