package mainFrame;

import toolbarElements.colorPicker.SimpleColorPicker;
import toolbarElements.colorPicker.advancedColorPicker.AdvancedColorPicker;
import toolbarElements.thicknessPicker.Slider;
import toolbarElements.lineTypePicker.LineTypePicker;
import toolbarElements.shapeTypePicker.ShapeTypePicker;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JToolBar {

    public Toolbar() {

        init();

    }

    private void init() {

        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        setPreferredSize(new Dimension(300, 60));
        setSize(300, 50);
        setBackground(Color.PINK);
        add(new Slider());
        add(new SimpleColorPicker());
        add(new LineTypePicker());
        add(new ShapeTypePicker());

    }
}
