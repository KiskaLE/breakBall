
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
public class Player {

    GamePanel panel;
    int x, y, width, height, live, level;
    double xSpeed, ySpeed;
    Rectangle topHitbox, rightHitbox, leftHitbox;
    boolean keyLeft, keyRight, keyUp, keyDown;

    public Player(GamePanel panel, int x, int y, int width, int height, int live) {
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.live = live;

        topHitbox = new Rectangle(x, y, width, 1);
        rightHitbox = new Rectangle(x + width - 1, y, 1, height);
        leftHitbox = new Rectangle(x, y, 1, height);
    }

    public Player(GamePanel panel, int x, int y, int width, int height, int live, int level) {
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.live = live;
        this.level = level;

        topHitbox = new Rectangle(x, y, width, 1);
        rightHitbox = new Rectangle(x + width - 1, y, 1, height);
        leftHitbox = new Rectangle(x, y, 1, height);
    }

    public void set() {
        int maxSpeed = 12;
        float acceleration = 1.8f;

        if (keyLeft && keyRight || !keyLeft && !keyRight) {
            xSpeed *= 0.5;
        } else if (keyLeft && !keyRight) {
            xSpeed -= acceleration;
        } else if (keyRight && !keyLeft) {
            xSpeed += acceleration;
        }

        if (xSpeed > 0 && xSpeed < 0.75) {
            xSpeed = 0;
        }
        if (xSpeed < 0 && xSpeed > -0.75) {
            xSpeed = 0;
        }

        if (xSpeed > maxSpeed) {
            xSpeed = maxSpeed;
        }
        if (xSpeed < -maxSpeed) {
            xSpeed = -maxSpeed;
        }

        if (keyUp && keyDown || !keyUp && !keyDown) {
            ySpeed *= 0.8;
        } else if (keyUp && !keyDown) {
            ySpeed--;
        } else if (keyDown && !keyUp) {
            ySpeed++;
        }

        //meze pohybu
        if (x <= panel.width - width && x > 0) {
            x += xSpeed;
        } else if (x > panel.width - width) {
            x--;
        } else {
            x++;
        }

        topHitbox.setLocation(x, y);
        rightHitbox.setLocation(x + width - 1, y);
        leftHitbox.setLocation(x, y);

    }

    public void draw(Graphics2D gtd) {
        gtd.setColor(new Color(253, 253, 250));
        gtd.fillRect(x, y, width, height);

    }
}
