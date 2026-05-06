package Collection.Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapMain {
    public static void main(String[] args) {
        //map -> seperate interface dont extend collection interface
        // in java map is an object that maps keys to values. It cannot contain duplicate keys, and each key can map to at most one value Think of it as dictionary where you look up the word(key) to find its definition (value)
        // key - unique

        // map -> dictionary -> key char ->
        //keyValue pair (2 chize store karana) , unique keys, no order-hashmap(some implementation maintain insertion order(LinkedHashMap), natural order (TreeMap)), one value per key
        //hashmap  ->  implementation class of map don't extend collection interface
        //hashmap  ->  implementation class of Map interface ->

        HashMap<Integer, String> map = new HashMap<>();
        //to add in map
        map.put(1, "Akshit");
        map.put(2, "Neha");
        map.put(3, "Shubham");
        System.out.println(map); //{1=Akshit, 2=Neha, 3=Shubham} any order follows

        //to fetch in map
        String student = map.get(1);
        System.out.println(student);
        String student2 = map.get(67); //67 key is not there hence null comes
        System.out.println(student2);

        //check if map contains a key return boolean
        System.out.println(map.containsKey(2));

        //check if map contains a value return value
        System.out.println(map.containsValue ("Shubham"));

        //run loop on map using map.keySet() or map.entrySet() which gives a SET (no duplicate list as all keys in map are unique)

        Set<Integer> keys = map.keySet();
        //loop through keys of the map to get the value
        for(int i : keys){
            System.out.println(map.get(i));
        }
        //NO ORDER FOLLOWS HASHMAP IN ANY OPERATION

        // write directly instead of creating variable
        for(int i : map.keySet()) {
            System.out.println(map.get(i));
        }

        //list of entries each entry has key and value
        Set<Map.Entry<Integer, String>>entries = map. entrySet();
        for (Map.Entry<Integer, String> entry: entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // all values in capital letter // set value in entry
        for (Map.Entry<Integer, String> entry: entries){
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(map);

        //key char of hashmap:
        // value can be null // key can be only 1 null because next null key will replace the old null key
        // not synchronized not thread safe requires external synchronization if used in a multi threaded context
        //O(1) constant time performance for basic operations like get and put assuming the hash function disperses elements properly

        //REPLACE
        map.put (null, "Vipul");
        map.put (null, "Ram"); //ram replaces vipul as key is null same can use null as key only once in map

        // to remove/delete a entry //2 overrided method one where we send key and one where we send key and value
        map.remove(3);
        System.out.println(map);

        boolean res = map. remove(3, "Nitin"); // wont remove/delete because nitin is not mapped to any key in the map, 3 mapped to shubham
        System.out.println("Removed? :" + res); //false //check if removed ??


        // List<Integer> list = Arrays.asList (2,3,4,56,78,31);
        // list.contains(3); // list will traverse one by one to search O(n) - linear search
        // map.containsKey(3) // map will be O(1) //OPTIMIZATION

        // Map fast because of internal structure of Hashmap.Hashmap

        // 4 basic components -
        // key (identifier used to retrieve the value),
        // value(data associated with the key),
        // bucket(-> internal array -> A place where key-value pairs are stored. Think of buckets as cells in a list(array)),
        // HashFunction (converts key to index(bucket location) and the key is stored in that index in the internal array/bucket)


        // hashFunction -> algorithm takes key as an input and return fixed size string of bytes numerical value output known as hash code /hash value/hash
        // hashFunction -> primary purpose -> map data of arbitrary size(any size) to data of fixed size
        //key characteristics - deterministic(same input always produce same output) -> fixed output size(regardless of input size output is of 32 bit or 64 bit) - efficient computation(hash function compute the hash quickly)


        //HOW DATA IS STORED IN HASHMAP (map.put)
        //1. HASHING THE KEY - key passed to hash function to generate unique hash code(integer no) which helps to determine where the key value pair will be stored in bucket array
        // map.put (3, "Shubham") //3 key will go to hash function and corresponding to this key hash code generated, hash code helps to find index in bucket array

        //2. CALCULATING THE INDEX - using hashcode put in formula -> int index = hashcode % arraysize
        // index decides which bucket will hold the key-value pair (default arraySize = 16) -> remainder is index

        //3. STORING IN THE BUCKET - Key value pair is stored in the bucket at calculated index
        // EACH BUCKET CAN HOLD MULTIPLE KEY VALUE PAIRS CALLED COLLISON HANDLING MECHANISM

        // map.put("apple", 50);
        // apple is key, 50 is value
        // hashcode of key apple is calculated with help of hash function
        // index is found using int index = hashcode % arraySize
        // key value pair ("apple",50) is stored in corresponding index in the bucket

        // HOW DATA IS RETRIEVED FROM HASHMAP (map. get)
        //1. HASHING THE KEY - key hashed using same hash function to calculate hashcode (SIMILAR TO INSERTION PUT)

        //2. FINDING THE INDEX - hashcode used to find index where key value pair is stored in the bucket array

        //3. SEARCHING IN THE BUCKET-Once correct bucket found checks for key in that bucket if it finds the key it return the associated value


        //why to search if we directly have index of that array??????????
        //bcoz to a hash function same input gives same output but 2 different input can also give same output called COLLISION BCOZ hash function produce finite no. of hash values only
        //bcoz of collision in our bucket array multiple key value pair are stored at 1 index same hashcode same index they are stored as LINKED LIST. LINKED LIST HAS POINTER TO NEXT VARIABLE(if more than 1 entry in map has same hashcode same index then linked list)



//        class Node<K,V>{
//            final int hash;
//            final K key;
//            V value;
//            Node <K,V> next;
//        }

        //EVERY INDEX HAS - KEY , VALUE, HASH(hashcode of key), NODE (pointer to next node in case of collision)

        // different keys can generate same hashcode same index hence till java8 uses linked lists to store multiple key value pair at 1 index
        // but after java8 it uses RED BLACK BALANCED BINARY SEARCH TREE(after insertion/deletion its always balanced )
        // BST because to retrieve a key value pair hashmap traverses through linked list checking each node until it finds a match if key is say at last node of linked list at a particular index of bucket array takes O(n) time more time (LINEAR SEARCH)
        // more time O(n) hence after Java 8 we Use RB Tree balanced bst O(logn) better performance than O(n)
        // linked list O(n) converted to rb tree(SELF BALANCING BINARY SEARCH TREE) O(log n) called TREEFICATION when entries in a particular index in bucket array is beyond certain threshold(8 ENTRIES)

        // linked list(O(n)) -> RB TREE (TREEFICATION) (O(logn)) WHEN ENTRIES > 8 (THRESHOLD) IN INDEX IN BUCKET ARRAY

        // map.put("apple",50);map.put("banana",30); map.put("orange",80); let say apple and orange key endup in same bucket due to hash collision. they will be stores in LINKED LIST
        // BUCKET 5: ("apple", 50) -> ("banana", 30)
        // WHEN WE DO map.get("orange"), Hashmap will go to Bucket 5 and then traverse

        // HASHMAP RESIZING -> REHASHING
        // hashmap internal array size = 16 (Default)
        // when no of elements grow and exceed load factor(default 0.75) hashmap automatically resize array to hold more data (doubles)called REHASHING
        // default array size = 16 . 16*0.75 = 12 if more than 12 elements are inserted hashmap resizes & array size doubled
        // jaise hi internal array ka size 12 se exceed hoga hashmap resize hojaiga ....

        // in hashmap constructor give the initial capacity and load factor
        HashMap<Integer, String> maps = new HashMap<> (17,0.5f) ;

        //17*0.5 = 8.5 array size › 8.5 array doubles hashmap resizes THE ARRAY SIZE IS DOUBLED

        // ALl existing entries rehashed ie positions are recalculated and placed in new array so ensures hashmap continue to perform efficiently as more data is added

        // map basic operation - 0(1) time (assuming no collision)
        // if collision - 0(n) time
        // after java 8 rb bst - O(Logn) time


        // TIMECOMPLEXITY
        // PUT -> 0(1) (avg case) (direct bucket access) -->O(logn) (worst case) (collision case RB tree - treeified bucket)
        // GET -> 0(1) (avg case) (direct bucket access) -->O(log n) (worst case) (collision case RB tree - treeified bucket)
        // remove -> 0(1) (avg case) (direct bucket access) -->O(log n) (worst case) (collision case RB tree - treeified bucket)
        //containsKey(key) -> 0(1) (avg case) (direct bucket access) -->O(log n) (worst case) (collision case RB tree - treeified bucket)

        // traverse all entries in containsValue no case of hashcode generation, linear search happens
        // containsValue(value) -> O(n) (avg case) (direct bucket access) -->O(n) (worst case)

        // in hashmap class size is stored in separate field (na key me iteration na value mein iteration) no need of iteration similarly isEmpty checks size only
        // size -> O(1) (avg case) --> O(1) (worst case)
        // isEmpty() →> O(1) (avg case) --> O(1) (worst case)








    }
}
