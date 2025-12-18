package lab4.graphics;

import java.awt.*;
import java.util.Arrays;

public class GraphApp {
    public static void main(String[] args) {
        Axis x = new Axis("X", -10, 10, 1);
        Axis y = new Axis("Y", -5, 5, 1);
        Grid grid = new Grid(true, 2);


        Graph graph = new Graph(x, y, grid);
     
        graph.addCurve(new Curve(
            "Прямая",
            "red",
            Arrays.asList(-8.0, -4.0, 0.0, 4.0, 8.0),
            Arrays.asList(-4.0, -2.0, 0.0, 2.0, 4.0)
        ));

        graph.addCurve(new Curve(
            "Парабола",
            "blue",
            Arrays.asList(-3.0, -2.0, -1.0, 0.0, 1.0, 2.0, 3.0),
            Arrays.asList(9.0, 4.0, 1.0, 0.0, 1.0, 4.0, 9.0)
        ));
        graph.printGraphInfo();

        
        Frame frame = new Frame("График функции");
        GraphCanvas canvas = new GraphCanvas(graph);
        frame.add(canvas);
        frame.setSize(800, 600);
        frame.setVisible(true);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                frame.dispose();
            }
        });
    }
}
