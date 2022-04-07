package shapeDrawing.circle;

import drawingElements.DrawingPanel;
import shapeDrawing.ShapeDrawingAlgorythms;
import shapeDrawing.rectangle.RectangleMsMotLst;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CircleMsLst implements MouseListener {

    static int x1;
    static int y1;
    static int x2;
    static int y2;
    static boolean checkClicked = false;
    static boolean checkPressed = false;

    @Override
    public void mouseClicked(MouseEvent e) {

        CircleMsMotLst.isDragged = false;

        if (!checkClicked){

            x1 = e.getX();
            y1 = e.getY();
            checkClicked = true;

        } else{

            ShapeDrawingAlgorythms.drawCircle(x1, y1, e.getX(), e.getY());
            DrawingPanel.drawingPanel.repaint();
            checkClicked = false;

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

        CircleMsMotLst.isDragged = false;

        checkPressed = true;

        if (!checkClicked) {
            x1 = e.getX();
            y1 = e.getY();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        CircleMsMotLst.rectAreaOfLine = null;
        CircleMsMotLst.raster = null;

        checkPressed = false;

        if (CircleMsMotLst.isDragged) checkClicked = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
