package frames.tabbedPanels.docsFrames;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

/**
 * Created by Maxon on 02.04.2017.
 */
public class SecondDocsFrame extends JFrame {


    public static void main(String[] args) {
        new SecondDocsFrame();
    }

    private JXDatePicker picker1;
    private JXDatePicker picker2;
    private InterPanel interPanel;
    private PrepPanel prepPanel;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public SecondDocsFrame() throws HeadlessException {
        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Формирование дополнительных соглашений по Расписанию");
        title.setFont(font);
        setBounds(300,0,900,550);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        interPanel = new InterPanel();
        contentPane.add(title);
        contentPane.add(interPanel);
        prepPanel = new PrepPanel();
        contentPane.add(prepPanel);
        setVisible(true);
    }

    public class InterPanel extends JPanel
    {
        public InterPanel() {
            setPreferredSize(new Dimension(600,60));
            setLayout(new FlowLayout(FlowLayout.CENTER));
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

                }
            });

            picker1.setFormats(simpleDateFormat);
            picker2.setFormats(simpleDateFormat);



            add(label1);
            add(picker1);
            add(label2);
            add(picker2);
            add(button);
        }
    }

    public class PrepPanel extends JPanel{
        private String[] mas1 = {"Акопов Сергей Константинович","Крылов Максим Федоров"};
        private String[] mas2 = {"Магистр","Бакалавр"};
        private JComboBox preps = new JComboBox(mas1);
        private JComboBox tipSt = new JComboBox(mas2);
        private JXDatePicker prepPicker1 = new JXDatePicker();
        private JXDatePicker prepPicker2 = new JXDatePicker();
        private JTextField tf1 = new JTextField();
        private JTextField tf2 = new JTextField();
        private JTextField tf3 = new JTextField();
        private JCheckBox prOpl = new JCheckBox();
        public PrepPanel() {

            setPreferredSize(new Dimension(880,300));
            setLayout(new FlowLayout(FlowLayout.CENTER));


            JPanel panel1 = new JPanel(new GridLayout(2,1));
            panel1.add(new JLabel("Выберите преподавателя"));
            panel1.add(preps);


            JPanel panel2 = new JPanel(new GridLayout(2,2));
            panel2.add(new JLabel("Начало"));
            panel2.add(new JLabel("Окончание"));
            panel2.add(prepPicker1);
            panel2.add(prepPicker2);
            MatteBorder mb = new MatteBorder(1, 0, 0, 0, Color.BLUE);
            TitledBorder tb = new TitledBorder(mb, "Дата проведения", TitledBorder.CENTER, TitledBorder.TOP);
            panel2.setBorder(tb);



            JPanel panel3 = new JPanel(new GridLayout(2,2));
            panel3.add(new JLabel("Штуки"));
            panel3.add(new JLabel("Тип ставки"));
            panel3.add(new JLabel("Ставка"));
            panel3.add(new JLabel("ПрОпл"));
            panel3.add(new JLabel("Примечание"));
            panel3.add(tf1);
            panel3.add(tipSt);
            panel3.add(tf2);
            panel3.add(prOpl);
            panel3.add(tf3);
            mb = new MatteBorder(1, 1, 1, 1, Color.RED);
            tb = new TitledBorder(mb, "Введите для преподавателя", TitledBorder.CENTER, TitledBorder.TOP);
            panel3.setBorder(tb);

            add(panel1);
            add(panel2);
            add(panel3);

            /*JButton button = new JButton("Добавить");
            add(button);*/

        }
    }
}
