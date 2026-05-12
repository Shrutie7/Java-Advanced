package Collection.MultiThreading;


class MyThreadSynchronization extends Thread{

    //field of CounterSynchronization6 type
    private CounterSynchronization6 counter;

    //constructor jisme counter lera
    public MyThreadSynchronization(CounterSynchronization6 counter){
        this.counter = counter;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10000 ; i++) {
            counter.increment(); // jo hamne t1 banaya h uske constructor me jo counter pass kiya usko increment kre
        }
    }
}
public class TestSynchronization7 {
    public static void main(String[] args) {
        CounterSynchronization6 counter = new CounterSynchronization6();
        MyThreadSynchronization t1 = new MyThreadSynchronization(counter);//pass in constructor of MyThreadSynchronization object // t1 ki property counter set hogy h wth of constructor
        MyThreadSynchronization t2 = new MyThreadSynchronization(counter); // pass in constructor of MyThreadSynchronization object

        t1.start();
        t2.start();
        // 2 threads h t1 and t2 and common obj/resource share hora counter in both of them

        // in dono thread ko khtm krnah so use join on them // join throws exception so keep in try catch block

        try {
            t1.join();
            t2.join();
        }
        catch(Exception e){
            System.out.println(e);
        }

        // printing get count after both thread t1 and t2 is finished executing otw it will print at any instance and t1 t2 chalte rahenge if we dont give join method hence finish both threads
        System.out.println(counter.getCount());//less than 2000 as many times u run

        //bcoz both threads are running simultaneously at same time,dono threads ka counter.increment() will run at the same
        //bcoz we are sharing same object between multiple threads t1 and t2 counter can give incorrect result bcoz common data sharing happening
        // shared resource is accessed and modified in increment() method that part of program is ***CRITICAL SECTION*** (use synchronized waha pe
        // w/o synchronized keyword wrong result coming b'coz outcome dependent on the relative timing of threads as they were running concurrently so result unpredictable
        // w/o synchronized keyword its called ***RACE CONDITION***
        // mutiple threads working on shared resource and unki timing ulti seedi hori result also wrong
        // RACE CONDITION SE BACHA SAKTE H USING ~~~~synchronized keyword, taki ek baar me ek hi thread access krsakta us critical section ko called ***MUTUAL EXCLUSION***
        // MUTUAL EXCLUSION ENSURES THAT AT ONE TIME MULTIPLE THREADS SIMULTANEOUSLY DON'T ACCESS THE CRITICAL SECTION
        // MUTUAL MEANS --> RELATIONSHIP B/W MULTIPLE THREADS WHO WANT TO ACCESS SHARED RESOURCE // EXCLUSION --> MEANS ROKNA/ TO PREVENT

        // to make sure that at one time only 1 thread is accessing counter.increment() and the other thread will wait**** use synchronized keyword**** in increment method
        //with synchronized keyword now also object is 1 and being shared between 2 threads ti and t2 but synchronized keyword makes sure ki ek baar ek thread chala rahah us method ko dusra nhi chalaega
        //no need to synchronize entire method can also use synchronized block with (this) -› means of 1 instance jispe increment call hora h, if multiple threads r accessing it ek bar me ek hi thread access krpaiga

    }
}
