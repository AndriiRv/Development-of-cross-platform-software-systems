package checkbutton;

import checkbutton.listeners.CheckboxListener;
import checkbutton.listeners.MainCheckboxListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Example of checkbutton");

        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(25, 1));

        Checkbox commonCheckbox = new Checkbox("All");

        List<Checkbox> group = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            group.add(new Checkbox("Option " + i));
        }

        jPanel.add(commonCheckbox);
        group.forEach(jPanel::add);

        commonCheckbox.addActionListener(new MainCheckboxListener(group));
        for (Checkbox c : group) {
            c.addActionListener(new CheckboxListener(commonCheckbox, group));
        }

        frame.getContentPane().add(jPanel);

        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
