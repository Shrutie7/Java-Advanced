package Collection.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStreamDemo {
    public static void main(String[] args) {
        //feature introduced in java 8
        //process collections(list,map, queue) of data in a functional and declarative manner -> use lambda expression with help of streams
        // w/o stream if else loop -› lot of lines of code --> less readability --> more chance of error
        // streams Simplify Data Processing
        // Embrace Functional Programming
        // Improve Readability and Maintainability
        // Enable Easy Parallelism (without dealing with multithreading complexity)

        //What is Stream ?
        //a sequence of elements supporting functional and declarative programming
        //STREAM --> INTERFACE --> A sequence of elements supporting sequential and parallel aggregate operations

        //How to use Streams?
        // Source, intermediate operations & terminal operation


        // convert any collection to stream so to use functional and declarative programming --> use .stream()
        List<Integer> numbers = Arrays.asList (1,2,3, 4,5);
        Stream<Integer> stream = numbers.stream();

        //count the no of even no in numbers list --› traditional way
        int count = 0 ;
        for (int num: numbers){
            if (num%2==0) {
                count++;
            }
        }
        System.out.println(count);

        //using streams --> in 1 line --›benefit
        //filter takes a predicate -> means checks condition
        // Source --> numbers //convert numbers to stream so as to access various methods, like filter-›intermediate operation, count-›terminal operation last operation jo chaiye hame!

        System.out.println(numbers.stream().filter(x->x%2==0).count());

        //CREATING STREAM
        // 1. FROM COLLECTIONS
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream1 = list.stream();

        //2. From Arrays
        String[] array = {"a", "b", "c", "d", "e"};
        Stream<String> stream2 = Arrays. stream(array) ;

        //3. Using Stream. of
        Stream<String> stream3 = Stream.of("a", "b");

        //4. Infinite Streams -- generate and iterate
        // 1. using generate method on Stream // infinite stream me count is non-short circuit operation (sare elements ko process krega start se end tk) consumes infinite stream if limit is not given
        Stream<Integer> generate = Stream.generate(()->1).limit(100);// creates an infinite stream using generate method takes in a supplier (doesnt take any i/p only returns o/p) of all 1 and using .limit limiting size to 100 w/o limit sare 1 rakhe h stream me
        //2. using iterate method on stream that takes in seed (starting pt) and unary operator (Function which has same type of return type and same parameter type)
        List<Integer> collect = Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList());// counting likhi hui h starting pt 1 h then goes on count 1,2,3,4,5....(agle element me kya krna h)

        System.out.println(collect);



    }
}
