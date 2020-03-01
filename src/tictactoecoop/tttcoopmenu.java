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
        btn_server.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tttservermenu servermenu = null;
                try {
                    servermenu = new tttservermenu(frame);
                    /////////
                    frame.add(servermenu);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn_client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tttclientmenu clientmenu = new tttclientmenu(frame);
                    setVisible(false);
                    frame.add(clientmenu);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
