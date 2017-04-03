package frames.tabbedPanels.raspFrames;

import controllers.RaspController;
import entities.*;
import frames.tabbedPanels.raspFrames.slovFrames.RaspFrame;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdesktop.swingx.JXDatePicker;
import utils.Cache;
import utils.HibernateUtil;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Maxon on 02.03.2017.
 */
public class FormRaspFrame extends JFrame {

    //private MainModel mainModel;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private JXDatePicker picker1;
    private JXDatePicker picker2;
    private InterPanel interPanel;
    private ProgSemPanel progSemPanel;
    private GroupPanel groupPanel;
    private InfoPanel infoPanel;
    private DateButtons dateButtons;
    private RaspEntity raspEntity = new RaspEntity();
    private List<RaspEntity> raspEntityList;
    private RaspController controller;


    public FormRaspFrame(RaspController controller) throws HeadlessException {
        this.controller = controller;
        raspEntityList = Cache.getRaspEntityList();
        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Формирование расписания занятий групп    ");
        title.setFont(font);
        setBounds(500,0,850,550);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        interPanel = new InterPanel();
        progSemPanel = new ProgSemPanel();

        contentPane.add(title);
        contentPane.add(interPanel);
        contentPane.add(progSemPanel);
        setVisible(true);
       // contentPane.add(groupPanel);
    }


    public class InterPanel extends JPanel
    {
        public InterPanel() {
            setPreferredSize(new Dimension(400,60));
            setLayout(new FlowLayout(FlowLayout.LEFT));
            MatteBorder mb = new MatteBorder(1, 1, 1, 1, Color.BLACK);
            TitledBorder tb = new TitledBorder(mb, "Задайте интервал", TitledBorder.CENTER, TitledBorder.TOP);
            setBorder(tb);

            JLabel label1 = new JLabel("с");
            picker1 = new JXDatePicker(controller.getDateStart());
            JLabel label2 = new JLabel("по");
            picker2 = new JXDatePicker(controller.getDateEnd());
            JButton button = new JButton("OK");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    progSemPanel.setVisible(true);
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

    public class ProgSemPanel extends JPanel
    {
        public ProgSemPanel() {
            setVisible(false);
            setPreferredSize(new Dimension(800,90));
            setLayout(new FlowLayout(FlowLayout.LEFT));
            setBorder(BorderFactory.createLineBorder(Color.green, 2));
            JLabel label1 = new JLabel("Выберите программу:");
            JLabel label2 = new JLabel("Выберите семестр:");
            final String[] mas2 = {"1","2","3","4","5","6","7","8","9","10","11","12"};

            final List<ProgsEntity> progsEntityList = Cache.getProgsEntityList();
            ArrayList<String> progName = new ArrayList<>();

            for (ProgsEntity progsEntity : progsEntityList)
            {
                String s = progsEntity.getПримеч();
                if (s==null)
                    s= "";
                String prog = progsEntity.getId()+" |"+progsEntity.getНаим()+" / "+progsEntity.getПрофПрогр()+" / "+progsEntity.getФормаОбуч()+"-"+
                        progsEntity.getПланСрок()+"-"+progsEntity.getКвалифик()+" / "+ s;
                progName.add(prog);
            }
            Object[] objects = progName.toArray();






            final JComboBox comboBox1 = new JComboBox(objects);
            final JComboBox comboBox2 = new JComboBox(mas2);
            JButton button = new JButton("OK");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    List<GroupsEntity> groupsEntityList = Cache.getGroupsEntityList();
                    ArrayList list = new ArrayList();
                    for (GroupsEntity entity :groupsEntityList)
                    {
                        Timestamp dateCl = entity.getДатаЗакр();

                        if (dateCl==null) {
                            int index = comboBox1.getSelectedIndex();
                            ProgsEntity entity1 = progsEntityList.get(index);
                            ProgsEntity entity2 = entity.getКодПрогр();

                            if (entity1.equals(entity2)) {
                                int sem = entity.getCurrSem();
                                String str = mas2[comboBox2.getSelectedIndex()];
                                int numSem = Integer.parseInt(str);
                                if (sem==numSem)
                                list.add(entity);
                            }
                            raspEntity.setСеместр((byte) Integer.parseInt((String) comboBox2.getSelectedItem()));
                        }
                    }
                    if (groupPanel==null) {
                        groupPanel = new GroupPanel(list);
                        FormRaspFrame.this.getContentPane().add(groupPanel);
                    }else {
                        if (infoPanel!=null)
                            FormRaspFrame.this.getContentPane().remove(infoPanel);
                        FormRaspFrame.this.getContentPane().remove(groupPanel);
                        groupPanel = new GroupPanel(list);
                        FormRaspFrame.this.getContentPane().add(groupPanel);
                        revalidate();
                        repaint();
                        FormRaspFrame.this.repaint();
                       // FormRaspFrame.this.getContentPane().repaint();

                    }

                }
            });

            add(label1);
            add(comboBox1);
            add(label2);
            add(comboBox2);
            add(button);
        }
    }

    public class GroupPanel extends JPanel{
        private List<PrepsEntity> prepsEntityList = Cache.getPrepsEntityList();
        private boolean flag=true;
        private JComboBox prepsNames = new JComboBox();
        public GroupPanel(final ArrayList list) {
            setPreferredSize(new Dimension(800,120));
            setLayout(new FlowLayout(FlowLayout.LEFT));
            setBorder(BorderFactory.createLineBorder(Color.blue, 2));

            Object[] groups = getNamesGroup(list);
            final List<DiscEntity> discEntityList = Cache.getDiscEntityList();
            ArrayList<String> nameList = new ArrayList<String>();
            for (DiscEntity entity:discEntityList)
            {
                String s=entity.getId()+"|"+entity.getНаимДисц();
                nameList.add(s);
            }
            Object[] disc = nameList.toArray();




            JLabel label1 = new JLabel("Группа:");
            final JComboBox comboBox1 = new JComboBox(groups);
            JLabel label2 = new JLabel("Дисциплина:");
            final JComboBox comboBox2 = new JComboBox(disc);
            JLabel label3 = new JLabel("Преподаватель:");
            JButton button1 = new JButton("Расписание");
            button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                RaspFrame raspFrame = new RaspFrame(picker1.getDate(),picker2.getDate(), (GroupsEntity) list.get(comboBox1.getSelectedIndex()));
                }
            });
           // button1.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel1.setPreferredSize(new Dimension(100,105));
            panel1.add(label1);
            panel1.add(comboBox1);
            panel1.add(button1);


            JButton button2 = new JButton("OK");
            button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (infoPanel==null) {
                        infoPanel = new InfoPanel();
                        FormRaspFrame.this.getContentPane().add(infoPanel);
                    }else {
                        FormRaspFrame.this.getContentPane().remove(infoPanel);
                        infoPanel = new InfoPanel();
                        FormRaspFrame.this.getContentPane().add(infoPanel);
                        revalidate();
                        repaint();
                    }
                    int index = prepsNames.getSelectedIndex();
                    String prep = (String) prepsNames.getItemAt(index);
                    String[] split = prep.split("|");
                    raspEntity.setКодПреп(prepsEntityList.get(Integer.parseInt(split[0])));
                    int selectedIndex = comboBox1.getSelectedIndex();
                    raspEntity.setКодГруп((GroupsEntity) list.get(selectedIndex));
                }
            });

            final JPanel panel4 = new JPanel(new GridLayout(2,1));
            panel4.setPreferredSize(new Dimension(680,85));
            panel4.setBorder(BorderFactory.createLineBorder(Color.red, 1));

            JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            final JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));


            JButton button3 = new JButton("OK");
            button3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int index = comboBox2.getSelectedIndex();
                    DiscEntity discEntity = discEntityList.get(index);
                    Object[] namesPreps = getNamesPreps(discEntity.getКодКаф());

                    raspEntity.setКодДисц(discEntity);

                    //prepsNames = new JComboBox(namesPreps);
                    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel(namesPreps);
                    prepsNames.setModel(comboBoxModel);
                    if (flag) {
                        panel4.add(panel3);
                        flag=false;
                    }else {
                        panel4.remove(panel3);
                        panel4.add(panel3);
                        repaint();
                    }
                }
            });

            panel2.add(label2);
            panel2.add(comboBox2);
            panel2.add(button3);

            panel4.add(panel2);

            panel3.add(label3);
            panel3.add(prepsNames);
            panel3.add(button2);

            add(panel1);
            add(panel4);

        }

        public Object[] getNamesGroup(ArrayList<GroupsEntity> list)
        {
            ArrayList namesGroup = new ArrayList();
            for (GroupsEntity entity : list) {
                String rash = entity.getРасшПрог();
                if (rash==null)
                    rash="";
                int currSem = entity.getCurrSem();
                String ng = entity.getСокрНг();
                String prof = entity.getПрофПрог();
                if (prof==null)
                    prof="";
                String s = rash+currSem+ng+prof;
                namesGroup.add(s);
            }

            return namesGroup.toArray();
        }

        public Object[] getNamesPreps(KafEntity kafEntity){
            ArrayList<String> prepsNames = new ArrayList<String>();
            for (PrepsEntity entity : prepsEntityList)
            {
                //System.out.println(entity.getКодКаф().getКодКаф()+" |||| "+kafEntity.getКодКаф());
                if (entity.getКодКаф().getКодКаф()==kafEntity.getКодКаф()) {
                    int indexOf = prepsEntityList.indexOf(entity);
                    prepsNames.add(indexOf+"| "+entity.getФамилия()+" "+entity.getИмя());
                }
            }

            return prepsNames.toArray();
        }
    }

    public class InfoPanel extends JPanel
    {
        public InfoPanel() {

            setPreferredSize(new Dimension(800,80));
            setLayout(new FlowLayout(FlowLayout.LEFT));
            setBorder(BorderFactory.createLineBorder(Color.black, 2));

            JPanel panel1 = new JPanel(new GridLayout(2,3));
            panel1.setPreferredSize(new Dimension(315,70));
            Font font = new Font("Courier", Font.PLAIN,8);
            setFont(font);
            MatteBorder mb = new MatteBorder(1, 0, 0, 1, Color.red);
            TitledBorder tb = new TitledBorder(mb, "для занятий", TitledBorder.CENTER, TitledBorder.TOP);
            //tb.setTitleFont(font);
            panel1.setBorder(tb);

            JLabel label1 = new JLabel("Начало:");
            String[] mas1 = {"10:10","11:50","14:00","15:40","17:20","19:00","20:40"};
            final JComboBox comboBox1 = new JComboBox(mas1);
            JLabel label2 = new JLabel("Часы:");
            String[] mas2 ={"2","4","6","8"};
            final JComboBox comboBox2 = new JComboBox(mas2);
            JLabel label3 = new JLabel("День:");
            //String[] mas3 ={"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье",};
            //JComboBox comboBox3 = new JComboBox(mas3);
            final JXDatePicker datePicker = new JXDatePicker();

            panel1.add(label1);
            panel1.add(label2);
            panel1.add(label3);
            panel1.add(comboBox1);
            panel1.add(comboBox2);
            panel1.add(datePicker);

            JPanel panel2 = new JPanel(new GridLayout(2,4));
            panel2.setPreferredSize(new Dimension(360,70));
            MatteBorder mb2 = new MatteBorder(1, 0, 0, 1, Color.red);
            TitledBorder tb2 = new TitledBorder(mb2, "для оплаты", TitledBorder.CENTER, TitledBorder.TOP);
            //tb.setTitleFont(font);
            panel2.setBorder(tb2);

            JLabel label4 = new JLabel("Тип ставки:");
            JLabel label5 = new JLabel("Ставка:");
            JLabel label6 = new JLabel("Пр.Опл:");
            JLabel label7 = new JLabel("Примеч-е:");

            final JComboBox comboBox4 = new JComboBox(new String[]{"Бакалавр","Магистр"});
            final JCheckBox checkBox = new JCheckBox();
            final JTextField textField1 = new JTextField();
            final JTextField textField2 = new JTextField();

            panel2.add(label4);
            panel2.add(label5);
            panel2.add(label6);
            panel2.add(label7);

            panel2.add(comboBox4);
            panel2.add(textField1);
            panel2.add(checkBox);
            panel2.add(textField2);

            JButton button = new JButton("OK");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    raspEntity.setТипСтуд((String) comboBox4.getSelectedItem());
                    int st = Integer.parseInt(textField1.getText());
                    raspEntity.setСтавка((double) st);
                    raspEntity.setПрОпл(checkBox.isSelected());
                    raspEntity.setПримеч(textField2.getText());
                    Date date = datePicker.getDate();
                    String s = (String) comboBox1.getSelectedItem();
                    Timestamp timestamp = Timestamp.valueOf("2017-01-13 "+s+":00");
                    raspEntity.setНачЗан(timestamp);
                    raspEntity.setКолЧас((byte) Integer.parseInt((String) comboBox2.getSelectedItem()));

                    if (dateButtons==null)
                    {
                        dateButtons = new DateButtons(date);
                        FormRaspFrame.this.getContentPane().add(dateButtons);
                    }else {
                        FormRaspFrame.this.getContentPane().remove(dateButtons);
                        dateButtons = new DateButtons(date);
                        FormRaspFrame.this.getContentPane().add(dateButtons);
                    }
                    FormRaspFrame.this.getContentPane().repaint();
                    revalidate();
                    repaint();
                }
            });


            add(panel1);
            add(panel2);
            add(button);
            //setLayout(new GridLayout(3,3));
        }
    }

    public class DateButtons extends JPanel{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        public DateButtons(Date date) {
            String[] days = {"","воскресение","понедельник","вторник","среда","четверг","пятница","суббота"};
            setPreferredSize(new Dimension(800,80));
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            Font font = new Font("Courier", Font.PLAIN,11);
            //setFont(font);
            System.out.println(raspEntity.toString());
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            //instance.add(Calendar.DAY_OF_MONTH, 1);// прибавляем 1 день к установленной дате
           // String format = simpleDateFormat.format(date);
            for (int i = 0; i < 8; i++) {
                final RaspEntity entity = raspEntity;
                Date newDate = instance.getTime();
                entity.setДатаЗан(new Timestamp(newDate.getTime()));
                int day = instance.get(Calendar.DAY_OF_WEEK);
                System.out.println(days[day]);
                entity.setДень(days[day]);
                entity.setТипЗан("");
                String format = simpleDateFormat.format(newDate);
                JButton button = new JButton(format);
                button.setMargin(new Insets(0,0,0,0));
                button.setFont(font);
                button.setBackground(Color.BLACK);
                button.setForeground(Color.ORANGE);
                button.setPreferredSize(new Dimension(90,70));
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Session session = HibernateUtil.getSessionFactory().openSession();
                        Transaction transaction = session.beginTransaction();
                        try{
                            // Object o = entities.get(selectedRow);
                            //o.
                            session.saveOrUpdate(entity);
                            transaction.commit();
                            raspEntityList.add(entity);
                            System.out.println("kaef");
                            System.out.println(entity.toString());
                        }catch (Throwable t) {
                            System.out.println("error");
                            transaction.rollback();
                        }finally {
                            // закрытие сессии
                            session.close();
                        }
                    }
                });
                add(button);
                repaint();
                instance.add(Calendar.WEEK_OF_MONTH,1);
            }


        }
    }
}
