package Game;

import JavaBeans_Task5to6.DiceView;

import javax.swing.*;
import java.awt.*;

public class DiceBoardPanel extends JPanel {

    private final CellType[] cells = {
            CellType.PLUS_10,
            CellType.PLUS_20,
            CellType.AGAIN,
            CellType.PLUS_30,
            CellType.MINUS_20,
            CellType.EMPTY,
            CellType.PLUS_40,
            CellType.MINUS_30,
            CellType.FINISH
    };

    private final Player p1 = new Player("Игрок 1", Color.RED);
    private final Player p2 = new Player("Игрок 2", Color.BLUE);
    private Player current = p1;

    private final DiceView dice = new DiceView();

    private boolean gameOver = false;

    private final JLabel statusLabel = new JLabel("Ход игрока 1");
    private final JButton rollButton = new JButton("Бросить кубик");
    private final JButton newGameButton = new JButton("Новая игра");

    public DiceBoardPanel() {
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        top.add(statusLabel);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottom.add(rollButton);
        bottom.add(newGameButton);

        rollButton.addActionListener(e -> makeMove());
        newGameButton.addActionListener(e -> resetGame());

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(900, 350));
        setBackground(new Color(230, 230, 230));
    }

    private void resetGame() {
        p1.position = 0;
        p2.position = 0;
        p1.score = 0;
        p2.score = 0;

        current = p1;
        gameOver = false;

        statusLabel.setText("Ход игрока 1");
        rollButton.setEnabled(true);

        repaint();
    }

    private void makeMove() {
        if (gameOver) return;

        dice.roll();
        int step = dice.getValue();

        current.position += step;
        if (current.position >= cells.length - 1) {
            current.position = cells.length - 1;
        }

        CellType cell = cells[current.position];

        if (cell == CellType.LOST_ALL) {
            current.score = 0;
        } else {
            current.score += cell.score;
        }


        if (cell == CellType.FINISH) {
            gameOver = true;
            rollButton.setEnabled(false);
            repaint();
            showWinner();
            return;
        }


        if (cell != CellType.AGAIN) {
            current = (current == p1) ? p2 : p1;
        }

        statusLabel.setText("Ход " + current.name);
        repaint();
    }

    private void showWinner() {
        String result;
        if (p1.score > p2.score) {
            result = "Победил Игрок 1";
        } else if (p2.score > p1.score) {
            result = "Победил Игрок 2";
        } else {
            result = "Ничья";
        }

        JOptionPane.showMessageDialog(
                this,
                result + "\nСчёт: " + p1.score + " : " + p2.score,
                "Игра окончена",
                JOptionPane.INFORMATION_MESSAGE
        );

        statusLabel.setText("Игра окончена");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int boardTop = 50;
        int boardHeight = height - 110;

        int cellW = Math.max(1, width / cells.length);

        for (int i = 0; i < cells.length; i++) {
            CellType c = cells[i];

            int x = i * cellW;
            int y = boardTop;

            g.setColor(c.color);
            g.fillRect(x + 2, y, cellW - 4, boardHeight);

            g.setColor(Color.BLACK);
            g.drawRect(x + 2, y, cellW - 4, boardHeight);

        
            g.setFont(new Font("Arial", Font.PLAIN, 14));
            drawCellText(g, c.text, x + 10, y + 30);
        }

    
        drawPlayerToken(g, p1, cellW, boardTop);
        drawPlayerToken(g, p2, cellW, boardTop);


        g.setColor(Color.BLACK);
        g.drawString("Игрок 1: очки=" + p1.score + ", позиция=" + (p1.position + 1), 10, height - 70);
        g.drawString("Игрок 2: очки=" + p2.score + ", позиция=" + (p2.position + 1), 10, height - 50);
    }

    private void drawPlayerToken(Graphics g, Player p, int cellW, int boardTop) {
        int x = p.position * cellW + cellW / 2 - 6;
        int y = boardTop - (p == p1 ? 18 : 35);

        g.setColor(p.color);
        g.fillOval(x, y, 12, 12);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 12, 12);
    }

    private void drawCellText(Graphics g, String text, int x, int y) {
        if (text == null || text.isEmpty()) return;

        String[] lines = text.split("\\n");
        for (int i = 0; i < lines.length; i++) {
            g.drawString(lines[i], x, y + i * 18);
        }
    }
}
