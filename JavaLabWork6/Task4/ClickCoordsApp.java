package Task4;

import javax.swing.*;

public class ClickCoordsApp extends JFrame {

    public ClickCoordsApp() {
        setTitle("Mouse coordinates");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new ClickPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new ClickCoordsApp().setVisible(true)
        );
    }
}
