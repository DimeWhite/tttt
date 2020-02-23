package tictactoecoop;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class tttsinglemenu extends JPanel{
    // создание label
    public static JLabel firsXLabel = new JLabel("Первый игрок: ");
    public static JLabel secondOLabel = new JLabel("Втрой игрок: ");
    // Создание текстовых полей
    public static JTextField firsXEntry = new JTextField("X", 15);
    public static JTextField secondOEntry = new JTextField("O", 15);
    // Кнопки для выбора режима
    public static JButton btnII = new JButton("Играть с ИИ");
    public static JButton btn2player = new JButton("Играть с кем-то");

    public static JButton exitbtn = new JButton("Назад");
    public tttsinglemenu(JFrame frame) {
        setLayout(new BorderLayout());
        JPanel cn = new JPanel(new GridLayout(3, 2));
        cn.add(firsXLabel);
        cn.add(firsXEntry);
        cn.add(secondOLabel);
        cn.add(secondOEntry);
        cn.add(btn2player);
        cn.add(btnII);
        add(cn, BorderLayout.CENTER);
        add(exitbtn, BorderLayout.SOUTH);
        validate();
        cn.validate();
        JPanel p = this;
        // методы кнопок
        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(p);
                try {
                    frame.add(new startmenu(frame)).validate();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                validate();
            }
        });
        btn2player.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.remove(p);
                frame.add(new tictactoesinglgame(frame, firsXEntry.getText(), secondOEntry.getText())).validate();
            }
        });
    }
}
