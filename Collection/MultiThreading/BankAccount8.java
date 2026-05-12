package Collection.MultiThreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount8 {
    private int balance = 100;

    //Lock -› interface -›make object of it using implementation class (cannot make obj of interface)
    // implementation class of lock class ReentrantLock()
    private final Lock lock = new ReentrantLock();//chabhi h


    //1.lock.tryLock()
    // immediately return krega true/false // no wait at all
    // --›returns boolean -> Acquires lock only if it's free at the time of invocation, immediately return true -> acquires lock if available, immediately return false -> if lock not available
    //t1 ke pass lock h & t2 access knna chah ra lock ko immediately false return krega with lock.trylock() wait nhi karaenge t2 ko
    // like it was waiting in case of synchronized upfront dikha denge else part me not free instead of waiting
    // wait nhi hora tha hence no need to catch exception


    // 2. lock.tryLock(time)
    // Acquires the lock if it's free within given waiting time & current thread has not been interrupted, if lock is available this method return immediately with value true

    // 3. lock.unlock()
    // Releases the lock. Other waiting threads can now acquire it
    // always unlock in finally block only, finally block me resources ko release krte h

    // 4. lock.lock()
    // similar to synchronized thread waits indefinitely till lock is acquired no use hence use tryLock()
    // Difference b/w synchronized & lock --> When we use .lock(), we explicitly unlock it in the finally block,
    // but with synchronized there is no such method - JVM unlocks it automatically.



    //instead of using synchronized(inbuilt lock) on this withdraw method we make our own object lock threads will access withdraw method with help of lock object we created
    //washroom h yeh below

    public void withdraw(int amount){
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){ // thread indefinitely wait nhi hora only 1s wait hora itne time me lock acquire hogya toh badhiya otw could not acquire
                if(balance>=amount){
                    try{
                        System.out.println(Thread.currentThread().getName()+ " :Proceeding with withdrawl");
                        Thread.sleep(1000);//thread pause hojaiga 10 s ke liye
                        balance-=amount;
                        System.out.println(Thread.currentThread().getName()+" Completed Withdrawl. Remianing Balance "+balance);
                    }
                    catch (InterruptedException e){
                        // 1f an InterruptedException is not handled properly, information that thread was interrupted will be lost .....
                        // Handling this exception means either to rethrow it or manually re-interrupt the current thread by calling Thread.interrupt(). Simply logging exception is not sufficient and counts as ignoring it.
                        // impact // Failing to interrupt thread(or rethrow) risks delaying the thread shutdown and losing the information that thread was interrupted probably w/o finishing its task
                        System.out.println(e);//logging not enough //lose krre h info that the thread was interrupted and its work is not done
                        // restore state which was interrupted
                        Thread.currentThread().interrupt();// //imp*// state kho di thi manually restore krih thread state so if any maintenance or clean up code can run

                    }finally {
                        lock.unlock();
                    }
                }else {
                    System.out.println(Thread.currentThread().getName()+" Insufficient Balance");
                }

            }else {
                System.out.println(Thread.currentThread().getName()+ " could not acquire the lock will try later!!!");
            }

        }catch (InterruptedException e){
            System.out.println(e);
            Thread.currentThread().interrupt();  //imp*// state kho di thi manually restore kri h thread state so if any maintenance or clean up code can run

        }
    }
}
