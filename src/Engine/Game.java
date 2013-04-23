package Engine;

import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.JFrame;

/**
 *
 * @author Titouan Vervack
 */
public abstract class Game implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    //Side GUI = 16 pixels
    private int width = 1360;
    //Top/Bottom GUI = 38 pixels
    private int height = 720;
    private int delay = 100;
    private String title = "GameEngine v1.6 \u00a9 Titouan Vervack";
    private boolean paused = false;
    private boolean over = false;
    private boolean won = false;
    private boolean starting = true;
    private JFrame window = new JFrame(title);
    public static final int TILESIZE = 64;

    public Game() {
    }

    public Game(String title) {
        this.title = title;
    }

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Game(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    abstract public void update();

    abstract public void draw(Graphics2D g);

    public void resetGame() {
        paused = false;
        won = false;
        over = false;
        starting = true;
        width = 1000;
        height = 700;
        title = "GameEngine v1.6 \u00a9 Titouan Vervack & Bart Middag";
        window.setTitle(title);
        delay = 100;
        System.gc();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        window.setTitle(title);
    }

    public boolean isPaused() {
        return paused;
    }

    public void pauseGame() {
        this.paused = true;
    }

    public void resumeGame() {
        this.paused = false;
    }

    public void togglePaused() {
        this.paused = !paused;
    }

    public boolean isOver() {
        return over;
    }

    public void stopGame() {
        this.over = true;
    }

    public boolean hasWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isStarting() {
        return starting;
    }

    public void startStarting() {
        this.starting = true;
    }

    public void stopStarting() {
        this.starting = false;
    }

    public JFrame getFrame() {
        return window;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
    }
}