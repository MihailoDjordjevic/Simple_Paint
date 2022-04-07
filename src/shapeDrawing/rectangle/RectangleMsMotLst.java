package shapeDrawing.rectangle;

import drawingElements.DrawingPanel;
import javafx.scene.shape.Shape;
import lineDrawing.LineDrawingAlgorythms;
import lineDrawing.straightLine.StraightLineMsLst;
import shapeDrawing.ShapeDrawingAlgorythms;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class RectangleMsMotLst implements MouseMotionListener {

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
            if (RectangleMsLst.checkClicked || RectangleMsLst.checkPressed){

                if (rectAreaOfLine != null){
                    rectAreaOfLine.setData(raster);
                }

                rectAreaOfLine = DrawingPanel.drawingPanel.getCanvas().getSubimage(
                        Math.min(RectangleMsLst.x1, e.getX())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.min(RectangleMsLst.y1, e.getY())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.abs(e.getX() - RectangleMsLst.x1) + LineDrawingAlgorythms.thickness + 1,
                        Math.abs(e.getY() - RectangleMsLst.y1) + LineDrawingAlgorythms.thickness + 1
                );

                raster = rectAreaOfLine.getData();

                ShapeDrawingAlgorythms.drawRectangle(RectangleMsLst.x1,
                        RectangleMsLst.y1,
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
            if (RectangleMsLst.checkClicked){

                if (rectAreaOfLine != null){
                    rectAreaOfLine.setData(raster);
                }

                rectAreaOfLine = DrawingPanel.drawingPanel.getCanvas().getSubimage(
                        Math.min(RectangleMsLst.x1, e.getX())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.min(RectangleMsLst.y1, e.getY())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.abs(e.getX() - RectangleMsLst.x1) + LineDrawingAlgorythms.thickness + 1,
                        Math.abs(e.getY() - RectangleMsLst.y1) + LineDrawingAlgorythms.thickness + 1
                );

                raster = rectAreaOfLine.getData();

                ShapeDrawingAlgorythms.drawRectangle(RectangleMsLst.x1,
                        RectangleMsLst.y1,
                        e.getX(),
                        e.getY()
                );

                DrawingPanel.drawingPanel.repaint();

            }
        } catch (Exception ex) {

        }

    }
}
