package button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends JComponent implements MouseListener {

    private final Color defaultColor = Color.GRAY;

    private int height;
    private int width;

    public Button() {
        enableInputMethods(true);
        addMouseListener(this);
    }

    public Button setupSize(int width, int height) {
        this.height = height;
        this.width = width;
        this.setSize(new Dimension(width, height));
        return this;
    }

    public Button setBackgroundColor(Color color) {
        this.setBackground(color);
        return this;
    }

    public Color getBackgroundColor() {
        return this.getBackground();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getBackgroundColor());
        g.fillRect(0, 0, width, height);
    }

    public void mouseClicked(MouseEvent e) {
        this.setBounds((int) (Math.random() * ((1000) + 1)), (int) (Math.random() * ((1000) + 1)), this.width, this.height);
    }

    public void mousePressed(MouseEvent e) {
        JComponent c = (JComponent) e.getComponent();
        c.setBackground(Color.YELLOW);
    }

    public void mouseReleased(MouseEvent e) {
        JComponent c = (JComponent) e.getComponent();
        c.setBackground(defaultColor);
    }

    public void mouseEntered(MouseEvent e) {
        JComponent c = (JComponent) e.getComponent();
        c.setBackground(Color.GRAY);
    }

    public void mouseExited(MouseEvent e) {
        JComponent c = (JComponent) e.getComponent();
        c.setBackground(Color.YELLOW);
    }
}
