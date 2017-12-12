package threads.basic;

import java.io.Serializable;

public class MyCustomThread implements Runnable, Serializable {

    public void run() {
        try {
           for(int i=0; i < 20; i++) {
              if(i % 3 == 0) {
                  System.out.println("Thread #4: NUMBER/3: " + i);
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
