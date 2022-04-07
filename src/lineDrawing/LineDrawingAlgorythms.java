package lineDrawing;

import drawingElements.DrawingPanel;
import subscriberUpdaterInterface.Subscriber;
import subscriberUpdaterInterface.SubscriptionType;
import toolbarElements.colorPicker.SimpleColorPicker;
import toolbarElements.thicknessPicker.Slider;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class LineDrawingAlgorythms implements Subscriber {

    public static BufferedImage canvas = DrawingPanel.drawingPanel.getCanvas();
    private static Color color = Color.BLACK;
    public static int thickness = 1;
    public static boolean sprayFlag = false;

    public LineDrawingAlgorythms() {

        SimpleColorPicker.subscribers.add(this);
        Slider.subscribers.add(this);

    }

    public static void paintDiagonal(int x, int y, int previousX, int previousY){

        if (x > previousX && Math.abs(x - previousX) >= Math.abs(y - previousY)) {
            drawSection(previousX, x, previousY, y, false);
        } else if (x < previousX && Math.abs(x - previousX) >= Math.abs(y - previousY)) {
            drawSection(x, previousX, y, previousY, false);
        } else if (y > previousY && Math.abs(x - previousX) < Math.abs(y - previousY)) {
            drawSection(previousY, y, previousX, x, true);
        } else if (y < previousY && Math.abs(x - previousX) < Math.abs(y - previousY)) {
            drawSection(y, previousY, x, previousX, true);
        }

    }

    private static void drawSection(int x1, int x2, int y1, int y2, boolean swapXYflag){

        double coefficient = (double) (y2 - y1)/(x2 - x1);

        for (int i = 0; i <= x2 - x1; i++){

            double yCoordinate = y1 + coefficient * i;
            int yInteger = (int) Math.round(yCoordinate);

            if (swapXYflag) {
               drawSectionSquare(yInteger, x1 + i);
            } else
               drawSectionSquare(x1 + i, yInteger);

        }

    }

    public static void drawSectionSquare(int x, int y){

        if (!sprayFlag) {
            int evenOrOdd = thickness % 2 == 0 ? 1 : 0;

            if (thickness == 1) evenOrOdd = -1;

            try {
                for (int i = x - thickness/2 + evenOrOdd; i < x + thickness/2; i++)
                    for (int j = y - thickness/2 + evenOrOdd; j < y + thickness/2; j++){
                        canvas.setRGB(i, j, color.getRGB());
                    }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        } else {

            int sprayThickness = thickness < 5 ? 6 : thickness;

            Random random = new Random();

            for (int i = 0; i < sprayThickness/4; i++) {

                int randomX = random.nextInt(sprayThickness);
                int randomY = random.nextInt(sprayThickness);

                try {
                    canvas.setRGB(
                            x - sprayThickness / 2 + randomX,
                            y - sprayThickness / 2 + randomY,
                            color.getRGB()
                    );
                } catch (ArrayIndexOutOfBoundsException e) {

                }
            }

        }


    }

    @Override
    public void update(Object object, SubscriptionType subscriptionType) {

        if (subscriptionType.equals(SubscriptionType.COLOR)) {
            LineDrawingAlgorythms.color = (Color) object;
        } else if (subscriptionType.equals(SubscriptionType.THICKNESS)){
            LineDrawingAlgorythms.thickness = (int) object;
        }

    }

    public static LineDrawingAlgorythms drawingAlgorythms = new LineDrawingAlgorythms();
}
