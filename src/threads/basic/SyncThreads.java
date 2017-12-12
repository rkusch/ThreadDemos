package threads.basic;

import java.util.*;

/**
 * An example class that demonstrates using several threads at once.
 * Notice how the theads are started one by one, and then are
 * programmed to sleep on a random basis. Finally, all output goes
 * to the console to show what is happening.
 */
public class SyncThreads {
	// Not thread safe!!
	   public static List list = new ArrayList();
	
	// create and start threads
	public static void main( String args[] )
	{
	   list.add("Hello Message");
	   
	   Thread[] printThreads = new Thread[4];

	   // create four PrintThread objects with default priority
	   printThreads[0] = new PrintThread2( "thread1" );
	   printThreads[1] = new PrintThread2( "thread2" );
	   printThreads[2] = new PrintThread3( "thread3" );
	   printThreads[3] = new PrintThread3( "thread4" );

	   System.err.println( "\nStarting threads" );

	   // set runtime priority
	   printThreads[0].setPriority(Thread.MAX_PRIORITY);
	   printThreads[1].setPriority(Thread.NORM_PRIORITY);
	   printThreads[2].setPriority(Thread.MIN_PRIORITY);
	   printThreads[3].setPriority(Thread.MIN_PRIORITY + 2);

	   // start executing PrintThreads
	   for( int i=0; i < printThreads.length; i++ ) {
		   printThreads[i].start();
	   }

	   System.err.println( "Threads started\n" );
	}

 }  // end class BasicThreading

//	Each object of this inner class picks a random sleep interval.
//	When a PrintThread executes, it prints its name, sleeps,
//	prints its name again and terminates.
 class PrintThread2 extends Thread {
	private int sleepTime;

	// PrintThread constructor assigns name to thread
	// by calling superclass Thread constructor
	public PrintThread2( String name )
	{
	   super( name );

	   // sleep between 0 and 5 seconds
	   sleepTime = (int) ( Math.random() * 5000 );

	   // display name and sleepTime
	   System.err.println(
		  "Name: " + getName() + ";  Total sleep time (ms): " + sleepTime );
	}

	// control thread's execution
	public void run()
	{
	   // put thread to sleep for a random interval
	   try {
		  System.err.println( getName() + " going to sleep" );

		  // put thread to sleep
		  Thread.sleep( sleepTime );
		  String threadName = this.getName();
		  
		  // extract the thread number
		  int tNum = Integer.parseInt( threadName.substring(threadName.length()-1));
		  
		  synchronized(SyncThreads.list) {
			  // Store different values based on even or odd number of thread
			  if( tNum % 2 == 0 ) { // must be an even number
				  SyncThreads.list.set(0, "Hello from " + threadName);
			  } else {
				  SyncThreads.list.set(0, "Goodbye from " + threadName);
			  }
		  }
		  
		  // Now print value
		  System.out.println(SyncThreads.list.get(0));
	   }

	   // if thread interrupted during sleep, catch exception
	   // and display error message
	   catch ( InterruptedException interruptedException ) {
		  System.err.println( interruptedException.toString() );
	   }

	   // print thread name
	   System.err.println( getName() + " done sleeping" );
	}

 }  // end class PrintThread

//	Each object of this inner class picks a random sleep interval.
//	When a PrintThread executes, it prints its name, sleeps,
//	prints its name again and terminates.
class PrintThread3 extends Thread {
	private int sleepTime;

	// PrintThread constructor assigns name to thread
	// by calling superclass Thread constructor
	public PrintThread3( String name )
	{
	   super( name );

	   // sleep between 0 and 5 seconds
	   sleepTime = 500; //(int) ( Math.random() * 5000 );

	   // display name and sleepTime
	   System.err.println(
		  "Name: " + getName() + ";  Total sleep time (ms): " + sleepTime );
	}

	// control thread's execution
	public void run()
	{
	   // put thread to sleep for a random interval
	   try {
		  System.err.println( getName() + " going to sleep" );

		  // put thread to sleep
		  Thread.sleep( sleepTime );
		  String threadName = this.getName();
		  
		  // extract the thread number
		  int tNum = Integer.parseInt( threadName.substring(threadName.length()-1));
		  
		  // Store different values based on even or odd number of thread
		  if( tNum % 2 == 0 ) { // must be an even number
			  SyncThreads.list.set(0, "Hello from " + threadName);
		  } else {
			  SyncThreads.list.set(0, "Goodbye from " + threadName);
		  }
		  
		  // Now print value
		  System.out.println(SyncThreads.list.get(0));
	   }

	   // if thread interrupted during sleep, catch exception
	   // and display error message
	   catch ( InterruptedException interruptedException ) {
		  System.err.println( interruptedException.toString() );
	   }

	   // print thread name
	   System.err.println( getName() + " done sleeping" );
	}

}  // end class PrintThread
