package toolbarElements;

import drawingElements.DrawingPanel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.MouseListener;
import java.net.URL;

public abstract class AbstractButton extends AbstractAction {

    public Icon loadIcon(String fileName){

        URL imageURL = this.getClass().getResource(fileName);

        Icon icon = null;

        if (imageURL != null)
           icon = new ImageIcon(imageURL);

        return icon;
    }

    protected void removePreviousDrawingPanelListener(){

        DrawingPanel.drawingPanel.removeMouseListener(DrawingPanel.drawingPanel.getMouseListeners()[0]);
        DrawingPanel.drawingPanel.removeMouseMotionListener(DrawingPanel.drawingPanel.getMouseMotionListeners()[0]);

    }
}
