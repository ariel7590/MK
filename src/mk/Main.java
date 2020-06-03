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
    GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd=ge.getDefaultScreenDevice();
    DisplayMode dm;
    public Main(){
    setUndecorated(true);
        setVisible(true);
        dm=new DisplayMode(800,600,64,DisplayMode.REFRESH_RATE_UNKNOWN);
        gd.setFullScreenWindow(this);
        gd.setDisplayMode(dm);
      Arena a=new Arena(this);
      new Thread (a).start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main me=new Main();
    }

}
