package lineDrawing.freeLine;

import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;

import java.awt.event.MouseEvent;

public class FreeLineMsLst implements java.awt.event.MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

        LineDrawingAlgorythms.drawSectionSquare(e.getX(), e.getY());
        DrawingPanel.drawingPanel.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

        FreeLineMsMotLst.previousX = e.getX();
        FreeLineMsMotLst.previousY = e.getY();

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
