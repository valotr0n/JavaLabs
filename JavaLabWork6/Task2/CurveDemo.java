package Task2;

import javax.swing.*;

public class CurveDemo extends JFrame {

    public CurveDemo() {
        setTitle("Curve sin(x)");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new CurvePanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new CurveDemo().setVisible(true)
        );
    }
}
