package lineDrawing.sprayLine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class SprayLineMsMotLst implements MouseMotionListener {

    SprayLineMsLst sprayLineMsLst = new SprayLineMsLst();

    @Override
    public void mouseDragged(MouseEvent e) {

        SprayLineMsLst.x = e.getX();
        SprayLineMsLst.y = e.getY();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
