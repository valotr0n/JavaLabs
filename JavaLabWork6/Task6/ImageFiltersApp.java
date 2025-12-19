package Task6;

import javax.swing.*;

public class ImageFiltersApp extends JFrame {

    public ImageFiltersApp() {
        setTitle("Image filters");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new ImageFilterPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new ImageFiltersApp().setVisible(true)
        );
    }
}
