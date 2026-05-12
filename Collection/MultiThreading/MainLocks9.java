package Collection.MultiThreading;

//LOCK-->
//WITH SYNCHRONIZED KEYWORD AT ONE TIME ONLY THREAD IS ACCESSING THE SHARED RESOURCE (COUNTER)
// MEANS THAT THREAD WILL PUT LOCK ON IT SUCH THAT ANOTHER THREAD CANNOT ACCESS IT, ONCE ITS WORK IS DONE IT WILL RELEASE THE LOCK SO O/P CORRECT
// LOCKING (LOCK LAGA RAHE RESOURCES PE)
//1. INTRINSIC LOCK --> These are built into every object in Java. You don't see them, but they're there. **When you use a synchronized keyword, you're using these automatic locks**
//2. EXPLICIT LOCK/MANUAL LOCK --> These are more advanced locks you can control yourself using the lock class from java.util.concurrent.locks. You explicitly say when to lock and unlock giving u more control over how and when people can write in the notebook
// with synchronized keyword hamare pass control nhi h pehle kon use kera and bad mein kon use kra kitne der tak kon Likh raha h
//LOCK class ki help SE ham bata sakte t1 kitne der tk chlega t2 kitne der tk chlega
public class MainLocks9 {

    public static void main(String[] args) {
        BankAccount8 bankAccount = new BankAccount8();
        //instead of creating thread class separately here only implementing the Runnable interface and override the run method (withdraw method )and creating the instance of thread
        // creating thread on fly
        // instead of extending Thread class implementing Runnable interface on the fly implementation class banaya h Runnable interface ka
        // anonymous class bcoz we cannot create instance/object of interface so it will be anonymous class
       Runnable task =new Runnable(){
           @Override
           public void run(){
               bankAccount.withdraw(50);
           }
        };

        //Thread constructor me Runnable ka object and name of thread
        //2 thread h same kaam krre 50 withdraw krre shared resource "task" h
        //simultaneous withdrawal 50 using t1 and t2 ek bar me dono thread access na krle use synchronized keyword in withdraw method ***
        // with synchronized keyword t1 ko mil gya h Lock
        // means jab t1 access karega tab t2 access nhi karsakta h even if sleep diya hua ho means t1 ka execution pura finish hojaiga(including the sleep) tabhi t2 access krega
        // Thread. sleep (10000) --> to simulate longer operation --›say db operation (say more time)
        // means t1 ruka hua jab tak wo longer operation ho nhi jata and t2 wait kre jarahah THAT'S A PROBLEM jab t1 complete hoga tab t2 chlega
        // HERE ITSAUTOMATIC LOCK ACHIEVED WITH SYNCHRONIZED KEYWORD

       Thread t1 = new Thread(task,"Thread 1");
       Thread t2 = new Thread(task, "Thread 2");
       t1.start();
       t2.start();

        //Remove synchronized keyword bcoz we will create lock on our own
        // hence use explicit lock/manual lock achieved using Lock class
        // har ek java object me automatic lock hota h synchronized uses that
        // but here we will make our object of type lock the thread that acquires this lock can access the critical section
        // Lock -->interface --> we will make object of it using implementation class (cannot make obj of interface)
        // Lock lock = new ReentrantLock();
        // methods
        // .lock() --> Thread which uses this statement means is trying to acquire this lock if lock is not available some other thread has acquired it then that thread will wait
        // .tryLock() -->
        // .unlock() --> Thread which has acquired the lock is trying to unlock then some other thread can lock it(release the lock)


    }
}
