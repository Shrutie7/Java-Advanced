package Collection.MultiThreading;

public class MultiThreadingTest2 {
    public static void main(String[] args) {

        System.out.println("Hello World");



        System.out.println(Thread.currentThread().getName()); //main



        // to print name of thread world (by default Thread-0) use class World class ka object banana hoga
        World world = new World();
        //world.start();//to start the thread when extends Thread class then use .start() method
        Thread t1 = new Thread(world); // do this when class implements Runnable interface
        t1.start();


        //infinite loop chalega
        for (;;){
            System.out.println(Thread.currentThread().getName());
        }

    }
}
