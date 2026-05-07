package Collection.Map;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class MainSortedMap {
    public static void main(String[] args) {
        //SORTEDMAP -> INTERFACE extends MAP, TREEMAP -> IMPLEMENTATION OF NAVIGABLE MAP(interface) AND NAVIGABLE MAP IMPLEMENTS SORTED MAP(interface)
        //SORTEDMAP IS AN INTERFACE THAT EXTENDS MAP (methods of map will come) AND GUARANTEES THAT THE ENTRIES ARE SORTED BASED ON THE KEYS, EITHER IN THEIR NATURAL ORDERING OR BY A SPECIFIED COMPARATOR(agar sort krna h on basis of keys use sortedMap)


        // hashmap -> not sorted
        // Linkedhashmap -> insertion order maintained with access order as false or true(lru)
        // weakHashmap -> weak reference GC
        // identityhashmap -> IDENTITYHASHCODE →> (Object class ka hashcode CHALEGA) AND == (equality check) not equals method

        // none of the map has sorted form on basis of // so use SortedMap -> keys ko sort knta natural ordering (Comparable Likha hua h iss class mein) //
        //or in TREEMAP GIVE COMPARATOR ALSO IN CONSTRUCTOR ITSELF WHILE CREATING SO SORTING HAPPENS ACC TO THAT

        // while creating Tree Map in constructor pass the comparator so it is sorted that way say descending bcoz natural order is ascending
        SortedMap<String, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        //if it was Student class instead of String write comparable implement in student or give comparator in bracket in here only in constructor
        // internal working of treeMap -> RED BLACK BALANCING BINARY SEARCH TREE SELF BALANCING BINARY SEARCH TREE ALL OPERATIONS IN O(log n) // in hashMap -> O(1)
        SortedMap<Integer, String> treeMap1 = new TreeMap<>((a,b)->b-a);
        treeMap1.put(91,"Cersei");
        treeMap1.put(99,"Jon");
        treeMap1.put(95,"Arya");
        // treeMap1. put (null, "Tyrion")://ERROR NULL POINTER EXCEPTION BCOZ SORT NHI HOGA KEY SE SORTED MAP h
        treeMap.get(99);
        treeMap.containsKey(95); // O(log n)
        treeMap.containsValue("Jon"); // O(n) kyuki yeh sorted nhi h value toh full traversal hence time complexity Linear
        // binary search tree regular unbalanced -> 010->020->030 right me jaoge bade hi hongi values to search 030 full traversal worst case 0(n)
        //RB Tree me 020
        //          /   \
        //         010   030                     yaha 030 right mein h O(log n)

        treeMap.put("Hitchcock",95);
        treeMap.put("Scully",90);
        treeMap.put("Holt",100);
        treeMap.put("Terry",99);

        System.out.println(treeMap); // calls toString() internally and sorts by key so lexicographically by dictionary order

        //Could have written Map<String,Integer> treeMap = new TreeMap<>(); but we wont get method of sorted map like firstKey lastKey headMap tailMap etc

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.headMap("Scully")); // excludes -> head se leke kaha tak ka data chaiye
        System.out.println(treeMap.tailMap("Holt")); // kaha se chaiye tail tak
        System.out.println(treeMap.subMap("Scully","Hitchcock"));

        System.out.println(treeMap1.headMap(91));//excludes
        System.out.println(treeMap1.tailMap(95));
        System.out.println(treeMap1.subMap(95,91));// bcoz its sorted in descending order of Integer
       // with sortedMap extra methods -> subMap (kaha se kaha tak). firstKey,lastKey,headMap ->  head se leke kaha tak ka data chaiye(toKey)/exclude key given, tailMap -> Kahase chaiye tail tak (fromKey)


        // TREEMAP extends AbstractMap AND implements NavigableMap AND NAVIGABLEMAP EXTENDS SORTED MAP SO SORTEDMAP AND NAVIGABLE MAP ARE INTERFACE AND TREE MAP IS IMPLEMENTATION OF NAVIGABLE MAP IN TURN OF SORTED MAP

        // NAVIGABLE MAP EXTENDS SORTEDMAP PROVIDING MORE POWERFUL NAVIGATION OPTIONS SUCH AS FINDING THE CLOSEST MATCHING KEY OR RETRIEVING THE MAP IN REVERSE ORDER


        NavigableMap<Integer,String> navigableMap = new TreeMap<>();

        navigableMap.put(91,"Cersei");
        navigableMap.put(99,"Jon");
        navigableMap.put(95,"Arya");

        System.out.println(navigableMap);//sorted form of keys
        navigableMap.descendingMap();//reverses the key in sorted order
        navigableMap.ceilingEntry(99);//returns full key value
        navigableMap.floorEntry(91);//returns full key value
        System.out.println(navigableMap.lowerEntry(95));// 95 se just lower key print returns greatest key strictly less than given key or null if no such value
        System.out.println(navigableMap.ceilingEntry(95));//returns least key greater or equal than given key
        System.out.println(navigableMap.higherKey(95));//Returns the least key strictly greater than the given key


        //DIFFERENCE BETWEEN SORTED MAP AND NAVIGABLE MAP -->
        //SORTED MAP TELLS THE RANGE USING METHODS (headMap,subMap,tailMap)
        //NAVIGABLE MAP TELLS THE CLOSEST MATCH(floorKey,ceilingKey,floorEntry, ceilingEntry)


    }
}
