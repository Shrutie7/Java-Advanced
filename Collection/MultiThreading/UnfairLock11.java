package Collection.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLock11 {
    //there is fair and unfair lock
    // which thread will receive the lock so order matters //arbitrary manner the threads will come there is no order
    // order comes correctly --› fairness of lock --> konse thread ko lock milega

    private final Lock unfairLock = new ReentrantLock();

    public void accessResource() {
        try {
            unfairLock.lock();
            System.out.println(Thread.currentThread().getName() + " acquired the lock ");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " releasing the lock");
            unfairLock.unlock();
        }
    }

    public static void main(String[] args) {

        UnfairLock11 unfairLock = new UnfairLock11();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                unfairLock.accessResource();
            }
        };

        //created 3 threads they are sharing the same resource task

        Thread t1 = new Thread(task,"Thread1");
        Thread t2 = new Thread(task,"Thread2");
        Thread t3 = new Thread (task,"Thread3'");
        t1.start();
        t2.start();
        t3.start();

    }
}
