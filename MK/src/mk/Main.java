/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mk;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author student
 */
public class Main extends JFrame{
    public Main(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720,240);
        setVisible(true);
       Fighter fighter=new Fighter(getContentPane(),50);
               new Thread(fighter).start();
               addKeyListener(fighter);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main me=new Main();
    }

}
