package Collection.Map;

import java.util.LinkedHashMap;
import java.util.Map;


public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    //make public constructor
    private int capacity;
    public LRUCache (int capacity){
        super (capacity, 0.75f, true); //call parent ka constructor and usme capacity and load factor and access order pas krenge
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry (Map.Entry<K, V> eldest) { return size()>capacity;}

    public static void main(String[] args) {
        // make LRU CACHE AS map WITH 3 entries there if 4th entry comes then least recently used entry hat jaye

        // make subclass of LINKEDHASHMAP hence extend it

        LRUCache<String, Integer> studentMap = new LRUCache<> (3) ;
        //LRUCache class extends LinkedHashMap which extends hashMap hence LUCache class will have all methods of both hashmap and linkedHashMap
        studentMap.put("Bob", 99);
        studentMap.put("Alice", 89);
        studentMap.put("Ram", 91);
        //studentMap.get ("Bob");
        studentMap.put("Bob", 100);
        studentMap.put("Vipul", 89);

        System.out.println(studentMap);

        //to do LRUCache override a method removeEldestEntry which is there in LinkedHashMap this method returns true and write a condition within that whenever true return from the method last entry is removed
        //so size (seperate field) is 4 and capacity in constructor is 3 so when vipul is added bob which is least recently used will removed on printing studentMap

        // removeEldestEntry tabhi chal jaiga when we do put vipul that moment itself Bob is removed but if we do get bob just before put of vipul then alice becomes LEAST RECENTLY USED and Alice Removed
        studentMap.get("Bob");

        //use krre h get se use ham put se bhi kr sakte h say to replace
    }
}
