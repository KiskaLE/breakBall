
import java.awt.Color;
import java.awt.Graphics2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vojtechkylar
 */
public class PowerBlock extends Block {

    GamePanel panel;

    public PowerBlock(int x, int y, int height, int width, int hp, GamePanel panel) {
        super(x, y, height, width, hp);
        this.panel = panel;
    }

    public void setPower() {

        if (Math.random() > 0.5) {
            panel.ball.xSpeed += 1;
            panel.ball.ySpeed += 1;
        }else{
            panel.ball.xSpeed = 4;
            panel.ball.ySpeed = 4;
        }
        
    }
    @Override
    public void draw(Graphics2D gtd){
        gtd.setColor(new Color(252, 177, 217));
        gtd.fillRect(x, y, width, height);
    }
}
