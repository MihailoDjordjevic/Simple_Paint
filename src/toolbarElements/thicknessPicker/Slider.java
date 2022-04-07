package toolbarElements.thicknessPicker;

import subscriberUpdaterInterface.Publisher;
import subscriberUpdaterInterface.Subscriber;
import subscriberUpdaterInterface.SubscriptionType;

import javax.swing.*;
import java.awt.*;

public class Slider extends JSlider implements Publisher {

    public Slider() {

        init();

    }

    private void init() {

        setPreferredSize(new Dimension(100, 50));
        setSize(100, 50);

        this.addChangeListener(new SelectThicknessAction());

        setMinimum(0);
        setMaximum(31);
        setMajorTickSpacing(5);
        setValue(1);
        setPaintTicks(true);
        setPaintLabels(true);

    }

    @Override
    public void publish(Object object, SubscriptionType subscriptionType) {

        for (Subscriber subscriber : subscribers){

            subscriber.update(object, subscriptionType);

        }

    }
}
