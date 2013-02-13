package XML;

import Engine.Game;
import Modes.WorldMap;
import Objects.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author Titouan Vervack
 */
public class XMLReader {

    public XMLReader(File file, WorldMap map) {
        try {
            Document document = new SAXBuilder().build(file);
            Element rootNode = document.getRootElement();
            List obstacles = rootNode.getChildren("Obstacle");
            List backgrounds = rootNode.getChildren("Background");
            List seas = rootNode.getChildren("Sea");
            ObjectsFactory fact = new ObjectsFactory();
            map.reset();

            for (int i = 0; i < obstacles.size(); i++) {
                Element el = (Element) obstacles.get(i);
                String type = el.getAttributeValue("type");
                int x = Integer.valueOf(el.getAttributeValue("i")).intValue();
                int y = Integer.valueOf(el.getAttributeValue("j")).intValue();
                Blocks obs = (Blocks) fact.get(type.toLowerCase());
                map.addObstacle(x, y, (Obstacles) obs);
                obs.setXY(x * Game.TILESIZE, y * Game.TILESIZE);
            }
            
            for (int i = 0; i < backgrounds.size(); i++) {
                Element el = (Element) backgrounds.get(i);
                String type = el.getAttributeValue("type");
                int x = Integer.valueOf(el.getAttributeValue("i")).intValue();
                int y = Integer.valueOf(el.getAttributeValue("j")).intValue();
                Blocks bk = (Blocks) fact.get(type.toLowerCase());
                map.addBackground(x, y, (Backgrounds) bk);
                bk.setXY(x * Game.TILESIZE, y * Game.TILESIZE);
            }
            
            for (int i = 0; i < seas.size(); i++) {
                Element el = (Element) seas.get(i);
                String type = el.getAttributeValue("type");
                int x = Integer.valueOf(el.getAttributeValue("i")).intValue();
                int y = Integer.valueOf(el.getAttributeValue("j")).intValue();
                Blocks sea = (Blocks) fact.get(type.toLowerCase());
                map.addSea(x, y, (Sea) sea);
                sea.setXY(x * Game.TILESIZE, y * Game.TILESIZE);
            }
            
        } catch (JDOMException | IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
