package frames;

import controllers.MainController;
import frames.tabbedPanels.DocsPanel;
import frames.tabbedPanels.OtchetPanel;
import frames.tabbedPanels.PrepPanel;
import frames.tabbedPanels.RaspPanel;
import models.MainModel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

/**
 * Created by Maxon on 15.02.2017.
 */
public class MainFrame extends JFrame {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private MainController controller;
    public MainFrame(MainController controller) throws HeadlessException {
        this.controller = controller;
        setBounds(500,0,600,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new Panel2());
        contentPane.add(new Panel1());
        contentPane.add(new Panel3());
    }

    public class Panel1 extends JPanel{
        public Panel1() {
            setPreferredSize(new Dimension(300,50));
            setLayout(new FlowLayout(FlowLayout.LEFT));
            setBorder(BorderFactory.createLineBorder(Color.red, 1));
            JLabel label1 = new JLabel("Семестр: ");
            JLabel label2 = new JLabel(controller.getModel().getEntity().getНаимСем());
            JLabel label3 = new JLabel("Рабочий интервал: с");
            JLabel label4 = new JLabel(simpleDateFormat.format(controller.getModel().getDate1()));
            JLabel label6 = new JLabel("по");
            JLabel label5 = new JLabel(simpleDateFormat.format(controller.getModel().getDate2()));


            add(label3);
            add(label4);
            add(label6);
            add(label5);
            add(label1);
            add(label2);
        }
    }

    public class Panel2 extends JPanel{
        public Panel2() {
            setPreferredSize(new Dimension(400,50));
            Font font = new Font("Verdana", Font.BOLD, 18);
            JLabel label1 = new JLabel("Факультет дистанционного обучения");
            label1.setFont(font);
            JLabel label2 = new JLabel("Оплата педагогических услуг");
            label2.setFont(new Font("Verdana",Font.ITALIC,11));
            add(label1);
            add(label2);
        }
    }

    public class Panel3 extends JPanel{
        public Panel3() {
            setPreferredSize(new Dimension(600,300));
            setLayout(new FlowLayout(FlowLayout.CENTER));
            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.setPreferredSize(new Dimension(550,300));
            tabbedPane.setFont(new Font("Verdana",Font.BOLD,12));
            tabbedPane.addTab("Расписание",new RaspPanel(controller));
            tabbedPane.addTab("Преподаватели",new PrepPanel(controller));
            tabbedPane.addTab("Документы оплаты",new DocsPanel());
            tabbedPane.addTab("Сводки и отчеты",new OtchetPanel());
            add(tabbedPane);

        }



    }

}
