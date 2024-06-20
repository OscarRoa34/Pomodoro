package co.edu.uptc.utils;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

public class RoundedPanel extends JPanel {
    private Color backgroundColor;
    private int arcWidth;
    private int arcHeight;

    public RoundedPanel(Color bgColor, int arcWidth, int arcHeight) {
        this.backgroundColor = bgColor;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(backgroundColor);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(295, 98);
    }
}
