package Collection.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        //A type of stream that enables parallel processing of elements
        // Allowing multiple threads to process parts of the stream simultaneously
        // This can significantly improve performance for large data sets
        // workload is distributed across multiple threads

        //with stream
        Long startTime = System.currentTimeMillis(); //January 1, 1970 UTC is date se kitne milliseconds nikal gye h
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        // List<Long> collect = list.stream().map(x -> factorial(x)).collect(Collectors.toList());

        List<Long> collect = list.stream().map(ParallelStream::factorial).collect(Collectors.toList()); // replace lambda with method reference
        System.out.println(collect);
        Long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential (normal) stream "+(endTime-startTime) +" ms");//kitna time laga factorial nikalne k Liye

        // with parallel stream (time very less)
        startTime = System.currentTimeMillis(); //January 1, 1970 UTC is date se kitne milliseconds nikal gye h
        list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        // List<Long> collect = list.stream().map(x -> factorial(x)).collect(Collectors.toList());
        collect = list.parallelStream().map(ParallelStream::factorial).collect(Collectors.toList()); // replace lambda with method reference

        List<Long> collect1 = list.parallelStream().map(ParallelStream::factorial).sequential().collect(Collectors.toList());// using sequential() method to convert parallel stre
        System.out.println(collect1);
        System.out.println(collect);
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream "+(endTime-startTime)+" ms");
        //Parallel streams are most effective for CPU INTENSIVE or large datasets where tasks are independent(each element should not be dependent on result of other element) (fa //They may add overhead for simple tasks or small datasets performance gir jaigi
        // local variables in lambda expression should be final or effectively final
        // cumulative sum
        List<Integer> numbers = Arrays.asList(1,2,3,4,5); // [1,3,6,10,15]

        //int sum = 0 ;// useAtomicInteger to achieve thread safety
        AtomicInteger sum = new AtomicInteger (0);
        //use stream ans will come correct** //ans comes wrong in parallel stream
        List<Integer> list1 = numbers.parallelStream().map(
                //x ->
                // int i = x + sum;
                // Variable used in lambda expression should be final or effectively final //final hoga toh change kaise hoga
                // sum = i;//record hona chaiye sum ka taki agli bar usko add krpao
                // return i;
                // lambda expression executes in parallel can lead to inconsistency //thread safenhih use AtomicInteger to achieve thread safety
                // sum.addAndGet(x) // addAndGet(x) method Atomically adds the given value x to the current value** can use method reference also
                sum:: addAndGet
        ).toList();

        System.out.println("Expected cumulative sum: [1,3,6,10,15] ");
        System.out.println("getting sum : "+ list1); // o/p is wrong in parallel stream bcoz cumulative sum is not independent use carefully
        // cumulative sum relies on sequential order but parallel stream don't guarantee order of execution

        // convert parallel stream to sequential stream use .sequential() method
        // normal stream to parallel stream use .parallelStream() and back to normal/sequential stream use .sequential()


    }

    private static long factorial(int n){
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact*n;
        }
        return fact;
    }
}
