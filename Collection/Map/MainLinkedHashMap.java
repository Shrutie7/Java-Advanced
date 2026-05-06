package Collection.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MainLinkedHashMap {
    public static void main(String[] args) {
        //LINKEDHASHMAP ->  EXTENDS HASHMAP AND IMPLEMENTS MAP - SUBCLASS OF HASHMAP
        // hashmap there is NO ORDER, but in LINKEDHASHMAP ORDER MAINTAINED (main difference b/w hashmap and Linked hashmap)

        //LINKEDHASHMAP -> DOUBLE LINKED LIST HOTI H WHICH KEEP ALL ENTRIES IN IT (JIS ORDER ME INSERT KRI H) (ALONG WITH ARRAY LIKE HASHMAP)
        // IS DOUBLY LINKED LIST KO USE KRTA H LinkedHashMap to store the insertion order hence LinkedHashMap thora slow h (bcoz of overhead of double linked list memory more) compared to HASHMAP
        // but time complexity is O(1) only for linkedHashMap use LinkedHashmap jab ORDER MATTER KRTA H
        // JUST LIKE HASHMAP IN CONSTRUCTOR GIVE INITIAL CAPACITY AND LOAD FACTOR (internal array ka size kab double krna h jab 11*0.8 = 8.8 se Zyada ho then)
        //in constructor in LinkedHashMap there is 3 thing can be given initialCapacity, loadFactor, accessOrder -> the ordering mode -> true-> for access order, false-›for insertion order(by default)

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11, 0.8f, true); // double linked list

        linkedHashMap.put("apple", 20);
        linkedHashMap.put("banana", 30);
        linkedHashMap.put("guava", 40);
        linkedHashMap.get("apple"); // ACCESS REACHES END, BCOZ ACCESSORDER TRUE IN CONSTRUCTOR OF LINKEDHASHMAP IT GOES TO END OF LINKEDHASHMAP WHEN WE PRINT SO INSERTION ORDER IS NOT MAINTAINED

        linkedHashMap.get("banana");//pehle guava then apple then banana, jo latest get kiya h wo last me aaiga
        // THIS ALGORITHM IS LEAST RECENTLY USED -> KEEP TRACK OF ELEMENTS WHICH ARE LEAST RECENTLY ACCESSED OR OLD JO CHIZ USE NHI HORI USKO UPAR RAKHTE H TAKI USKO REMOVE KR SAKE(LIKE GUAVA)
        linkedHashMap.get("guava");
        linkedHashMap.get("apple");
        linkedHashMap.get("banana");
        linkedHashMap.get("apple");
        linkedHashMap.get("guava");

        //aise me pata krna mushkil h which is least recently used toh use ****access order true and LinkedHashMap**** so in this case banana will come at top and we can remove it easily
        //if more data is there pata kena mushkil h least recently used konsa h

        //CACHING -> CACHE EVICTION STRATEGY →> if we start saving everything in cache disk full hojaigi so remove least recently used
        Set<Map.Entry<String, Integer>> entries = linkedHashMap.entrySet();
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        //CAN ALSO CREATE LINKEDHASHMAP FROM HASHMAP IN CONSTRUCTOR PASS HASHMAP

        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap<>(hashMap);
        hashMap.put("Shubham", 20);
        hashMap.put("Bob", 30);
        hashMap.put("Akshit", 40);

        //TO HANDLE EDGE CASES →> getOrDefault and putIfAbsent method in HASHMAP AND ALSO IN LINKEDHASHMAP all hashmap methods can also be used in LINKEDHASHMAP
        //Linkedhashmap also NOT THREAD SAFE LIKE HASHMAP

        //getOrDefault method -> agar hashmap me key shubham aati h toh uski value return krdo nhi h toh 0 return krdo.
        Integer res = hashMap.getOrDefault("Shubham", 0);
        // Integer res = hashMap. getOrDefault ("Vipul", 0);
        System.out.println(res);


        //putIfAbsent method ->nhi h hashmap me tab daliye
        hashMap.putIfAbsent("Shubham", 92); //put-> method replace krdega wo entry ko
        System.out.println(hashMap);//put nhi hoga bcoz already Shubham there in hashmap

        Set<Map.Entry<String,Integer>> entrie = hashMap. entrySet();
        for (Map.Entry<String, Integer> entry:hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
