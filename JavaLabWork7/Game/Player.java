package Game;

import java.awt.Color;

public class Player {
    public final String name;
    public final Color color;
    public int position = 0;
    public int score = 0;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }
}
