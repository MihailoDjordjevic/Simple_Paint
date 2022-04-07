package toolbarElements.colorPicker.advancedColorPicker;

import toolbarElements.AbstractButton;
import toolbarElements.colorPicker.advancedColorPicker.AdvancedColorPicker;

import java.awt.event.ActionEvent;

public class AdvancedClrPckButton extends AbstractButton {

    public AdvancedClrPckButton() {

        putValue(SMALL_ICON, loadIcon("plusIcon.jpg"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AdvancedColorPicker.advancedColorPicker.setVisible(true);
    }
}
