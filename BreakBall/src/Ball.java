
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
public class Ball {

    int x, y, radius;
    double xSpeed, ySpeed;
    Rectangle hitBox;
    GamePanel panel;

    public Ball(GamePanel panel, int x, int y, int radius, int speed) {
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.radius = radius;
        xSpeed = speed;
        ySpeed = speed;
        hitBox = new Rectangle(x, y, radius, radius);
    }

    public void set() {

        // kolize
        //hráč
        intersectsCheck(panel.player);
        //zdi
        intersectsCheck();
        //bloky
        intersectsCheck(panel.blocksArray);

        x += xSpeed;
        y += ySpeed;

        hitBox.setLocation(x, y);
    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(new java.awt.Color(0, 228, 185));
        gtd.fillOval(x, y, radius, radius);
    }

    private void removeBlock(Block block, int index) {
        panel.blocksList.remove(block);
        panel.blocksArray[index] = null;

    }

    private boolean isDead(Block block) {
        if (block.hp <= 0) {
            return true;
        } else {
            return false;
        }

    }

    private void intersectsCheck() {
        if (x < 0 || x > panel.getWidth() - radius) {
            xSpeed *= -1;
        }
        if (y < 0) {
            ySpeed = Math.abs(ySpeed);
        }
        if (y > panel.getHeight()) {
            //panel.player.live = 0;
            panel.balls.remove(this);
        }
    }

    private void intersectsCheck(Player player) {
        if (player.leftHitbox.intersects(hitBox) && player.topHitbox.intersects(hitBox) && xSpeed > 0) {
            xSpeed *= -1;
            ySpeed = -Math.abs(ySpeed);
        } else if (player.rightHitbox.intersects(hitBox) && player.topHitbox.intersects(hitBox) && xSpeed < 0) {
            xSpeed *= -1;
            ySpeed = -Math.abs(ySpeed);
        } else if (player.topHitbox.intersects(hitBox)) {
            ySpeed = -Math.abs(ySpeed);
        }

    }

    private void intersectsCheck(Block[] blocks) {
        for (int i = 0; i < blocks.length; i++) {

            Block block = blocks[i];
            if (block != null) {
                if (block.topHitbox.intersects(hitBox) && ySpeed < 0 && ((block.leftHitbox.intersects(hitBox) && xSpeed > 0) || (block.rightHitbox.intersects(hitBox) && xSpeed < 0))) {
                    xSpeed *= -1;
                    block.hp--;
                } else if (block.topHitbox.intersects(hitBox) && ySpeed > 0 && ((block.leftHitbox.intersects(hitBox) && xSpeed > 0) || (block.rightHitbox.intersects(hitBox) && xSpeed < 0))) {
                    xSpeed *= -1;
                    ySpeed *= -1;
                    block.hp--;
                } else if (block.topHitbox.intersects(hitBox) && ySpeed > 0 && ((block.leftHitbox.intersects(hitBox) && xSpeed < 0) || (block.rightHitbox.intersects(hitBox) && xSpeed > 0))) {
                    ySpeed *= -1;
                    block.hp--;
                } else if (block.bottomHitbox.intersects(hitBox) && ySpeed < 0 && ((block.leftHitbox.intersects(hitBox) && xSpeed > 0) || (block.rightHitbox.intersects(hitBox) && xSpeed < 0))) {
                    xSpeed *= -1;
                    ySpeed *= -1;
                    block.hp--;
                } else if (block.bottomHitbox.intersects(hitBox) && ySpeed < 0 && ((block.leftHitbox.intersects(hitBox) && xSpeed < 0) || (block.rightHitbox.intersects(hitBox) && xSpeed > 0))) {
                    ySpeed *= -1;
                    block.hp--;
                } else if (block.bottomHitbox.intersects(hitBox) && ySpeed > 0 && ((block.leftHitbox.intersects(hitBox) && xSpeed > 0) || (block.rightHitbox.intersects(hitBox) && xSpeed < 0))) {
                    xSpeed *= -1;
                    block.hp--;
                } else if (block.topHitbox.intersects(hitBox) || block.bottomHitbox.intersects(hitBox)) {
                    ySpeed *= -1;
                    block.hp--;
                } else if (block.leftHitbox.intersects(hitBox) || block.rightHitbox.intersects(hitBox)) {
                    xSpeed *= -1;
                    block.hp--;
                }
                if (isDead(block)) {
                    panel.blocksArray[i].set();
                    removeBlock(block, i);
                }
            }

        }
    }

}
