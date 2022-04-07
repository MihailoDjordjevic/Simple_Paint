package shapeDrawing.rectangle;

import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;
import lineDrawing.straightLine.StraightLineMsMotLst;
import shapeDrawing.ShapeDrawingAlgorythms;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RectangleMsLst implements MouseListener {

    static int x1;
    static int y1;
    static int x2;
    static int y2;
    static boolean checkClicked = false;
    static boolean checkPressed = false;

    @Override
    public void mouseClicked(MouseEvent e) {

        RectangleMsMotLst.isDragged = false;

        if (!checkClicked){

            x1 = e.getX();
            y1 = e.getY();
            checkClicked = true;

        } else{

            ShapeDrawingAlgorythms.drawRectangle(e.getX(), e.getY(), x1, y1);
            DrawingPanel.drawingPanel.repaint();
            checkClicked = false;

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

        RectangleMsMotLst.isDragged = false;

        checkPressed = true;

        if (!checkClicked) {
            x1 = e.getX();
            y1 = e.getY();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        RectangleMsMotLst.rectAreaOfLine = null;
        RectangleMsMotLst.raster = null;

        checkPressed = false;

        if (RectangleMsMotLst.isDragged) checkClicked = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
