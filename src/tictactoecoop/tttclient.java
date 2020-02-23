package tictactoecoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class tttclient extends JPanel {
    public static JButton btn[] = {new JButton("Вернуться в меню "),
            new JButton(" "),
            new JButton(" "),
            new JButton(" "),
            new JButton(" "),
            new JButton(" "),
            new JButton(" "),
            new JButton(" "),
            new JButton(" "),
            new JButton(" "),
    };
    public static String x = "";
    public static String o = "O";
    public static String move = x;
    public static int sq;
    public static boolean wait = true;
    public static Socket socket = null;
    public static DataInputStream in = null;
    public static DataOutputStream out = null;

    public tttclient(JFrame frame, String z, String port) throws Exception {
        frame.setName("client");
        x = "";
        o = z;
        socket = new Socket("192.168.0.42", Integer.parseInt(port));
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        System.out.println(socket);
        System.out.println(out);
        JPanel geo = new JPanel();
        setLayout(new BorderLayout());
        setVisible(true);
        validate();
        add(geo, BorderLayout.CENTER);
        move = x;
        geo.setLayout(new GridLayout(3, 3));
        add(btn[0], BorderLayout.SOUTH);
        geo.add(btn[1]);
        geo.add(btn[2]);
        geo.add(btn[3]);
        geo.add(btn[4]);
        geo.add(btn[5]);
        geo.add(btn[6]);
        geo.add(btn[7]);
        geo.add(btn[8]);
        geo.add(btn[9]);
        geo.setVisible(true);
        validate();
        frame.validate();
        String b = in.readUTF();
        x = b;
        out.writeUTF(o);
        out.flush();
        if(wait){
            read();
        }
        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                try {
                    frame.add(new tttcoopmenu(frame));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 1; i < btn.length; i++) {
            int finalI = i;
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        hod(finalI);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }

    private void hod(int g) throws IOException {
        if(!wait) {
            if (btn[g].getText().equals(" ")) {
                btn[g].setText(o);
                move = move.equals(x) ? o : x;
                sq = g;
                out.writeUTF(sq + "");
                out.flush();
                System.out.println("клиент отправил");

                wins();
                System.out.println("клиент проверил");
                wait = true;
                read();
            }
        }
    }

    private void read() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (wait) {
                        String b = null;
                        try {
                            b = in.readUTF();
                            System.out.println("клиент получил");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        btn[Integer.parseInt(b)].setText(x);
                        System.out.println("клиент записал в " + x);
                        wins();
                        System.out.println("клиент проверил");
                        wait = false;
                    }
                }
            }
        }.start();
    }

    private void wins() {
        if (btn[1].getText().equals(btn[2].getText()) && btn[2].getText().equals(btn[3].getText()) && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = true;
            move = o;
        } else if (btn[4].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[6].getText()) && !btn[4].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = true;
            move = o;
        } else if (btn[7].getText().equals(btn[8].getText()) && btn[8].getText().equals(btn[9].getText()) && !btn[7].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = true;
            System.out.println("тут");
            move = o;
        } else if (btn[1].getText().equals(btn[4].getText()) && btn[4].getText().equals(btn[7].getText()) && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
                for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = true;
            System.out.println("тут");
            move = o;
        } else if (btn[2].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[8].getText()) && !btn[2].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = true;
            System.out.println("тут");
            move = o;
        } else if (btn[3].getText().equals(btn[6].getText()) && btn[6].getText().equals(btn[9].getText()) && !btn[3].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = true;
            System.out.println("тут");
            move = o;
        } else if (btn[1].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[9].getText()) && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = true;
            System.out.println("тут");
            move = o;
        } else if (btn[3].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[7].getText()) && !btn[3].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = true;
            System.out.println("тут");
            move = o;
        } else if (!btn[1].getText().equals(" ") && !btn[2].getText().equals(" ") && !btn[3].getText().equals(" ")
                && !btn[4].getText().equals(" ") && !btn[5].getText().equals(" ") && !btn[6].getText().equals(" ")
                && !btn[7].getText().equals(" ") && !btn[8].getText().equals(" ") && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Ничья");
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = true;
            System.out.println("тут");
            move = o;
        }
    }
}

