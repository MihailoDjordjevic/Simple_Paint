package toolbarElements.thicknessPicker;

import subscriberUpdaterInterface.SubscriptionType;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SelectThicknessAction implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent e) {
        Slider slider = (Slider) e.getSource();

        int thickness = slider.getValue();
        slider.publish(thickness + 1, SubscriptionType.THICKNESS);
    }
}
