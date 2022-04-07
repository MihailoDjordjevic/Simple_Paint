package shapeDrawing;

import drawingElements.DrawingPanel;
import subscriberUpdaterInterface.Subscriber;
import subscriberUpdaterInterface.SubscriptionType;
import toolbarElements.colorPicker.SimpleColorPicker;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ShapeDrawingAlgorythms implements Subscriber {

    public static BufferedImage canvas = DrawingPanel.drawingPanel.getCanvas();
    private static Color color = Color.BLACK;
    public static int thickness = 1;

    public ShapeDrawingAlgorythms() {

        SimpleColorPicker.subscribers.add(this);

    }

    public static void drawRectangle(int X1, int Y1, int X2, int Y2){

        int x1 = Math.min(X1, X2);
        int x2 = Math.max(X1, X2);
        int y1 = Math.min(Y1, Y2);
        int y2 = Math.max(Y1, Y2);

        for (int i = 0; i <= x2 - x1; i++){
                canvas.setRGB(x1 + i, y1, color.getRGB());
                canvas.setRGB(x1 + i, y2, color.getRGB());
        }

        for (int i = 0; i <= y2 - y1; i++){
            canvas.setRGB(x1, y1 + i, color.getRGB());
            canvas.setRGB(x2, y1 + i, color.getRGB());
        }

    }

    public static void drawCircle(int X1, int Y1, int X2, int Y2){  //its important that X1 and Y1 be the coordinates
                                                                    //of the first clicked pixel when passed to this function
        int x1 = Math.min(X1, X2);
        int x2 = Math.max(X1, X2);
        int y1 = Math.min(Y1, Y2);
        int y2 = Math.max(Y1, Y2);

        int diameter = Math.min(x2 - x1, y2 - y1);
        int radius = diameter/2;

        int centerX = (x1 == X1) ? (x1 + radius) : (x2 - radius);
        int centerY = (y1 == Y1) ? (y1 + radius) : (y2 - radius);

        for (int i = 0; i <= radius * 0.74; i++){

            int dy = (int) Math.round(Math.sqrt(Math.pow(radius, 2) - Math.pow(i, 2)));

            canvas.setRGB(centerX + i, centerY - dy, color.getRGB());
            canvas.setRGB(centerX + i, centerY + dy, color.getRGB());
            canvas.setRGB(centerX - i, centerY - dy, color.getRGB());
            canvas.setRGB(centerX - i, centerY + dy, color.getRGB());

            canvas.setRGB(centerX - dy, centerY + i, color.getRGB());
            canvas.setRGB(centerX - dy, centerY - i, color.getRGB());
            canvas.setRGB(centerX + dy, centerY + i, color.getRGB());
            canvas.setRGB(centerX + dy, centerY - i, color.getRGB());

        }

    }

    public static ShapeDrawingAlgorythms shapeDrawingAlgorythms = new ShapeDrawingAlgorythms();

    @Override
    public void update(Object object, SubscriptionType subscriptionType) {

        if (subscriptionType.equals(SubscriptionType.COLOR)){

            color = (Color) object;

        }

    }
}
