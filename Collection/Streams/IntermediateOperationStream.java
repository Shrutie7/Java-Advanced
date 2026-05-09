package Collection.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperationStream {
    public static void main(String[] args) {

        // Intermediate operations transforms/ converts one stream to another stream
        // They are lazy, meaning will not be executed until a terminal operation (count, collect, map, max, reduce etc) is invoked

        // 1. filter --> TAKES IN A PREDICATE
        List<String> studentList = Arrays.asList ("Ankit", "Ram", "Shyam", "Ghanshyam", "Ankit");
        //filter -› intermediate operation which take in a predicate (functional interface which checks a condition)
        Stream<String> filteredStudentlist = studentList.stream().filter(x -> x.startsWith("A"));
        System.out.println(filteredStudentlist);
        //no filtering at this point use terminal operation like count to see o/p
        long res = studentList.stream().filter(x -> x.startsWith("A")).count();
        System.out.println(res);

        //2. map --> TAKES IN A FUNCTION KUCH LEGA KUCH DEGA //convert into something

        Stream<String> stringStream = studentList.stream().map(x -> x.toUpperCase());
        Stream<String> stringStream1 = studentList.stream().map(String::toUpperCase); //using double colon operator/method reference
        // no map at this point use terminal operation like collect here to see o/p

        System.out.println(stringStream.collect(Collectors.toList()));
        System.out.println(stringStream1.collect(Collectors.toList()));

        //3.sorted
        // natural ordering me stream sort hojaigi by default// can pass in custom comparator also
        Stream<String> sortedStream = studentList.stream().sorted();
        System.out.println(sortedStream.collect(Collectors.toList()));
        //or we can pass in comparator also to do sorting on basis of what we want

        Stream<String> sortedStreamUsingComparator = studentList.stream().sorted((a, b) -> a. length() - b. length());//sort on basis of size
        System.out.println(sortedStreamUsingComparator.collect(Collectors.toList()));

        //4. distinct
        // unique chize chaiye stream se use termination operation count to execute distinct
        System.out.println(studentList.stream().filter(x -> x.startsWith("A")).distinct().count());

        //5. limit
        //System.out.println(Stream.iterate(1,x->x+1).count()):// infinite loop -Non-short-circuit operation consumes infinite stream (sare elements ko process krega start se end tk) if limit is not given
        System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());//100

        //6. skip
        System.out.println( Stream.iterate(1, x -> x + 1).skip(10).limit(100).count()); //100 //will still give count as 100 skips starting 10 no start from 11 but still 100 size after that

        // 7. peek--> takes in a consumer
        // forEach is terminal operation consume krta h same kaam peek krtah but wo intermediate operation h
        //     peek will also perform action on each element
        Stream.iterate(1,x->x+1).skip(10).limit(100).peek(System.out::println).count();
        //peek ne consume kriya h so prints from 11 to 110

        //8. flatMap
        //Handle streams of collections, lists, or arrays where each element is itself a collection
        // Flatten nested structure (eg. lists within lists) so that they can be processed as a single sequence of elements //Transform and flatten elements at the same time
        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("apple", "banana"), Arrays.asList("orange", "kiwi"),Arrays.asList("pear", "grape"));
        System.out.println(listOfLists.get(1).get(1)); // kiwi
        // create all the elements in list of list to upper case and we need flat list // means in 1 sequence // in flat map make x.stream() in 1 single stream unified stream
        System.out.println(listOfLists.stream().flatMap(x->x.stream()).map(x->x.toUpperCase()).collect(Collectors.toList()));
        System.out.println(listOfLists.stream().flatMap(x->x.stream()).map(String::toUpperCase).toList());//same as above using method reference and .toList()
        // we can also transform a stream using flatMap other than just flattening it
        List<String> sentences = Arrays.asList(
                "Hello World",
                "Java streams are powerful",
                "flatMap is useful"
        ) ;
        System.out.println(sentences.stream().flatMap (sentence->Arrays.stream(sentence.split(" "))).map (x->x.toUpperCase()).toList());
    }
}
