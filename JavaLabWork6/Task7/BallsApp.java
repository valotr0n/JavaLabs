package Task7;

import javax.swing.*;

public class BallsApp extends JFrame {

    public BallsApp() {
        setTitle("Balls animation");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new BallsPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new BallsApp().setVisible(true)
        );
    }
}
