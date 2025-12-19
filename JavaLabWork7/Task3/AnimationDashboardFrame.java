package Task3;

import javax.swing.*;
import java.awt.*;

public class AnimationDashboardFrame extends JFrame {

    public AnimationDashboardFrame() {
        setTitle("Animation control (Task 3)");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        AnimationPanel animationPanel = new AnimationPanel();
        TickerPanel tickerPanel = new TickerPanel(animationPanel);

        JButton startBtn = new JButton("Start");
        JButton stopBtn  = new JButton("Stop");

        startBtn.addActionListener(e -> animationPanel.start());
        stopBtn.addActionListener(e -> animationPanel.stop());

        JPanel controls = new JPanel();
        controls.add(startBtn);
        controls.add(stopBtn);

        setLayout(new BorderLayout());
        add(controls, BorderLayout.NORTH);
        add(animationPanel, BorderLayout.CENTER);
        add(tickerPanel, BorderLayout.SOUTH);
    }
}
