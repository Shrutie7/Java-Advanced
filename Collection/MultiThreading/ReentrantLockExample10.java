package Collection.MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample10 {
    //lock. lockInterruptibly();//allows a thread to wait for a lock, but can be interrupted while waiting. no indefinite waiting
    // Wait to acquire the lock, but if the thread is interrupted while waiting, stop waiting and throw InterruptedException.
    private final Lock lock = new ReentrantLock();

    private void OuterMethod(){
        lock.lock();

        try{
            System.out.println("Outer lock");
            innerMethod();
        }finally {
            lock.unlock();
        }
    }
    private void innerMethod(){
        lock.lock();
        // jo lock pehle se kr rakha h outer method me usko firse lock krne ka try krre waiting khud ka hi ki kab khtm hoga release outer method ka lock finally block me hoga
        // apne upr hi depend krra ~ DEADLOCK mai kisi pe depend knra aur wo merepe depend krra
        // outermethod is waiting for inner method to finish // inner method wait krra for outer method to finish ~ deadlock ~ taki lock unlock hojaye
        // THATS Y REENTRANT LOCK is there (dubara se enter krsakte) so inner method acquires the lock again bcoz same thread holds it - toh deadlock hota nhi h bcoz of REENTRANT LOCK

        try{
            System.out.println("inner method");
        }finally {
            lock.unlock();
            //lock.unlock(); // gives exception lock ka count -1 hojaiga extra unlock h
        }
    }
    public static void main(String[] args) {
        ReentrantLockExample10 reentrantLockExample = new ReentrantLockExample10();
        reentrantLockExample.OuterMethod();
    }
}

//REENTRANT LOCK --> count maintain knta h ki lock kitne bar acquire kiya gaya h kitne bar unlock kiya h
// lock release hoga jab har ek lock match hojaiga uske unlock se
//methods
// .lock()
// .unlock()
// .tryLock() --1. without time --2. with time specified
//Reentrancy of reentrant lock --> how deadlock is prevented because of Reentrant lock
//SYNCHRONIZED - BLOCKED
//what is the state of Thread when lock laga rhe --› lock. lock() --› indefinitely wait karta h like synchronized ki acquire krsakta h kya Lock --> WAITING
//lock.trylock() -> wait for specified time interval or w/o time wala doesnt wait at all --> TIMED WAITING
//lock.lockInterruptibly() -> thread is in WAITING state/ TIMED WAITING STATE --> Wait to acquire the lock, but if the thread is interrupted while waiting, stop waiting and throw InterruptedException


// .lock() ke sath interrupt nhi krpaenge if we want to interrupt then use lock. lockIntencuptibly) interrupt exception throw hoga with try catch
// fairness of lock --> FIFO ORDER MAINTAINED PASS TRUE IN PARAM OF REENTRANT LOCK


//SYNCHRONIZED
//DISADVANTAGES:
//1. NO GUARANTEE OF FAIRNESS
//2. INDEFINITELY BLOCKING HORI
//3. INTERRUPTIBILITY NOT THERE ( interrupt nhi krsakte time hogya h bahut)
//4. READ/WRITE LOCKING (locks everything usko pata hi nhih konsa read h konsa write hai) (but if we use lock manually then this disadvantage can also be eliminated using 2 locks)