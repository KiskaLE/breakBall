
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

    int width, level;
    int defaultSpeed;
    long timer, score;
    Timer gameTimer;
    MainFrame frame;
    List<Block> blocksList = new ArrayList<>();
    List<Ball> balls = new ArrayList<>();
    Block[] blocksArray;
    Player player;
    Ball ball;
    
    JLabel gameOverLabel, scoreLabel;
    JButton menu;

    public GamePanel(MainFrame frame) {
        this.frame = frame;
        score = 0;
        player = new Player(this, frame.getWidth() / 2 - 50, frame.getHeight() - 100, 100, 20, 3);
        init();

        gameTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (player.live > 0) {
                    player.set();
                    balls.forEach(ball -> {
                        ball.set();
                    });
                    
                    if (timer <= 0) {
                        timer = 0;
                        for (Ball ball1 : balls) {
                            if (ball1.xSpeed<0) {
                                ball1.xSpeed = -defaultSpeed;
                            }else{
                                ball1.xSpeed = defaultSpeed;
                            }
                            if (ball1.ySpeed<0) {
                                ball1.ySpeed = -defaultSpeed;
                            }else{
                                ball1.ySpeed = defaultSpeed;
                            }
                            
                            
                        }
                    }else{
                        timer--;
                    }
                } else {
                    gameOverLabel.setVisible(true);

                    scoreLabel.setVisible(true);
                    menu.setVisible(true);

                }
                
                repaint();

            }

        }, 0, 17);
    }

    private void init() {
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

    private Integer randomInteger(int min, int max) {
        return (int) ((max - min) * Math.random()) + min;

    }

    private void generateBlocks(int blocksNumber, int powerBlockNumber, int width, int height, int lives) {
        int count;
        int x = 20;
        int y = 10;
        if (blocksNumber > powerBlockNumber) {
            if (blocksNumber % powerBlockNumber != 0) {
                powerBlockNumber--;
            }
            int number = blocksNumber + powerBlockNumber;
            count = blocksNumber / powerBlockNumber - 1;
            int maxWidth = frame.getWidth();
            for (int i = 0; i < number; i++) {
                if (i % count == 0) {
                    blocksList.add(new PowerBlock(x, y, height, width, lives, this));
                } else {
                    blocksList.add(new Block(x, y, height, width, lives, this));
                }

                if (x < maxWidth - (width + 50)) {
                    x += width + 10;
                } else {
                    x = 20;
                    y += height + 10;
                }
            }

        }
        blocksArray = new Block[blocksList.size()];
        for (int i = 0; i < blocksList.size(); i++) {
            blocksArray[i] = blocksList.get(i);

        }

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

            for (Block block : blocksArray) {
                if (block != null) {
                    block.draw(gtd);
                }

            }
            balls.forEach(ball -> {
                ball.draw(gtd);
            });

        }

    }

//    public void setPlayer(int lives) {
//        player = new Player(this, frame.getWidth() / 2 - 50, frame.getHeight() - 100, 100, 20, lives);
//
//    }
    public void setBall(int radius, int speed) {
        if (balls.isEmpty() == false) {
            balls.clear();
        }
        balls.add(new Ball(this, blocksArray[blocksArray.length - 1].x + 30, randomInteger(100, 300), 15));
        for (Ball ball : balls) {
            ball.xSpeed = speed;
            ball.ySpeed = speed;
            
        }
        defaultSpeed = speed;
    }

    public void setBallsSpeed(int speed) {
        for (Ball ball : balls) {
            ball.xSpeed = speed;
            ball.ySpeed = speed;
        }
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public void setBlocks(int blocksNumeber, int PowerBlockNumber, int width, int height, int lives) {
        generateBlocks(blocksNumeber, PowerBlockNumber, width, height, lives);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
// tlačítko nás vrací do menu:

    private void menuActionPerformed(ActionEvent evt) {
        setVisible(false);
        frame.remove(this);
        frame.setMenuVisibility(true);
    }
// vytvoří level podle zadaného levelu:

//    private void createLevel() {
//        gameTimer = new Timer();
//        setFocusable(true);
//        requestFocus();
//        this.setBackground(new Color(254, 234, 174));
//        player = new Player(this, frame.getWidth() / 2 - 50, frame.getHeight() - 100, 100, 20, 5);
//        ball = new Ball(this, frame.getWidth() / 2 - 50, frame.getHeight() - randomInteger(200, 300), 15);
//        switch (level) {
//            case 1:
//                generateBlocks(100, 25, 1, 21);
//                break;
//            case 2:
//                generateBlocks(50, 25, 2, 36);
//                break;
//            case 3:
//                generateBlocks(50, 25, 2, 50);
//                setBallSpeed(4);
//                break;
//        }
//
//    }
}
