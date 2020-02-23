package tictactoecoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class startmenu extends JFrame {
    public startmenu() throws Exception {
        JPanel panel = new JPanel();
        add(panel);
        this.setDefaultCloseOperation(1);
        setSize(500, 500);
        panel.setLayout(new GridLayout(3, 1));
        setVisible(true);
        JButton singl = new JButton("Одиночная игра");
        panel.add(singl);
        JButton coop = new JButton("Мультиплеер");
        panel.add(coop);
        JButton exits = new JButton("Выход");
        panel.add(exits);
        validate();
        tttcoopmenu coopmenu = new tttcoopmenu(this);
        tttsinglemenu singlmenu;
        singlmenu = new tttsinglemenu(this);
        singl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ////////////////////////////////////////////////////dsadas//sd/asd/
                panel.setVisible(false);
                add(singlmenu);
                validate();
            }
        }
        );
        coop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                add(coopmenu);
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