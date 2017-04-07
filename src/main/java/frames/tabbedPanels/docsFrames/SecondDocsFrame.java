package frames.tabbedPanels.docsFrames;

import entities.PrepsEntity;
import utils.NewCache;
import utils.TableFactory;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.*;

/**
 * Created by Maxon on 07.04.2017.
 */
public class SecondDocsFrame extends JFrame {
    private JTable table;
    public SecondDocsFrame() throws HeadlessException {
        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Ввод/Коррекция сведений по УМР преподавателей / сотрудников ФДО");
        title.setPreferredSize(new Dimension(700,60));
        title.setFont(font);
        setBounds(350,0,900,710);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    public class Tpanel extends JPanel{
        public Tpanel() {
            String[] head={" ФИО","ФДО"};
            int[] widths = {220,40};

            java.util.List<PrepsEntity> prepsEntityList = NewCache.getCache().getPrepsEntities();
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
}
