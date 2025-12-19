package JavaBeans_Task5to6;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DiceView extends JComponent {

    private int value = 1;
    private final Random rnd = new Random();

    public DiceView() {
        setPreferredSize(new Dimension(80, 80));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value >= 1 && value <= 6) {
            this.value = value;
            repaint();
        }
    }

    public void roll() {
        setValue(rnd.nextInt(6) + 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);

        g.setColor(Color.BLACK);
        g.drawRect(0, 0, w - 1, h - 1);

        drawDots(g, w, h);
    }

    private void drawDots(Graphics g, int w, int h) {
        int d = Math.min(w, h) / 6;
        int cx = w / 2;
        int cy = h / 2;

        g.setColor(Color.BLACK);

        switch (value) {
            case 1 -> dot(g, cx, cy, d);
            case 2 -> {
                dot(g, cx - d, cy - d, d);
                dot(g, cx + d, cy + d, d);
            }
            case 3 -> {
                dot(g, cx, cy, d);
                dot(g, cx - d, cy - d, d);
                dot(g, cx + d, cy + d, d);
            }
            case 4 -> {
                dot(g, cx - d, cy - d, d);
                dot(g, cx + d, cy - d, d);
                dot(g, cx - d, cy + d, d);
                dot(g, cx + d, cy + d, d);
            }
            case 5 -> {
                dot(g, cx, cy, d);
                dot(g, cx - d, cy - d, d);
                dot(g, cx + d, cy - d, d);
                dot(g, cx - d, cy + d, d);
                dot(g, cx + d, cy + d, d);
            }
            case 6 -> {
                dot(g, cx - d, cy - d, d);
                dot(g, cx + d, cy - d, d);
                dot(g, cx - d, cy, d);
                dot(g, cx + d, cy, d);
                dot(g, cx - d, cy + d, d);
                dot(g, cx + d, cy + d, d);
            }
        }
    }

    private void dot(Graphics g, int x, int y, int d) {
        g.fillOval(x - d / 2, y - d / 2, d, d);
    }
}
