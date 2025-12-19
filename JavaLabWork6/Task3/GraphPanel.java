package Task3;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {

    private Curve sinCurve;
    private Curve cosCurve;
    public GraphPanel() {
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        Axis axis = new Axis();
        axis.draw(g, w, h);

        if (sinCurve == null) {
            sinCurve = new Curve(w - 70, h - 120, 25, true);
            cosCurve = new Curve(w - 70, h - 120, 25, false);
        }

        g.setColor(Color.BLUE);
        drawCurve(g, sinCurve);

        g.setColor(Color.RED);
        drawCurve(g, cosCurve);

        g.drawString("f(x) = sin(x)", 80, 40);
        g.drawString("f(x) = cos(x)", 80, 60);
    }

    private void drawCurve(Graphics g, Curve c) {
        for (int x = 1; x < c.size(); x++) {
            g.drawLine(
                    50 + x - 1, c.getY(x - 1),
                    50 + x, c.getY(x)
            );
        }
    }
}
