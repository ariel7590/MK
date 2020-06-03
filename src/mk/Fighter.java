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
         moveLeft();
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            _x=_x+5;
          moveRight();
        }
        if(e.getKeyCode()==KeyEvent.VK_X){
           punch();
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.exit(0);
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
        _arena.chekCollision(this);
    }
    public void run(){
        while(true){
            
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
        if(currentState==2){
            if(currentNum>=WalkPics.length)             
                    currentNum=0;
               _x=_x-10;
                currentImg=WalkPics[WalkPics.length-currentNum-1];
        }
    if(currentState==3){
         if(currentNum>=PunchPics.length)
                currentNum=0;  
            currentImg=PunchPics[currentNum];
    }
     
    }
    public void pause(int t){
        try{Thread.sleep(t);}
        catch(InterruptedException e){}
    }
    Graphics g;
        Image StandPics[];
         Image currentImg;
             int currentNum;
             int _x=50;
             int _y=100;
             Image WalkPics[];
             Image PunchPics[];
           Arena _arena;
           int life=100;
             int currentState=0;
            
 public  Fighter(Graphics theG,boolean auto,String name,int x,int nStand,int  nWalk,int nPunch,Arena theArena){
     StandPics=new Image[nStand];
     WalkPics=new Image[nWalk];
     PunchPics=new Image[nPunch];
    _arena=theArena;
     g=theG;
     _x=x;
     
        for (int i=0;i<StandPics.length;i++){
          try{StandPics [i]=ImageIO.read(new File("D:\\MK pics"+name+"\\stand\\"+(i+1)+".gif") );
           }catch(IOException e){System.out.println(e.getMessage());}
          try{WalkPics [i]=ImageIO.read(new File("D:\\MK pics"+name+"\\walk\\"+(i+1)+".gif") );
           }catch(IOException e){System.out.println(e.getMessage());}
          try{PunchPics [i]=ImageIO.read(new File("D:\\MK pics"+name+"\\punch\\"+(i+1)+".gif") );
           }catch(IOException e){System.out.println(e.getMessage());}
     }
 
            currentImg=StandPics[0];
            currentNum=0;     
     }
     
 public void drawMe(boolean flip){
  if(!flip)
    g.drawImage(currentImg,_x,_y,null);
  else
      g.drawImage(currentImg, _x, _y,-currentImg.getWidth(null),currentImg.getHeight(null),null);
  g.drawString(Integer.toString(life), _x, _y);
}
 }


