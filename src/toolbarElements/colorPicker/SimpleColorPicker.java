package toolbarElements.colorPicker;

import drawingElements.DrawingPanel;
import mainFrame.MainFrame;
import subscriberUpdaterInterface.Publisher;
import subscriberUpdaterInterface.Subscriber;
import subscriberUpdaterInterface.SubscriptionType;
import toolbarElements.colorPicker.advancedColorPicker.AdvancedClrPckButton;
import toolbarElements.colorPicker.advancedColorPicker.AdvancedColorPicker;
import toolbarElements.lineTypePicker.FreeLineButton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

public class SimpleColorPicker extends JPanel implements Publisher {

    private JButton blueButton = new JButton();
    private JButton redButton = new JButton();
    private JButton yellowButton = new JButton();
    private JButton greenButton = new JButton();
    private JButton blackButton = new JButton();
    private JButton whiteButton = new JButton();

    private JPanel holderCurrColor = new JPanel();
    public JPanel currentColor = new JPanel();
    private static Color color = Color.black;
    private JButton advancedColorPickerButton;

    private GridLayout gridLayout;

    private JPanel mainColorContainer = new JPanel();

    public SimpleColorPicker() {

        setPreferredSize(new Dimension(120,50));
        setSize(new Dimension(120,50));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        mainColorContainer.setSize(new Dimension(70, 50));
        mainColorContainer.setPreferredSize(new Dimension(70, 50));
        gridLayout = new GridLayout(2,3, 3,3);
        mainColorContainer.setLayout(gridLayout);
        mainColorContainer.setBackground(Color.gray);

        init();

    }

    private void init(){

        initButtons();

        add(mainColorContainer);

        currentColor.setSize(new Dimension(20,20));
        currentColor.setPreferredSize(new Dimension(20,20));
        currentColor.setBackground(Color.BLACK);
        currentColor.setBorder(new LineBorder(Color.black));

        advancedColorPickerButton = new JButton(new AdvancedClrPckButton());
        advancedColorPickerButton.setSize(new Dimension(20,20));
        advancedColorPickerButton.setPreferredSize(new Dimension(20,20));

        holderCurrColor.setSize(new Dimension(40, 50));
        holderCurrColor.setPreferredSize(new Dimension(40, 50));

        holderCurrColor.setLayout(null);

        holderCurrColor.setBackground(Color.gray);
        holderCurrColor.add(currentColor); currentColor.setLocation(15, 3);
        holderCurrColor.add(advancedColorPickerButton); advancedColorPickerButton.setLocation(15, 26);

        add(holderCurrColor);

    }

    private void initButtons(){

        blueButton.setBackground(Color.blue);
        redButton.setBackground(Color.red);
        greenButton.setBackground(Color.yellow);
        yellowButton.setBackground(Color.green);
        blackButton.setBackground(Color.black);
        whiteButton.setBackground(Color.white);

        ArrayList<JButton> buttons = new ArrayList<>();
        Collections.addAll(buttons, redButton, blueButton, greenButton, yellowButton, whiteButton, blackButton);

        for (JButton button : buttons){

            button.setSize(new Dimension(20,20));
            button.setPreferredSize(new Dimension(20,20));
            button.addActionListener(new SelectColorAction());

            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    currentColor.setBackground(button.getBackground());
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

        }

        mainColorContainer.add(blueButton);
        mainColorContainer.add(redButton);
        mainColorContainer.add(greenButton);
        mainColorContainer.add(yellowButton);
        mainColorContainer.add(blackButton);
        mainColorContainer.add(whiteButton);
    }

    public void updateCurrentColor(Color newColor) {

        color = newColor;
        currentColor.setBackground(color);

    }

    @Override
    public void publish(Object object, SubscriptionType subscriptionType) {

        for (Subscriber subscriber : subscribers){
            subscriber.update(object, subscriptionType);
        }

    }

    public static SimpleColorPicker simpleColorPicker = new SimpleColorPicker();
}
