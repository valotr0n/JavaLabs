package Task7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BallsPanel extends JPanel {

    private final ArrayList<Ball> balls = new ArrayList<>();
    private final Timer timer;

    public BallsPanel() {
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int speed = 2 + (int)(Math.random() * 5);
                balls.add(new Ball(e.getX(), e.getY(), speed));
            }
        });

        timer = new Timer(20, e -> {
            for (Ball b : balls) {
                b.move(getWidth(), getHeight());
            }
            repaint();
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball b : balls) {
            b.draw(g);
        }
    }
}
