//Created by Alan Chan
//Version 1.00
//Date: November 18, 2021

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class pong implements KeyListener{
	//properties
	JFrame theframe = new JFrame("PONG");
	MovementPanel thepanel = new MovementPanel();
	
	//methods
	public void keyReleased(KeyEvent evt){
		//stops player 1 movement when key is released 
		if(evt.getKeyChar() == 'w'){
			thepanel.intP1Def = 0;
		}else if(evt.getKeyChar() == 's'){
			thepanel.intP1Def = 0;
		}
		//stops player 2 movement when key is released
		if(evt.getKeyCode() == KeyEvent.VK_UP){
			thepanel.intP2Def = 0;
		}else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
			thepanel.intP2Def = 0;
		}
	}
	
	public void keyPressed(KeyEvent evt){
		//movement player 1
		if(evt.getKeyChar() == 'w'){
			thepanel.intP1Def = -5;
		}else if(evt.getKeyChar() == 's'){
			thepanel.intP1Def = 5;
		}
		//movement player 2
		if(evt.getKeyCode() == KeyEvent.VK_UP){
			thepanel.intP2Def = -5;
		}else if(evt.getKeyCode() == KeyEvent.VK_DOWN){
			thepanel.intP2Def = 5;
		}
		//serve the ball
		if(evt.getKeyCode() == KeyEvent.VK_SPACE){
			if(thepanel.intBallX == 395 && thepanel.intBallY == 2){
				thepanel.intBallX = 10;
				thepanel.intBallY = 20;
				thepanel.intBallDefX = 5;
				thepanel.intBallDefY = (int)(Math.random()*5+1);
			}
			
			if(thepanel.intPreX > 800 && thepanel.intBallX == 395 && thepanel.intBallY == 4){
				thepanel.intBallX = 790;
				thepanel.intBallY = 20;
				thepanel.intBallDefX = -5;
				thepanel.intBallDefY = (int)(Math.random()*5+1);
			}else if(thepanel.intPreX < 0 && thepanel.intBallX == 395 && thepanel.intBallY == 4){
				thepanel.intBallX = 0;
				thepanel.intBallY = 20;
				thepanel.intBallDefX = 5;
				thepanel.intBallDefY = (int)(Math.random()*5+1);
			}
		}
		//play again by pressing enter key after someone wins
		if(evt.getKeyCode() == KeyEvent.VK_ENTER){
			if(thepanel.intP1Points == 5 || thepanel.intP2Points == 5){
				thepanel = new MovementPanel();
				theframe.setContentPane(thepanel);
				theframe.pack();
			}
		}
	}
	
	public void keyTyped(KeyEvent evt){
		
	}
	
	//constructor
	public pong(){
		//frame setup
		theframe.setResizable(false);
		theframe.addKeyListener(this);
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setVisible(true);
	}

	//main method
	public static void main(String[] args){
		new pong();
	}
}
