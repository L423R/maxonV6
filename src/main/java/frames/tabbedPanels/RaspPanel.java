package frames.tabbedPanels;

import controllers.MainController;
import controllers.RaspController;
import models.RaspModel;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by Maxon on 01.03.2017.
 */
public class RaspPanel extends JPanel{


    private RaspController raspController;

    public RaspPanel(MainController controller) {


        RaspModel raspModel = new RaspModel();
        raspModel.setDate1(controller.getDateStart());
        raspModel.setDate2(controller.getDateEnd());
        raspController = new RaspController(raspModel);



        setPreferredSize(new Dimension(570,290));
        Dimension dimension = new Dimension(400,30);
        Font font = new Font("Verdana", Font.BOLD,14);
        JButton button1 = new JButton("Формирование расписания занятий в группах");
        JButton button2 = new JButton("Коррекция расписаний групп");
        JButton button3 = new JButton("Тиражирование расписания группы/дисц");

        button1.setPreferredSize(dimension);
        button2.setPreferredSize(dimension);
        button3.setPreferredSize(dimension);

        button1.setFont(font);
        button2.setFont(font);
        button3.setFont(font);

        button1.setBackground(Color.red);
        button2.setBackground(Color.red);
        button3.setBackground(Color.green);

        button1.addActionListener(e -> raspController.ShowFormRaspFrame());

        button2.addActionListener(e -> raspController.showCorrRaspFrame());

        button3.addActionListener(e -> raspController.showTirGrFrame());


        add(button1);
        add(button2);
        add(button3);
        add(new SlovPanel());

    }

    public class SlovPanel extends JPanel{
        public SlovPanel() {
            setPreferredSize(new Dimension(500,120));
            setLayout(new FlowLayout(FlowLayout.LEFT));
            Dimension dimension = new Dimension(150,30);
            Font font = new Font("Courier", Font.BOLD,10);
            MatteBorder mb = new MatteBorder(1, 0, 0, 0, Color.BLACK);
            TitledBorder tb = new TitledBorder(mb, "Словари", TitledBorder.CENTER, TitledBorder.TOP);
            setBorder(tb);


            JButton button1 = new JButton("Дисциплины");
            JButton button2 = new JButton("Кафедры");
            JButton button3 = new JButton("Программы обучения");
            JButton button4 = new JButton("Группы");
            JButton button5 = new JButton("Направления обучения");
            JButton button6 = new JButton("Методисты ФДО");

            button1.setPreferredSize(dimension);
            button2.setPreferredSize(dimension);
            button3.setPreferredSize(dimension);
            button4.setPreferredSize(dimension);
            button5.setPreferredSize(dimension);
            button6.setPreferredSize(dimension);

            button1.setFont(font);
            button2.setFont(font);
            button3.setFont(font);
            button4.setFont(font);
            button5.setFont(font);
            button6.setFont(font);



            add(button1);
            add(button2);
            add(button3);
            add(button4);
            add(button5);
            add(button6);

            button1.addActionListener(e -> raspController.ShowDiscFrame());

            button2.addActionListener(e -> raspController.ShowKafFrame());

            button3.addActionListener(e -> raspController.ShowProgsFrame());

            button4.addActionListener(e -> raspController.ShowGroupsFrame());

            button5.addActionListener(e -> raspController.ShowNapravlFrame());

            button6.addActionListener(e -> raspController.ShowMethodistsFrame());

        }
    }
}
