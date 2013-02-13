package Objects;

import Engine.Game;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author Titouan Vervack
 */
public class Sea extends Backgrounds {

    private static final int HBLOCKS = 1;
    private static final int VBLOCKS = 1;

    public Sea() {
        super(HBLOCKS, VBLOCKS);
        icon = new ImageIcon(Grass.class.getResource("../images/Grass1.png"));
        image = new ImageIcon(Grass.class.getResource("../images/Grass1.png")).getImage();
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
        return "Sea";
    }
}
