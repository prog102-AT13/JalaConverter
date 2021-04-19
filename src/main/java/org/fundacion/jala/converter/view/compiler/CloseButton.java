package org.fundacion.jala.converter.view.compiler;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

class CloseButton extends JButton {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.BLACK);
        Line2D line1 = new Line2D.Double(new Point2D.Double(0, 0),
                new Point2D.Double(getWidth(), getHeight()));
        Line2D line2 = new Line2D.Double(new Point2D.Double(0, getHeight()),
                new Point2D.Double(getWidth(), 0));
        g2.setStroke(new BasicStroke(3));
        g2.draw(line1);
        g2.draw(line2);
    }
}
