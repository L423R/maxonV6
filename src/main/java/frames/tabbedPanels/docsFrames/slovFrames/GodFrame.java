package frames.tabbedPanels.docsFrames.slovFrames;

import entities.GodEntity;
import utils.DaoFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Maxon on 08.04.2017.
 */
public class GodFrame extends JFrame {


    private GodEntity godEntity;

    public GodFrame() throws HeadlessException {
        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Сведения о работодателе РЭУ");
        title.setFont(font);
        setBounds(500,0,500,330);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        add(title);
        godEntity = (GodEntity) DaoFactory.getDaoFactory().getGodDao().getById(GodEntity.class,1);
        JPanel panel = new JPanel(new GridLayout(0,1));
        JLabel label1 = new JLabel("В лице КОГО?");
        JLabel label2 = new JLabel("ФИО КТО?");
        JLabel label3 = new JLabel("Доверенность:");
        JTextField tf1 = new JTextField(godEntity.getЛицо());
        JTextField tf2 = new JTextField(godEntity.getДолжн());
        JTextField tf3 = new JTextField(godEntity.getФио());
        JTextField tf4 = new JTextField(godEntity.getДовер());
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(tf2);
        p.add(tf3);

        panel.add(label1);panel.add(tf1);
        panel.add(label2);panel.add(p);
        panel.add(label3);panel.add(tf4);

        add(panel);
        setVisible(true);
    }


}
