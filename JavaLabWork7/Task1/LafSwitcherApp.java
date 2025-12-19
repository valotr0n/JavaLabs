package Task1;

import javax.swing.SwingUtilities;

public class LafSwitcherApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LafSwitcherFrame().setVisible(true));
    }
}
