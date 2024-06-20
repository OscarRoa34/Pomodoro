package co.edu.uptc.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;

public class RoundBorder extends AbstractBorder {
    private Color color;
    private int arcWidth;
    private int arcHeight;
    private int thickness;

    public RoundBorder(Color color, int arcWidth, int arcHeight, int thickness) {
        this.color = color;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.thickness = thickness;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(color);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(thickness));
        g2.draw(new RoundRectangle2D.Double(x + thickness / 2.0, y + thickness / 2.0,
                width - thickness, height - thickness, arcWidth, arcHeight));
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.right = insets.top = insets.bottom = thickness;
        return insets;
    }
}
