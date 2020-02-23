package tictactoecoop;

import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("меню");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.add(new startmenu(frame)).validate();

    }

}
