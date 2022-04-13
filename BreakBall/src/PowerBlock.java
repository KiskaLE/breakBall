
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

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
        super(x, y, height, width, hp, panel);
        this.panel = panel;
    }

    public void set() {
        panel.score += 100;

        for (Ball ball : panel.balls) {
            ball.xSpeed = panel.defaultSpeed + 2;
            ball.ySpeed += panel.defaultSpeed + 2;
        }
        panel.timer = 200l;

    }

    @Override
    public void draw(Graphics2D gtd) {
        topHitbox = new Rectangle(x, y, width, 1);
        bottomHitbox = new Rectangle(x, y + height - 1, width, 1);
        rightHitbox = new Rectangle(x + width - 1, y, 1, height);
        leftHitbox = new Rectangle(x, y, 1, height);
        
        gtd.setColor(new Color(252, 177, 217));
        gtd.fillRect(x, y, width, height);
    }
}
