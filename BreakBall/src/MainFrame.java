
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vojtechkylar
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        level1 = new javax.swing.JButton();
        level2 = new javax.swing.JButton();
        level3 = new javax.swing.JButton();
        level4 = new javax.swing.JButton();
        level5 = new javax.swing.JButton();
        level6 = new javax.swing.JButton();
        level7 = new javax.swing.JButton();
        level8 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("These Nuts!");
        setBackground(new java.awt.Color(217, 204, 178));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        level1.setBackground(new java.awt.Color(102, 255, 51));
        level1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        level1.setForeground(new java.awt.Color(0, 0, 0));
        level1.setText("1.level");
        level1.setBorderPainted(false);
        level1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        level1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level1ActionPerformed(evt);
            }
        });

        level2.setBackground(new java.awt.Color(102, 255, 51));
        level2.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        level2.setForeground(new java.awt.Color(0, 0, 0));
        level2.setText("2.level");
        level2.setBorderPainted(false);
        level2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        level2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level2ActionPerformed(evt);
            }
        });

        level3.setBackground(new java.awt.Color(102, 255, 51));
        level3.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        level3.setForeground(new java.awt.Color(0, 0, 0));
        level3.setText("3.level");
        level3.setBorderPainted(false);
        level3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        level3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level3ActionPerformed(evt);
            }
        });

        level4.setBackground(new java.awt.Color(102, 255, 51));
        level4.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        level4.setForeground(new java.awt.Color(0, 0, 0));
        level4.setText("4.level");
        level4.setBorderPainted(false);
        level4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        level4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level4ActionPerformed(evt);
            }
        });

        level5.setBackground(new java.awt.Color(255, 255, 51));
        level5.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        level5.setForeground(new java.awt.Color(0, 0, 0));
        level5.setText("5.level");
        level5.setBorderPainted(false);
        level5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        level5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level5ActionPerformed(evt);
            }
        });

        level6.setBackground(new java.awt.Color(255, 255, 51));
        level6.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        level6.setForeground(new java.awt.Color(0, 0, 0));
        level6.setText("6.level");
        level6.setBorderPainted(false);
        level6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        level6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level6ActionPerformed(evt);
            }
        });

        level7.setBackground(new java.awt.Color(255, 255, 51));
        level7.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        level7.setForeground(new java.awt.Color(0, 0, 0));
        level7.setText("7.level");
        level7.setBorderPainted(false);
        level7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        level7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level7ActionPerformed(evt);
            }
        });

        level8.setBackground(new java.awt.Color(255, 255, 51));
        level8.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        level8.setForeground(new java.awt.Color(0, 0, 0));
        level8.setText("8.level");
        level8.setBorderPainted(false);
        level8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        level8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level8ActionPerformed(evt);
            }
        });

        jMenu2.setText("Level");
        jMenuBar1.add(jMenu2);

        jMenu1.setText("Settings");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(level1)
                        .addGap(18, 18, 18)
                        .addComponent(level5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(level2)
                        .addGap(18, 18, 18)
                        .addComponent(level6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(level3)
                        .addGap(18, 18, 18)
                        .addComponent(level7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(level4)
                        .addGap(18, 18, 18)
                        .addComponent(level8)))
                .addContainerGap(451, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(level1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(level6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(level3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(level4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(level8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void level1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level1ActionPerformed
        panel = new GamePanel(this);
        panel.setBlocks(15, 0, 100, 30, 1);
        panel.setBall(30, 3);
        initPanel(panel);
    }//GEN-LAST:event_level1ActionPerformed

    private void level2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level2ActionPerformed
        panel = new GamePanel(this);
        List<Block> blocks = new ArrayList<>();
        Collections.addAll(blocks, generateBlocks(10, 1, panel));
        Collections.addAll(blocks, generatePowerBlocks(1, 2, panel));
        Collections.addAll(blocks, generateBlocks(5, 1, panel));
        Collections.addAll(blocks, generatePowerBlocks(2, 2, panel));
        Collections.addAll(blocks, generateBlocks(10, 1, panel));
        panel.setBlocks(50, 20, blocks);
        panel.setBall(20, 3);
        initPanel(panel);

    }//GEN-LAST:event_level2ActionPerformed

    private void level3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level3ActionPerformed

    }//GEN-LAST:event_level3ActionPerformed

    private void level4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level4ActionPerformed

    }//GEN-LAST:event_level4ActionPerformed

    private void level6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level6ActionPerformed

    }//GEN-LAST:event_level6ActionPerformed

    private void level7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level7ActionPerformed

    }//GEN-LAST:event_level7ActionPerformed

    private void level8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level8ActionPerformed

    }//GEN-LAST:event_level8ActionPerformed

    private void level5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level5ActionPerformed

    }//GEN-LAST:event_level5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);

            }
        });
    }

    private void init() {
        setFocusable(true);
        getContentPane().setBackground(new Color(217, 204, 178));

    }

    private void initPanel(GamePanel panel) {
        panel.setLocation(0, 0);
        panel.setSize(this.getWidth(), this.getHeight() - 80);
        panel.setVisible(true);
        add(panel);
        addKeyListener(new KeyChecker(this));
        setMenuVisibility(false);
    }

    private Block[] generateBlocks(int number, int hp, GamePanel panel) {
        Block[] blocks = new Block[number];
        for (int i = 0; i < number; i++) {
            blocks[i] = new Block(0, 0, 10, 10, hp, panel);
        }
        return blocks;
    }

    private PowerBlock[] generatePowerBlocks(int number, int hp, GamePanel panel) {
        PowerBlock[] blocks = new PowerBlock[number];
        for (int i = 0; i < number; i++) {
            blocks[i] = new PowerBlock(0, 0, 10, 10, hp, panel);
        }
        return blocks;
    }

    /**
     * Nastavuje viditelnost menu tlačítek
     *
     * @param b
     * @setMenuVisibility
     */
    public void setMenuVisibility(boolean b) {
        level1.setVisible(b);
        level2.setVisible(b);
        level3.setVisible(b);
        level4.setVisible(b);
        level5.setVisible(b);
        level6.setVisible(b);
        level7.setVisible(b);
        level8.setVisible(b);
    }

    public GamePanel getPanel() {
        return panel;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public JMenu getjMenu2() {
        return jMenu2;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public JButton getStartJButton() {
        return level1;
    }

    public GamePanel panel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton level1;
    private javax.swing.JButton level2;
    private javax.swing.JButton level3;
    private javax.swing.JButton level4;
    private javax.swing.JButton level5;
    private javax.swing.JButton level6;
    private javax.swing.JButton level7;
    private javax.swing.JButton level8;
    // End of variables declaration//GEN-END:variables
}
