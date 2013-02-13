package Models;

import Modes.WorldMap;
import panels.EditorPanel;

/**
 *
 * @author Titouan Vervack
 */
public class ButtonModel extends TModel {

    private int verticalCounter = 0;
    private int horizontalCounter = 0;
    private int vMax;
    private int hMax;
    private int change;

    public ButtonModel(WorldMap map) {
        vMax = map.getSize().height / EditorPanel.VBLOCKS;
        hMax = map.getSize().width / EditorPanel.HBLOCKS;
    }

    public int getVerticalCounter() {
        return verticalCounter;
    }

    public void incrementVerticalCounter(int incr) {
        if (verticalCounter + incr >= 0 && verticalCounter + incr < vMax) {
            if (verticalCounter == 0) {
                change = 2;
                change();
            }

            if (verticalCounter == vMax - 1) {
                change = 3;
                change();
            }
            verticalCounter += incr;

            if (verticalCounter == 0) {
                change = 2;
                change();
                return;
            }

            if (verticalCounter == vMax - 1) {
                change = 3;
                change();
            }
        }
    }

    public int getHorizontalCounter() {
        return horizontalCounter;
    }

    public void incrementHorizontalCounter(int incr) {
        if (horizontalCounter + incr >= 0 && horizontalCounter + incr < hMax) {
            if (horizontalCounter == 0) {
                change = 1;
                change();
            }

            if (horizontalCounter == hMax - 1) {
                change = 0;
                change();
            }

            horizontalCounter += incr;

            if (horizontalCounter == 0) {
                change = 1;
                change();
                return;
            }

            if (horizontalCounter == hMax - 1) {
                change = 0;
                change();
            }
        }
    }

    public int getChange() {
        return change;
    }
}
