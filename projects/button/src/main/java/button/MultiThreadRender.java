package button;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class MultiThreadRender implements Runnable {

    private final JPanel jPanel;
    private final boolean isDifferentColor;

    public MultiThreadRender(JPanel jPanel, boolean isDifferentColor) {
        this.jPanel = jPanel;
        this.isDifferentColor = isDifferentColor;
    }

    @Override
    public void run() {
        try {
            multithreadingRender();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void multithreadingRender() throws InterruptedException {
        if (this.isDifferentColor) {
            for (long i = 0; i < Long.MAX_VALUE; i++) {
                render(setupColor(), new Dimension(50, 50));
            }
        } else {
            for (long i = 0; i < Long.MAX_VALUE; i++) {
                render(setupColor(), setupDimension());
            }
        }
    }

    private Color setupColor() {
        int r = (int) (Math.random() * ((255) + 1));
        int g = (int) (Math.random() * ((255) + 1));
        int b = (int) (Math.random() * ((255) + 1));
        return new Color(r, g, b);
    }

    private Dimension setupDimension() {
        int width = (int) (Math.random() * ((200) + 1));
        int height = (int) (Math.random() * ((200) + 1));
        return new Dimension(width, height);
    }

    private void render(Color color, Dimension dimension) throws InterruptedException {
        Thread.sleep(50);
        Button button = new Button()
                .setBackgroundColor(color)
                .setupSize((int) dimension.getWidth(), (int) dimension.getHeight());
        jPanel.add(button);

        jPanel.validate();
    }
}
