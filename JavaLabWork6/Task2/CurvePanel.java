package Task2;

import javax.swing.*;
import java.awt.*;

public class CurvePanel extends JPanel {

    private final Curve curve;
    private int prevY;

    public CurvePanel() {
        curve = new Curve();
        curve.setData(0, 2 * Math.PI, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        int left = 30;
        int right = w - 30;
        int top = 30;
        int bottom = h - 30;

        g.setColor(Color.BLACK);
        g.drawLine(left, h / 2, right, h / 2);
        g.drawLine(left, top, left, bottom);

        g.drawString("X", right - 10, h / 2 - 5);
        g.drawString("Y", left - 15, top + 10);
        g.drawString("0", left - 10, h / 2 + 15);

        String[] xLabels = {"0", "1", "3.14", "5.71", "8.28"};
        for (int i = 0; i < 5; i++) {
            int x = left + (right - left) * i / 4;
            g.drawLine(x, h / 2 - 5, x, h / 2 + 5);
            g.drawString(xLabels[i], x - 15, h / 2 + 20);
        }

        String[] yLabels = {"1.0", "0.5", "0", "-0.5", "-1.0"};
        for (int i = 0; i < 5; i++) {
            int y = top + (bottom - top) * i / 4;
            g.drawLine(left - 5, y, left + 5, y);
            g.drawString(yLabels[i], left - 35, y + 5);
        }

        g.setColor(Color.BLUE);

        for (int i = 0; i < curve.size(); i++) {
            int x = left + (int)((curve.getX(i)) / (2 * Math.PI) * (right - left));
            int y = h / 2 - (int)(curve.getY(i) * (bottom - top) / 2);

            if (i > 0) {
                g.drawLine(left + (int)((curve.getX(i - 1)) / (2 * Math.PI) * (right - left)),
                           prevY, x, y);
            }
            prevY = y;
        }
    }
}
