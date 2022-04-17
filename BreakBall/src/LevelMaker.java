
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vojtechkylar
 */
public class LevelMaker {

    MainFrame frame;
    GamePanel panel;

    public LevelMaker(GamePanel panel) {
        this.panel = panel;
        frame = panel.frame;

    }

    public List<Block> createLevel(byte[][] map) {
        List<Block> blocks = new ArrayList<>();
        for (byte[] map1 : map) {
            for (int j = 0; j < map1.length; j++) {
                switch (map1[j]) {
                    case 0 -> blocks.add(new HiddenBlock(panel));
                    case 1 -> blocks.add(new Block(panel));
                    case 2 -> blocks.add(new PowerBlock(panel));
                    case 3 -> blocks.add(new BallBlock(panel));
                }
            }
        }

        return blocks;
    }
}
