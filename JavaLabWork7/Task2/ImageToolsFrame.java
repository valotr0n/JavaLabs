package Task2;

import javax.swing.*;
import java.awt.*;

public class ImageToolsFrame extends JFrame {

    public ImageToolsFrame() {
        setTitle("Image tools (Task 2)");
        setSize(700, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageCanvas canvas = new ImageCanvas();

        JButton rotateBtn = new JButton("Rotate 180°");
        JButton grayBtn   = new JButton("Grayscale");
        JButton blurBtn   = new JButton("Blur");

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controls.add(rotateBtn);
        controls.add(grayBtn);
        controls.add(blurBtn);

        rotateBtn.addActionListener(e -> canvas.applyRotate());
        grayBtn.addActionListener(e -> canvas.applyGray());
        blurBtn.addActionListener(e -> canvas.applyBlur());

        setLayout(new BorderLayout());
        add(controls, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
    }
}
