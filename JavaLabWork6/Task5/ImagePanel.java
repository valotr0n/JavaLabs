package Task5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImagePanel extends JPanel {

    private BufferedImage image;
    private boolean rotated = false;

    public ImagePanel() {
        setBackground(Color.GRAY);

        try {
            image = ImageIO.read(new File("123.png"));
        } catch (Exception e) {
            image = null;
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rotated = !rotated;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            g.setColor(Color.RED);
            g.drawString("Image not found", 20, 20);
            return;
        }

        int panelW = getWidth();
        int panelH = getHeight();

        double imgRatio = (double) image.getWidth() / image.getHeight();
        double panelRatio = (double) panelW / panelH;

        int drawW, drawH;

        if (panelRatio > imgRatio) {
            drawH = panelH;
            drawW = (int) (panelH * imgRatio);
        } else {
            drawW = panelW;
            drawH = (int) (panelW / imgRatio);
        }

        int x = (panelW - drawW) / 2;
        int y = (panelH - drawH) / 2;

        Graphics2D g2 = (Graphics2D) g;

        if (rotated) {
            g2.rotate(Math.PI, panelW / 2.0, panelH / 2.0);
        }

        g2.drawImage(image, x, y, drawW, drawH, null);
    }
}
