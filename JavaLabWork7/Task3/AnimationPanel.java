package Task3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AnimationPanel extends JPanel {

    private final ArrayList<Ball> balls = new ArrayList<>();
    private final Timer timer;
    private final int maxBalls = 20;

    public AnimationPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (balls.size() < maxBalls) {
                    balls.add(new Ball(e.getX(), e.getY()));
                }
            }
        });

        timer = new Timer(20, e -> {
            for (Ball b : balls) {
                b.move(getWidth(), getHeight());
            }
            repaint();
        });
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public int getBallCount() {
        return balls.size();
    }

    public int getMaxBalls() {
        return maxBalls;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball b : balls) {
            b.draw(g);
        }
    }
}
