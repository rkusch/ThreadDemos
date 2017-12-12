package threads.basic;

public class Test1 {
    public static void main(String[] args) {
        Thread t1 = new Test1Thread1();
        t1.start();
        
        MyCustomThread mct = new MyCustomThread();
        Thread t2 = new Thread(mct, "My Custom Runnable");
        t2.start();
    }
}
