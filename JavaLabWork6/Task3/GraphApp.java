package Task3;

import javax.swing.*;

public class GraphApp extends JFrame {

    public GraphApp() {
        setTitle("Graph demo");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new GraphPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new GraphApp().setVisible(true)
        );
    }
}
