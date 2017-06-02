package frames.tabbedPanels;

import controllers.MainController;
import controllers.PrepController;
import models.PrepModel;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Maxon on 25.03.2017.
 */
public class PrepPanel extends JPanel {

    private PrepController prepController;

    public PrepPanel(MainController controller) {

        PrepModel prepModel = new PrepModel();
        prepController = new PrepController(prepModel);

        setPreferredSize(new Dimension(570,290));

        add(new SlovPanel());
    }

    public class SlovPanel extends JPanel{
        public SlovPanel() {
            setPreferredSize(new Dimension(300,280));
            setLayout(new FlowLayout(FlowLayout.CENTER));
            Dimension dimension = new Dimension(250,40);
            Font font = new Font("Courier", Font.BOLD,10);
            MatteBorder mb = new MatteBorder(1, 0, 0, 0, Color.BLACK);
            TitledBorder tb = new TitledBorder(mb, "Преподаватели", TitledBorder.CENTER, TitledBorder.TOP);
            setBorder(tb);


            JButton button1 = new JButton("Ввод первичных данных");
           /* JButton button2 = new JButton("<html>Ввод/Коррекция показателей<br>" +
                    "Закреплене дисциплин обучения<br>" +
                    "Сведения о нагрузке<br>" +
                    "Печать документов оплаты услуг</html>");*/
            JButton button2 = new JButton("Ввод/Коррекция показателей преподавателей");

            String ss = "<html>Ввод/Коррекция показателей<br>" +
                    "Закреплене дисциплин обучения<br>" +
                    "Сведения о нагрузке<br>" +
                    "Печать документов оплаты услуг</html>";
            JButton button3 = new JButton("Работа с АРХИВОМ");


            button1.setPreferredSize(dimension);
            button2.setPreferredSize(dimension);
            button3.setPreferredSize(dimension);


            button1.setFont(font);
            button2.setFont(font);
            button3.setFont(font);


            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    prepController.showFirstButtonFrame();
                }
            });

            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    prepController.showSecondButtonFrame();
                }
            });

            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    prepController.showThirdButtonFrame();
                }
            });



            add(button1);
            add(button2);
            add(button3);
        }
    }

}
