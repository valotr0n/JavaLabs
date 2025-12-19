package Task4;

import javax.swing.*;
import java.awt.*;

public class PlotPanel extends JPanel {

    private double xFrom = -3.14;
    private double xTo   =  3.14;
    private int funcType = 0;
    private Color color  = Color.BLUE;

    public PlotPanel() {
        setBackground(Color.WHITE);
    }

    public void setParams(double from, double to, int type) {
        xFrom = from;
        xTo = to;
        funcType = type;
        repaint();
    }

    public void setColor(Color c) {
        color = c;
        repaint();
    }

    public Color getColor() {
        return color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        int left = 40;
        int right = w - 20;
        int top = 20;
        int bottom = h - 40;

        // оси
        g.setColor(Color.BLACK);
        g.drawLine(left, h / 2, right, h / 2);
        g.drawLine(left, top, left, bottom);

        g.setColor(color);

        int prevY = 0;
        for (int px = left; px < right; px++) {
            double x = xFrom +
                    (xTo - xFrom) * (px - left) / (right - left);

            double y;
            if (funcType == 0)
                y = Math.sin(x);
            else if (funcType == 1)
                y = Math.sin(x * x) + Math.cos(x * x);
            else
                y = 2 * Math.sin(x) + Math.cos(2 * x);

            int py = h / 2 - (int)(y * (bottom - top) / 4);

            if (px > left)
                g.drawLine(px - 1, prevY, px, py);

            prevY = py;
        }
    }
}
