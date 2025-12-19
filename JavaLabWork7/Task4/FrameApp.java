package Task4;

import javax.swing.*;
import java.awt.*;

public class FrameApp extends JFrame {

    public FrameApp() {
        setTitle("Function plot (Task 4)");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PlotPanel plotPanel = new PlotPanel();

        JTextField fromField = new JTextField("-3.14", 6);
        JTextField toField   = new JTextField("3.14", 6);

        JComboBox<String> funcBox = new JComboBox<>(new String[]{
                "sin(x)",
                "sin(x*x) + cos(x*x)",
                "2*sin(x) + cos(2*x)"
        });

        JButton colorBtn = new JButton("Color");
        JButton drawBtn  = new JButton("Draw");

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("From:"));
        controlPanel.add(fromField);
        controlPanel.add(new JLabel("To:"));
        controlPanel.add(toField);
        controlPanel.add(funcBox);
        controlPanel.add(colorBtn);
        controlPanel.add(drawBtn);

        colorBtn.addActionListener(e -> {
            Color c = JColorChooser.showDialog(
                    this, "Choose color", plotPanel.getColor());
            if (c != null) plotPanel.setColor(c);
        });

        drawBtn.addActionListener(e -> {
            try {
                double from = Double.parseDouble(fromField.getText());
                double to   = Double.parseDouble(toField.getText());
                plotPanel.setParams(from, to, funcBox.getSelectedIndex());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input");
            }
        });

        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.NORTH);
        add(plotPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new FrameApp().setVisible(true)
        );
    }
}
