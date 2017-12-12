package threads.basic;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jlombardo
 */
public class Example2 {

    public static void main(String[] args) throws InterruptedException {
        final Example2 e2 = new Example2();

        /*
         * Code that excecutes on a custom Thread
         *
         * This is called an anonymous class. The braces after
         * new Runnable() define the class that implements the Runnable
         * interface and which is instantiated. An anonymous class is just
         * a class with no name. It's defined on the fly as we're doing here.
         * Note the overridden run() method, which is where our execution
         * code goes. NOTE: the variable e2 must be declared final to be
         * used in the run() method below.
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    e2.doLongTaskInCustomThread();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Example2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Excecutes on the main application thread
        e2.doLongTaskInMainThread();

    }

    private void doLongTaskInMainThread() throws InterruptedException {
        for(int i=0; i < 50; i++) {
            System.out.println("Executing loop #" + i + " in Main Thread");
            Thread.sleep(1000);
        }
    }

    private void doLongTaskInCustomThread() throws InterruptedException {
        for(int i=0; i < 50; i++) {
            System.out.println("Executing loop #" + i + " in Custom Thread");
            Thread.sleep(500);
        }

    }
}
