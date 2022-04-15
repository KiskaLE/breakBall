
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
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    case 0:
                        blocks.add(new HiddenBlock(panel));
                        break;
                    case 1:
                        blocks.add(new Block(panel));
                        break;
                    case 2:
                        blocks.add(new PowerBlock(panel));
                        break;
                }
            }
        }
        
        return blocks;
    }

    private void setBlocks(List<Block> blocks, int height, int xBlocksCount) {

        int x = 20;
        int y = 10;
        int c = 0;
        final int width = (frame.getWidth()-2*x - xBlocksCount*10) / xBlocksCount;
        Block[] II;
        boolean notFist = false;
        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);
            
            if (block.getClass() != new HiddenBlock(panel).getClass()) {
                block.setLocation(x, y);
                block.setSize(width, height);
            } else {
                blocks.remove(block);
                i--;
            }
            if (c< xBlocksCount-1) {
                x+= 10+width;
                c++;
            }else{
                x = 20;
                y += 10+height;
                c=0;
            }
        }
        if (blocks.isEmpty() == false) {
            II = new Block[blocks.size()];
            for (int i = 0; i < blocks.size(); i++) {
                II[i] = blocks.get(i);

            }
            
        }

    }
}
