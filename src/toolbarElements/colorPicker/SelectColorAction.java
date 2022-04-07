package toolbarElements.colorPicker;

import subscriberUpdaterInterface.SubscriptionType;
import toolbarElements.colorPicker.SimpleColorPicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectColorAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();
        Color color = button.getBackground();

        SimpleColorPicker.simpleColorPicker.publish(color, SubscriptionType.COLOR);

    }
}
