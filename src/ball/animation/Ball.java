package ball.animation;

import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;


/**
 * A simple demo of a java applet that uses threads to animate a ball
 * that bounces around on the viewing area similar to the game "breakout".
 * Once the applet loads, click your mouse in the viewing area to start the animation.
 * <p>
 * Note: because this program uses the swing library you must have a Java 2 enabled
 * browser (IE is not Java 2 enabled, but Netscap is), or you must install the
 * Java 2 plugin for your web browser (see Sun website). The easiest way to run
 * this program is to use Eclipse Run As -> Java Applet.
 * 
 */
public class Ball extends JFrame implements Runnable
{
   private Thread blueBall,redBall;
   private boolean xUp, yUp, bouncing;
   private int x, y, x2, y2, xDx, yDy;
   private final int MAX_X = 200, MAX_Y = 200;

   public Ball() {
       init();
       this.setBounds(50, 50, MAX_X, MAX_Y);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
   }
   
   public void init()
   {
	  // initialize values
	  xUp = false;
	  yUp = false;
	  xDx = 1;
	  yDy = 1;
	  bouncing = false;

	  // let Ball Applet be its own MouseListener
	  addMouseListener( 
   
		 new MouseListener() {

			public void mousePressed( MouseEvent event ) 
			{

			   // delegate call to ball starter
			   createBall( event );
			}
   
			public void mouseExited( MouseEvent event ) {}

			public void mouseClicked( MouseEvent event ) {}

			public void mouseReleased( MouseEvent event ) {}

			public void mouseEntered( MouseEvent event ) {}
		 }
	  );

	  // set size of Applet
//	  setSize( MAX_X, MAX_Y );
   }

   // creates a ball and sets it in motion 
   // if no ball exists
   private void createBall( MouseEvent event )
   {

	  if ( blueBall == null ) {
		 x = event.getX();
		 y = event.getY();
		 blueBall = new Thread( this );

		 // start ball's bouncing
		 bouncing = true;
		 blueBall.start();
	  }
	  if ( redBall == null ) {
		 x2 = event.getX()+10;
		 y2 = event.getY()+5;
		 redBall = new Thread( this );

		 // start ball's bouncing
		 bouncing = true;
		 redBall.start();
	  }
   }

   // called if applet is closed.  by setting blueBall to null,
   // threads will be ended.
   public void stop()
   {
	  if ( blueBall != null )
		 blueBall = null;
   }

   // draws ball at current position
   public void paint( Graphics g )
   {
	  super.paint( g );

	  if ( bouncing ) {
		 g.setColor( Color.blue );
		 g.fillOval( x, y, 10, 10 );
		 g.setColor( Color.red );
		 g.fillOval( x2, y2, 10, 10 );
	  }
   }

   // action to perform on execution, bounces ball
   // perpetually until applet is closed.
   public void run()
   {
	  while ( true ) {

		 // sleep for a random interval
		 try {
			// Don't do this:  blueBall.sleep( 20 );
			Thread.sleep(150);
		 }

		 // process InterruptedException during sleep
		 catch ( InterruptedException exception ) {
			System.err.println( exception.toString() );
		 }

		 // determine new x position
		 if ( xUp == true ) {
			x += xDx;
			x2 += xDx;
                 } else {
			x -= xDx;
			x2 -= xDx;
                  }

		 // determine new y position
		 if ( yUp == true ) {
			y += yDy;
			y += yDy;
                 } else {
			y -= yDy;
			y -= yDy;
                 }

		 // randomize variables for creating next move
		 if ( y <= 0 ) {
			yUp = true;
			yDy = ( int ) ( Math.random() * 5 + 2 );
		 }

		 else if ( y >= MAX_Y - 10 ) {
			yDy = ( int ) ( Math.random() * 5 + 2 );
			yUp = false;
		 }

		 if ( x <= 0 ) {
			xUp = true;
			xDx = ( int ) ( Math.random() * 5 + 2 );
		 }

		 else if ( x >= MAX_X - 10 ) {
			xUp = false;
			xDx = ( int ) ( Math.random() * 5 + 2 );
		 }

		 repaint();

	  }  // end while

   }  // end method run
   
    public static void main(String[] args) {
        new Ball();
    }

}  // end class Ball
