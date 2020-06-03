

package mk;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Arena implements Runnable {
    Fighter f1;
    Fighter f2;
    Graphics g;
    BufferedImage oImg;
    Graphics oGraphics;
    Image arena;
    public  Arena(JFrame JF){
        g=JF.getContentPane().getGraphics();
           oImg=new BufferedImage(JF.getContentPane().getWidth(),JF.getContentPane().getHeight(),BufferedImage.TYPE_INT_RGB);
           oGraphics=oImg.getGraphics();
           try{arena=ImageIO.read(new File("c:\\MK\\01.png"));}
     catch(IOException e){System.out.println(e.getMessage());}
           f1=new Fighter(oGraphics,false,"Scorpion",50,8,8,9);
           f2=new Fighter(oGraphics,true,"Sektor",250,8,8,9);
           new Thread (f1).start();
           new Thread (f2).start();
           JF.addKeyListener (f1);

    }
    public void drawMe(){
               oGraphics.drawImage(arena, 0, 0, null);
           f1.drawMe();
           f2.drawMe();
           g.drawImage(oImg, 0, 0, null);
         }
public void run(){
    while(true){
        drawMe();
    }
}
}
