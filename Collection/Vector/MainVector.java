package Collection.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class MainVector {
    public static void main(String[] args) {

        //VECTOR
        // part of java.util package and is one of the legacy classes in java that implements the List interface
        // introduced in JDK 1.0 before collection framework and is synchronized making it thread-safe
        // now its part of collection framework
        // HOWEVER DUE TO SYNCHRONIZATION OVERHEAD(PROCESSING MORE, MEMORY MORE) ITS GENERALLY RECOMMENDED TO USE ARRAYLIST IN SINGLE THREADED SCENARIOS
        // despite this VECTOR STILL USEFUL in certain situations, particularly in multi-threaded environments where thread safety is a concern

        //Key features:
        //1. DYNAMIC ARRAY: Like Arraylist Vector is dynamic array that grows automatically when more elements are added than its current capacity
        //2. SYNCHRONIZED : All methods in vector are synchronized, which makes it thread safe This means multiple threads can work on a Vector without the risk of corrupting data
        // However, this introduces performance overhead in single threaded environments
        //3. LEGACY CLASS : Vector was part of Java's original release and is considered a legacy class. Its generally recommended to use ArrayList in single threaded environments due to performance considerations
        //4. RESIZING MECHANISM: When the current capacity of vector is exceeded, it *doubles**(*2) its size by default (or increases by a specific capacity increment if provided)
        // 5. RANDOM ACCESS: Similar to Array and ArrayList, vector allows random access to elements, making it efficient for accessing elements using an index.


        //Constructors of Vector(4)
        //1. Vector(): Creates a vector with an initial capacity of 10 //like ArrayList
        // 2. Vector(int initialCapacity): Creates a vector with a specified initial capacity
        // 3. Vector(int initialCapacity, int CapacityIncrement): Creates a vector with a specified initial capacity and capacity increment(how much the vector should grow when its capacity is exceeded)
        // 4. Vector(Collection‹? extends E> c) : Creates a vector containing the elements of the specified collection

        Vector<Integer> vector = new Vector<>(11); //initial capacity by default = 10, we gave initial capacity as 11

        // unlike ArrayList(doing by reflection) vector has method to check capacity
        System.out.println(vector.capacity());

        //can give capacity increment also
        Vector<Integer> vector1 = new Vector<>(5);
        vector1.add(1);
        vector1.add(1);
        vector1.add(1);
        vector1.add(1);
        vector1.add(1);
        System.out.println(vector1.capacity());//5
        vector1.add(1);
        System.out.println(vector1.capacity()); //10 when we add more ele the array internally doubles(*2) so then capacity becomes 10 unlike ArrayList(1.5 times)

        // to not double we want to increment by specific no
        // initial capacity + capacity imcrement // give in constructor
        Vector<Integer> vector2 = new Vector<>(5,3); //5+3 = 8 once more than 5 ele is added

        vector2.add(1);
        vector2.add(1);
        vector2.add(1);
        vector2.add(1);
        vector2.add(1) ;
        System.out.println(vector2.capacity());//5
        vector2.add(1);
        System.out.println(vector2.capacity()); //8 = 5+3 (as more than 5 ele added)
        vector2.add(1);
        vector2.add(1);
        System.out.println(vector2.capacity());//8
        vector2.add(1);
        System.out.println(vector2.capacity()); //8+3 = 11 (as more than 8 ele added)

        //SO IF WE DONT GIVE THE CAPACITY INCREMENT IT WILL DOUBLE EVERYTIME

        //PASS A COLLECTION -> whether thats an ArrayList or Linked List
        Vector<Integer> vector3 = new Vector<>(Arrays.asList (1,2,3));
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        Vector<Integer> vector4 = new Vector<>(linkedList);
        System.out.println(vector4); // internally toString method chal jata h [1,2,3] print hojaiga

        for (int i = 0; i < vector3.size(); i++) {
            System.out.println(vector3.get(i));
        }
        System.out.println(linkedList.isEmpty());

        //METHODS in vector
        //1. add(E e) : Adds an element at end
        //2. add (int index, E element) : Inserts an element at the specified index
        //3. get(int index) : Retrieves the element at the specified index
        // 4. set(int index, E element) : Replaces the element at the specified index
        // 5. remove(Object o) : Removes the first Occurrence of the specified index (or give index)
        //6. size() : Returns the number of elements in the vector
        // 7. isEmpty() : Checks if vector is empty // can do on ARRAYLIST AND LINKEDLIST ALSO
        // 8. contains(Object o): Checks if the vector contains the specified element
        //9. clear(): Removes all elements from the vector // can do on ARRAYLIST AND LINKEDLIST ALSO

        linkedList.clear();
        vector3.clear();
        System.out.println(vector3); //[]

        // INTERNAL IMPLEMENTATION OF VECTOR
        // INTERNALLY VECTOR USES AN ARRAY TO STORE ITS ELEMENTS, THE SIZE OF THE ARRAY GROWS AS NEEDED WHEN MORE ELEMENTS ARE ADDED.
        // THE DEFAULT BEHAVIOUR IS TO DOUBLE THE SIZE OF ARRAY WHEN IT RUNS OUT OF SPACE. THIS RESIZING OPERATION IS COSTLY ONE, AS IT REQUIRES COPYING THE OLD ELEMENTS TO THE NEW LARGER ARRAY


        // SYNCHRONIZATION AND PERFORMANCE
        // SINCE ALL VECTOR METHODS ARE SYNCHRONIZED, IT ENSURES THAT ONLY ONE THREAD CAN ACCESS THE VECTOR AT A TIME
        // THIS MAKES IT THREAD SAFE BUT CAN INTRODUCE PERFORMANCE OVERHEAD IN A SINGLE THREADED ENVIRONMENTS BCOZ SYNCHRONIZATION ADDS LOCKING AND UNLOCKING COSTS

        //IN MODERN JAVA APPLICATIONS, ARRAYLIST IS GENERALLY PREFERRED OVER VECTOR WHEN SYNCHRONIZATION ISN'T REQUIRED.
        // FOR THREAD SAFE COLLECTIONS, THE ********CopyOnWriteArrayList or *****ConcurrentHashMap from the java.util.concurrent package is often recommended instead.



        // SUMMARY
        // 1. VECTOR IS A LEGACY SYNCHRONIZED COLLECTION CLASS THAT IMPLEMENTS THE LIST INTERFACE
        // 2. IT BEHAVES LIKE A DYNAMIC ARRAY AND GROWS AS NEEDED
        // 3.IT PROVIDES THREAD SAFETY BUT WITH A PERFORMANCE COST IN SINGLE THREADED ENVIRONMENTS
        //4. IN MODERN APPLICATIONS, ARRAYLIST OR CONCURRENT ALTERNATIVES LIKE CopyOnWriteArrayList ARE TYPICALLY PREFERRED OVER VECTOR UNLESS THREAD SAFETY IS A PRIORITY

        // THREAD
        ArrayList<Integer> arrayList = new ArrayList<>();
        Vector<Integer> vector5 = new Vector<>();
        Thread t1 = new Thread(()-> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(1);
                vector5.add(1);
            }
        });
        Thread t2 = new Thread(()-> {
             for (int i = 0; i < 1000; i++) {
                    arrayList.add(1);
                    vector5.add(1);
                }
            });

        t1.start();
        t2.start();

        try{
        t1.join();
        t2.join();
    }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Size of list " + arrayList.size()); //0N RUNNING GIVE 1566 then on running again give 1830,
        // means ARRAYLIST NOT THREADSAFE AT SAME TIME BOTH THREADS ARE ACCESSING THE LIST THEREFOR NOT 2000 ek instant pe dono t1 and t2 ne list ka access liya abd ek sath add chalaya

        // change ARRAYLIST to VECTOR immediately you will see 2000
        System.out.println("Size of list " + vector5.size()); // 2000

    }
}
