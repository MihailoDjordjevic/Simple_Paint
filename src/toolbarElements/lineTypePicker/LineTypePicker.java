package toolbarElements.lineTypePicker;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LineTypePicker extends JPanel {

    JButton freeLineButton;
    JButton straightLineButton;
    JButton sprayLineButton;

    public LineTypePicker( ) {

        init();
    }

    private void init(){

        setPreferredSize(new Dimension(150, 50));
        setSize(new Dimension(150, 50));
        setBackground(Color.gray);

        freeLineButton = new JButton(new FreeLineButton());
        freeLineButton.setPreferredSize(new Dimension(32, 32));
        freeLineButton.setSize(new Dimension(32, 32));

        add(freeLineButton);

        straightLineButton = new JButton(new StraightLineButton());
        straightLineButton.setPreferredSize(new Dimension(32, 32));
        straightLineButton.setSize(new Dimension(32, 32));

        add(straightLineButton);

        sprayLineButton = new JButton(new SprayLineButton());
        sprayLineButton.setPreferredSize(new Dimension(32, 32));
        sprayLineButton.setSize(new Dimension(32, 32));

        add(sprayLineButton);

    }

}
