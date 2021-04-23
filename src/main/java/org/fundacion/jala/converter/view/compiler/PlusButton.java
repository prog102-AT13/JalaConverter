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

class PlusButton extends JButton {
    private final int LINE_WIDTH = 3;

    /**
     * Rewrites paintComponent to include "+" in button.
     *
     * @param graphics helps to draw the component.
     */
    public void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setPaint(Color.BLACK);
        Line2D line1 = new Line2D.Double(new Point2D.Double(getWidth() / 2, 0),
                new Point2D.Double(getWidth() / 2, getHeight()));
        Line2D line2 = new Line2D.Double(new Point2D.Double(0, getHeight() / 2),
                new Point2D.Double(getWidth(), getHeight() / 2));
        graphics2D.setStroke(new BasicStroke(LINE_WIDTH));
        graphics2D.draw(line1);
        graphics2D.draw(line2);
    }
}
