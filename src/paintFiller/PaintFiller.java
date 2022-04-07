package paintFiller;

import drawingElements.DrawingPanel;
import subscriberUpdaterInterface.Subscriber;
import subscriberUpdaterInterface.SubscriptionType;
import toolbarElements.colorPicker.SimpleColorPicker;

import java.awt.*;
import java.util.LinkedList;

public class PaintFiller implements Subscriber {

    private static Color paintPixelColor = Color.BLACK;
    private Color startingColor;
    private Color nextPixelColor;
    private LinkedList<Point> frontPixels = new LinkedList<>();

    public PaintFiller() {
        SimpleColorPicker.subscribers.add(this);
    }

    private void fillSurroundingPixelsWithPaint(int x, int y, LinkedList<Point> tmpFrontPixels){

        int width = DrawingPanel.drawingPanel.getCanvas().getWidth();
        int height = DrawingPanel.drawingPanel.getCanvas().getHeight();

        //left
        if (!(x - 1 < 0 || y < 0 || x - 1 > width - 1 ||y > height - 1)) {
            nextPixelColor = new Color(DrawingPanel.drawingPanel.getCanvas().getRGB(x - 1, y));

            if (nextPixelColor.equals(startingColor)) {
                DrawingPanel.drawingPanel.getCanvas().setRGB(x - 1, y, paintPixelColor.getRGB());
                tmpFrontPixels.add(new Point(x - 1, y));
            }
        }
        //right
        if (!(x + 1 < 0 || y < 0 || x + 1 > width - 1 || y > height - 1)) {
            nextPixelColor = new Color(DrawingPanel.drawingPanel.getCanvas().getRGB(x + 1, y));

            if (nextPixelColor.equals(startingColor)) {
                DrawingPanel.drawingPanel.getCanvas().setRGB(x + 1, y, paintPixelColor.getRGB());
                tmpFrontPixels.add(new Point(x + 1, y));
            }
        }
        //up
        if (!(x < 0 || y - 1 < 0 || x > width - 1 || y - 1 > height - 1)) {
            nextPixelColor = new Color(DrawingPanel.drawingPanel.getCanvas().getRGB(x, y - 1));

            if (nextPixelColor.equals(startingColor)) {
                DrawingPanel.drawingPanel.getCanvas().setRGB(x, y - 1, paintPixelColor.getRGB());
                tmpFrontPixels.add(new Point(x, y - 1));
            }
        }
        //down
        if (!(x < 0 || y + 1 < 0 || x > width - 1 || y + 1 > height - 1)) {
            nextPixelColor = new Color(DrawingPanel.drawingPanel.getCanvas().getRGB(x, y + 1));

            if (nextPixelColor.equals(startingColor)) {
                DrawingPanel.drawingPanel.getCanvas().setRGB(x, y + 1, paintPixelColor.getRGB());
                tmpFrontPixels.add(new Point(x, y + 1));
            }
        }

        DrawingPanel.drawingPanel.repaint();
    }

    public void fillWithPaint(int x, int y, Color startingColor){

        if (startingColor.equals(paintPixelColor))
            return;

        this.startingColor = startingColor;

        frontPixels.add(new Point(x, y));

        while (true){

            LinkedList<Point> tmpList = new LinkedList<>();

            for (Point p : frontPixels){

                fillSurroundingPixelsWithPaint(p.x, p.y, tmpList);

            }

            frontPixels.clear();

            frontPixels = tmpList;

            if (frontPixels.isEmpty())
                break;
        }

    }

    public static PaintFiller paintFiller = new PaintFiller();
    @Override
    public void update(Object object, SubscriptionType subscriptionType) {
        if (subscriptionType.equals(SubscriptionType.COLOR))

            paintPixelColor = (Color) object;

    }
}
