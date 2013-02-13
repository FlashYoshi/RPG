package Actions;

import Modes.WorldMap;
import XML.XMLReader;
import XML.XMLWriter;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

/**
 *
 * @author Titouan Vervack
 */
public class OpenAction extends AbstractAction {

    private WorldMap map;
    
    public OpenAction(WorldMap map) {
        this.map = map;
        putValue(NAME, "Open");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser(new java.io.File("./src/levels"));
        fc.setDialogTitle("Open level");
        int knop = fc.showOpenDialog(null);
        if (knop == JFileChooser.APPROVE_OPTION) {
            XMLReader reader = new XMLReader(fc.getSelectedFile(), map);
        }
    }
}
