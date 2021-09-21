package button;

import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Generating buttons");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        frame.setPreferredSize(new Dimension((int) width, (int) height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.black);
        jPanel.setLayout(new GridLayout(50, 5));

        frame.getContentPane().add(jPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            Thread thread = new Thread(new MultiThreadRender(jPanel, true));
            thread.start();
            System.out.println(thread.getName() + " started to work");
        }
    }
}
