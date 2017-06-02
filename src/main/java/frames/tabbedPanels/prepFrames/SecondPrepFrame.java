package frames.tabbedPanels.prepFrames;

import dao.PrepDao;
import entities.PrepsEntity;
import org.jdesktop.swingx.JXDatePicker;
import utils.Cache;
import utils.DaoFactory;
import utils.NewCache;
import utils.TableFactory;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Maxon on 30.03.2017.
 */
public class SecondPrepFrame extends JFrame {
    private JTable table;
    private Tpanel tpanel;
    private InfoPanel infoPanel;
    private Object[] zvanMas;
    private Object[] stepMas;
    private Object[] doljnMas;
    private Object[] doljnFdoMas;
    private Object[] kafNames;
    private Object[] nprNames;
    public SecondPrepFrame() throws HeadlessException {

        PrepDao dao = DaoFactory.getDaoFactory().getPrepDao();

        zvanMas = dao.getZvanMas();
        stepMas = dao.getStepMas();
        doljnMas = dao.getDoljnMas();
        doljnFdoMas = dao.getDoljnFdoMas();
        kafNames = DaoFactory.getDaoFactory().getKafDao().getKafNames();
        nprNames = DaoFactory.getDaoFactory().getNprDao().getNamesNpr();

        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Ввод/Коррекция показателей преподавателей");
        title.setPreferredSize(new Dimension(700,60));
        title.setFont(font);
        setBounds(350,0,900,710);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        tpanel = new Tpanel();
        //infoPanel = new InfoPanel();





        contentPane.add(title);
        contentPane.add(tpanel);
       // contentPane.add(infoPanel);
        setVisible(true);
    }


    public class Tpanel extends JPanel{
        public Tpanel() {
            String[] head={" ФИО","АРХ"};
            int[] widths = {220,40};

            List<PrepsEntity> prepsEntityList = NewCache.getCache().getPrepsEntities();
            /*List<PrepsEntity> keks = new ArrayList();
            for (PrepsEntity prepsEntity:prepsEntityList){
                if (prepsEntity.getNagrList().size()!=0)
                    keks.add(prepsEntity);
            }*/


            TableFactory tableFactory = new TableFactory(head,widths,prepsEntityList) {
                @Override
                public void fillMas() {
                    for (int i = 0; i < mas.length; i++) {
                        PrepsEntity entity = (PrepsEntity) list.get(i);
                        String name = entity.getФамилия()+" "+entity.getИмя()+" "+entity.getОтчество();
                        mas[i][0] = name;
                        mas[i][1] = entity.getПрАрх();

                    }
                }
            };


            int sum=0;
            for (int i = 0; i < widths.length; i++) {
                sum+=widths[i];
            }


            table = tableFactory.getTable();
            setPreferredSize(new Dimension(sum+15,700));
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    getInfoSR(table,prepsEntityList);
                }
            });
            JScrollPane tableContainer = new JScrollPane(table);
            tableContainer.setPreferredSize(new Dimension(sum+13, 370));
            tableContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            tableContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            add(tableContainer);
            System.out.println(sum+13);
        }

        private void getInfoSR(JTable table, List<PrepsEntity> list){
            int selectedRow = table.getSelectedRow();
            if (selectedRow>-1) {
                PrepsEntity entity = list.get(selectedRow);
                String fio = (String) table.getValueAt(selectedRow, 0);
                System.out.println(fio + " " + entity.getId());
                System.out.println(entity.getОтчество());
                if (infoPanel!= null)
                {

                    SecondPrepFrame.this.getContentPane().remove(infoPanel);

                }
                infoPanel = new InfoPanel(entity);
                SecondPrepFrame.this.getContentPane().add(infoPanel);
                revalidate();
                repaint();
            }
        }

    }

    public class InfoPanel extends JPanel{
        PrepsEntity entity;
        FirstInfo firstInfo = null;
        SecondInfo secondInfo = null;
        TabbedPanel tabbedPanel = new TabbedPanel();

        public InfoPanel(PrepsEntity entity) {
            this.entity = entity;
            setPreferredSize(new Dimension(530,700));
            setLayout(new FlowLayout(FlowLayout.CENTER));

            firstInfo = new FirstInfo();
            secondInfo = new SecondInfo();

            add(firstInfo);
            add(secondInfo);
           // add(tabbedPanel);
            JButton save = new JButton("Сохранить");
            add(save);


        }

        public class FirstInfo extends JPanel{

            public FirstInfo() {

                setPreferredSize(new Dimension(550,130));
                setLayout(new FlowLayout(FlowLayout.CENTER));

                JPanel panel1 = new JPanel(new GridLayout(3,1));
                panel1.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                panel1.setPreferredSize(new Dimension(100,125));
                JLabel secondName = new JLabel(" "+entity.getФамилия());
                JLabel firstName = new JLabel(" "+entity.getИмя());
                JLabel thirdName = new JLabel(" "+entity.getОтчество());
                panel1.add(secondName);
                panel1.add(firstName);
                panel1.add(thirdName);







                JPanel panel2 = new JPanel(new GridLayout(2,2));
                panel2.setPreferredSize(new Dimension(170,50));
                JLabel phone1 = new JLabel("Тел:");
                JLabel mail = new JLabel("mail:");
                JTextField textPhone1 = new JTextField(25);
                textPhone1.setText(entity.getТелефон());
                JTextField textMail = new JTextField(25);
                textMail.setText(entity.getПочта());
                panel2.add(phone1);panel2.add(textPhone1);
                panel2.add(mail);panel2.add(textMail);



                JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                panel3.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
                panel3.setPreferredSize(new Dimension(370,125));
                JLabel doc = new JLabel("Договор");
                JTextField textDoc = new JTextField(10);
                textDoc.setText(entity.getДоговорНомер());
                JLabel ot = new JLabel("от: ");
                JTextField dateDoc = new JTextField(10);
                Timestamp date2 = entity.getДоговорДата();
                if (date2!=null)
                dateDoc.setText(date2.toString());

                JLabel doc1 = new JLabel("Договор");
                JTextField textDoc1 = new JTextField(10);
                textDoc1.setText(entity.getДогФдоНомер());
                JLabel ot1 = new JLabel("от: ");
                JTextField dateDoc1 = new JTextField(10);
                Timestamp date1 = entity.getДогФдоДата();
                if (date1!=null)
                dateDoc1.setText(date1.toString());


                JButton button = new JButton("ok");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });

                panel3.add(doc);
                panel3.add(textDoc);
                panel3.add(ot);
                panel3.add(dateDoc);
                panel3.add(doc1);
                panel3.add(textDoc1);
                panel3.add(ot1);
                panel3.add(dateDoc1);
                panel3.add(panel2);
                panel3.add(button);


                add(panel1);
                add(panel3);


            }
        }

        public class SecondInfo extends JPanel{
            String[] str1 = {"д.и.н.","д.м.н.","к.полит.н."};
            String[] str2 = {".","доцент","профессор"};
            String[] str3 = {"","профессор,д.н.","ст.преподаватель"};
            String[] str4 = {"ведущий специалист","ассистент","профессор"};
            String[] str5 = {"ведущий программист","начальник отделения"};
            String[] str6 = {"информационного,предпринимательского и трудового права","доцент","профессор"};

            JComboBox step = new JComboBox(stepMas);
            JComboBox zvan = new JComboBox(zvanMas);
            JComboBox npr = new JComboBox(nprNames);
            JComboBox vnesh = new JComboBox(doljnMas);
            JComboBox fdo = new JComboBox(doljnFdoMas);
            JComboBox kaf = new JComboBox(kafNames);
            //JTextField tf = new JTextField("65");
            public SecondInfo() {

                setPreferredSize(new Dimension(550,190));
                setLayout(new FlowLayout(FlowLayout.CENTER));
                add(new FirstPanel());
                add(new SecondPanel());
                add(new ThirdPanel());

            }

            public class FirstPanel extends JPanel{
                public FirstPanel() {
                    setPreferredSize(new Dimension(540,55));
                    JPanel panel1 = new JPanel(new GridLayout(2,2));
                    panel1.setPreferredSize(new Dimension(235,50));
                    panel1.add(new JLabel("Ученая степень:"));
                    panel1.add(step);
                    step.setSelectedItem(entity.getНаимСтеп());
                    panel1.add(new JLabel("Ученое звание:"));
                    panel1.add(zvan);
                    zvan.setSelectedItem(entity.getНаимЗван());

                    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    panel2.setPreferredSize(new Dimension(285,50));
                    panel2.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
                    panel2.add(new JLabel("Квалификация НПР:"));
                    panel2.add(npr);
                    npr.setSelectedItem(entity.getКодНпр().getНаимНпр());
                    add(panel1);
                    add(panel2);

                }
            }

            public class SecondPanel extends JPanel{
                public SecondPanel() {
                    setPreferredSize(new Dimension(540,70));
                    setLayout(new FlowLayout(FlowLayout.LEFT));
                    JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    panel1.setPreferredSize(new Dimension(520,30));
                    panel1.add(new JLabel("Должность:"));
                    panel1.add(vnesh);
                    vnesh.setSelectedItem(entity.getДолжн());
                    panel1.add(new JLabel("Сотр.ФДО:"));
                    panel1.add(fdo);
                    fdo.setSelectedItem(entity.getДолжнФдо());

                    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    panel2.setPreferredSize(new Dimension(520,35));
                    panel2.add(new JLabel("Кафедра:"));
                    panel2.add(kaf);
                    kaf.setSelectedItem(entity.getКодКаф().getНаимКаф());
                   // panel2.add(new JLabel("№"));
                  //  panel2.add(tf);

                    add(panel1);
                    add(panel2);


                }
            }



            public class ThirdPanel extends JPanel{
                public ThirdPanel() {

                    setPreferredSize(new Dimension(525,50));
                    setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    setLayout(new GridLayout(2,4));



                    JCheckBox checkBoxFDO = new JCheckBox("Сотрудник ФДО");
                    checkBoxFDO.setSelected(entity.getПрФдо());
                    JCheckBox checkBoxVO = new JCheckBox("Внеш. орган.");
                    checkBoxVO.setSelected(entity.getПрВнеш());

                    JTextField textField1 = new JTextField(20);
                    textField1.setText(entity.getНаимВнеш());
                    JTextField textField2 = new JTextField(5);
                    textField2.setText(String.valueOf(entity.getСтавкаВнешМ()));
                    JTextField textField3 = new JTextField(5);
                    textField3.setText(String.valueOf(entity.getСтавкаВнешБ()));

                    add(checkBoxFDO);
                    add(new JLabel("Наименование"));
                    add(new JLabel("Магистр"));
                    add(new JLabel("Бакалавр"));
                    add(checkBoxVO);
                    add(textField1);
                    add(textField2);
                    add(textField3);


                }
            }
        }

        public class TabbedPanel extends JPanel{
            public TabbedPanel() {
                setPreferredSize(new Dimension(540,350));
                setLayout(new FlowLayout(FlowLayout.CENTER));
                JTabbedPane tabbedPane = new JTabbedPane();
                tabbedPane.setPreferredSize(new Dimension(530,160));
                tabbedPane.setFont(new Font("Verdana",Font.BOLD,12));
                tabbedPane.addTab("Оплата на интервале",new FirstTabbedPanel());
                tabbedPane.addTab("Нагрузка семестра",new JPanel());
                tabbedPane.addTab("Нагрузка полная",new JPanel());

                add(tabbedPane);
            }


            public class FirstTabbedPanel extends JPanel{
                private JXDatePicker picker1;
                private JXDatePicker picker2;
                private JXDatePicker picker3 = new JXDatePicker();
                public FirstTabbedPanel() {
                    setLayout(new FlowLayout(FlowLayout.CENTER));
                    //setPreferredSize(new Dimension(525,330));
                    add(new InterPanel());
                    MatteBorder mb = new MatteBorder(1, 1, 0, 1, Color.BLACK);
                    TitledBorder tb = new TitledBorder(mb, "Кафедра/Внешний", TitledBorder.CENTER, TitledBorder.TOP);
                    setBorder(tb);
                    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    panel.setPreferredSize(new Dimension(430,60));
                    panel.add(new JLabel("Задайте любую дату месяца выдачи"));
                    panel.add(picker3);
                    JButton docs = new JButton("Документы");
                    panel.add(docs);
                    add(panel);
                }

                public class InterPanel extends JPanel
                {
                    public InterPanel() {
                        setPreferredSize(new Dimension(430,60));
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
        }
    }


}
