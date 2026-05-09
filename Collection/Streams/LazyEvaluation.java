package Collection.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluation {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ALice", "Bob", "Charlie", "David");
        Stream<String> stringStream = names.stream().filter(name -> {
            System.out.println("Filtering: " + name);
            return name.length() > 3;
        });
        //means line 11 to 14 won't even run until terminal Operation is invoked // Before terminal Operation is invoked will print first then the flter will happen

        System.out.println("Before terminal Operation is invoked");

        List<String> list = stringStream.collect(Collectors.toList());

        System.out.println("After terminal Operation is invoked");

        System.out.println(list);
    }
}
