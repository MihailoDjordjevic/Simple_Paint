package toolbarElements.paintFillButton;

import cursorViewer.CursorFactory;
import drawingElements.DrawingPanel;
import paintFiller.paintFillMsLst;
import shapeDrawing.circle.CircleMsMotLst;
import toolbarElements.AbstractButton;

import java.awt.event.ActionEvent;

public class PaintFillButton extends AbstractButton {

    public PaintFillButton() {

        putValue(SMALL_ICON, loadIcon("paintFillIcon.jpg"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        removePreviousDrawingPanelListener();

        DrawingPanel.drawingPanel.addMouseMotionListener(new CircleMsMotLst());
        DrawingPanel.drawingPanel.addMouseListener(new paintFillMsLst());

        CursorFactory.cursorFactory.setIconCursor("src/toolbarElements/paintFillButton/paintFillIcon.jpg");
    }
}
