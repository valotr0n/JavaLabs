package Task6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageFilterPanel extends JPanel {

    private BufferedImage image;
    private String currentFilter = "";
    private boolean grayUsed = false;

    public ImageFilterPanel() {
        setFocusable(true);
        setBackground(Color.GRAY);

        try {
            image = ImageIO.read(new File("pic.jpg"));
        } catch (Exception e) {
            image = null;
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                applyFilter();
                repaint();
                requestFocusInWindow();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char k = Character.toLowerCase(e.getKeyChar());
                if (k == 'r') currentFilter = "rotate";
                if (k == 'g' && !grayUsed) currentFilter = "gray";
                if (k == 'b') currentFilter = "blur";
            }
        });
    }

    private void applyFilter() {
        if (image == null) return;

        switch (currentFilter) {
            case "rotate":
                rotate180();
                break;
            case "gray":
                toGray();
                grayUsed = true;
                break;
            case "blur":
                blur();
                break;
        }
    }

    private void rotate180() {
        int w = image.getWidth();
        int h = image.getHeight();

        BufferedImage out = new BufferedImage(w, h, image.getType());

        for (int y = 0; y < h; y++)
            for (int x = 0; x < w; x++)
                out.setRGB(w - x - 1, h - y - 1, image.getRGB(x, y));

        image = out;
    }

    private void toGray() {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color c = new Color(image.getRGB(x, y));
                int avg = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
                Color g = new Color(avg, avg, avg);
                image.setRGB(x, y, g.getRGB());
            }
        }
    }

    private void blur() {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage copy = new BufferedImage(w, h, image.getType());

        for (int y = 1; y < h - 1; y++) {
            for (int x = 1; x < w - 1; x++) {
                int r = 0, g = 0, b = 0;

                for (int dy = -1; dy <= 1; dy++)
                    for (int dx = -1; dx <= 1; dx++) {
                        Color c = new Color(image.getRGB(x + dx, y + dy));
                        r += c.getRed();
                        g += c.getGreen();
                        b += c.getBlue();
                    }

                r /= 9;
                g /= 9;
                b /= 9;

                copy.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        image = copy;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            g.setColor(Color.RED);
            g.drawString("Image not found", 20, 20);
            return;
        }

        int w = getWidth();
        int h = getHeight();

        double imgRatio = (double) image.getWidth() / image.getHeight();
        double panelRatio = (double) w / h;

        int dw, dh;

        if (panelRatio > imgRatio) {
            dh = h;
            dw = (int) (h * imgRatio);
        } else {
            dw = w;
            dh = (int) (w / imgRatio);
        }

        int x = (w - dw) / 2;
        int y = (h - dh) / 2;

        g.drawImage(image, x, y, dw, dh, null);
    }
}
