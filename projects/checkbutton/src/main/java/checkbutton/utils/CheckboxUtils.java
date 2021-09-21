package checkbutton.utils;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class CheckboxUtils {

    public static final Icon CHECKED_ICON = getChecked();
    public static final Icon HALF_CHECKED_ICON = getHalfChecked();
    public static final Icon UNCHECKED_ICON = getUnChecked();

    private CheckboxUtils() {
    }

    private static Icon getChecked() {
        return new ImageIcon(ClassLoader.getSystemResource("images/checked.png"));
    }

    private static Icon getHalfChecked() {
        return new ImageIcon(ClassLoader.getSystemResource("images/halfchecked.png"));
    }

    private static Icon getUnChecked() {
        return new ImageIcon(ClassLoader.getSystemResource("images/unchecked.png"));
    }
}
