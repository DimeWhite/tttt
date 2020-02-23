package tictactoecoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;



public class tictactoesinglgame extends JPanel {
    public static JButton btn[] = { new JButton("Вернуться в меню "),
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

    public tictactoesinglgame(JFrame frame, String a, String z) {
        setVisible(true);
        JPanel geo = new JPanel();
        setLayout(new BorderLayout());
        add(geo, BorderLayout.CENTER);
        x = a;
        o = z;
        move = x;
        geo.setLayout(new GridLayout(3,3));
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
        validate();
        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                frame.add(new tttsinglemenu(frame));
            }
        });

        btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn[1].getText().equals(" ")) {
                    btn[1].setText(move);
                    move = move.equals(x) ? o : x;
                    win();
                }
            }
        });

        btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn[2].getText().equals(" ")) {
                    btn[2].setText(move);
                    move = move.equals(x) ? o : x;
                    win();
                }
            }
        });

        btn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn[3].getText().equals(" ")) {
                    btn[3].setText(move);
                    move = move.equals(x) ? o : x;
                    win();
                }
            }
        });
        btn[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn[4].getText().equals(" ")) {
                    btn[4].setText(move);
                    move = move.equals(x) ? o : x;
                    win();
                }
            }
        });
        btn[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn[5].getText().equals(" ")) {
                    btn[5].setText(move);
                    move = move.equals(x) ? o : x;
                    win();
                }
            }
        });
        btn[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn[6].getText().equals(" ")) {
                    btn[6].setText(move);
                    move = move.equals(x) ? o : x;
                    win();
                }
            }
        });
        btn[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn[7].getText().equals(" ")) {
                    btn[7].setText(move);
                    move = move.equals(x) ? o : x;
                    win();
                }
            }
        });
        btn[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn[8].getText().equals(" ")) {
                    btn[8].setText(move);
                    move = move.equals(x) ? o : x;
                    win();
                }
            }
        });
        btn[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btn[9].getText().equals(" ")) {
                    btn[9].setText(move);
                    move = move.equals(x) ? o : x;
                    win();
                }
            }
        });

    }
    public static void win()
    {
        if (btn[1].getText().equals(btn[2].getText()) && btn[2].getText().equals(btn[3].getText()) && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move == x?o:x));
            for (int i = 0; i < btn.length ; i++) {
                btn[i].setText(" ");

            }
            move = x;
        }
        else if (btn[4].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[6].getText()) && !btn[4].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move == x?o:x));
            for (int i = 0; i < btn.length ; i++) {
                btn[i].setText(" ");

            }
            move = x;
        }
        else if (btn[7].getText().equals(btn[8].getText()) && btn[8].getText().equals(btn[9].getText()) && !btn[7].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move == x?o:x));
            for (int i = 0; i < btn.length ; i++) {
                btn[i].setText(" ");

            }
            move = x;
        }
        else if (btn[1].getText().equals(btn[4].getText()) && btn[4].getText().equals(btn[7].getText()) && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move == x?o:x));
            for (int i = 0; i < btn.length ; i++) {
                btn[i].setText(" ");

            }
            move = x;
        }
        else if (btn[2].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[8].getText()) && !btn[2].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move == x?o:x));
            for (int i = 0; i < btn.length ; i++) {
                btn[i].setText(" ");

            }
            move = x;
        }
        else if (btn[3].getText().equals(btn[6].getText()) && btn[6].getText().equals(btn[9].getText()) && !btn[3].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move == x?o:x));
            for (int i = 0; i < btn.length ; i++) {
                btn[i].setText(" ");

            }
            move = x;
        }
        else if (btn[1].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[9].getText())  && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move == x?o:x));
            for (int i = 0; i < btn.length ; i++) {
                btn[i].setText(" ");

            }
            move = x;
        }
        else if (btn[3].getText().equals(btn[5].getText()) && btn[5].getText().equals(btn[7].getText()) && !btn[3].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Победили - " + (move == x?o:x));
            for (int i = 0; i < btn.length ; i++) {
                btn[i].setText(" ");

            }
            move = x;
        }
        else if (!btn[1].getText().equals(" ") && !btn[2].getText().equals(" ") && !btn[3].getText().equals(" ")
                && !btn[4].getText().equals(" ") && !btn[5].getText().equals(" ") && !btn[6].getText().equals(" ")
                && !btn[7].getText().equals(" ") && !btn[8].getText().equals(" ") && !btn[1].getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Ничья");
            for (int i = 0; i < btn.length ; i++) {
                btn[i].setText(" ");

            }
            move = x;
        }
    }
}
