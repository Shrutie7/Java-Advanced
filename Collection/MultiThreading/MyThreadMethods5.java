package Collection.MultiThreading;


class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread is running........");
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted: " + e);
        }
    }
}

class MyThread2 extends Thread {
    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield();//A hint to the scheduler that the current thread is willing to yield its current use of a processor. The scheduler is free to ignore this hint.
            // hint h guarantee nhi h bs more random aaiga ti is running t2 is running
        }
    }
}

class MyThread3 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello World !");
        }
    }
}
public class MyThreadMethods5 extends Thread {
    //to change name of Thread which is by default as Thread-0 we can make a constructor and pass in name and call super (name) --> means Thread class ke constructor ko call kara sakte h
    //so in parameter pass the name of thread u want that will come
    public MyThreadMethods5(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread is Running.........");
//        for (int i = 0; 1 <= 5; i++) {
//            try {
//                //current thread ke execution ko suspend/pause krre for 1 sec so prints i from 0 to 5 with pause of 1 sec in between
//                Thread.sleep(1000);
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);
//        }

        for (int i = 0; i < 5; i++) {
            String a = "";
            for (int j = 0; j < 10000; j++) {
                a += "a";
                System.out.println(Thread.currentThread().getName() + "-Priority: " + Thread.currentThread().getPriority() + " count: " + 1);
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //Thread Methods


        //1. .start()
        // once start is executed JVM will run run method of this thread class for u
        MyThreadMethods5 l = new MyThreadMethods5("Low Priority Thread");
        MyThreadMethods5 m = new MyThreadMethods5 ("Medium Priority Thread");
        MyThreadMethods5 h = new MyThreadMethods5( "High Priority Thread");


        //5. setPriority
        // if 3 to 4 threads are running we can set priority also before .start() method ***************
        // MAX_PRIORITY = 10, MIN_PRIORITY = 1, NORM_PRIORITY = 5 --> (all by default)
        // if kaafi sare threads chal rhe h then CPU can decide which has more priority and so on by using.setPriority
        l.setPriority(Thread.MIN_PRIORITY); // u will see priority as 1 m.setPriority(Thread.NORM_PRIORITY)://u will see priority as 5
        h.setPriority(Thread.MAX_PRIORITY);// u will see priority as 10
        l.start();
        m.start();
        h.start();
        //won't come in order/sequence depends on no of core and jvm of ur machine hence parallel execution can happen more noticable when single core processor

        //2. run()
        // overridden method of Thread class
        // actual me jo code Krna h means dusre thread me jo kaam karana h wo run() method me Likhna hoga

        //3. sleep()
        // pauses/suspends the execution of current thread for certain time mentioned
        // Thread.sleep will throw exception hence add in method signature InterruptedException or enclose in try catch block

        //4. join()
        // main method (caller) which is calling this thread will wait for h thread to die or terminate or finish so it can move further
        // will throw exception hence add in method signature InterruptedException
        h.join();

        System.out.println("HELLO");// this HELLO will print only when the t1 thread is finished/terminated happens after 5s because t1 is sleeping for 5s (5000ms) diye h run me Thread.sleep(5000)

        //6. interrupt
        MyThread t1 = new MyThread();
        t1.start();
        t1.interrupt();//Interrupts this thread means jo bhi krre ho aap usko rok do whether ur waiting or sleep or etc
        // goes to catch block of MyThread run method o/p: Thread Interrupted: java. lang. InterruptedException: sleep interrupted
        // so main method ne MyThread ke sleep ko interrupt kiya h hence Thread is running.... will not even print wont go in try block

        //7. yield
        MyThread2 t3 = new MyThread2( "t1");
        MyThread2 t4 = new MyThread2("t2");
        t3.start();
        t4.start();
        //Thread.yield() is like ham scheduler ko bolenge har ek iteration ke badh dusre thread ko chance dijive
        // hint h guarantee nhi h bs more random aaiga t3 is running t4 is running but yeild denge to hint lega ki dusce threads ko bhi mauka dena h


        // 8. setDaemon
        // user thread-> jo kaam kara rahe ho wo user thread se hota h
        //daemon thread -> thread which run in background ex in java garbage collector

        // JVM DOESN'T WAIT FOR DAEMON THREADS ********** it sees main method is over user threads work is over so JVM will terminate irrespective of whether daemon thread is running or not
        // DAEMON THREAD -> BACKGROUND THREAD JINKA JVM INTEZAAR NHI KRTA................!!!!!!!!!

        MyThread3 myThread = new MyThread3(); //called USER THREAD -> useful work / business logic Hello world print karana h jis thread ke help se yeh print hora MyThread3 called USER THREAD
        // MyThread Hello World print krte jaraha tha we can also setDaemon true
        myThread.setDaemon (true);
        MyThread3 myThread2 = new MyThread3();
        myThread.start();//RUNNABLE STATE// daemon thread as we setDaemon (true)
        myThread2.start(); //user thread //jvm terminate nhi hopaega bcoz jvm wait krra h myThread2(userThread) k khatam hone ka bcoz main hogya khtm and myThread toh daemon tha goli maro usko


        // keeps printing Hello world! infinitely means MAIN THREAD KHTM HOGYA M OBJ CREATE KIYA myThread AND START KIYA ITS WORK IS DONE when setDaemon true is not given*******
        // JVM is waiting for myThread ka kaam hojave complete means its printing Hello World! continuously then JVM KA kaam khtm hojiaga when setDaemon true is not given ********

        System.out.println("Main Done");

        //until userThread myThread2 is given..
        // now it will print Main Done and Hello World! for some time and stop when setDaemon (true) given
        // bcoz with myThread.start();// its in RUNNABLE STATE, cpu ne chalaya print kra Hello World! Main Done and utne me Hello World print hote jara hote jara
        // then it sees main Thread to hogya KHAlAN
        // and sees myThread is Daemon as we setDaemon (true) so usko maro goli and band hojaiga bcoz jvm dont wait for DAEMON THREADS SO IT STOPS FULLY THE PROGRAM
        // JVM KA H KI BAKI THREADS(main thread & userThread) BAND HOGYE H TOH M BHI BAND HOJATA HU DAEMON THREADS SE KOI MATLAB NHI H


        // when userThread myThread2 is given.....
        // keeps printing Main Done and Hello World! infinietly bcoz jvm waiting for user thread myThread to finish doesnt care abt daemon thread myThread

    }
}
//start run sleep join setPriority interrupt yield setDaemon