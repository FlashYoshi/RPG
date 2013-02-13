package Misc;

import Actions.OSAction;
import Engine.Game;
import Engine.GamePanel;
import Engine.GameStarter;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Titouan Vervack
 */
public class TheStart extends Game {

    private static final ArrayList<String> CHOICES = new ArrayList<>();
    private TList openingScreen;

    public TheStart() {
        GamePanel panel = new GamePanel(this);
        CHOICES.add("Start Game");
        CHOICES.add("Open Leveleditor");
        CHOICES.add("Exit");
        openingScreen = new TList(CHOICES, new OSAction(), new Dimension(getWidth(), getHeight()), panel);
        GameStarter.start(this, panel);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
        if (isStarting()) {
            openingScreen.draw(g);
        }
        //draw sea
        //draw background
        //draw obstacles
    }
}
