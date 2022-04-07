package toolbarElements.shapeTypePicker;

import cursorViewer.CursorFactory;
import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;
import lineDrawing.freeLine.FreeLineMsLst;
import lineDrawing.freeLine.FreeLineMsMotLst;
import shapeDrawing.circle.CircleMsLst;
import shapeDrawing.circle.CircleMsMotLst;
import toolbarElements.AbstractButton;

import java.awt.event.ActionEvent;

public class CircleButton extends AbstractButton {

    public CircleButton() {

        putValue(SMALL_ICON, loadIcon("imageIcons/circle.png"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        removePreviousDrawingPanelListener();

        DrawingPanel.drawingPanel.addMouseMotionListener(new CircleMsMotLst());
        DrawingPanel.drawingPanel.addMouseListener(new CircleMsLst());

        CursorFactory.cursorFactory.setIconCursor("standard");

    }
}
