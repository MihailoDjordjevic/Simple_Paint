package lineDrawing.straightLine;

import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StraightLineMsLst implements MouseListener {

    static int x1;
    static int y1;
    static int x2;
    static int y2;
    static boolean checkClicked = false;
    static boolean checkPressed = false;
    @Override
    public void mouseClicked(MouseEvent e) {

        StraightLineMsMotLst.isDragged = false;

        if (!checkClicked){

            x1 = e.getX();
            y1 = e.getY();
            checkClicked = true;

        } else{

            LineDrawingAlgorythms.paintDiagonal(e.getX(), e.getY(), x1, y1);
            DrawingPanel.drawingPanel.repaint();
            checkClicked = false;

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

        StraightLineMsMotLst.isDragged = false;

        checkPressed = true;

        if (!checkClicked) {
            x1 = e.getX();
            y1 = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        StraightLineMsMotLst.rectAreaOfLine = null;
        StraightLineMsMotLst.raster = null;

        checkPressed = false;

        if (StraightLineMsMotLst.isDragged) checkClicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
