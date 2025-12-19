package Task3;

import javax.swing.*;
import java.awt.*;

public class TickerPanel extends JPanel {

    private int x = 0;
    private final Timer timer;

    public TickerPanel(AnimationPanel panel) {
        setPreferredSize(new Dimension(0, 30));
        setBackground(Color.BLACK);
        setForeground(Color.GREEN);
        setFont(new Font("Arial", Font.PLAIN, 14));

        timer = new Timer(40, e -> {
            x += 2;
            if (x > getWidth()) x = -300;
            repaint();
        });
        timer.start();

        addPropertyChangeListener(evt -> repaint());

        this.panel = panel;
    }

    private final AnimationPanel panel;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getForeground());

        String text = "Balls: " + panel.getBallCount() +
                      " / Max: " + panel.getMaxBalls();

        g.drawString(text, x, 20);
    }
}
