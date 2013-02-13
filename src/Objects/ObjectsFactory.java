package Objects;

import java.util.HashMap;

/**
 *
 * @author Titouan Vervack
 */
public class ObjectsFactory<K, V> extends HashMap {

    //Always use String as Key and Blocks as Value
    public ObjectsFactory() {
    }

    @Override
    public V get(Object key) {
        return makeNewBlock(key);
    }

    //Don't forget ListsModel    
    public V makeNewBlock(Object key) {
        String s = (String) key;
        switch (s) {
            case "sea":
                return (V) new Sea();
            case "main":
                return (V) new Main();
            case "grass":
                return (V) new Grass();
            case "sand":
                return (V) new Sand();
            case "tree":
                return (V) new Tree();
            default:
                return null;
        }
    }
}
