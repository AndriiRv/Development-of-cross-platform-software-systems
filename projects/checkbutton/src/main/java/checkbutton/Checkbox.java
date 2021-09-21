package checkbutton;

import checkbutton.enums.CheckboxEnum;
import checkbutton.utils.CheckboxUtils;

import javax.swing.JCheckBox;

public class Checkbox extends JCheckBox {

    private CheckboxEnum checkboxEnum;

    public CheckboxEnum getState() {
        return checkboxEnum;
    }

    public Checkbox(String text) {
        super(text);
        this.setIcon(CheckboxUtils.UNCHECKED_ICON);
    }

    public void changeState() {
        if (checkboxEnum == CheckboxEnum.UNCHECKED) {
            checkboxEnum = CheckboxEnum.CHECKED;
            this.setIcon(CheckboxUtils.CHECKED_ICON);
        } else {
            checkboxEnum = CheckboxEnum.UNCHECKED;
            this.setIcon(CheckboxUtils.UNCHECKED_ICON);
        }
    }

    public void setStateForce(CheckboxEnum checkboxEnum) {
        this.checkboxEnum = checkboxEnum;
        if (checkboxEnum == CheckboxEnum.HALF_CHECKED) {
            this.setIcon(CheckboxUtils.HALF_CHECKED_ICON);
        } else if (checkboxEnum == CheckboxEnum.UNCHECKED) {
            this.setIcon(CheckboxUtils.UNCHECKED_ICON);
        } else {
            this.setIcon(CheckboxUtils.CHECKED_ICON);
        }
    }
}
