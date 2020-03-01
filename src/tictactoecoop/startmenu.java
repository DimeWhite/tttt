package tictactoecoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class startmenu extends JPanel {
    public startmenu(JFrame frame) throws Exception {
        frame.validate();
        setSize(500, 500);
        setLayout(new GridLayout(3, 1));
        setVisible(true);
        JButton singl = new JButton("Одиночная игра");
        add(singl);
        JButton coop = new JButton("Мультиплеер");
        add(coop);
        JButton exits = new JButton("Выход");
        add(exits);
        singl.addActionListener(e -> {

            ////////////////////////////////////////////////////
            frame.remove(this);
            frame.add(new tttsinglemenu(frame));
        }
        );
        coop.addActionListener(e -> {
            try {
                tttcoopmenu coopmenu = new tttcoopmenu(frame);
                frame.remove(this);
                frame.add(coopmenu);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        exits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
        frame.setSize(501,500);
        frame.setSize(500,500);
    }

}