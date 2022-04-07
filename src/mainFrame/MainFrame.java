package mainFrame;

import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;
import paintFiller.PaintFiller;
import shapeDrawing.ShapeDrawingAlgorythms;
import shapeDrawing.circle.CircleMsLst;
import shapeDrawing.circle.CircleMsMotLst;
import shapeDrawing.rectangle.RectangleMsLst;
import shapeDrawing.rectangle.RectangleMsMotLst;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private DrawingPanel drawingPanel = DrawingPanel.drawingPanel;

    public MainFrame() {

        init();

    }

    private void init() {

        setSize(new Dimension(950,750));
        setLocation(150,150);

        add(DrawingPanel.drawingPanel, BorderLayout.CENTER);

        LineDrawingAlgorythms drawingAlgorythms = LineDrawingAlgorythms.drawingAlgorythms;
        ShapeDrawingAlgorythms shapeDrawingAlgorythms = ShapeDrawingAlgorythms.shapeDrawingAlgorythms;
        PaintFiller paintFiller = PaintFiller.paintFiller;

        add(new Toolbar(), BorderLayout.NORTH);

        setVisible(true);

    }

    public static MainFrame mainFrame = new MainFrame();

}
