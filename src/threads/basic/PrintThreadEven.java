package threads.basic;

/**
 *
 * @author jlombardo
 */
public class PrintThreadEven extends Thread {
    private int sleepTime;

    // PrintThreadEven constructor assigns name to thread
    // by calling superclass Thread constructor
    public PrintThreadEven( String name )
    {
       super( name );

       // sleep between 0 and 5 seconds
       sleepTime = 1000; // 1000 ms = 1 second
    }

    // control thread's execution
    public void run()
    {
       try {
           for(int i=0; i < 20; i++) {
              if(i % 2 == 0) {
                  System.out.println(this.getName() + ": EVEN NUMBER: " + i);
              }

              // put thread to sleep
              Thread.sleep( 10 );
           }

       // if thread interrupted during sleep, catch exception
       // and display error message
       } catch ( InterruptedException interruptedException ) {
              System.err.println( interruptedException.toString() );
       }
    }

}
