package threads.basic;

/**
 *
 * @author jlombardo
 */
public class Example1 {
    /**
     *  When main runs it runs on the application thread (#1).
     * @param args - not used.
     */
    public static void main(String[] args) {
        // These threads are subclasses of Thread
        Thread t2 = new PrintThreadEven("Thread #2");
        Thread t3 = new PrintThreadOdd("Thread #3");

        // Now let's use the Runnable interface instead
        MyCustomThread mct = new MyCustomThread();
        Thread t4 = new Thread(mct, "Thread #4");

        System.out.println( "\nStarting threads..." );

        t2.setPriority(1);
        t2.start();
        t3.setPriority(9);
        t3.start();
        t4.setPriority(5);
        t4.start();

    }
}
