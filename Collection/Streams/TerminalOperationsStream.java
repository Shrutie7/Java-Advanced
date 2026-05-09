package Collection.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsStream {
    public static void main(String[] args) {
        //terminal operation --> stream se result nikalna

        // 1. collect
        // takes in collector --> Collectors.toList() --> returns a collector that accumulates input elements into a new list, Collectors.toSet() for set, Collectors.tounmodifiableList
        // can write directly .tolist also

        List<Integer> list = Arrays.asList (1,2,3);

        list.stream().skip(1).collect(Collectors.toList());
        //can also use directly .toList() depending on java version
        list.stream().toList();
        //. toList() accumulates elements of stream into a list, list is unmodifiable
        // toList and collect() termination operation

        //2. forEach
        // kuch lega kuch dega nhi
        list. stream().forEach(x-> System.out.println(x));

        //3. reduce: Combines elements to produce a single result // returns OPTIONAL value // use .get() method to get the value otw u wont get answer
        // reduce takes in a binary operator--> bifunction 2 same type param and same type ka o/p same return type
        // SUM CALCULATE KRRE
        // also called ACCUMULATOR
        // can convert lambda expression to method reference

        Optional<Integer> optionalInteger = list.stream().reduce((x,y)->(x+ y)); // OPTIONAL TYPE KA INTEGER COMES --> OPTIONAL --> MAY OR MAY NOT HAVE VALUE IN IT
        Optional<Integer> optionalInteger1 = list.stream().reduce (Integer:: sum); //call sum method on Integer class
        // to get the optionalInteger use .get() method
        System.out.println(optionalInteger.get());

        //4. count

        // 5. anyMatch, allMatch , noneMatch
        // ALL ARE SHORT CIRCUIT TERMINAL OPERATION - AS SOON AS THEY FIND SOMETHING THEY STOP PROCESING ELEMENTS FURTHER

        // anyMatch --> takes in a PREDICATE checks condition returns boolean
        // check if *any* no in stream is even
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);//true

        // allMatch --> takes in a PREDICATE checks condition returns boolean
        // checks if all no in stream is satisfying this condition
        boolean b1 = list.stream().allMatch(x -> x>0);
        System. out .println(b1); //true

        // noneMatch --> takes in a PREDICATE checks condition returns boolean
        // returns true if no element satisfy this predicate
        boolean b2 = list.stream().noneMatch(x -> x < 0);
        System.out.println(b2);//true

        //6. findFirst, findAny -> bring any element
        // ALL ARE SHORT CIRCUIT TERMINAL OPERATION --> AS SOON AS THEY FIND SOMETHING THEY STOP PROCESSING ELEMENTS FURTHER
        // returns Optional<Integer>
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        //7.toArray()
        // Stream ko convert to Array and to terminate also
        Stream.of(1,2,3).toArray();

        //8.min / max
        // TAKES IN A COMPARATOR // use .get() also bcoz returns a Optional
        System.out.println("max: "+ Stream.of(2,44,69).max((x,y)->y-x).get()); // descending me sort so ulta hoge max doesnt mean max always bcoz its akhri element here 2
        System.out.println("min: "+ Stream.of(2,44,69).min(Comparator.naturalOrder()).get());

        //9. forEachOrdered
        // for PARALLEL STREAM when using parallel stream forEach loop will run randomly in arbitary manner but to run in order in case of parallel stream
        List<Integer> numbers0 = Arrays.asList (1,2,3,4,5,6,7,8,9,10);
        System.out.println("Using forEach with parallel streams"); numbers0.parallelStream().forEach(System.out::println); // no order at all

        numbers0.parallelStream().forEachOrdered(System.out::println);// order me aaiga 1,2,3, 4,5,6,7,8,9,10 parallelly chal ri h order me hori


        // Examples
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");

        //1. find all names in list whose length is greater than 3
        System.out.println(names.stream().filter(x->x.length()>3).collect(Collectors.toList())); // directly .toList() instead of .collect(Collectors.toList())

        //2. Squaring and sorting numbers
        List<Integer> numbers = Arrays.asList(5,2,9,1,6);
        System.out.println(numbers.stream().map(x->x*x).sorted().collect(Collectors.toList())); // directly .toList() instead of .collect(Collectors.toList())

        // 3. Summing values
        List<Integer> num = Arrays.asList (1,2,3,4,5);
        System. out. println(num.stream().reduce(Integer:: sum).get());

        //4. Counting occurence of Character
        String sentence = "Hello World";

        //1.
        List<String> sentenceList = Arrays.asList(sentence.split(""));
        System.out.println(sentenceList.stream().filter(s->s.equals("l")).count());

        //2.
        System.out.println(sentence.chars().filter(c->c=='l').count()); // .chars()--> CONVERT STRING TO INSTREAM so to avoid split and creating List<String>


        //3.
        // Arrays.stream(): //dont have anything Like Character that goes in param hence we have chars() that CONVERT STRING TO INSTREAM integer stream

        // source --> convert to stream --> use intermediate operation (filter, map) --> use terminal operation (count, reduce, toList(), collect)
        // intermediate operation wont execute until terminal operation is invoked

        //EXAMPLE
        // ***************STREAMS CANNOT BE REUSED AFTER A TERMINAL OPERATION HAS BEEN CALLED************ throws exception
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println); // sout is shortcut in intellij for method reference
        //List<String> list1 = stream.map(String::toUpperCase).toList(); // throws EXCEPTION bcoz forEach is terminal operation that has been already ran on stream
        // u already closed the stream using forEach again opening it with another terminal operation


        //stateful & stateless operation
        // stateless - ek bar me ek element ko hi dekhna like map
        // stateful - sorted and distinct --› sabhi elements ka pata hona chaiye





    }
}
