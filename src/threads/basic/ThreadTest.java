/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author rkusch
 */
public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("The main thread is running");
        ExecutorService threadExecutor = Executors.newFixedThreadPool(1);
        MyThread2 myThread = new MyThread2();
        threadExecutor.execute(myThread);
        System.out.println("Starting MyThread2");
        
        System.out.println("The main thread has ended");
    }
  
}
