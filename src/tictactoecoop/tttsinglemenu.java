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
    public tttsinglemenu(JFrame frame) {
        validate();
        JPanel panelexit = new JPanel(new BorderLayout());
        panelexit.add(this, BorderLayout.CENTER);
        JButton exitbtn = new JButton("Назад");
        setLayout(new GridLayout(3, 2));
        panelexit.add(exitbtn, BorderLayout.SOUTH);
        panelexit.setVisible(true
        );
        add(firsXLabel);
        add(firsXEntry);
        add(secondOLabel);
        add(secondOEntry);
        add(btnII);
        add(btn2player);
        add(firsXLabel);
        add(firsXEntry);
        add(secondOLabel);
        add(secondOEntry);
        add(btnII);
        add(btn2player);
        validate();
        // методы кнопок
        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                panelexit.setVisible(false);
                try {
                    frame.add(new startmenu());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                validate();
            }
        });
        btn2player.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                panelexit.setVisible(false);
                frame.add(new tictactoesinglgame(frame, firsXEntry.getText(), secondOEntry.getText()));
                validate();
            }
        });


        // плитка


    }

}
