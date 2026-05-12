package Collection.MultiThreading;

public class MultiThreadingTest2 {
    public static void main(String[] args) {

        System.out.println("Hello World");
        //in o/p terminal --> Process finished with exit code 0 means program ki process chali
        // WHEN A JAVA PROGRAM STARTS, ONE THREAD BEGINS RUNNING IMMEDIATELY, WHICH IS CALLED THE MAIN THREAD. THIS THREAD IS RESPONSIBLE FOR EXECUTING THE MAIN METHOD OF A PROGRAM



        System.out.println(Thread.currentThread().getName()); //main

        //we want to create a thread other than main thread
        // To create a new thread in java, you can either 1. extend the Thread class or 2. implement the Runnable interface

        //1. A new class World is created that extends Thread.
        //2. The run method is overridden to define the code that constitutes the new Thread (run me Likhenge karana kya h)
        //3. start method is called to initiate the new Thread (obj create krke start() call krlijye)

        //1. A new class World is created that implements Runnable interface.
        //2. The run method is overridden to define the code that constitutes the new Thread (run me likhenge karana kya h)
        //3. A Thread object is created by passing an instance of World class.
        //4. start method is called on the Thread object to initiate the new Thread. t1.start()

        // In both cases, The run method contains the code that will be executed in the new Thread.


        //1. when class extends Thread class --> use .start() after creating obj directly start krpaye
        //2. when class implements Runnable interface --> after creating object make Thread instance also -› Thread t1 = new Thread(world) -> pass in constructor that object of class World
        // when class implements Runnable interface .start() throws error use t1.start();



        // to print name of thread world (by default Thread-0) use class World class ka object banana hoga
        World world = new World();
        //world.start();//to start the thread when extends Thread class then use .start() method
        Thread t1 = new Thread(world); // do this when class implements Runnable interface
        t1.start();


        //infinite loop chalega
        for (;;){
            System.out.println(Thread.currentThread().getName());
        }

        //BELOW IS UNREACHABLE STATEMENT BCOZ UPAR HI infinite loop chalti rahegi
//        for (;;){
//            System.out.println(Thread.currentThread().getName());
//        }

    }
}
