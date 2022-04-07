package toolbarElements.lineTypePicker;

import cursorViewer.CursorFactory;
import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;
import lineDrawing.freeLine.FreeLineMsLst;
import lineDrawing.freeLine.FreeLineMsMotLst;
import toolbarElements.AbstractButton;

import java.awt.event.ActionEvent;

public class FreeLineButton extends AbstractButton {

    public FreeLineButton() {

        putValue(SMALL_ICON, loadIcon("imageIcons/freeLine.png"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        LineDrawingAlgorythms.sprayFlag = false;

        removePreviousDrawingPanelListener();

        DrawingPanel.drawingPanel.addMouseMotionListener(new FreeLineMsMotLst(0, 0));
        DrawingPanel.drawingPanel.addMouseListener(new FreeLineMsLst());

        CursorFactory.cursorFactory.setIconCursor(null);
    }
}
