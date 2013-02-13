package Objects;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Icon;

/**
 *
 * @author Titouan Vervack
 */
public abstract class Blocks {

    //Array defining the area of the block
    protected boolean[][] bounds;
    //x position
    protected int x;
    //y position
    protected int y;
    protected Image image;
    protected Icon icon;

    //HBLOCKS, amount of horizontal blocks;
    //VBLOCKS, amount of vertical blocks
    public Blocks(int HBLOCKS, int VBLOCKS) {
        bounds = new boolean[HBLOCKS][VBLOCKS];
    }

    public abstract void draw(Graphics2D g);
    public abstract void editorDraw(Graphics2D g, int xDiv, int yDiv);
    
    public abstract void fillArray();

    public Image getImage() {
        return image;
    }

    public Icon getIcon() {
        return icon;
    }

    public boolean[][] getArray() {
        return bounds;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract String identify();
}
