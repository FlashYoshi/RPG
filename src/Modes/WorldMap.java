package Modes;

import Objects.*;
import java.awt.Dimension;

/**
 *
 * @author Titouan Vervack
 */
public class WorldMap {

    private Dimension size;
    //array containing the land in the map
    private Blocks[][] worldMap;
    private Blocks[][] worldObstacles;
    private Blocks[][] sea;
    private Main main = null;
    private ObjectsFactory fact = new ObjectsFactory();

    public WorldMap() {
        size = new Dimension(160, 110);
        worldMap = new Blocks[size.width][size.height];
        worldObstacles = new Obstacles[size.width][size.height];
        sea = new Sea[size.width][size.height];
    }

    public WorldMap(Dimension size) {
        this.size = size;
        worldMap = new Blocks[size.width][size.height];
        worldObstacles = new Obstacles[size.width][size.height];
        sea = new Sea[size.width][size.height];
    }

    public Dimension getSize() {
        return size;
    }

    public boolean addMain(int x, int y) {
        if (main == null) {
            main = (Main) fact.get("main");
            if (check(x, y, main) == true) {
                worldObstacles[x][y] = main;
            }
            return true;
        }
        return false;
    }

    public boolean addObstacle(int x, int y, Obstacles obs) {
        if (check(x, y, obs)) {
            for (int i = 0; i < obs.getArray().length; i++) {
                for (int j = 0; j < obs.getArray()[i].length; j++) {
                    worldObstacles[x + i][y + j] = obs;
                }
            }
            return true;
        }
        return false;
    }

    public boolean addBackground(int x, int y, Backgrounds back) {
        if (check(x, y, back)) {
            for (int i = 0; i < back.getArray().length; i++) {
                for (int j = 0; j < back.getArray()[i].length; j++) {
                    worldMap[x + i][y + j] = back;
                }
            }
            return true;
        }
        return false;
    }

    public boolean addSea(int x, int y, Sea lSea) {
        if (check(x, y, lSea)) {
            for (int i = 0; i < lSea.getArray().length; i++) {
                for (int j = 0; j < lSea.getArray()[i].length; j++) {
                    sea[x + i][y + j] = lSea;
                }
            }
            return true;
        }
        return false;
    }

    public boolean check(int x, int y, Blocks block) {
        boolean[][] array = block.getArray();
        if (block instanceof Sea) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (sea[x + i][y + j] != null) {
                        return false;
                    }
                }
            }
        } else if (block instanceof Backgrounds) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (worldMap[x + i][y + j] != null) {
                        return false;
                    }
                }
            }
        } else if (block instanceof Obstacles) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (worldObstacles[x + i][y + j] != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Blocks[][] getObstacles() {
        return worldObstacles;
    }

    public Blocks[][] getBackground() {
        return worldMap;
    }
    
    public Blocks[][] getSea(){
        return sea;
    }
    
    public void reset(){
        sea = new Blocks[size.width][size.height];
        worldMap = new Blocks[size.width][size.height];
        worldObstacles = new Blocks[size.width][size.height];
    }
}
