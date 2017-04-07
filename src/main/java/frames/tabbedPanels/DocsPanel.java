package frames.tabbedPanels;

import controllers.DocsController;
import frames.tabbedPanels.docsFrames.FirstDocsFrame;
import models.DocsModel;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Maxon on 25.03.2017.
 */
public class DocsPanel extends JPanel {

    private DocsController docsController;

    public DocsPanel() {

        DocsModel docsModel = new DocsModel();
        docsController = new DocsController(docsModel);
        setPreferredSize(new Dimension(570,290));

        add(new FirstPanel());
        add(new SlovPanel());
    }


    public class FirstPanel extends JPanel{
        public FirstPanel() {
            setPreferredSize(new Dimension(550,150));
            setLayout(new FlowLayout(FlowLayout.CENTER));
            Dimension dimension = new Dimension(520,30);
            Font font = new Font("Courier", Font.BOLD,15);
            MatteBorder mb = new MatteBorder(1, 0, 0, 0, Color.BLACK);
            TitledBorder tb = new TitledBorder(mb, "Формирование Дополнительных соглашений и Актов", TitledBorder.CENTER, TitledBorder.TOP);
            setBorder(tb);


            JButton button1 = new JButton("Учебно-методическое сопровождение аудиторных занятий");
            JButton button2 = new JButton("Проведение учебно-методических работ");
            JButton button3 = new JButton("Закрепление Курсовых работ за преподавателями");


            button1.setPreferredSize(dimension);
            button2.setPreferredSize(dimension);
            button3.setPreferredSize(dimension);


            button1.setFont(font);
            button2.setFont(font);
            button3.setFont(font);

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    docsController.showFirstFrame();
                }
            });

            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    docsController.showSecondFrame();
                }
            });

            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    docsController.showThirdFrame();
                }
            });


            add(button1);
            add(button2);
            add(button3);
        }
    }

    public class SlovPanel extends JPanel{
        public SlovPanel() {
            setPreferredSize(new Dimension(520,120));
            setLayout(new FlowLayout(FlowLayout.CENTER));
            Dimension dimension = new Dimension(160,30);
            Font font = new Font("Courier", Font.BOLD,10);
            MatteBorder mb = new MatteBorder(1, 0, 0, 0, Color.BLACK);
            TitledBorder tb = new TitledBorder(mb, "Словари", TitledBorder.CENTER, TitledBorder.TOP);
            setBorder(tb);


            JButton button1 = new JButton("Группы видов Педнагрузки / Работ");
            JButton button2 = new JButton("Квалификация НПР");
            JButton button3 = new JButton("СТАВКИ");
            JButton button4 = new JButton("Реквизиты Работодателя");



            button1.setPreferredSize(dimension);
            button2.setPreferredSize(dimension);
            button3.setPreferredSize(dimension);
            button4.setPreferredSize(new Dimension(300,30));



            button1.setFont(font);
            button2.setFont(font);
            button3.setFont(font);
            button4.setFont(font);


            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    docsController.showNprFrame();
                }
            });

            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });



            add(button1);
            add(button2);
            add(button3);
            add(button4);

        }
    }
}
