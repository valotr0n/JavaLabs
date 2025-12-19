package Task8;

import javax.swing.*;

public class TickerApp extends JFrame {

    public TickerApp() {
        setTitle("Running text");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new TickerPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new TickerApp().setVisible(true)
        );
    }
}
