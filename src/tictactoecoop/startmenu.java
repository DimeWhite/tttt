package tictactoecoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class startmenu extends JPanel {
    public startmenu(JFrame frame) throws Exception {
        frame.validate();
        validate();
        setSize(500, 500);
        setLayout(new GridLayout(3, 1));
        setVisible(true);
        JButton singl = new JButton("Одиночная игра");
        add(singl);
        JButton coop = new JButton("Мультиплеер");
        add(coop);
        JButton exits = new JButton("Выход");
        add(exits);
        tttcoopmenu coopmenu = new tttcoopmenu(frame);
        tttsinglemenu singlmenu = new tttsinglemenu(frame);
        frame.validate();
        validate();
        JPanel p = this;
        singl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ////////////////////////////////////////////////////dsadas//sd/asd/
                frame.remove(p);
                frame.add(singlmenu).validate();
                validate();
            }
        }
        );
        coop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                frame.add(coopmenu).validate();
            }
        });
        exits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
    }

}