package Collection.MultiThreading;

public class MyThreadLifeCycle4 extends Thread {
    @Override
    public void run() {
        System.out.println("RUNNING");
        // sleep t1 thread also for 2s
        // here Thread.sleep will throw error enclose in try catch block // we cant write in method signature throws Interrupted Exception bcoz run method is overridden throws error
        try{//t1 ko pause kra diya h
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //getState() method returns State which is enum --> NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED
        // BUT IN JAVA in enum State RUNNING STATE IS NOT THERE BCOZ RUNNABLE MEANS EITHER ITS RUNNING OR READY TO RUN
        MyThreadLifeCycle4 t1 = new MyThreadLifeCycle4();// NEW STATE
        System.out.println(t1.getState()); //NEW
        t1.start();
        System.out.println(t1.getState()); // RUNNABLE STATE


        //this all operations is done by Main Thread
        // so to check call Thread.currentThread() in whichever method u will see that Thread
        System.out.println(Thread.currentThread().getState());//main thread ki state bata raha h // RUNNABLE bcoz Running state not there // RUNNABLE

        //so OS /JVM ko time mile so they can run run() method so we sleep the mainThread for 100ms // main ko pause krre 100 ms ke Liye
        //Thread.sleep will throw exception hence add in method signature InterruptedException or enclose in try catch block
        Thread.sleep(100);
        System.out.println(t1.getState());


        //. join() --> Waits for this thread to die.
        // An invocation of this method behaves in exactly the same way as the invocation
        t1.join(); // jis thread pe call krre usko finish hone ka wait krra main thread chala raha isko main thread --> main method'll wait for t1 to get finished tabhi main method will continue further
        System.out.println(t1.getState());//TERMINATED // wait kiya main thread ne ti finish hone ka aur wo finish hogya and tabhi main method will continue further



        //THREAD VS RUNNABLE
        // 2 WAYS TO CREATE A THREAD --> 1. EXTENDS THREAD CLASS 2. IMPLEMENT RUNNABLE INTERFACE
        // WHEN TO USE WHAT?????
        //say a class already extends another class then we want to create a Thread of that class we cannot extend Thread class because JAVA DON'T SUPPORT MULTIPLE INHERITANCE hence IMPLEMENTS RUNNABLE INTERFACE
        //waise aap koi bhi use kr sakte if a class is not extending another class
    }
}
