package cursorViewer;

import drawingElements.DrawingPanel;
import subscriberUpdaterInterface.Subscriber;
import subscriberUpdaterInterface.SubscriptionType;
import toolbarElements.colorPicker.SimpleColorPicker;
import toolbarElements.thicknessPicker.Slider;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CursorFactory implements Subscriber {

    private static Point point = new Point();
    private int size = 1;
    private Color color = Color.black;
    private static Image image;
    private boolean isUpdateable = true;
    private String iconFileName = null;

    public CursorFactory() {

        SimpleColorPicker.subscribers.add(this);
        Slider.subscribers.add(this);

    }

    private Image setImagePixelByPixel() {

        BufferedImage tmpImage = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);

        if (size < 5){
            for (int i = 0; i < 32; i++){

                if (i < 10 || i >21){
                    tmpImage.setRGB(16, i, Color.black.getRGB());
                    tmpImage.setRGB(15, i, Color.black.getRGB());
                }

            }

            for (int i = 0; i < 32; i++){

                if (i < 10 || i >21) {
                    tmpImage.setRGB(i, 16, Color.black.getRGB());
                    tmpImage.setRGB(i, 15, Color.black.getRGB());
                }
            }
        }

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                tmpImage.setRGB(i + (32 - size)/2, j + (32 - size)/2, color.getRGB());


        return tmpImage;

    }

    private Image getImage(){

        if (iconFileName != null) {
            point.x = 0;
            point.y = 0;
            return new ImageIcon(iconFileName).getImage();
        }
        else {
            point.x = 16;
            point.y = 16;
            return setImagePixelByPixel();
        }

    }

    public void setIconCursor(String s){

        iconFileName = s;
        image = getImage();

        isUpdateable = iconFileName == null;

        DrawingPanel.drawingPanel.setCursor(getCursor());

    }

    @Override
    public void update(Object object, SubscriptionType subscriptionType) {

        if (subscriptionType.equals(SubscriptionType.COLOR)) {

            this.color = (Color) object;

        } else if (subscriptionType.equals(SubscriptionType.THICKNESS)){

            this.size = (int) object;

        }

        if(isUpdateable)
            DrawingPanel.drawingPanel.setCursor(getCursor());
    }

    public static Cursor getCursor(){

        if (cursorFactory.iconFileName != null && cursorFactory.iconFileName.equals("standard"))
            return null;

        return Toolkit.getDefaultToolkit().createCustomCursor(cursorFactory.getImage(), point, "cursor");

    }

    public static CursorFactory cursorFactory = new CursorFactory();
}
