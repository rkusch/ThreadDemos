package clock;

import java.awt.event.*;
import javax.swing.*;

/**
 * This is a real-time clock program that demonstrates a simplistic  
 * form of multithreading. This is the driver class -- run this!
 * <p>
 * In this case a separate thread of program
 * execution is controlled by a Timer object. The timer fires events 
 * on a consistent time frequency. With each event, the clock is updated.
 * The timer operates on (and creates) a separate thread, and therefore,
 * allows other threads to be executed simultaneously. For example, in
 * this object, like all GUI objects, there is an Event Dispatch thread
 * that processes GUI events. Here we connect the timer to the the Event
 * Dispatch thread by having the timer create a GUI ActionEvent every second.
 * <p>
 * 
 * Tecnically, however, although the timer is running on a separate thread,
 * the work that is done when the timer fires is done on the Event Dispatch
 * Thread, which is not a good idea when the work is large (which it isn't here).
 * A better use of multithreading is to put that work on it's own thread. 
 */
public class TimerClock extends StillClock implements ActionListener {
  /** Create a timer with delay of 1000 ms and a event listener object
   *  (this object)
   */
  protected Timer timer = new Timer(1000, this);

  /** Constructor used to start the timer */
  public TimerClock() {
    timer.start();
  }

  /** This object is a listener that will handle the action event caused by the timer */
  public void actionPerformed(ActionEvent e) {
    // Set new time and repaint the clock to display current time
    setCurrentTime();
    repaint();
  }

  /**
   * This class is a subclass of JPanel. Here, in main, we create a
   * JFrame and add this JPanel to that frame, which causes the timer
   * to start, which runs the clock indefinitely until we quit.
   */
  public static void main(String[] args) {
    JFrame frame = new JFrame("TimerClock");
    TimerClock clock = new TimerClock();
    frame.getContentPane().add(clock);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}
