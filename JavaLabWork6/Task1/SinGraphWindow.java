package Task1;
import javax.swing.*;


public class SinGraphWindow extends JFrame {

    public SinGraphWindow() {
        setTitle("Sin(x) plot");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new GraphPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new SinGraphWindow().setVisible(true)
        );
    }
}
