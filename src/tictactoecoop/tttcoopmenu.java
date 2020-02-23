package tictactoecoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tttcoopmenu extends JPanel {
    public tttcoopmenu(JFrame frame) throws Exception{
        setVisible(true);
        validate();
        frame.validate();
        setLayout(new GridLayout(2, 1));
        JButton btn_server = new JButton("Создать");
        add(btn_server);
        JButton btn_client = new JButton("Подключится");
        add(btn_client);
        tttservermenu servermenu = new tttservermenu(frame);
        tttclientmenu clientmenu = new tttclientmenu(frame);
        btn_server.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                frame.add(servermenu);
            }
        });
        btn_client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                frame.add(clientmenu);
            }
        });
    }
}
