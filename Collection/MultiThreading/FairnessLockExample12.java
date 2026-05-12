package Collection.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample12 {

    //till now in the UnfairLock11 example the lock is unfair
    //to make the lock fair ReentrantLock provides the functionality we pass true in param so fairness will be true
    // order will be maintained jis order me request krenge usi order me milenge threads
    // o/p thread chal koi bhi sakta h doesnt matter ki likha kaise h depend krta h thread ki scheduling pe OS ki jvm ki andar kaam fair hora h
    // but if we want to see in o/p jaise likha hah hamne main method mein then give sleep after every thread of some time
    // but if there r 20 threads then maybe 1 thread may not get chance to run/time to run that condition is called STARVATION*
    // but if we pass in param of REENTRANT LOCK as true fairness sab threads ko mauka milega order will be there also FIFO


    private final Lock lock = new ReentrantLock(true); //FIFO ORDER MAINTAINED of threads

    public void accessResource() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " acquired the lock ");
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " releasing the lock");
            lock.unlock();
        }
    }
    public static void main(String[] args) {

        UnfairLock11 lock = new UnfairLock11();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                lock.accessResource();
            }
        };

        //created 3 threads they are sharing the same resource task

        Thread t1 = new Thread(task,"Thread1");
        Thread t2 = new Thread(task,"Thread2");
        Thread t3 = new Thread (task,"Thread3'");
       try{
           t1.start();
           Thread.sleep(50);
           t2.start();
           Thread.sleep(50);
           t3.start();
           //now order will be maintained bcoz there is sleep of 50 ms after every thread
       }catch(Exception e){

       }


    }
}
