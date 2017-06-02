package frames.tabbedPanels.docsFrames;

import controllers.DocsController;
import entities.NagrEntity;
import entities.PrepsEntity;
import org.jdesktop.swingx.JXDatePicker;
import utils.Cache;
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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * Created by Maxon on 25.03.2017.
 */
public class FirstDocsFrame extends JFrame {
    private DocsController controller;
    private JXDatePicker picker1;
    private JXDatePicker picker2;
    private InterPanel interPanel;
    private Tpanel tpanel;
    private InfoPanel infoPanel;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private JTable table;
    private InfoPanel.NagrPanel nagrPanel;



    public FirstDocsFrame(DocsController controller) throws HeadlessException {
        this.controller = controller;

        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Учебно-методическое сопровождение аудиторных занятий");
        title.setFont(font);
        setBounds(500,0,850,550);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        interPanel = new InterPanel();
        contentPane.add(title);
        contentPane.add(interPanel);
        tpanel = new Tpanel();
        contentPane.add(tpanel);
       /* infoPanel = new InfoPanel();
        contentPane.add(infoPanel);*/
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

    public class Tpanel extends JPanel{
        public Tpanel() {

            String[] head={" ФИО","ФДО","Внеш"};
            int[] widths = {220,40,50};

            List<PrepsEntity> prepsEntityList = NewCache.getCache().getPrepsEntities();
            List<PrepsEntity> keks = new ArrayList();
            for (PrepsEntity prepsEntity:prepsEntityList){
                if (prepsEntity.getNagrList().size()!=0)
                    keks.add(prepsEntity);
            }


            TableFactory tableFactory = new TableFactory(head,widths,keks) {
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
            setPreferredSize(new Dimension(sum+5,400));
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    getInfoSR(table,keks);
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
                if (infoPanel!= null)
                {
                    if (nagrPanel!= null)
                        infoPanel.remove(nagrPanel);

                    FirstDocsFrame.this.getContentPane().remove(infoPanel);

                }
                infoPanel = new InfoPanel(entity,fio);
                FirstDocsFrame.this.getContentPane().add(infoPanel);
                revalidate();
                repaint();
            }
        }
    }

    public class InfoPanel extends JPanel{

        public InfoPanel(PrepsEntity entity,String fio) {
            setPreferredSize(new Dimension(490,400));
            JLabel name = new JLabel(fio);
            Font font = new Font("Verdana",Font.BOLD,15);

            name.setFont(font);
            name.setPreferredSize(new Dimension(450,15));


            JPanel prepPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            String vnesh;
            if (entity.getПрВнеш())
                vnesh = "Внешний";
            else
                vnesh = "Внутренний";

            String number = entity.getДоговорНомер();
            String time="";
            if(number!=null)
            time = simpleDateFormat.format(new Date(entity.getДоговорДата().getTime()));

            String doljn = entity.getДолжн();
            String kafd = entity.getКодКаф().getНаимКаф();
            //JLabel doc = new JLabel("Внешний Договор: "+"444"+" от "+"4 окт 2017");
            JLabel doc = new JLabel("<html><body> <font color=green>"+vnesh+" </font> Договор: <font color=blue>"+number+"</font> от <font color=blue>"+time+"</font></body></html>");
            JLabel rank = new JLabel("<html><body>Должность: <font color=blue>"+doljn+" </font> </body></html>");
            JLabel kaf = new JLabel("<html><body>Кафедра: <font color=blue>"+kafd+" </font> </body></html>");

            prepPanel.add(doc);
            prepPanel.add(rank);
            prepPanel.add(kaf);
            prepPanel.setPreferredSize(new Dimension(270,115));
            prepPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 1));


            JPanel nprPanel = new JPanel();
            JLabel npr = new JLabel("Квалификация НПР");
            JLabel label1 = new JLabel("<html><body><font color=blue>"+entity.getКодНпр().getНаимНпр()+" </font> </body></html>");
            JLabel stavki = new JLabel("Ставки руб/ак.час");
            JLabel bak = new JLabel("<html><body>Магистр: <font color=blue>"+entity.getСтавкаВнешМ()+" </font> </body></html>");
            JLabel mag = new JLabel("<html><body>Бакалавр: <font color=blue>"+entity.getСтавкаВнешБ()+" </font> </body></html>");
            //JLabel test = new JLabel("<html><body> <font color=red>My </font><font color=green>label</font> </body></html>");

            nprPanel.add(npr);
            nprPanel.add(label1);
            nprPanel.add(stavki);
            nprPanel.add(bak);
            nprPanel.add(mag);
            nprPanel.setPreferredSize(new Dimension(120,115));
            nprPanel.setBorder(BorderFactory.createLineBorder(Color.red, 1));

            add(name);
            add(prepPanel);
            add(nprPanel);
            Collection<NagrEntity> nagrList = entity.getNagrList();
            if (nagrPanel!=null)
                this.remove(nagrPanel);
            if (nagrList.size()!=0) {
                nagrPanel = new NagrPanel(nagrList);
                add(nagrPanel);
            }

            JButton button1 = new JButton("Формирование доп соглашений");
            JButton button2 = new JButton("<html><body><font color=red> Сформировать Акт </font> </body></html>");

            button1.setPreferredSize(new Dimension(200,30));
            button2.setPreferredSize(new Dimension(200,30));

            add(button1);
            add(button2);
            revalidate();
            repaint();
        }

        public class NagrPanel extends JPanel{
            public NagrPanel(Collection<NagrEntity> nagrList) {
                String[] head={"ДатаЗан","НачЗ","","Дисциплина","Часы","Ставка","ДатаОпл"};
                int[] widths = {80,50,70,130,40,40,80};
                System.out.println(nagrList.size());

                    List<NagrEntity> list = new ArrayList<>(nagrList);
                    TableFactory tableFactory = new TableFactory(head, widths, list) {
                        @Override
                        public void fillMas() {
                            for (int i = 0; i < mas.length; i++) {
                                NagrEntity nagrEntity = (NagrEntity) list.get(i);
                                mas[i][0] = nagrEntity.getДатаЗан();
                                mas[i][1] = nagrEntity.getНачЗан();
                                mas[i][2] = nagrEntity.getТипСтуд();
                                mas[i][3] = nagrEntity.getDiscByКодДисц().getНаимДисц();
                                mas[i][4] = nagrEntity.getЧисло();
                                mas[i][5] = nagrEntity.getСтавка();
                                mas[i][6] = nagrEntity.getДатаОпл();
                            }
                        }
                    };


                    int sum = 0;
                    for (int i = 0; i < widths.length; i++) {
                        sum += widths[i];
                    }


                JTable table = tableFactory.getTable();
                setPreferredSize(new Dimension(sum + 5, 170));
                    JScrollPane tableContainer = new JScrollPane(table);
                    tableContainer.setPreferredSize(new Dimension(sum + 13, 150));
                    tableContainer.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                    tableContainer.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    add(tableContainer);

            }
        }
    }
}
