package Task5;

import javax.swing.*;

public class ImageViewerApp extends JFrame {

    public ImageViewerApp() {
        setTitle("Image viewer");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new ImagePanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new ImageViewerApp().setVisible(true)
        );
    }
}
