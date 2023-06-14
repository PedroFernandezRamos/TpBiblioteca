import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

class RoundedButton extends JButton {

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, 20, 20));

        super.paintComponent(g);
    }
}

