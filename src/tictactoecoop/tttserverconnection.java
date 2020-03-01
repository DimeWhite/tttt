package tictactoecoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class tttserverconnection extends JPanel {
    public static Socket accepted = null;
    public tttserverconnection(JFrame frame, String port, String x) throws Exception{
        JLabel label = new JLabel("Подключение, ваш порт " + port);
        add(label);
        JButton button = new JButton("отмена");
        add(button);
        validate();
        final boolean[] con = {false};
        new Thread(){
            @Override
            public void run() {
                if(!con[0]) {
                    ServerSocket server = null;
                    try {
                        server = new ServerSocket(Integer.parseInt(port));
                        accepted = server.accept();
                        System.out.println("Подключился");
                        System.out.println(accepted.getLocalAddress());
                        setVisible(false);
                        DataOutputStream out = new DataOutputStream(accepted.getOutputStream());
                        System.out.println(out);
                        DataInputStream in = new DataInputStream(accepted.getInputStream());
                        tttserver tserver = new tttserver(frame, x, port, in, out);
                        frame.add(tserver);

                        validate();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }}.start();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con[0] = true;
                try {
                    frame.add(new tttservermenu(frame));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


    }
}