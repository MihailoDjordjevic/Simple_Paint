
package toolbarElements.lineTypePicker;

import cursorViewer.CursorFactory;
import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;
import lineDrawing.sprayLine.SprayLineMsLst;
import lineDrawing.sprayLine.SprayLineMsMotLst;
import toolbarElements.AbstractButton;

import java.awt.event.ActionEvent;


public class SprayLineButton extends AbstractButton {

    public SprayLineButton() {

        putValue(SMALL_ICON, loadIcon("imageIcons/sprayIcon.png"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        LineDrawingAlgorythms.sprayFlag = true;

        removePreviousDrawingPanelListener();

        DrawingPanel.drawingPanel.addMouseMotionListener(new SprayLineMsMotLst());
        DrawingPanel.drawingPanel.addMouseListener(new SprayLineMsLst());

        CursorFactory.cursorFactory.setIconCursor("src/toolbarElements/lineTypePicker/imageIcons/sprayiconTransparent.png");
    }
}
