package Task3;

import java.awt.*;

public class Axis {

    public void draw(Graphics g, int w, int h) {
        g.setColor(Color.BLACK);

        // оси
        g.drawLine(50, 20, 50, h - 40);     // Y
        g.drawLine(50, h - 40, w - 20, h - 40); // X

        g.drawString("Ось Y", 10, 20);
        g.drawString("Ось X", w - 50, h - 20);

        // деления Y
        for (int y = h - 40; y >= 40; y -= 50) {
            g.drawLine(45, y, 55, y);
        }
    }
}
