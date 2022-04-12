/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 *
 * @author vojtechkylar
 */
public class KeyChecker extends KeyAdapter{
    
    //GamePanel panel;
    MainFrame frame;
    public KeyChecker(MainFrame frame){
        this.frame = frame;
    }
   
    @Override
    public void keyPressed(KeyEvent e){
        frame.panel.keyPressed(e);
        
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        frame.panel.keyReleased(e);
    }
}
