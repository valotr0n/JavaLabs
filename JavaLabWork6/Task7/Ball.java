package Task7;

import java.awt.*;

public class Ball {

    int x, y;
    int dx, dy;
    int r = 10;
    Color color;

    public Ball(int x, int y, int speed) {
        this.x = x;
        this.y = y;

        dx = speed;
        dy = speed;

        color = new Color(
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );
    }

    public void move(int w, int h) {
        x += dx;
        y += dy;

        if (x <= 0 || x + 2*r >= w) dx = -dx;
        if (y <= 0 || y + 2*r >= h) dy = -dy;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 2*r, 2*r);
    }
}
