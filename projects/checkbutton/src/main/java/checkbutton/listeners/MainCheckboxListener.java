package checkbutton.listeners;

import checkbutton.Checkbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainCheckboxListener implements ActionListener {

    private final List<Checkbox> checkboxes;

    public MainCheckboxListener(List<Checkbox> checkboxes) {
        this.checkboxes = checkboxes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Checkbox checkbox = (Checkbox) e.getSource();
        checkbox.changeState();
        for (Checkbox t : checkboxes) {
            t.setStateForce(checkbox.getState());
        }
    }
}
