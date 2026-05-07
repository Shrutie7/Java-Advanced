package Collection.MultiThreading;

//say hame dusri thread me print karana h world create a new class World that extends Thread and usme override krna h run method jisme likhenge ki kya kamm karana h

class World1 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class World implements Runnable{
    @Override
    public void run() {
        for (;;){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
