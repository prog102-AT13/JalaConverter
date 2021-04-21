/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Joel Rodrigo Rojas Roman
 */

package org.fundacion.jala.converter.view.compiler;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

class CloseButton extends JButton {

    /**
     * Rewrites paintComponent to include "X" in button
     * @param g
     */
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
