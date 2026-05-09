package Collection.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class MainCollector {
    public static void main(String[] args) {
        //Like Arrays, Collections are utility class
        // COLLECTORS is a utility class
        // provides a set of methods to create common collectors

        //1. Collecting to a list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> a = names.stream().filter(x -> x.startsWith("A")).collect(Collectors.toList());
        System.out.println(a);

        //2. Collecting to a SET
        List<Integer> nums = Arrays. asList (1,2,2,3,4,4,5);
        Set<Integer> collect = nums.stream().collect(Collectors. toSet());
        System.out.println(collect); //removes duplicate and we get unique ele in set

        //3. Collecting to a specified collection
        //toCollection() --> takes in a SUPPLIER kuch lega nhi bs dega ham kisi bhi collection me convert kara sakte h stream ko
        // ArrayList or LinkedList or ArrayDeque
        ArrayDeque<String> collect1 = names. stream().collect(Collectors. toCollection(() -> new ArrayDeque<>()));

        //4. Joining Strings
        // CONCATENATES STREAM ELEMENTS INTO A SINGLE STRING
        // Collectors.joining() --> takes in a sperator or even nothing will join as is
        String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(", ")) ;
        System.out.println(concatenatedNames);

        //5. Summarising Data
        //Generate Statistical summary (count, sum, min, average, max)
        //summarizingInt --> takes in a ToIntFunction which is a FUNCTIONAL INTERFACE that has 1 abstract method as applyAsInt() kuch lega kuch dega
        List<Integer> numbers = Arrays.asList (2,3,5,7,11);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x->x));
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Min: " +stats. getMin());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Count: " + stats.getCount());

        //6. Calculating Average
        Double average = numbers.stream().collect(Collectors.averagingInt(x->x));
        System.out.println("Average: "+ average);

        //7.Counting Elements
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

        //8.  Grouping elements
        List<String> words = Arrays.asList("Hello", "world", "java", "streams", "collecting");
        //group krne h element 4 length k kitne words h 5 length ke kitne words h map me store karana

        //3 types to group by from ...
        // 1. Function jaiga classifier (decides konsa ele kis grp me jaiga)
        System.out.println(words.stream().collect(Collectors.groupingBy(x->x.length())));//length ke behalf pe inko bata dijive
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));//using method reference

        //2. classifier ke sath (decides konsa ele kis grp me jaiga), ek downstream collector jaiga (after grouping do u want to do anything with the grp)say joining/counting here

        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(", "))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));//{4=1, S=2, 7=1, 10=1}

        //3. classifier ke sath (decides konsa ele kis grp me jaiga), mapFactory(that can give specific map implementation), ek downstream collector jaiga (after grouping do u want to do anything with the grp) say joining/counting here
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap); //o/p same as above only but map sorted by key treeMap //{4=1, 5=2, 7=1, 10=1}

        //9. Partitioning Elements
        //Partitions elements into 2 groups (true and false) based on a predicate
        // 1. pass only predicate //2. pass predicate and downstream collector
        System.out.println(words.stream().collect(Collectors.partitioningBy(x->x.length()>5)));//{false=[Hello, world, java], true=[streams, collecting]}

        //10. Mapping and Collecting
        //Applies a mapping function before collecting
        //pass a function and a downstream collector --> means before collecting kuch kaam kara sakte h alag se map na Likh ke
        System.out.println(words.stream().collect(Collectors.mapping(x->x.toUpperCase(), Collectors.toList())));


        //Example 1. Collecting names by length
        List<String> l1 = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice"); //group krna h length se use groupingBy
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));


        //Example 2. Counting Word Occurences
        String sentence = "hello world hello java world"; //split and store in Arrays.stream
        // grouping criteria is word only hence x->x
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));


        //Example 3: Partitioning Even and Odd Numbers
        List<Integer> l2 = Arrays.asList (1,2,3,4,5,6);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x->x%2==0)));


        //Example 4: Summing Values in a map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);
        System.out.println(items.values().stream().reduce(Integer:: sum) .get());
        System.out.println(items.values().stream().collect(Collectors.summarizingInt(x->x)).getSum());

        //Collectors.SummingInt() ->Returns a collector that produces sum of a integer valued function applied to input elements
        // -> takes in a toIntFunction kuch lega kuch dega as is wapas bhejna
        System.out.println(items.values().stream().collect(Collectors.summingInt(x->x)));

        //Example 5 : Creating a Map from Stream Elements
        // Collectors.toMap()
        // fruit name is key and uska length is the value direct key value mapping chaiye
        List<String> fruits = Arrays.asList ("Apple", "Banana", "Cherry");
        Map<String, Integer> map = fruits.stream().collect(Collectors.toMap(x->x.toUpperCase(),x -> x.length()));
        System.out.println(map);

        //Example 6:
        //apple kitni bar aara and banana kitni bar aara so use toMap with mergeFunction
        // toMap -> there are duplicates -> need to give merge function (Binary operator)
        // jab apple fir se aaiga then merge function will run
        List<String> words2 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        //words2. stream().collect(Collectors. toMap(k->k,v->v)); // Exception duplicate key

        System.out.println(words2.stream().collect(Collectors.toMap(k->k,v->1, (x,y)->x+y))); // pehli bar aaya 1 rakh diya then dobara aega then merge function chlega then 1+1 then again 2+1....



    }
}
