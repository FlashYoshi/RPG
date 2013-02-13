package Actions;

import Misc.LevelEditor;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Titouan Vervack
 */
public class OSAction extends AbstractAction {

    public OSAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getID()) {
            case (0):
                //Start game
                break;
            case (1):
                LevelEditor edit = new LevelEditor();
                break;
            case (2):
                System.exit(0);
                break;
        }
    }
}
