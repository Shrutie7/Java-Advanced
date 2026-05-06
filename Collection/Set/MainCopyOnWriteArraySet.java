package Collection.Set;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class MainCopyOnWriteArraySet {
    public static void main(String[] args) {

        //hashset linkedhashset treeset -> not thread safe if multiple threads tries to modify DATA CORRUPTION AND CONCURRENT MODIFICATION EXCEPTION COMES....
        // concurrentSkipListSet -> with this also we get concurrency but it is sorted form / To use range based operation (larger than this element/smaller than this element)so use case is different -> uses skipList data structure

        // copyWriteArraySet -> internal ARRAY / not stored in sorted manner different use case

        // THREAD SAFE
        //COPY-ON-WRITE MECHANISM -> on every add/update new copy of internal array is created every write operation creates a new copy
        // NO DUPLICATE ELEMENTS →> BCOZ SET
        // ITERATORS DO NOT REFLECT MODIFICATIONS -> BCOZ ONCE LOOP ENDS THEN ONLY LATEST MODIFICATION WILL REFLECT BCOZ LOOP OLD COPY OF ARRAY PE CHAL RAHA (STABLE) -> PURANI = NEW (LOOP SE NIKALNE KE BADH)

        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        for (int i = 1; i <= 5 ; i++) {
            copyOnWriteArraySet.add(i);
            concurrentSkipListSet.add(i);
        }

        System.out.println(copyOnWriteArraySet);
        System.out.println(concurrentSkipListSet);

        for(Integer num : copyOnWriteArraySet) {
            System.out.println("Reading from copyOnWriteArraySet: " + num); // 6 will not print bcoz iteration happens on stable photo outside Loop u will see 6 added
            copyOnWriteArraySet.add(6);
        }
        System.out.println(copyOnWriteArraySet);


        for (Integer num : concurrentSkipListSet) {
            System.out.println("Reading from concurrentSkipListSet:" + num); // 6 will print also ** THATS Y concurrentSkipListSet CALLED WEEKLY CONSISTENT BCOZ WHILE ITERATION MAY OR MAY NOT REFLECT
            // concurrentSkipListSet.add (6);

            if (num == 5) {
                concurrentSkipListSet.add(6); // now 6 will not print weekly consistent wont get CONCURRENT MODIFICATION EXCEPTION bcoz using concurrentSkipListSet
            }
        }

        //MORE WRITE OPERATION -> copyOnWriteArraySet not useful bcoz every write will make a new copy high memory consumption
        // READ INTENSIVE AND LESS WRITE /iterate on stable photo->copy0nWriteArraySet

        // FREQUENT READ AND WRITE --›concurrentSkipListSet (BALANCE)



    }
}
