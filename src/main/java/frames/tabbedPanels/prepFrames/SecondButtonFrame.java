package frames.tabbedPanels.prepFrames;

import dao.PrepsEntity;
import utils.Cache;
import utils.TableFactory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by Maxon on 30.03.2017.
 */
public class SecondButtonFrame extends JFrame {
    private JTable table;
    private Tpanel tpanel;
    private InfoPanel infoPanel;
    public SecondButtonFrame() throws HeadlessException {

        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Просмотр/Коррекция расписания занятий группы");
        title.setPreferredSize(new Dimension(700,60));
        title.setFont(font);
        setBounds(500,0,900,500);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        tpanel = new Tpanel();
        infoPanel = new InfoPanel();





        contentPane.add(title);
        contentPane.add(tpanel);
        contentPane.add(infoPanel);
        setVisible(true);
    }


    public class Tpanel extends JPanel{
        public Tpanel() {
            String[] head={" ФИО","ФДО","Внеш"};
            int[] widths = {220,40,50};

            List<PrepsEntity> prepsEntityList = Cache.getPrepsEntityList();
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
                        mas[i][1] = entity.getПрФдо();
                        mas[i][2] = entity.getПрВнеш();
                    }
                }
            };


            int sum=0;
            for (int i = 0; i < widths.length; i++) {
                sum+=widths[i];
            }


            table = tableFactory.getTable();
            setPreferredSize(new Dimension(sum+15,400));
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {

                }
            });
            JScrollPane tableContainer = new JScrollPane(table);
            tableContainer.setPreferredSize(new Dimension(sum+13, 370));
            tableContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            tableContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            add(tableContainer);
            System.out.println(sum+13);
        }
    }

    public class InfoPanel extends JPanel{
        FirstInfo firstInfo = new FirstInfo();

        public InfoPanel() {
            setPreferredSize(new Dimension(530,400));
            setLayout(new FlowLayout(FlowLayout.CENTER));

            add(firstInfo);
        }

        public class FirstInfo extends JPanel{

            public FirstInfo() {

                setPreferredSize(new Dimension(550,155));
                setLayout(new FlowLayout(FlowLayout.CENTER));

                JPanel panel1 = new JPanel(new GridLayout(3,1));
                panel1.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                panel1.setPreferredSize(new Dimension(100,100));
                JLabel secondName = new JLabel(" Ivanov");
                JLabel firstName = new JLabel(" Ivan");
                JLabel thirdName = new JLabel(" Ivanovich");
                panel1.add(secondName);
                panel1.add(firstName);
                panel1.add(thirdName);







                JPanel panel2 = new JPanel(new GridLayout(3,2));
                panel2.setPreferredSize(new Dimension(230,100));
                JLabel phone1 = new JLabel("Тел:");
                JLabel phone2 = new JLabel("Тел2:");
                JLabel mail = new JLabel("mail:");
                JTextField textPhone1 = new JTextField(10);
                JTextField textPhone2 = new JTextField(10);
                JTextField textMail = new JTextField(10);
                panel2.add(phone1);panel2.add(textPhone1);
                panel2.add(phone2);panel2.add(textPhone2);
                panel2.add(mail);panel2.add(textMail);



                JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                panel3.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
                panel3.setPreferredSize(new Dimension(370,150));
                JLabel doc = new JLabel("Договор");
                JTextField textDoc = new JTextField(10);
                JLabel ot = new JLabel("от: ");
                JTextField dateDoc = new JTextField(10);
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
                panel3.add(panel2);
                panel3.add(button);


                add(panel1);
                add(panel3);


            }
        }
    }


}
