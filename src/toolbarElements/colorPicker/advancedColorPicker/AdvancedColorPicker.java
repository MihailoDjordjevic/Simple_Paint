package toolbarElements.colorPicker.advancedColorPicker;

import drawingElements.DrawingPanel;
import mainFrame.MainFrame;
import subscriberUpdaterInterface.SubscriptionType;
import toolbarElements.colorPicker.SimpleColorPicker;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AdvancedColorPicker extends JDialog {

    JColorChooser colorChooser = new JColorChooser();

    JFileChooser jFileChooser= new JFileChooser();

    public AdvancedColorPicker() {

        setLocation(200, 200);
        setAlwaysOnTop(true);
        setPreferredSize(new Dimension(630, 420));
        setSize(new Dimension(630, 420));
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(630, 420));
        panel.setSize(new Dimension(630, 420));

        add(panel);

        panel.add(colorChooser);

        colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                Color color = colorChooser.getColor();
                SimpleColorPicker.simpleColorPicker.publish(color, SubscriptionType.COLOR);
                SimpleColorPicker.simpleColorPicker.updateCurrentColor(color);

            }
        });
    }

    public static AdvancedColorPicker advancedColorPicker = new AdvancedColorPicker();
}
