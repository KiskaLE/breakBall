
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vojtechkylar
 */
public class GamePanel extends javax.swing.JPanel implements ActionListener {

    int width, level, ballRadius, ballSpeed, hp;
    double defaultSpeed;
    long timer, score;
    private byte[][] map;
    private int bHeight;
    private Timer gameTimer;
    MainFrame frame;
    List<Block> blocksList = new ArrayList<>();
    List<Ball> balls = new ArrayList<>();
    Block[] blocksArray;
    Player player;
    Ball ball;

    JLabel gameOverLabel, scoreLabel;
    JButton menu;

    public GamePanel(MainFrame frame, byte[][] map, int height, int hp, int ballRadius, int ballSpeed) {
        this.frame = frame;
        this.map = map;
        this.bHeight = height;
        this.hp = hp;
        this.ballRadius = ballRadius;
        this.ballSpeed = ballSpeed;
        
        initComponents();
        initLevel();

        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (player.live > 0) {
                    player.set();
                    for (Ball ball1 : balls) {
                        ball1.set();
                    }

                    checkTimer();
                } else {
                    showGameOver();
                }

                repaint();

            }

        }, 0, 17);
    }

    private void initComponents() {
        gameTimer = new Timer();

        setFocusable(true);
        requestFocus();
        this.setBackground(new Color(254, 234, 174));
        player = new Player(this, frame.getWidth() / 2 - 50, frame.getHeight() - 100, 100, 20, 5);

        gameOverLabel = new JLabel();
        gameOverLabel.setLocation(100, 300);
        gameOverLabel.setForeground(Color.red);
        gameOverLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 50));
        gameOverLabel.setText("Game Over");
        gameOverLabel.setVisible(false);
        add(gameOverLabel);

        scoreLabel = new JLabel();
        scoreLabel.setForeground(Color.GREEN);
        scoreLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 30));

        scoreLabel.setVisible(false);
        add(scoreLabel);

        menu = new JButton();
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        menu.setBounds(100, 500, 100, 200);
        menu.setFont(new java.awt.Font("Helvetica Neue", 0, 20));
        menu.setText("Menu");
        menu.setVisible(false);
        add(menu);

        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    private void initLevel() {
        score = 0;
        player = new Player(this, frame.getWidth() / 2 - 50, frame.getHeight() - 100, 100, 20, 3);
        LevelMaker maker = new LevelMaker(this);
        setBlocks(maker.createLevel(map), this.bHeight, map[0].length, hp);
        setBall(ballRadius, ballSpeed);
    }

    private void checkTimer() {
        if (timer <= 0) {
            timer = 0;
            for (Ball ball1 : balls) {
                if (ball1.xSpeed < 0) {
                    ball1.xSpeed = -defaultSpeed;
                } else {
                    ball1.xSpeed = defaultSpeed;
                }
                if (ball1.ySpeed < 0) {
                    ball1.ySpeed = -defaultSpeed;
                } else {
                    ball1.ySpeed = defaultSpeed;
                }

            }
        } else {
            timer--;
        }
    }

    private void showGameOver() {
        gameOverLabel.setVisible(true);
        scoreLabel.setVisible(true);
        menu.setVisible(true);
    }

    private Integer randomInteger(int min, int max) {
        return (int) ((max - min) * Math.random()) + min;

    }

    void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            player.keyLeft = true;
        }

        if (e.getKeyChar() == 'd') {
            player.keyRight = true;
        }

    }

    void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            player.keyLeft = false;
        }

        if (e.getKeyChar() == 'd') {
            player.keyRight = false;
        }

    }

    private void setBallSpeed(int speed) {

        ball.xSpeed = speed;
        ball.ySpeed = speed;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (player.live > 0) {
            Graphics2D gtd = (Graphics2D) g;
            player.draw(gtd);
            if (blocksArray != null) {
                for (Block block : blocksArray) {
                    if (block != null) {
                        block.draw(gtd);
                    }

                }
            }

            balls.forEach(ball -> {
                ball.draw(gtd);
            });

        }

    }

    public void setBall(int radius, int speed) {
        defaultSpeed = speed;
        if (blocksArray != null) {
            if (balls.isEmpty() == false) {
                balls.clear();
            }
            balls.add(new Ball(this, randomInteger(100, 300), blocksArray[blocksArray.length - 1].y + blocksArray[blocksArray.length - 1].height + 10, radius, speed));

        }

    }

    public void setBallsSpeed(double speed) {
        for (Ball ball : balls) {
            ball.xSpeed = speed;
            ball.ySpeed = speed;
        }
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public void setBlocks(int width, int height, List<Block> blocks) {

        int x = 20;
        int y = 10;
        boolean notFist = false;
        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);

            if (notFist) {
                if (x < frame.getWidth() - (width + 50)) {
                    x += width + 10;
                } else {
                    x = 20;
                    y += height + 10;
                }

            } else {
                notFist = true;
            }
            if (block.getClass() != new HiddenBlock(this).getClass()) {
                block.setLocation(x, y);
                block.setSize(width, height);
            } else {
                blocks.remove(block);
                i--;
            }

        }
        if (blocks.isEmpty() == false) {
            blocksArray = new Block[blocks.size()];
            for (int i = 0; i < blocks.size(); i++) {
                blocksArray[i] = blocks.get(i);

            }
        }

    }

    public void setBlocks(List<Block> blocks, int height, int xBlocksCount, int hp) {

        int x = 20;
        int y = 10;
        int c = 0;
        final int width = (frame.getWidth() - 2 * x - xBlocksCount * 10) / xBlocksCount;
        Block[] II;
        boolean notFist = false;
        for (int i = 0; i < blocks.size(); i++) {
            Block block = blocks.get(i);

            if (block.getClass() != new HiddenBlock(this).getClass()) {
                block.setLocation(x, y);
                block.setSize(width, height);
                block.setHp(hp);
            } else {
                blocks.remove(block);
                i--;
            }
            if (c < xBlocksCount - 1) {
                x += 10 + width;
                c++;
            } else {
                x = 20;
                y += 10 + height;
                c = 0;
            }
        }
        if (blocks.isEmpty() == false) {
            blocksArray = new Block[blocks.size()];
            for (int i = 0; i < blocks.size(); i++) {
                blocksArray[i] = blocks.get(i);

            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
//vrací do menu:

    private void menuActionPerformed(ActionEvent evt) {
        setVisible(false);
        frame.remove(this);
        frame.setMenuVisibility(true);
    }
}
