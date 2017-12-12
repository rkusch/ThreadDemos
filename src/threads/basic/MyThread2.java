/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.basic;

/**
 *
 * @author rkusch
 */
public class MyThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            System.out.println("MyThread2 executing, count " + i);
        }
        System.out.println("MyThread2 DONE executing");
    }
    
    
    
}
