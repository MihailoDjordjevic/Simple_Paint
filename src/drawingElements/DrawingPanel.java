package drawingElements;

import cursorViewer.CursorFactory;
import lineDrawing.freeLine.FreeLineMsLst;
import lineDrawing.freeLine.FreeLineMsMotLst;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {

    private BufferedImage canvas;

    public DrawingPanel() {

        setPreferredSize( new Dimension(1100,1100));
        setBackground(Color.black);
        init();

    }

    private void init(){

        canvas = new BufferedImage(1300, 800, BufferedImage.TYPE_INT_ARGB);
        paintCanvasWhite();

        addMouseMotionListener(new FreeLineMsMotLst(0,0));
        addMouseListener(new FreeLineMsLst());

        setCursor(CursorFactory.getCursor());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }

    private void paintCanvasWhite(){

        for (int i = 0; i < canvas.getHeight(); i++)
            for(int j = 0; j < canvas.getWidth(); j++) {
                canvas.setRGB(j, i, Color.white.getRGB());
            }

    }

    public static DrawingPanel drawingPanel = new DrawingPanel();

    public BufferedImage getCanvas() {
        return canvas;
    }

    public void setCanvas(BufferedImage canvas) {
        this.canvas = canvas;
    }

}
