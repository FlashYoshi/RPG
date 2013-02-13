package Actions;

import Modes.WorldMap;
import XML.XMLWriter;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

/**
 *
 * @author Titouan Vervack
 */
public class SaveAction extends AbstractAction {

    private WorldMap map;
    
    public SaveAction(WorldMap map) {
        putValue(NAME, "Save");
        this.map = map;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser(new java.io.File("./src/levels"));
        fc.setDialogTitle("Save level");
        int knop = fc.showOpenDialog(null);
        if (knop == JFileChooser.APPROVE_OPTION) {
            XMLWriter writer = new XMLWriter(fc.getSelectedFile(), map);
        }
    }
}
