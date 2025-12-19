package Game;

import java.awt.Color;

public enum CellType {
    PLUS_10("+10", new Color(200,255,200), 10),
    PLUS_20("+20", new Color(200,255,200), 20),
    PLUS_30("+30", new Color(200,255,200), 30),
    PLUS_40("+40", new Color(200,255,200), 40),

    MINUS_20("-20", new Color(255,150,150), -20),
    MINUS_30("-30", new Color(255,180,180), -30),

    LOST_ALL("Потеря всех", Color.RED, Integer.MIN_VALUE),

    AGAIN("Повтори ход", Color.YELLOW, 0),

    EMPTY("", Color.WHITE, 0),

    FINISH("+50\nФиниш", Color.GREEN, 50);

    public final String text;
    public final Color color;
    public final int score;

    CellType(String t, Color c, int s) {
        text = t;
        color = c;
        score = s;
    }
}
