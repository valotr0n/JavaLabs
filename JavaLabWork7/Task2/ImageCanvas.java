package Task2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageCanvas extends JPanel {

    private BufferedImage image;
    private boolean grayUsed = false;

    public ImageCanvas() {
        setBackground(Color.DARK_GRAY);
        try {
            image = ImageIO.read(new File("pic.jpg"));
        } catch (Exception e) {
            image = null;
        }
    }

    public void applyRotate() {
        if (image == null) return;
        int w = image.getWidth();
        int h = image.getHeight();

        BufferedImage out = new BufferedImage(w, h, image.getType());
        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++)
                out.setRGB(w - x - 1, h - y - 1, image.getRGB(x, y));

        image = out;
        repaint();
    }

    public void applyGray() {
        if (image == null || grayUsed) return;

        for (int y = 0; y < image.getHeight(); y++)
            for (int x = 0; x < image.getWidth(); x++) {
                Color c = new Color(image.getRGB(x, y));
                int avg = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                image.setRGB(x, y, new Color(avg, avg, avg).getRGB());
            }

        grayUsed = true;
        repaint();
    }

    public void applyBlur() {
        if (image == null) return;

        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage copy = new BufferedImage(w, h, image.getType());

        for (int y = 1; y < h - 1; y++)
            for (int x = 1; x < w - 1; x++) {
                int r = 0, g = 0, b = 0;

                for (int dy = -1; dy <= 1; dy++)
                    for (int dx = -1; dx <= 1; dx++) {
                        Color c = new Color(image.getRGB(x + dx, y + dy));
                        r += c.getRed();
                        g += c.getGreen();
                        b += c.getBlue();
                    }

                copy.setRGB(x, y, new Color(r / 9, g / 9, b / 9).getRGB());
            }

        image = copy;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            g.setColor(Color.RED);
            g.drawString("Image not found", 20, 20);
            return;
        }

        int pw = getWidth();
        int ph = getHeight();

        double imgRatio = (double) image.getWidth() / image.getHeight();
        double panelRatio = (double) pw / ph;

        int dw, dh;
        if (panelRatio > imgRatio) {
            dh = ph;
            dw = (int) (ph * imgRatio);
        } else {
            dw = pw;
            dh = (int) (pw / imgRatio);
        }

        int x = (pw - dw) / 2;
        int y = (ph - dh) / 2;

        g.drawImage(image, x, y, dw, dh, null);
    }
}
