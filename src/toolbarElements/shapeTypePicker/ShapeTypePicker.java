package toolbarElements.shapeTypePicker;

import toolbarElements.paintFillButton.PaintFillButton;

import javax.swing.*;
import java.awt.*;

public class ShapeTypePicker extends JPanel {

    private JButton circleButton;
    private JButton rectangleButton;
    private JButton paintFillButton;

    public ShapeTypePicker() {

        setSize(new Dimension(120, 50));
        setPreferredSize(new Dimension(120, 50));
        setBackground(Color.gray);

        init();
    }

    private void init(){

        circleButton = new JButton(new CircleButton());
        circleButton.setPreferredSize(new Dimension(32, 32));
        circleButton.setSize(new Dimension(32, 32));

        add(circleButton);

        rectangleButton = new JButton(new RectangleButton());
        rectangleButton.setPreferredSize(new Dimension(32, 32));
        rectangleButton.setSize(new Dimension(32, 32));

        add(rectangleButton);

        paintFillButton = new JButton(new PaintFillButton());
        paintFillButton.setPreferredSize(new Dimension(32, 32));
        paintFillButton.setSize(new Dimension(32, 32));

        add(paintFillButton);

    }
}
