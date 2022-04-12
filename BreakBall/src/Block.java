
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
public class Block {

    int height;
    int width;
    int hp;

    int x;
    int y;
    
    GamePanel panel;
    
    Rectangle topHitbox, rightHitbox, bottomHitbox, leftHitbox;
    Rectangle hitBox;

    public Block(int x, int y, int height, int width, int hp, GamePanel panel) {
        this.x = x;
        this.y = y;

        this.height = height;
        this.width = width;
        this.hp = hp;

        this.panel = panel;
        //make Block hitboxes
        topHitbox = new Rectangle(x, y, width, 1);
        bottomHitbox = new Rectangle(x, y + height - 1, width, 1);
        rightHitbox = new Rectangle(x + width - 1, y, 1, height);
        leftHitbox = new Rectangle(x, y, 1, height);

    }

    public void set() {
    panel.score +=50;
    }

    public void draw(Graphics2D gtd) {

        gtd.setColor(new Color(0, 194, 249));
        gtd.fillRect(x, y, width, height);

    }

    @Override
    public String toString() {
        return "Block{" + "height=" + height + ", width=" + width + ", hp=" + hp + ", x=" + x + ", y=" + y + ", topHitbox=" + topHitbox + ", rightHitbox=" + rightHitbox + ", bottomHitbox=" + bottomHitbox + ", leftHitbox=" + leftHitbox + ", hitBox=" + hitBox + '}';
    }

}
