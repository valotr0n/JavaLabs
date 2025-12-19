package Task8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TickerPanel extends JPanel {

    private final String[] messages = {
            "Его",
            "Имя",
            "Джеймс",
            "Гослинг",
            "Java"
    };

    private String text = messages[0];
    private int x;
    private final int y = 100;

    public TickerPanel() {
        setBackground(Color.BLACK);
        setForeground(Color.GREEN);
        setFont(new Font("Arial", Font.BOLD, 18));

        x = -200;

        Timer timer = new Timer(30, e -> {
            x += 2;
            if (x > getWidth()) {
                x = -getFontMetrics(getFont()).stringWidth(text);
            }
            repaint();
        });

        timer.start();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = (int)(Math.random() * messages.length);
                text = messages[i];
                x = -getFontMetrics(getFont()).stringWidth(text);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getForeground());
        g.drawString(text, x, y);
    }
}
