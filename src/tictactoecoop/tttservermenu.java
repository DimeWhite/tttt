package tictactoecoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tttservermenu extends JPanel {
    public tttservermenu(JFrame frame) throws Exception {
        JLabel firsXLabel = new JLabel("Первый игрок: ");
        JLabel port = new JLabel("Порт: ");

        JTextField firsXEntry = new JTextField("X", 15);
        JTextField portEntry = new JTextField("1234", 15);
        JButton btnII = new JButton("Играть");
        validate();
        JPanel panelexit = new JPanel(new BorderLayout());
        panelexit.add(this, BorderLayout.CENTER);
        JButton exitbtn = new JButton("Назад");
        setLayout(new GridLayout(3, 2));
        panelexit.add(exitbtn, BorderLayout.SOUTH);
        panelexit.setVisible(true);
        add(firsXLabel);
        add(firsXEntry);
        add(port);
        add(portEntry);
        add(btnII);

        validate();
        // методы кнопок
        tttserverconnection serverconnection = new tttserverconnection(frame, portEntry.getText(),  firsXEntry.getText());
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
                    frame.add(serverconnection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                validate();
            }
        });
    }
}
