package toolbarElements.shapeTypePicker;

import cursorViewer.CursorFactory;
import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;
import lineDrawing.freeLine.FreeLineMsLst;
import lineDrawing.freeLine.FreeLineMsMotLst;
import shapeDrawing.rectangle.RectangleMsLst;
import shapeDrawing.rectangle.RectangleMsMotLst;
import toolbarElements.AbstractButton;

import java.awt.event.ActionEvent;

public class RectangleButton extends AbstractButton {

    public RectangleButton() {

        putValue(SMALL_ICON, loadIcon("imageIcons/rectangle.png"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        removePreviousDrawingPanelListener();

        DrawingPanel.drawingPanel.addMouseMotionListener(new RectangleMsMotLst());
        DrawingPanel.drawingPanel.addMouseListener(new RectangleMsLst());

        CursorFactory.cursorFactory.setIconCursor("standard");

    }
}
