package JavaBeans_Task5to6;

import javax.swing.*;
import java.awt.*;

public class TripleLabelPanel extends JPanel {

    private final JLabel label1 = new JLabel("Label 1");
    private final JLabel label2 = new JLabel("Label 2");
    private final JLabel label3 = new JLabel("Label 3");

    public TripleLabelPanel() {
        setLayout(new GridLayout(3, 1, 5, 5));
        add(label1);
        add(label2);
        add(label3);
    }

    public String getLabel1Text() {
        return label1.getText();
    }

    public void setLabel1Text(String text) {
        label1.setText(text);
    }

    public String getLabel2Text() {
        return label2.getText();
    }

    public void setLabel2Text(String text) {
        label2.setText(text);
    }

    public String getLabel3Text() {
        return label3.getText();
    }

    public void setLabel3Text(String text) {
        label3.setText(text);
    }
}
