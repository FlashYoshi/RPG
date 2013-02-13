package panels;

import Engine.Game;
import Models.ButtonModel;
import Models.ListsModel;
import Modes.WorldMap;
import Objects.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.JPanel;

/**
 *
 * @author Titouan Vervack
 */
public class EditorPanel extends JPanel implements MouseMotionListener, MouseListener, FocusListener {

    private static final int SIZE = Game.TILESIZE;
    public static final int HBLOCKS = 16;
    public static final int VBLOCKS = 11;
    private static final int HEIGHTLINE = VBLOCKS * SIZE;
    private static final int WIDTHLINE = HBLOCKS * SIZE;
    private Integer mouseX = null;
    private Integer mouseY;
    private ListsModel model;
    private WorldMap map;
    private ButtonModel bModel;

    public EditorPanel(ListsModel model, WorldMap map, ButtonModel bModel) {
        this.model = model;
        this.map = map;
        this.bModel = bModel;
        addMouseListener(this);
        addMouseMotionListener(this);
        addFocusListener(this);
    }

    @Override
    protected void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg.create();
        for (int i = 1; i <= 16; i++) {
            g.fillRect(i * SIZE, 0, 3, HEIGHTLINE);
            if (i < 11) {
                g.fillRect(0, i * SIZE, WIDTHLINE, 3);
            }
        }

        int curX = bModel.getHorizontalCounter() * HBLOCKS;
        int curY = bModel.getVerticalCounter() * VBLOCKS;


        for (int i = curX; i < curX + HBLOCKS; i++) {
            for (int j = curY; j < curY + VBLOCKS; j++) {
                if (map.getSea()[i][j] != null) {
                    map.getSea()[i][j].editorDraw(g, bModel.getHorizontalCounter() * 1024, bModel.getVerticalCounter() * 704);
                }
            }
        }

        for (int i = curX; i < curX + HBLOCKS; i++) {
            for (int j = curY; j < curY + VBLOCKS; j++) {
                if (map.getBackground()[i][j] != null) {
                    map.getBackground()[i][j].editorDraw(g, bModel.getHorizontalCounter() * 1024, bModel.getVerticalCounter() * 704);
                }
            }
        }

        for (int i = curX; i < curX + HBLOCKS; i++) {
            for (int j = curY; j < curY + VBLOCKS; j++) {
                if (map.getObstacles()[i][j] != null) {
                    map.getObstacles()[i][j].editorDraw(g, bModel.getHorizontalCounter() * 1024, bModel.getVerticalCounter() * 704);
                }
            }
        }

        //Hover
        if (model.getToDraw() != null && mouseX != null) {
            g.drawImage(model.getToDraw(), mouseX, mouseY, SIZE, SIZE, null);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        mouseX = x;
        mouseY = y;
        grabFocus();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Blocks block = model.getSelected();
        ObjectsFactory fact = model.getObjectsFactory();
        if (block != null) {
            int x = (int) Math.floor((double) e.getX() / Game.TILESIZE);
            int y = (int) Math.floor((double) e.getY() / Game.TILESIZE);
            Blocks placeBlock = (Blocks) fact.get(block.identify().toLowerCase());
            int xMov = bModel.getHorizontalCounter();
            int yMov = bModel.getVerticalCounter();
            if (block instanceof Backgrounds) {
                map.addBackground(x + (HBLOCKS * xMov), y + (VBLOCKS * yMov), (Backgrounds) placeBlock);
            } else if (block instanceof Obstacles) {
                map.addObstacle(x + (HBLOCKS * xMov), y + (VBLOCKS * yMov), (Obstacles) placeBlock);
            } else if (block instanceof Sea) {
                map.addSea(x + (HBLOCKS * xMov), y + (VBLOCKS * yMov), (Sea) placeBlock);
            } else {
                map.addMain(x + (HBLOCKS * xMov), y + (VBLOCKS * yMov));
            }
            placeBlock.setXY((x + (HBLOCKS * xMov)) * Game.TILESIZE, (y + (VBLOCKS * yMov)) * Game.TILESIZE);
        }
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
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        mouseX = null;
        repaint();
    }
}
