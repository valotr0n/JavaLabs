package Task1;
import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {

    private int lastY;

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
        g.drawLine(w / 2, top, w / 2, bottom);

        g.drawString("Ось X", right - 40, h / 2 - 10);
        g.drawString("Ось Y", w / 2 + 10, top + 10);
        g.drawString("0", w / 2 + 5, h / 2 + 15);

        String[] xLabels = {"-3.14", "-1.57", "0", "1.57", "3.14"};
        for (int i = 0; i < 5; i++) {
            int x = left + (right - left) * i / 4;
            g.drawLine(x, h / 2 - 5, x, h / 2 + 5);
            g.drawString(xLabels[i], x - 15, h / 2 + 20);
        }

        String[] yLabels = {"1.0", "0.5", "0", "-0.5", "-1.0"};
        for (int i = 0; i < 5; i++) {
            int y = top + (bottom - top) * i / 4;
            g.drawLine(w / 2 - 5, y, w / 2 + 5, y);
            g.drawString(yLabels[i], w / 2 - 35, y + 5);
        }

        g.setColor(Color.BLUE);

        for (int x = left; x <= right; x++) {
            double realX = -Math.PI + 2 * Math.PI * (x - left) / (right - left);
            double y = Math.sin(realX);
            int screenY = h / 2 - (int) (y * (bottom - top) / 2);

            if (x != left) {
                g.drawLine(x - 1, lastY, x, screenY);
            }
            lastY = screenY;
        }
    }
}
