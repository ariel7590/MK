/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mk;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
/**
 *
 * @author student
 */
public class Fighter implements Runnable, KeyListener{
    public void keyReleased(KeyEvent e){
        currentState=0;
    }
    public void keyTyped(KeyEvent e){
        
    }
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            _x=_x-5;
         currentState=2;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            _x=_x+5;
          currentState=1;
        }
        if(e.getKeyCode()==KeyEvent.VK_X){
            currentState=3;
        }
    }
    public void moveRight(){
        currentState=1;
    }
    public void moveLeft(){
        currentState=2;
    }
    public void stand(){
        currentState=0;
    }
    public void punch(){
        currentState=3;
    }
    public void run(){
        while(true){
            drawMe();
            pause(100);
             nextImage();
        }
    }
    public void nextImage(){
        currentNum++; 
      if(currentState==0){
          if(currentNum>=StandPics.length)
                currentNum=0;
            currentImg=StandPics[currentNum];
       }
        if(currentState==1){
            if(currentNum>=WalkPics.length)
                currentNum=0;
            _x=_x+10;
            currentImg=WalkPics[currentNum];
            
            
        }
    
     
    }
    public void pause(int t){
        try{Thread.sleep(t);}
        catch(InterruptedException e){}
    }
    Graphics g;
        Image StandPics[]=new Image[8];
         Image currentImg;
             int currentNum;
             int _x=50;
             int _y=50;
             Image WalkPics[]=new Image[8];
             Image PunchPics[]=new Image[9];
             int currentState=0;
              BufferedImage oImg;
            Graphics oGraphics;
 public  Fighter(Container theG,int x){
     g=theG.getGraphics();
     _x=x;
     oImg=new BufferedImage(theG.getWidth(),theG.getHeight(),BufferedImage.TYPE_INT_RGB);
     oGraphics=oImg.getGraphics();
     String standSrc[]={"C:\\MK\\stand\\1.gif","C:\\MK\\stand\\2.gif","C:\\MK\\stand\\3.gif","C:\\MK\\stand\\4.gif","C:\\MK\\stand\\5.gif","C:\\MK\\stand\\6.gif","C:\\MK\\stand\\7.gif","C:\\MK\\stand\\8.gif"};
     String walkSrc[]={"C:\\MK\\walk\\WF1.gif","C:\\MK\\walk\\WF2.gif","C:\\MK\\walk\\WF3.gif","C:\\MK\\walk\\WF4.gif","C:\\MK\\walk\\WF5.gif","C:\\MK\\walk\\WF6.gif","C:\\MK\\walk\\WF7.gif","C:\\MK\\walk\\WF8.gif"};
     String punchSrc[]={"C:\\MK\\punch\\1.gif","C:\\MK\\punch\\2.gif","C:\\MK\\punch\\3.gif","C:\\MK\\punch\\4.gif","C:\\MK\\punch\\5.gif","C:\\MK\\punch\\6.gif","C:\\MK\\punch\\7.gif","C:\\MK\\punch\\8.gif","C:\\MK\\punch\\9.gif"};
        for (int i=0;i<StandPics.length;i++){
          try{StandPics [i]=ImageIO.read(new File(standSrc[i]) );
           }catch(IOException e){System.out.println(e.getMessage());}
          try{WalkPics [i]=ImageIO.read(new File(walkSrc[i]) );
           }catch(IOException e){System.out.println(e.getMessage());}
          try{PunchPics [i]=ImageIO.read(new File(punchSrc[i]) );
           }catch(IOException e){System.out.println(e.getMessage());}
     }
 
            currentImg=StandPics[0];
            currentNum=0;     
           
     }
 public void drawMe(){
    oGraphics.drawImage(currentImg,_x,_y,null);
    g.drawImage(oImg, 0, 0, null);
}
 }


