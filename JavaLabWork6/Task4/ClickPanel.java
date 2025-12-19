package Task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickPanel extends JPanel {

    private int x = -1;
    private int y = -1;
    private Color textColor = Color.BLACK;

    public ClickPanel() {
        setBackground(Color.WHITE);
        setFocusable(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
                requestFocusInWindow();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (Character.toLowerCase(e.getKeyChar())) {
                    case 'b': textColor = Color.BLACK; break;
                    case 'w': textColor = Color.WHITE; break;
                    case 'r': textColor = Color.RED; break;
                    case 'g': textColor = Color.GREEN; break;
                    case 'o': textColor = Color.ORANGE; break;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (x >= 0 && y >= 0) {
            g.setColor(textColor);
            g.drawString("(" + x + ", " + y + ")", x, y);
        }
    }
}
