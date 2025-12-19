package Task3;

import javax.swing.SwingUtilities;

public class AnimationDashboardApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new AnimationDashboardFrame().setVisible(true)
        );
    }
}
