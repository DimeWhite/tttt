package tictactoecoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tttclientmenu extends JPanel{
    public tttclientmenu(JFrame frame) throws Exception {
        JLabel secondXLabel = new JLabel("Первый игрок: ");
        JLabel port = new JLabel("Порт: ");

        JTextField secondXEntry = new JTextField("O", 15);
        JTextField portEntry = new JTextField("1234", 15);
        JButton btnII = new JButton("Играть");
        validate();
        JPanel panelexit = new JPanel(new BorderLayout());
        panelexit.add(this, BorderLayout.CENTER);
        JButton exitbtn = new JButton("Назад");
        setLayout(new GridLayout(3, 2));
        panelexit.add(exitbtn, BorderLayout.SOUTH);
        panelexit.setVisible(true);
        add(secondXLabel);
        add(secondXEntry);
        add(port);
        add(portEntry);
        add(btnII);

        validate();
        // методы кнопок
        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelexit.setVisible(false);
                try {
                    frame.add(new startmenu(frame));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                validate();
            }
        });
        btnII.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                panelexit.setVisible(false);
                try {
                    frame.add(new tttclient(frame, secondXEntry.getText(), portEntry.getText()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                validate();
            }
        });

    }
}
