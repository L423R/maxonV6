package frames.tabbedPanels.raspFrames;

import entities.GroupsEntity;
import frames.tabbedPanels.raspFrames.slovFrames.RaspFrame;
import org.jdesktop.swingx.JXDatePicker;
import utils.Cache;
import utils.DaoFactory;
import utils.NewCache;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxon on 07.03.2017.
 */
public class CorrRaspFrame extends JFrame {
    private List<GroupsEntity> groupsEntityList;
    private JXDatePicker picker1;
    private JXDatePicker picker2;
    //private ArrayList<GroupsEntity> currList = new ArrayList();
    private InterPanel interPanel;
    private GroupPanel groupPanel;
    public CorrRaspFrame() throws HeadlessException {

       // groupsEntityList = DaoFactory.getDaoFactory().getGroupDao().getOpenGr(picker1.getDate(),picker2.getDate());
        interPanel = new InterPanel();
        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Просмотр/Коррекция расписания занятий группы");
        title.setFont(font);
        setBounds(500,0,500,300);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(title);
        contentPane.add(interPanel);
        setVisible(true);
    }

    public class InterPanel extends JPanel
    {
        public InterPanel() {
            setPreferredSize(new Dimension(400,60));
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
                    if (groupPanel==null)
                    {   groupPanel = new GroupPanel();
                        CorrRaspFrame.this.getContentPane().add(groupPanel);
                    }else {
                        CorrRaspFrame.this.getContentPane().remove(groupPanel);
                        groupPanel = new GroupPanel();
                        CorrRaspFrame.this.getContentPane().add(groupPanel);
                        revalidate();
                        repaint();
                    }
                }
            });



            add(label1);
            add(picker1);
            add(label2);
            add(picker2);
            add(button);

        }


    }

    public class GroupPanel extends JPanel
    {
        public GroupPanel() {
            setPreferredSize(new Dimension(400,60));
            setLayout(new FlowLayout());
            groupsEntityList = DaoFactory.getDaoFactory().getGroupDao().getOpenGr(picker1.getDate(),picker2.getDate());
            JLabel label = new JLabel("Группа:");
            final JComboBox comboBox = new JComboBox(DaoFactory.getDaoFactory().getGroupDao().getNamesGr(groupsEntityList));
            JButton button = new JButton("Расписание");
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    RaspFrame raspFrame = new RaspFrame(picker1.getDate(),picker2.getDate(), groupsEntityList.get(comboBox.getSelectedIndex()));
                }
            });
            add(label);
            add(comboBox);
            add(button);
        }

        /*public Object[] getNamesGroup(List<GroupsEntity> list)
        {
            ArrayList namesGroup = new ArrayList();
            for (GroupsEntity entity : list) {
                if (entity.getДатаЗакр()==null && (entity.getДатаОткр().getTime()>=picker1.getDate().getTime())
                        && (entity.getДатаОткр().getTime()<=picker2.getDate().getTime())) {

                    currList.add(entity);
                    namesGroup.add(entity.getCurrName());
                }
            }

            return namesGroup.toArray();
        }*/


    }
}
