import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vojtechkylar
 */
public class HiddenBlock extends Block {

    public HiddenBlock(GamePanel panel) {
        super(panel);
     topHitbox = new Rectangle(1, 1, 1, 1);
        bottomHitbox = new Rectangle(1, 1, 1, 1);
        rightHitbox = new Rectangle(1, 1, 1, 1);
        leftHitbox = new Rectangle(1, 1, 1, 1);
    }

    @Override
    public void set() {

    }

    @Override
    public void draw(Graphics2D gtd) {

    }

}
