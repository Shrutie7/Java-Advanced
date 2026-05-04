package Collection.AtomicvsVolatile;


//VOLATILE --> JITNE BHI THREADS HAI UNKO DIRECTLY VALUE MAIN MEMORY SE UTHANI H YA WRITE KRNI H
// EK TIME PE 2 THREADS COUNTER KO BADHA SAKTE H NON BLOCKING H WAHI DIKKAT H 20000 KABHI NHI AAIGA
// BS THREAD KI LOCAL COPY NHI HOGI VARIABLE KI, BS SIMPLE FLAG/STATE(TRUE/FALSE) KE CASE ME USE KRNA VOLATILE KO

//ATOMICITY -->An operation is done completely by one thread without interruption from other threads.
//Java provides Atomic classes to make operations atomic.
//HAR EK OPERATION ISOLATE RHE EK BAR ME EK HI THREAD ACCESS KRE (KYUKI 2 THREAD COUNTER KO EK SATH ACCESS KRRI)

import java.util.concurrent.atomic.AtomicInteger;

//WE CAN USE SYNCHRONIZED/LOCK/ATOMIC class given by java --›(Atomic Integer/Atomic Long etc) ensure ATOMICITY/ISOLATION W/O USING LOCKS
//ATOMIC CLASSES IN JAVA --> THREAD SAFE (ek bar me ek hi thread kam krega)
public class VolatileCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    private void increment() { counter.incrementAndGet();}// inbuilt method h yeh incrementAndGet()}
    private int getCounter() {return counter.get();} // inbuilt method h yeh get()
    public static void main(String[] args) throws InterruptedException {

        VolatileCounter vc = new VolatileCounter();

        //2 writer threads hai
        Thread t1 = new Thread (()-> {
            for (int i = 0; i < 10000; i++) {
                vc.increment();
            }
        });

        Thread t2 = new Thread (()-> {
            for (int i = 0; i < 10000; i++) {
                vc.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(vc.getCounter());  // will not give you 20000 that's issue with volatile its not BLOCKING



    }
}
