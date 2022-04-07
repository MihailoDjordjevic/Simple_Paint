package lineDrawing.straightLine;

import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class StraightLineMsMotLst implements MouseMotionListener {

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
            if (StraightLineMsLst.checkClicked || StraightLineMsLst.checkPressed){

                if (rectAreaOfLine != null){
                    rectAreaOfLine.setData(raster);
                }

                rectAreaOfLine = DrawingPanel.drawingPanel.getCanvas().getSubimage(
                        Math.min(StraightLineMsLst.x1, e.getX())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.min(StraightLineMsLst.y1, e.getY())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.abs(e.getX() - StraightLineMsLst.x1) + LineDrawingAlgorythms.thickness + 1,
                        Math.abs(e.getY() - StraightLineMsLst.y1) + LineDrawingAlgorythms.thickness + 1
                );

                raster = rectAreaOfLine.getData();

                LineDrawingAlgorythms.paintDiagonal(StraightLineMsLst.x1,
                        StraightLineMsLst.y1,
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
            if (StraightLineMsLst.checkClicked){

                if (rectAreaOfLine != null){
                    rectAreaOfLine.setData(raster);
                }

                rectAreaOfLine = DrawingPanel.drawingPanel.getCanvas().getSubimage(
                        Math.min(StraightLineMsLst.x1, e.getX())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.min(StraightLineMsLst.y1, e.getY())  - LineDrawingAlgorythms.thickness/2 - 1,
                        Math.abs(e.getX() - StraightLineMsLst.x1) + LineDrawingAlgorythms.thickness + 1,
                        Math.abs(e.getY() - StraightLineMsLst.y1) + LineDrawingAlgorythms.thickness + 1
                );

                raster = rectAreaOfLine.getData();

                LineDrawingAlgorythms.paintDiagonal(StraightLineMsLst.x1,
                        StraightLineMsLst.y1,
                        e.getX(),
                        e.getY()
                );

                DrawingPanel.drawingPanel.repaint();

            }
        } catch (Exception ex) {

        }

    }
}
