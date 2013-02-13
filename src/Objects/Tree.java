package Objects;

import Engine.Game;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Titouan Vervack
 */
public class Tree extends Obstacles {

    private static final int HBLOCKS = 1;
    private static final int VBLOCKS = 1;

    public Tree() {
        super(HBLOCKS, VBLOCKS);
        icon = new ImageIcon(Tree.class.getResource("../images/Tree.png"));
        image = new ImageIcon(Tree.class.getResource("../images/Tree.png")).getImage();
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(image, x, y, Game.TILESIZE, Game.TILESIZE, null);
    }

    @Override
    public void editorDraw(Graphics2D g, int xDiv, int yDiv) {
        if (xDiv == 0) {
            xDiv = 1024;
        }
        if (yDiv == 0) {
            yDiv = 704;
        }
        g.drawImage(image, x % xDiv, y % yDiv, Game.TILESIZE, Game.TILESIZE, null);
    }

    @Override
    public void fillArray() {
        bounds[0][0] = true;
    }

    @Override
    public String identify() {
        return "Tree";
    }
}
