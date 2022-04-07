package lineDrawing.sprayLine;

import drawingElements.DrawingPanel;
import lineDrawing.LineDrawingAlgorythms;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SprayLineMsLst implements MouseListener {

    private Thread t;
    private boolean stop = false;

    static int x;
    static int y;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        x = e.getX();
        y = e.getY();
        stop = false;

        class Spray implements Runnable{

            @Override
            public void run() {

                LineDrawingAlgorythms.sprayFlag = true;

                while (true) {

                    if (stop) break;

                    LineDrawingAlgorythms.drawSectionSquare(x, y);
                    DrawingPanel.drawingPanel.repaint();

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {

                    }

                }

            }
        }

        t = new Thread(new Spray());
        t.start();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        stop = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
