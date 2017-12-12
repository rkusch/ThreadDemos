package threads.basic;

public class Test1Thread1 extends Thread {
    
    @Override
    public void run() {
        System.out.println("My customer thread has run.");
    }
}
