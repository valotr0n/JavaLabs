package Game;

import javax.swing.*;

public class DiceBoardFrame extends JFrame {
    public DiceBoardFrame() {
        setTitle("Игра в кости");
        setSize(900, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new DiceBoardPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new DiceBoardFrame().setVisible(true)
        );
    }
}
