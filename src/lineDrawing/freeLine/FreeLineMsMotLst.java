package lineDrawing.freeLine;

import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class FreeLineMsMotLst implements MouseMotionListener {

    static int previousX;
    static int previousY;
    private int x;
    private int y;
    private DrawingPanel drawingPanel = DrawingPanel.drawingPanel;

    public FreeLineMsMotLst(int previousX, int previousY) {
        this.previousX = previousX;
        this.previousY = previousY;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        x = e.getX();
        y = e.getY();

        LineDrawingAlgorythms.paintDiagonal(x, y, previousX, previousY);
        DrawingPanel.drawingPanel.repaint();

        previousX = x;
        previousY = y;

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
