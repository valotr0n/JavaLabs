package Task7;

import JavaBeans_Task5to6.TripleLabelPanel;
import JavaBeans_Task5to6.DiceView;

import javax.swing.*;
import java.awt.*;

public class BeansTestFrame extends JFrame {

    public BeansTestFrame() {
        setTitle("Beans test (Task 7)");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        TripleLabelPanel labels = new TripleLabelPanel();
        labels.setLabel1Text("Player");
        labels.setLabel2Text("Score");
        labels.setLabel3Text("Status");

        DiceView dice = new DiceView();

        JButton rollBtn = new JButton("Roll dice");
        rollBtn.addActionListener(e -> dice.roll());

        JPanel center = new JPanel(new FlowLayout());
        center.add(dice);

        JPanel bottom = new JPanel();
        bottom.add(rollBtn);

        setLayout(new BorderLayout());
        add(labels, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new BeansTestFrame().setVisible(true)
        );
    }
}
