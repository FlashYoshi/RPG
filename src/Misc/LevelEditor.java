package Misc;

import Actions.ButtonAction;
import Actions.OpenAction;
import Actions.SaveAction;
import Engine.Game;
import Engine.GamePanel;
import Engine.GameStarter;
import Models.ButtonModel;
import Models.ListsModel;
import Modes.WorldMap;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import panels.EditorPanel;

/**
 *
 * @author Titouan Vervack
 */
public class LevelEditor extends Game implements ChangeListener {

    private EditorPanel panel;
    private WorldMap map = new WorldMap();
    private ButtonModel bModel = new ButtonModel(map);
    private JButton[] buttons = {new JButton(new ButtonAction(0, bModel)), new JButton(new ButtonAction(1, bModel)), new JButton(new ButtonAction(2, bModel)), new JButton(new ButtonAction(3, bModel))};
    private static final Dimension MIN = new Dimension(320, 30);
    
    public LevelEditor() {
        setDelay(1000 / 60);
        GamePanel gPanel = new GamePanel(this);
        setTitle("RPG's LevelEditor v1.0 \u00a9 Titouan Vervack");
        ListsModel model = new ListsModel();
        MakeList selectionList = new MakeList(model);

        panel = new EditorPanel(model, map, bModel);
        panel.setMaximumSize(new Dimension(1024, 704));
        panel.setLayout(null);
        selectionList.setPreferredSize(new Dimension(320, 674));

        bModel.addListener(this);

        for (JButton b : buttons) {
            b.setContentAreaFilled(false);
            panel.add(b);
        }

        JButton rightArrow = buttons[0];
        rightArrow.setBounds(992, 320, 32, 64);
        rightArrow.setIcon(new ImageIcon(LevelEditor.class.getResource("../images/RightArrow.png")));


        JButton leftArrow = buttons[1];
        leftArrow.setBounds(0, 320, 32, 64);
        leftArrow.setIcon(new ImageIcon(LevelEditor.class.getResource("../images/LeftArrow.png")));
        leftArrow.setEnabled(false);

        JButton topArrow = buttons[2];
        topArrow.setBounds(496, 0, 64, 32);
        topArrow.setIcon(new ImageIcon(LevelEditor.class.getResource("../images/TopArrow.png")));
        topArrow.setEnabled(false);

        JButton bottomArrow = buttons[3];
        bottomArrow.setBounds(496, 650, 64, 32);
        bottomArrow.setIcon(new ImageIcon(LevelEditor.class.getResource("../images/BottomArrow.png")));

        JButton save = new JButton(new SaveAction(map));
        save.setMinimumSize(MIN);
        
        JButton open = new JButton(new OpenAction(map));
        open.setMinimumSize(MIN);
        
        GroupLayout layout = new GroupLayout(gPanel);
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(panel)
                .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(save))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(open))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(selectionList))))
                );
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(panel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(save)
                .addComponent(open)
                .addComponent(selectionList))
                );
        gPanel.setLayout(layout);

        GameStarter.start(this, gPanel);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g) {
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        buttons[bModel.getChange()].setEnabled(!buttons[bModel.getChange()].isEnabled());
    }
}
