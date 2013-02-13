package Actions;

import Models.ButtonModel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Titouan Vervack
 */
public class ButtonAction extends AbstractAction {

    private final int button;
    private final ButtonModel model;

    public ButtonAction(int button, ButtonModel model) {
        this.button = button;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (button) {
            case 0:
                model.incrementHorizontalCounter(1);
                break;
            case 1:
                model.incrementHorizontalCounter(-1);
                break;
            case 2:
                model.incrementVerticalCounter(-1);
                break;
            case 3:
                model.incrementVerticalCounter(1);
                break;
        }
    }
}
