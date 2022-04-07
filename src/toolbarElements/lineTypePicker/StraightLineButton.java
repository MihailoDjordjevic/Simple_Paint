package toolbarElements.lineTypePicker;

import cursorViewer.CursorFactory;
import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;
import lineDrawing.straightLine.StraightLineMsLst;
import lineDrawing.straightLine.StraightLineMsMotLst;
import toolbarElements.AbstractButton;

import java.awt.event.ActionEvent;

public class StraightLineButton extends AbstractButton {

    public StraightLineButton() {

        putValue(SMALL_ICON, loadIcon("imageIcons/straightline.png"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        LineDrawingAlgorythms.sprayFlag = false;

        removePreviousDrawingPanelListener();

        DrawingPanel.drawingPanel.addMouseMotionListener(new StraightLineMsMotLst());
        DrawingPanel.drawingPanel.addMouseListener(new StraightLineMsLst());

        CursorFactory.cursorFactory.setIconCursor(null);
    }
}
