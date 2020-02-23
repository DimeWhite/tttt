package tictactoecoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class tttserver extends JPanel {
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
    public static String x = "X";
    public static String o = "O";
    public static String move = x;
    public static int sq = 0;
    public static boolean wait = false;
    public static DataOutputStream out = null;

    public tttserver(JFrame frame, String a, String port, DataInputStream in, DataOutputStream out) throws Exception {
        frame.setName("server");
        validate();
        x = a;
        this.out = out;
        out.writeUTF(x);
        out.flush();
        String b = in.readUTF();
        o = b;


        JPanel geo = new JPanel();
        setLayout(new BorderLayout());
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
        geo.validate();
        frame.validate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (wait){
                        String b = null;
                        try {
                            System.out.println("сервер получает");
                            b = in.readUTF();
                            System.out.println("сервер получил");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        btn[Integer.parseInt(b)].setText(o);
                        System.out.println("сервер записал" + b);
                        wins();
                        System.out.println("сервер проверил");
                        wait = false;
                    }
                }
            }
        }).start();

        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                try {
                    frame.add(new tttservermenu(frame));
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
                    hod(finalI, in);
                }
            });
        }
    }
    private void read(DataInputStream in){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (wait){
                        String b = null;
                        try {
                            System.out.println("сервер получает");
                            b = in.readUTF();
                            System.out.println("сервер получил");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        btn[Integer.parseInt(b)].setText(o);
                        System.out.println("сервер записал" + b);
                        wins();
                        System.out.println("сервер проверил");
                        wait = false;
                    }
                }
            }
        }).start();


    }
    private void hod(int g, DataInputStream in) {
        if(!wait) {
            if (btn[g].getText().equals(" ")) {
                btn[g].setText(x);
                move = move.equals(x) ? o : x;
                sq = g;
                try {
                    out.writeUTF(sq + "");
                    out.flush();
                    System.out.println("Сервер отправил" + sq);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                wins();
                System.out.println("я проверил");
                wait = true;
                read(in);
            }
        }
    }

    private void wins() {
        if (btn[1].getText().equals(btn[2].getText()) && btn[2].getText().equals(btn[3].getText()) && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            wait = false;
            System.out.println("тут");
            move = x;
            btn[0].setText("Вернуться в меню");
        } else if (btn[4].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[6].getText()) && !btn[4].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            wait = false;
            System.out.println("тут");
            move = x;
            btn[0].setText("Вернуться в меню");
        } else if (btn[7].getText().equals(btn[8].getText()) && btn[8].getText().equals(btn[9].getText()) && !btn[7].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = false;
            System.out.println("тут");
            move = x;

        } else if (btn[1].getText().equals(btn[4].getText()) && btn[4].getText().equals(btn[7].getText()) && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = false;
            System.out.println("тут");
            move = x;
        } else if (btn[2].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[8].getText()) && !btn[2].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = false;
            System.out.println("тут");
            move = x;
        } else if (btn[3].getText().equals(btn[6].getText()) && btn[6].getText().equals(btn[9].getText()) && !btn[3].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = false;
            System.out.println("тут");
            move = x;
        } else if (btn[1].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[9].getText()) && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = false;
            System.out.println("тут");
            move = x;
        } else if (btn[3].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[7].getText()) && !btn[3].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move.equals(x) ? o : x));
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = false;
            System.out.println("тут");
            move = x;
        } else if (!btn[1].getText().equals(" ") && !btn[2].getText().equals(" ") && !btn[3].getText().equals(" ")
                && !btn[4].getText().equals(" ") && !btn[5].getText().equals(" ") && !btn[6].getText().equals(" ")
                && !btn[7].getText().equals(" ") && !btn[8].getText().equals(" ") && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Ничья");
            for (int i = 0; i < btn.length; i++) {
                btn[i].setText(" ");

            }
            btn[0].setText("Вернуться в меню");
            wait = false;
            System.out.println("тут");
            move = x;
        }
    }
}