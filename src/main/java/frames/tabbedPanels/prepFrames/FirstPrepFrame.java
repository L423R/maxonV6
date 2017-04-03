package frames.tabbedPanels.prepFrames;

import entities.PrepsEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Maxon on 30.03.2017.
 */
public class FirstPrepFrame extends JFrame {
    public FirstPrepFrame() throws HeadlessException {
        Font font = new Font("Verdana",Font.BOLD,18);
        JLabel title = new JLabel("Введите первичные данные");
        title.setFont(font);
        setBounds(500,0,500,300);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));



        JPanel panel = new JPanel(new GridLayout(2,3));
        panel.setPreferredSize(new Dimension(400,50));

        panel.add(new JLabel("Фамилия"));
        panel.add(new JLabel("Имя"));
        panel.add(new JLabel("Отчество"));

        JTextField secondName = new JTextField();
        JTextField firstName = new JTextField();
        JTextField thirdName = new JTextField();

        panel.add(secondName);
        panel.add(firstName);
        panel.add(thirdName);


        JButton addButton = new JButton("Добавить");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        contentPane.add(title);
        contentPane.add(panel);
        contentPane.add(addButton);
        setVisible(true);
    }
    public PrepsEntity addNewPrep(){
        return null;
    }

}
