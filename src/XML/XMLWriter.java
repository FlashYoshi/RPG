package XML;

import Modes.WorldMap;
import Objects.Blocks;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 *
 * @author Titouan Vervack
 */
public class XMLWriter {

    public XMLWriter(File file, WorldMap map) {
        try {
            //Get title
            Element root = new Element("Level1");
            Element size = new Element("Size");
            size.setAttribute("i", String.valueOf(map.getSize().width));
            size.setAttribute("j", String.valueOf(map.getSize().height));
            Blocks[][] obstacles = map.getObstacles();
            for (int i = 0; i < obstacles.length; i++) {
                for (int j = 0; j < obstacles[i].length; j++) {
                    Blocks obs = obstacles[i][j];
                    if (obs != null) {
                        Element obstacle = new Element("Obstacles");
                        obstacle.setAttribute("type", obs.identify());
                        obstacle.setAttribute("i", String.valueOf(i));
                        obstacle.setAttribute("j", String.valueOf(j));
                        root.addContent(obstacle);
                    }
                }
            }

            Blocks[][] background = map.getBackground();
            for (int i = 0; i < background.length; i++) {
                for (int j = 0; j < background[i].length; j++) {
                    Blocks bg = background[i][j];
                    if (bg != null) {
                        Element bkg = new Element("Background");
                        bkg.setAttribute("type", bg.identify());
                        bkg.setAttribute("i", String.valueOf(i));
                        bkg.setAttribute("j", String.valueOf(j));
                        root.addContent(bkg);
                    }
                }
            }

            Blocks[][] Sea = map.getSea();
            for (int i = 0; i < Sea.length; i++) {
                for (int j = 0; j < Sea[i].length; j++) {
                    Blocks sea = Sea[i][j];
                    if (sea != null) {
                        Element seas = new Element("Sea");
                        seas.setAttribute("type", sea.identify());
                        seas.setAttribute("i", String.valueOf(i));
                        seas.setAttribute("j", String.valueOf(j));
                        root.addContent(seas);
                    }
                }
            }
            Document document = new Document(root);
            XMLOutputter serializer = new XMLOutputter();
            FileWriter writer = new FileWriter(file);
            serializer.setFormat(Format.getPrettyFormat());
            serializer.output(document, writer);
        } catch (IOException ex) {
            Logger.getLogger(XMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
