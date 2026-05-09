package Collection.Streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainPrimitiveStreams {
    public static void main(String[] args) {

        //till now we worked on Integer, String
        int[] numbers = {1,2,3,4,5}; // primitive int

        IntStream stream = Arrays.stream(numbers); // IntStream
        // IntStream -> A sequence of primitive int-valued elements supporting sequential and parallel aggregate operations

        //similarly convert to doubleStream, longStream ,boxed (means wrapper class me convert hogaya into Stream)
        Stream<Integer> boxed = stream.boxed();
        //methods also onIntStream interface iterate, generate, of, range
        IntStream range = IntStream.range (1,5); //1 inclusive 5 exclusive 1 to 4
        System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));
        //rangeClosed -> dono inclusive
        System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

        //.of()
        IntStream.of(1,2,3);
        //new Random --> class jisme instance pe doubles() method chalaenge into stream
        DoubleStream doubles = new Random().doubles(5);
//        System.out.println(doubles.boxed().toList());//5 random doubles aajainge
//        System.out.println(doubles.sum());//stream upar terminal operation se close hogyi h so exception will come so comment above line// similarly sum max average min summaryStatistics anyMatch allMatch mapToInt
//        System.out.println(doubles.min());
//        System.out.println(doubles.average());
//        System.out.println(doubles.max());
//        System.out.println(doubles.summaryStatistics());
        System.out.println(doubles.mapToInt(x->(int)x+1).boxed().toList());

        // similarly use ints
        IntStream ints = new Random ().ints(5);
        System.out.println(ints.boxed().toList());//5 random integer aajainge



        Integer [] numbers1 = {1,2,3,4,5}; //Wrapper class Integer
        Stream<Integer> stream1 = Arrays.stream (numbers1);//Stream<Integer> bcoz of wrapper class Integer till now we used this
    }
}
