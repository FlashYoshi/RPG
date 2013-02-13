package Models;

import Objects.Blocks;
import Objects.ObjectsFactory;
import java.awt.Image;
import javax.swing.Icon;

/**
 *
 * @author Titouan Vervack
 */
public class ListsModel {

    private ObjectsFactory fact = new ObjectsFactory();
    //Don't forget Factory
    private String[] blocks = {"grass", "sand", "tree"};
    private Icon[] icons = new Icon[blocks.length];
    private Object[] objects;
    private Image toDraw = null;
    private Blocks selected;

    public ListsModel() {
        for (int i = 0; i < blocks.length; i++) {
            Blocks block = (Blocks) fact.get(blocks[i]);
            icons[i] = block.getIcon();
        }
    }

    public String[] getStringList() {
        return blocks;
    }

    public Icon[] getIconList() {
        return icons;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public Object[] getObjects() {
        return objects;
    }
    
    public void setToDraw(Image toDraw) {
        this.toDraw = toDraw;
    }

    public Image getToDraw() {
        return toDraw;
    }
    
    public ObjectsFactory getObjectsFactory(){
        return fact;
    }
    
    public Blocks getSelected(){
        return selected;
    }

    public void setSelected(Blocks selected) {
        this.selected = selected;
    }
}
