package paintFiller;

import drawingElements.DrawingPanel;
import paintFiller.PaintFiller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

public class paintFillMsLst implements MouseListener {

    Color startingColor;
    Color nextPixelColor;
    LinkedList<Point> frontPixels = new LinkedList<>();
    @Override
    public void mouseClicked(MouseEvent e) {

        startingColor = new Color(DrawingPanel.drawingPanel.getCanvas().getRGB(e.getX(), e.getY()));

        PaintFiller.paintFiller.fillWithPaint(e.getX(), e.getY(), startingColor);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
