package Collection.HashTable;

import java.util.HashMap;
import java.util.Hashtable;

public class MainHashTable {
    public static void main(String[] args) {
        //HASHTABLE present since JDK 1.O even before collection framework was there
        // HASHTABLE -> IMPLEMENTS MAP JUST LIKE HASHMAP
        // HASHTABLE IS SYNCHRONIZED
        // NO NULL KEY OR VALUE
        // LEGACY CLASS, REPLACED BY ConcurrentHashMap
        // slower than Hashmap -> bcoz of synchronized bcoz of overhead thread safety multithreading achieve (just like in vector)
        // internal working similar to hashmap TO RETRIEVE OR STORE bucket array index is found and stored there and here after the threshold of 8 also in array
        // STORES IN LINKED LIST ONLY NO RB TREE HERE(EVEN AFTER THRESHOLD OF 8) IN CASE OF COLLISION
        // ALL METHODS ARE SYNCHRONIZED INCLUDING GET (READ)
        // create hashtable just like map

        Hashtable<Integer,String> hashtable = new Hashtable<>();
        hashtable.put(1,"Apple");
        hashtable.put(2, "Banana");
        hashtable.put(3, "Grapes");
        System.out.println(hashtable);
        System.out.println(hashtable.get (2));
        System.out.println(hashtable.containsKey(1));

        hashtable.remove(1);
        System.out.println("After removing key 1: "+hashtable);
        //containsKey containsValue, putIfAbsent, putAll, computeIfAbsent (takes a function) -›java 8 -> all methods of map bcoz implements map

        //NEITHER KEY NULL NOR VALUE NULL THROWS NULL POINTER EXCEPTION
        // hashtable.put(null,"value"); //THROWS EXCEPTION
        // hashtable.put (4, null); // THROWS EXCEPTION


        // CONCURRENCY
        HashMap<Integer, String> map = new HashMap<>();
        Hashtable< Integer, String> hashtable1 = new Hashtable<>();
        Thread t1 = new Thread (()-> {
            for (int i = 0; i < 1000; i++) {
                map.put(1, "Thread1");
                hashtable1.put(1, "Thread1");
            }
        });

        Thread t2 = new Thread(()-> {
            for (int i = 1000; i < 2000; i++) {
                map.put(1, "Thread2");
                hashtable1.put(1, "Thread1");
            }
        });

        //start the thread

        t1.start();
        t2.start();

        //join krenge khatam hone ka wait krenge
        try {
        t1.join();
        t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final size of hashmap " + map.size());// everytime run kre different aega bcoz hashmap is not thread safe bcoz at same time t1 and t2 is running
        // hence size 2 baar nhi badh ke ek bar hi badh rhi 1 hi entry hori dono hona tha size should have been 2000
        //jab t1 use kna tha map tab lock lag jana chaiye tha so t2 use na kre same time pe

        System.out.println("Final size of hashTable " +hashtable1.size());//2000 bcoz hashTable is ThreadSafe!
        // ALL METHODS IN HASHTABLE ARE SYNCHRONIZED INCLUDING GET

        // EK BAR ME EK HI THREAD READ KRSAKTA HASHTABLE KO - LIMITATION ALSO FOR READ ALSO
        // even read method get is also locked in hashtable hence concurrentHashMap came which doesnt have lock in simple read or get method


    }
}
