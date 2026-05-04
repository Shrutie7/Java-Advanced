package Collection.Set;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class MainSet {
    public static void main(String[] args) {
        //SET IS A COLLECTION THAT CANNOT CONTAIN DUPLICATE ELEMENTS Unlike list arraylist linkedlist
        // works on principle of hashmap -› insert/find 0(1) complexity faster operations
        // Map-> interface --> implementation -> HashMap, LinkedHashMap, TreeMap, EnumMap
        // Set-> interface --> implementation -> HashSet, LinkedHashSet, TreeSet, EnumSet --> all are not thread safe
        Set<Integer> set = new HashSet<>();

        //hashset internal working similar to hashmap
        // difference from hashmap value koi hai nhi toh dummy value padi hoti h so only keys there no value
        Map<Integer, String> map = new HashMap<>();
        Set<Integer> integers = map.keySet();
        // keys of hashmap is set only bcoz hashmap keys are also unique

        //methods in set--> list wale bcoz SET EXTENDS Collection --> put ke jagah add
        set.add(12) ;
        set.add(1);
        set.add(1);//wont add duplicate in set wont give error also
        set. add (67);
        System.out. println(set); //random order
        // 1. unordered output just like in hashmap in hashset also
        // 2. for ordered output use LinkedHashSet which has same internal working internally linked list that maintains order
        Set<Integer> set1 = new LinkedHashSet<>();
        set1.add(12);
        set1.add(1);
        set1.add(1);//wont add duplicate in set wont give error also
        set1.add(67);
        System.out.println(set1); //order maintained

        // set1.addAll()adds another set/collection to this set if not already present (dont allow duplicates)
        //addAll

        //3. TreeSet
        // implement navigable set so more methods come in cieling floor higher etc
        // sorted manner me set > natural ordering -› ascending
        // reference can be SORTED SET OR NAVIGABLE SET OR SET (bcoz navigable set extends sorted set)
        Set<Integer> set2 = new TreeSet<>();
        set2.add (12);
        set2.add(1);
        set2.add(1);//wont add duplicate in set wont give error also
        set2.add(67);
        NavigableSet<String> set3 = new TreeSet<>();
        set3.add ("Shruti");
        set3.add ("Sakshi");
        set3.add ("Shyam");
        set3. add("Anuradha");
        System.out.println(set2);
        System.out.println(set3);
        System.out.println(set2.remove(67));
        set2.clear();//pura set empty
        System.out.println(set2.isEmpty());
        for(int i: set2) {
            System.out.println(i); //nothing come set2 cleared
        }
        for (String i : set3){
                System.out.println(i);
        }

        //all method similar to hashmap Linkedhashmap treemap except put is add here //contains remove clear size isEmpty etc there
        // hashcode equals everything similar here

        // 4. EnumSet
        // works similar to EnumMap


        //none of this set is threadSAFE
        // THREAD SAFETY --> koi bhi map synchronize --› Collections.synchronizedMap (collections is STATIC CLASS) which takes map interface (implementation class can be anything HashMap, LinkedHashMap, treeMap, enumMap etc)
        // koi bhi set synchronize --> Collections.synchronizedSet() in its constructor pass the set itself u created

        Set<Integer> integers1 = Collections.synchronizedSet(set); //integers1 set is synchronized // original set not synchronous
        //EXTERNAL SYNCHRONIZATION passed set is wrapped in Synchronized block all operations are blocking until 1 thread is working another thread will not even come --> NO PERFORMANCE AT ALL

        // IF U PASS TREESET set2/set3 there RB tree will come more complexity so dont use Collections.synchronizedSet(set) thats y not used in map also
        // use concurrentSkipListSet //for built in thread safety and sorted order instead of Collections.synchronizedSet(set)
        // concurrentSkipListSet implements NavigableSet

        NavigableSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        //reference can be NavigableSet or Set

        // BELOW NOT RECOMMENDED
        Set<Integer> syncSet = Collections.synchronizedSet(new TreeSet<>());

        //just to loop we have to use synchronized loop all methods of treeSet are wrapped in Synchronized block
        synchronized (syncSet){
            for (int i : syncSet) {
                System.out.println(i);
            }
        }

        //unmodifiable set
        // set.of
        Set<Integer> integers2 = Set.of(1, 2, 3, 4, 5);
        //in map.of limitation was 10 entries but in Set.of it can allow unlimited values
        Set<String> integers3 = Collections.unmodifiableSet(set3); // set3 is immutable set
    }
}
