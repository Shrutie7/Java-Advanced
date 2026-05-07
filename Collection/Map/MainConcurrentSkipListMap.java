package Collection.Map;

import java.util.concurrent.ConcurrentSkipListMap;

public class MainConcurrentSkipListMap {
    public static void main(String[] args) {
        //TO STORE KEYS IN SORTED MANNER AND THREAD SAFE

        // MAP --> SORTED --> THREAD SAFE --> ConcurrentSkipListMap

        // ConcurrentSkipListMap data store in data structure called SKIPLIST
        // LIKE IN NORMAL MAP HASHMAP DATA STORED IN ARRAYS
        // HASHMAP -> ARRAYS
        // TREEMAP -> RB TREE SELF BALANCING BINARY SEARCH TREE
        // ConcurrentSkipListMap -> SORTED MANNER DATA STORE AND CONCURRENCY ACHIEVED --> SYNCHRONIZED/THREAD-SAFE TREE MAP

        //list -> 1,2,3,4,5,6,7,8,9
        //skiplist -> PROBABILISTIC DATA STRUCTURE THAT ALLOWS FOR EFFICIENT SEARCH, INSERTION AND DELETION OPERATION
        //                   IT IS SIMILAR TO SORTED LINKED LIST BUT WITH MULTIPLE LAYERS THAT SKIP OVER PORTIONS OF THE LIST TO PROVIDE FASTER ACCESS TO ELEMENTS

        // -->SORTED -->MULTIPLE LAYERS/LEVELS --> FAST ACCESS
        //1 5 9
        //1 3 5 7 9
        //1 2 3 4 5 6 7 8 9
        //MULTIPLE LAYERS OF LINKED LIST TOP MOST LAYER MANY ELE SKIP, BELOW THAT LESS ELE SKIP, BELOW THAT NOTHING SKIP

        // SEARCH -- SAY 2 GO TO LEVEL 1 SEE 1 GO TO RIGHT SEE 5 SO ON LEFT OF IT (NOTHING), GO TO LEVEL 2 SEE 1 GO TO RIGHT SEE 3 (NOTHING) SO ON LEFT OF IT, GO TO LEVEL 3 SEE 1 THEN 2 FOUND
        // TIME COMPLEXITY →> O(logn) better than linear search
        // why new data structure skip list why not use treemap??? -> rb tree SELF BALANCING BINARY SEARCH TREE bcoz complex algorithms to balance no need of that bcoz skiplist is not strict
        //to insert say 3.5 there is no 100% surity which layer it will affect here so things are random no strictness new ele come usually 50% probability it goes to upper layer
        //in RB TREE - CONSTANT REBALANCING SO THINGS ARE NOT UNBALANCED -> WORST CASE O(n) complexity but here things are random in skiplist

        // skiplist -› to make things simpler data storage simpler bcoz we want to achieve concurrency

        //ConcurrentSkipListMap -→> key value pair stored in skiplist data structure
        // node -> key value hash next.... will be stored in skiplist data structure
        ConcurrentSkipListMap<String, Integer> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        //ConcurrentSkipListMap implements ConcurrentNavigableMap which extends ConcurrentMap, NavigableMap(for navigation-> matching lowerkey..)

        //METHODS LIKE IN NAVIGABLE MAP // CAN USE IN MULTI-THREADED ENVIRONMENT -- usecase
        concurrentSkipListMap.put("Apple", 1);

        //**********************************************REVISION******************************************//
        // to sort -> TREE MAP (range nikalni h)
        // closest/matching (firstEntry,lastEntry) --> Navigable Map INTERFACE IMPLEMENTED BY TREE MAP CLASS
        // Concurrency in Hashmap --> CONCURRENT HASHMAP --> concurrent version of HASHMAP
        // SORTED AND CONCURRENCY --> ConcurrentSkipListMap --> concurrent version of TREEMAP
        // ************************************************************************************************//


    }
}
