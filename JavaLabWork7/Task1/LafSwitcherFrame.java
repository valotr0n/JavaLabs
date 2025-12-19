package Task1;

import javax.swing.*;
import java.awt.*;

public class LafSwitcherFrame extends JFrame {

    private final JComboBox<UIManager.LookAndFeelInfo> lafCombo;
    private final JLabel infoLabel;
    private final JButton actionButton;
    private final JCheckBox checkBox;
    private final JRadioButton radioButton;
    private final JTable table;

    public LafSwitcherFrame() {
        setTitle("LAF + Components (Task 1)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 420);
        setLocationRelativeTo(null);

        UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();
        lafCombo = new JComboBox<>(lafs);
        lafCombo.setRenderer((list, value, index, isSelected, cellHasFocus) -> {
            JLabel lbl = new JLabel(value == null ? "" : value.getName());
            if (isSelected) {
                lbl.setOpaque(true);
                lbl.setBackground(list.getSelectionBackground());
                lbl.setForeground(list.getSelectionForeground());
            }
            return lbl;
        });

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Look & Feel:"));
        top.add(lafCombo);

        infoLabel = new JLabel("Выбери LAF в списке сверху");
        actionButton = new JButton("Нажми меня");
        checkBox = new JCheckBox("Флажок");
        radioButton = new JRadioButton("Радио-кнопка");

        ButtonGroup group = new ButtonGroup();
        group.add(radioButton);

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        left.add(infoLabel);
        left.add(Box.createVerticalStrut(10));
        left.add(actionButton);
        left.add(Box.createVerticalStrut(10));
        left.add(checkBox);
        left.add(Box.createVerticalStrut(10));
        left.add(radioButton);
        left.add(Box.createVerticalGlue());

        table = new JTable(LanguagesTableData.rows(), LanguagesTableData.columns());
        table.setFillsViewportHeight(true);
        JScrollPane tableScroll = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(left, BorderLayout.WEST);
        add(tableScroll, BorderLayout.CENTER);

        actionButton.addActionListener(e -> infoLabel.setText("Кнопка нажата!"));

        lafCombo.addActionListener(e -> {
            UIManager.LookAndFeelInfo selected = (UIManager.LookAndFeelInfo) lafCombo.getSelectedItem();
            if (selected == null) return;

            try {
                UIManager.setLookAndFeel(selected.getClassName());
                SwingUtilities.updateComponentTreeUI(this);
                this.invalidate();
                this.validate();
                this.repaint();
            } catch (Exception ex) {
                infoLabel.setText("Не удалось применить LAF: " + selected.getName());
            }
        });
    }
}
