
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
public class BallBlock extends Block {

    public BallBlock(int x, int y, int height, int width, int hp, GamePanel panel) {
        super(x, y, height, width, hp, panel);
    }

    public BallBlock(GamePanel panel) {
        super(panel);
    }

    @Override
    public void set() {
        Ball ball = panel.balls.stream().findFirst().get();
        
        panel.addBall(new Ball(panel, randomInteger(100, 300), panel.spawnY, ball.radius, (int) ball.xSpeed));
    }
    
    private Integer randomInteger(int min, int max) {
        return (int) ((max - min) * Math.random()) + min;

    }

    @Override
    public void draw(Graphics2D gtd) {
        topHitbox = new Rectangle(x, y, width, 1);
        bottomHitbox = new Rectangle(x, y + height - 1, width, 1);
        rightHitbox = new Rectangle(x + width - 1, y, 1, height);
        leftHitbox = new Rectangle(x, y, 1, height);
        
        gtd.setColor(new Color(220, 20, 60));
        gtd.fillRect(x, y, width, height);
    }
}
