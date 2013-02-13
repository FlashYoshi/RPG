package Objects;

/**
 *
 * @author Titouan Vervack
 */
public abstract class Characters extends Obstacles {

    private static final int HBLOCKS = 1;
    private static final int VBLOCKS = 1;

    public Characters() {
        super(HBLOCKS, VBLOCKS);
    }

    @Override
    public void fillArray() {
        bounds[1][1] = true;
    }
}
