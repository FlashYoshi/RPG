package Misc;

import Models.ListsModel;
import Objects.Blocks;
import Objects.ObjectsFactory;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/**
 *
 * @author Titouan Vervack
 */
public class MakeList extends JList implements MouseListener, MouseMotionListener {

    private Object[] panels;
    private static final Dimension MIN = new Dimension(320, 704);
    private ListsModel model;
    private ObjectsFactory fact;

    public MakeList(ListsModel model) {
        this.model = model;
        fact = model.getObjectsFactory();
        setCellRenderer(new CellRenderer());

        String[] materialen = model.getStringList();
        Icon[] icons = model.getIconList();
        panels = new Object[materialen.length];

        for (int i = 0; i < materialen.length; i++) {
            JLabel label = new JLabel(materialen[i], icons[i], JLabel.LEFT);
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(label, BorderLayout.WEST);
            panels[i] = panel;
        }

        model.setObjects(panels);

        setListData(model.getObjects());

        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setMinimumSize(MIN);
        setPreferredSize(MIN);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Blocks block = (Blocks) fact.get(model.getStringList()[getSelectedIndex()]);
        model.setToDraw(block.getImage());
        model.setSelected(block);
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
        grabFocus();
        repaint();
    }
}
