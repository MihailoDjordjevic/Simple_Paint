package shapeDrawing.circle;

import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;
import shapeDrawing.ShapeDrawingAlgorythms;
import shapeDrawing.rectangle.RectangleMsLst;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class CircleMsMotLst implements MouseMotionListener {

    public static Raster raster;
    public static BufferedImage rectAreaOfLine;
    public static boolean isDragged = false;

    @Override
    public void mouseDragged(MouseEvent e) {

        mouseDraggedLineAnimation(e);

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        mouseMovedLineAnimation(e);

    }

    private void mouseDraggedLineAnimation(MouseEvent e){

        isDragged = true;

        try {
            if (CircleMsLst.checkClicked || CircleMsLst.checkPressed){

                if (rectAreaOfLine != null){
                    rectAreaOfLine.setData(raster);
                }

                rectAreaOfLine = DrawingPanel.drawingPanel.getCanvas().getSubimage(
                        Math.min(CircleMsLst.x1, e.getX())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.min(CircleMsLst.y1, e.getY())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.abs(e.getX() - CircleMsLst.x1) + LineDrawingAlgorythms.thickness + 1,
                        Math.abs(e.getY() - CircleMsLst.y1) + LineDrawingAlgorythms.thickness + 1
                );

                raster = rectAreaOfLine.getData();

                ShapeDrawingAlgorythms.drawCircle(CircleMsLst.x1,
                        CircleMsLst.y1,
                        e.getX(),
                        e.getY()
                );

                DrawingPanel.drawingPanel.repaint();

            }
        } catch (Exception ex) {

        }

    }

    private void mouseMovedLineAnimation(MouseEvent e){

        try {
            if (CircleMsLst.checkClicked){

                if (rectAreaOfLine != null){
                    rectAreaOfLine.setData(raster);
                }

                rectAreaOfLine = DrawingPanel.drawingPanel.getCanvas().getSubimage(
                        Math.min(CircleMsLst.x1, e.getX())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.min(CircleMsLst.y1, e.getY())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.abs(e.getX() - CircleMsLst.x1) + LineDrawingAlgorythms.thickness + 1,
                        Math.abs(e.getY() - CircleMsLst.y1) + LineDrawingAlgorythms.thickness + 1
                );

                raster = rectAreaOfLine.getData();

                ShapeDrawingAlgorythms.drawCircle(CircleMsLst.x1,
                        CircleMsLst.y1,
                        e.getX(),
                        e.getY()
                );

                DrawingPanel.drawingPanel.repaint();

            }
        } catch (Exception ex) {

        }

    }

}
