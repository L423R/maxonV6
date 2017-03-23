package frames.tabbedPanels.raspFrames;

import dao.DiscEntity;
import dao.GroupsEntity;
import dao.RaspEntity;
import frames.tabbedPanels.raspFrames.slovFrames.RaspTirFrame;
import models.MainModel;
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
import java.util.*;
import java.util.List;

/**
 * Created by Maxon on 08.03.2017.
 */
public class TirGrFrame extends JFrame {

    private List<RaspEntity> raspEntities;
    private JXDatePicker picker1;
    private JXDatePicker picker2;
    private GroupsPanel groupsPanel;
    private JPanel buttonsPanel;
    private List<GroupsEntity> groupsEntities;
    private GroupsEntity originGroup;
    private GroupsEntity cloneGroup;


    public TirGrFrame() throws HeadlessException {

        groupsEntities = Cache.getGroupsEntityList();
      //  raspEntities = this.mainModel.getRaspEntityList();

        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Тиражирование расписания занятий групп");
        title.setFont(font);
        setBounds(500,0,615,350);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(title);
        contentPane.add(new InterPanel());
        setVisible(true);
    }

    public class InterPanel extends JPanel {
        public InterPanel() {
            setPreferredSize(new Dimension(400, 60));
            setLayout(new FlowLayout(FlowLayout.CENTER));
            MatteBorder mb = new MatteBorder(1, 1, 1, 1, Color.BLACK);
            TitledBorder tb = new TitledBorder(mb, "Задайте интервал", TitledBorder.CENTER, TitledBorder.TOP);
            setBorder(tb);

            JLabel label1 = new JLabel("с");
            picker1 = new JXDatePicker();
            JLabel label2 = new JLabel("по");
            picker2 = new JXDatePicker();
            JButton button = new JButton("OK");
            button.addActionListener(e -> {
                if (groupsPanel!=null)
                    TirGrFrame.this.remove(groupsPanel);
                groupsPanel = new GroupsPanel(getCurrGroupList());
                TirGrFrame.this.add(groupsPanel);
                revalidate();
                repaint();
            });

            add(label1);
            add(picker1);
            add(label2);
            add(picker2);
            add(button);

        }

        private List<GroupsEntity> getCurrGroupList()
        {
            List<GroupsEntity> list = new ArrayList<GroupsEntity>();
            for (GroupsEntity entity: groupsEntities)
            {
                if (entity.getДатаЗакр()==null)
                {
                    long time = entity.getДатаОткр().getTime();
                    if (time>=picker1.getDate().getTime() && time<=picker2.getDate().getTime())
                        list.add(entity);
                }
            }
            return list;
        }
    }

    public class GroupsPanel extends JPanel
    {
        JPanel panel2;
        JPanel panel1;
        JPanel panel3;
        JComboBox comboBox1;
        JComboBox comboBox2;
        JRadioButton radioButton2 = new JRadioButton("Тираж Дисц");
        JRadioButton radioButton1 = new JRadioButton("Тираж Расп");
        List<GroupsEntity> groupsEntityList;
        public GroupsPanel(List<GroupsEntity> groupsEntityList) {
            setPreferredSize(new Dimension(600,100));
            setLayout(new FlowLayout(FlowLayout.CENTER,20,5));
            setBorder(BorderFactory.createLineBorder(Color.blue, 2));
            this.groupsEntityList = groupsEntityList;


            radioButton1.addActionListener(e -> {
                radioButton2.setSelected(false);
                if (buttonsPanel!=null)
                    TirGrFrame.this.remove(buttonsPanel);
                buttonsPanel = new ButtonsPanel(1);
                TirGrFrame.this.add(buttonsPanel);
                revalidate();
                repaint();
            });

            radioButton2.addActionListener(e -> {
                radioButton1.setSelected(false);
                if (buttonsPanel!=null)
                    TirGrFrame.this.remove(buttonsPanel);
                buttonsPanel = new ButtonsPanel(2);
                TirGrFrame.this.add(buttonsPanel);
                revalidate();
                repaint();
            });

            panel1 = new JPanel();
            //panel1.setPreferredSize(new Dimension(400,70));
            JLabel label1 = new JLabel("Выберите группу-ОБРАЗЕЦ");
            final JLabel label2 = new JLabel("Выберите группу-КЛОН");
            //String[] mas = {"один","два","три","четыри","пять"};
            List<String> groupsNames = new ArrayList<String>();
            for (GroupsEntity entity :groupsEntityList)
                groupsNames.add(entity.getCurrName());

            comboBox1 = new JComboBox(groupsNames.toArray());
            comboBox1.setSelectedIndex(-1);
            comboBox1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.getActionCommand().toString());
                    if (comboBox1.getSelectedIndex()>-1)
                    {
                        if (panel2!=null)
                        {
                            if (panel3!=null)
                                GroupsPanel.this.remove(panel3);
                            //TirGrFrame.this.getContentPane().remove(panel2);
                            GroupsPanel.this.remove(panel2);
                        }
                        originGroup = GroupsPanel.this.groupsEntityList.get(comboBox1.getSelectedIndex());
                        try {
                            RaspTirFrame raspTirFrame = new RaspTirFrame(picker1.getDate(),picker2.getDate(),originGroup,"ОБРАЗЕЦ");
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                        panel2 = new JPanel();
                        //panel2.setPreferredSize(new Dimension(400,70));
                        panel2.add(label2);
                       // cloneGroup = GroupsPanel.this.groupsEntityList.get(comboBox1.getSelectedIndex());
                        final List<GroupsEntity> currGroupList2 = getCurrGroupList2(originGroup);
                        List kek = new ArrayList();
                        for (GroupsEntity entity: currGroupList2)
                            kek.add(entity.getCurrName());
                        comboBox2 = new JComboBox(kek.toArray());
                        comboBox2.setSelectedIndex(-1);
                        comboBox2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int index = comboBox2.getSelectedIndex();
                                if (index>-1)
                                {
                                    cloneGroup = currGroupList2.get(comboBox2.getSelectedIndex());
                                    try {
                                        RaspTirFrame raspTirFrame = new RaspTirFrame(picker1.getDate(),picker2.getDate(),currGroupList2.get(comboBox2.getSelectedIndex()),"КЛОН");
                                    } catch (Throwable throwable) {
                                        throwable.printStackTrace();
                                    }
                                }

                            }
                        });
                        panel2.add(comboBox2);

                        panel3 = new JPanel();
                        //panel3.setPreferredSize(new Dimension(700,50));
                        panel3.add(radioButton1);
                        panel3.add(radioButton2);
                        GroupsPanel.this.add(panel2);
                        GroupsPanel.this.add(panel3);
                        revalidate();
                        repaint();
                    }
                }
            });

            panel1.add(label1);
            panel1.add(comboBox1);
            add(panel1);

        }

        private List<GroupsEntity> getCurrGroupList2(GroupsEntity groupsEntity)
        {
            List<GroupsEntity> list = new ArrayList<GroupsEntity>();
            for (GroupsEntity entity: groupsEntities)
            {
                if (entity.getДатаЗакр()==null)
                {
                    long time = entity.getДатаОткр().getTime();
                    if (time>=picker1.getDate().getTime() && time<=picker2.getDate().getTime() && groupsEntity.getКодПрогр().equals(entity.getКодПрогр()) )
                        list.add(entity);
                }
            }
            return list;
        }

    }

    public class ButtonsPanel extends JPanel
    {
        List list;
        JComboBox discBox = null;

        public ButtonsPanel(int count) {
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setPreferredSize(new Dimension(410,200));
            JButton button1 = new JButton("Клон");
            JButton button2 = new JButton("удалить клон");
            JButton button3 = new JButton("Клонирование дисциплины");
            JButton button4 = new JButton("Удаление дисциплины клона");
            JLabel disc = new JLabel("Дисциплина:");

            List currDiscList = new ArrayList();

            button1.setPreferredSize(new Dimension(200,50));
            button2.setPreferredSize(new Dimension(200,50));
            button3.setPreferredSize(new Dimension(200,50));
            button4.setPreferredSize(new Dimension(200,50));


            button1.addActionListener(e -> {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                try{

                    Timestamp timestamp1 = new Timestamp(picker1.getDate().getTime());
                    Timestamp timestamp2 = new Timestamp(picker2.getDate().getTime());

                    int i = session.createQuery("delete RaspEntity where КодГруп = :КодГруп and ДатаЗан between :start and :end")
                            .setParameter("КодГруп", cloneGroup)
                            .setParameter("start", timestamp1)
                            .setParameter("end", timestamp2)
                            .executeUpdate();


                    list = session.createQuery("from RaspEntity where КодГруп =:КодГруп and ДатаЗан between :start and :end ")
                            .setParameter("КодГруп",originGroup)
                            .setParameter("start",timestamp1)
                            .setParameter("end",timestamp2)
                            .list();

                    transaction.commit();

                    transaction = session.beginTransaction();




                    for (Object object:list)
                    {
                        RaspEntity entity = new RaspEntity();
                        entity = (RaspEntity) object;
                        session.evict(entity);
                        entity.setId(0);
                        entity.setКодГруп(cloneGroup);
                        System.out.println("BEFORE"+entity);
                        session.save(entity);
                        System.out.println("AFTER"+entity);

                    }

                    transaction.commit();
                    RaspTirFrame raspTirFrame = new RaspTirFrame(picker1.getDate(),picker2.getDate(),cloneGroup,"КЛОН");

                }catch (Throwable t) {
                    System.out.println("error");
                    t.printStackTrace();
                    transaction.rollback();
                }finally {
                    // закрытие сессии
                    session.close();
                }
            });



            button2.addActionListener(e -> {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                try{

                    Timestamp timestamp1 = new Timestamp(picker1.getDate().getTime());
                    Timestamp timestamp2 = new Timestamp(picker2.getDate().getTime());

                    int i = session.createQuery("delete RaspEntity where КодГруп = :КодГруп  and ДатаЗан between :start and :end")
                            .setParameter("КодГруп", cloneGroup)
                            .setParameter("start", timestamp1)
                            .setParameter("end", timestamp2)
                            .executeUpdate();

                    transaction.commit();
                    System.out.println(i);

                }catch (Throwable t) {
                    System.out.println("error");
                    t.printStackTrace();
                    transaction.rollback();
                }finally {
                    // закрытие сессии
                    session.close();
                }
            });


            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    Transaction transaction = session.beginTransaction();
                    try{

                        Timestamp timestamp1 = new Timestamp(picker1.getDate().getTime());
                        Timestamp timestamp2 = new Timestamp(picker2.getDate().getTime());
                        int index = discBox.getSelectedIndex();
                        DiscEntity discEntity =(DiscEntity) list.get(index);


                        int i = session.createQuery("delete RaspEntity where КодГруп = :КодГруп and КодДисц=:КодДисц and ДатаЗан between :start and :end")
                                .setParameter("КодГруп", cloneGroup)
                                .setParameter("КодДисц", discEntity)
                                .setParameter("start", timestamp1)
                                .setParameter("end", timestamp2)
                                .executeUpdate();

                        List list;
                        list = session.createQuery("from RaspEntity where КодГруп =:КодГруп and КодДисц=:КодДисц and ДатаЗан between :start and :end ")
                                .setParameter("КодГруп",originGroup)
                                .setParameter("КодДисц", discEntity)
                                .setParameter("start",timestamp1)
                                .setParameter("end",timestamp2)
                                .list();

                        transaction.commit();

                        transaction = session.beginTransaction();




                        for (Object object:list)
                        {
                            RaspEntity entity = new RaspEntity();
                            entity = (RaspEntity) object;
                            session.evict(entity);
                            entity.setId(0);
                            entity.setКодГруп(cloneGroup);
                            System.out.println("BEFORE"+entity);
                            session.save(entity);
                            System.out.println("AFTER"+entity);

                        }

                        transaction.commit();
                        RaspTirFrame raspTirFrame = new RaspTirFrame(picker1.getDate(),picker2.getDate(),cloneGroup,"КЛОН");

                    }catch (Throwable t) {
                        System.out.println("error");
                        t.printStackTrace();
                        transaction.rollback();
                    }finally {
                        // закрытие сессии
                        session.close();
                    }

                    System.out.println(list.size());
                }
            });


            button4.addActionListener(e -> {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                try{

                    Timestamp timestamp1 = new Timestamp(picker1.getDate().getTime());
                    Timestamp timestamp2 = new Timestamp(picker2.getDate().getTime());

                    int index = discBox.getSelectedIndex();
                    DiscEntity discEntity =(DiscEntity) list.get(index);


                    int i = session.createQuery("delete RaspEntity where КодГруп = :КодГруп and КодДисц=:КодДисц and ДатаЗан between :start and :end")
                            .setParameter("КодГруп", cloneGroup)
                            .setParameter("КодДисц", discEntity)
                            .setParameter("start", timestamp1)
                            .setParameter("end", timestamp2)
                            .executeUpdate();

                    transaction.commit();
                    System.out.println(i);

                }catch (Throwable t) {
                    System.out.println("error");
                    t.printStackTrace();
                    transaction.rollback();
                }finally {
                    // закрытие сессии
                    session.close();
                }
            });


            if(count==1) {
                add(button1);
                add(button2);
            }else if (count==2){
                list = initList();
                ArrayList<String> dicsList = new ArrayList();
                for (Object object:list)
                {
                    DiscEntity entity = (DiscEntity) object;
                    dicsList.add(entity.getНаимДисц());

                }
                discBox = new JComboBox(dicsList.toArray());
                add(disc);
                add(discBox);
                add(button3);
                add(button4);
            }


        }

        public List initList(){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            try{

                Timestamp timestamp1 = new Timestamp(picker1.getDate().getTime());
                Timestamp timestamp2 = new Timestamp(picker2.getDate().getTime());

                List list;
                list = session.createQuery("select R.кодДисц from RaspEntity R where R.кодГруп =:КодГруп and R.датаЗан between :start and :end ")
                        .setParameter("КодГруп",originGroup)
                        .setParameter("start",timestamp1)
                        .setParameter("end",timestamp2)
                        .list();

                transaction.commit();

                transaction = session.beginTransaction();



                List arrayList = new ArrayList();
                for (Object object:list)
                {
                    DiscEntity entity = (DiscEntity) object;
                    if(!(arrayList.contains(entity))) {
                        arrayList.add(entity);
                    }
                }

                transaction.commit();
                return  arrayList;

            }catch (Throwable t) {
                System.out.println("error");
                t.printStackTrace();
                transaction.rollback();
            }finally {
                // закрытие сессии
                session.close();
            }
            return null;
        }
    }
}
