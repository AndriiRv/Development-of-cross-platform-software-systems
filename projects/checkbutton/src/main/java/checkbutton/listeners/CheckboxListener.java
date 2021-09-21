package checkbutton.listeners;

import checkbutton.Checkbox;
import checkbutton.enums.CheckboxEnum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CheckboxListener implements ActionListener {

    private final Checkbox tristateCheckbox;
    private final List<Checkbox> group;

    public CheckboxListener(Checkbox tristateCheckbox, List<Checkbox> group) {
        this.tristateCheckbox = tristateCheckbox;
        this.group = group;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean allChecked = false;
        boolean partiallyCheck;

        Checkbox box = (Checkbox) e.getSource();
        box.changeState();
        for (Checkbox t : group) {
            if (t.getState() == CheckboxEnum.UNCHECKED) {
                allChecked = false;
                break;
            } else {
                allChecked = true;
            }
        }

        boolean noOneHaveStateChecked = true;
        for (Checkbox t : group) {
            if (t.getState() == CheckboxEnum.CHECKED) {
                noOneHaveStateChecked = false;
                break;
            }
        }
        partiallyCheck = !noOneHaveStateChecked;

        if (allChecked) {
            tristateCheckbox.setStateForce(CheckboxEnum.CHECKED);
        } else if (partiallyCheck) {
            tristateCheckbox.setStateForce(CheckboxEnum.HALF_CHECKED);
        } else {
            tristateCheckbox.setStateForce(CheckboxEnum.UNCHECKED);
        }
    }
}
