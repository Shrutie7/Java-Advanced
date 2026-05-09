package Collection.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class MainPreStreams {
    public static void main(String[] args) {
        //Streams


        // Java 8 --> minimal code, functional programming features (bcoz java was object oriented language)
        // Java 8 --> MAIN FEATURES --> Lambda expression, Streams, Date&Time API //STREAMS -> METHOD REFERENCE, CONSTRUCTOR REFERENCE , FUNCTIONAL INTERFACE
        // LAMBDA EXPRESSION
        // Lambda expression is an anonymous function (no name, no return type, no access modifier)
        Thread t1 = new Thread(new Task()); // we write runnable ka object inside the brackets

        // we can write lambda expression here also

        Thread t2 = new Thread (()-> {
            System.out.println("shruti");
        });

        //same thing is happening when creating thread t1 and t2 using lambda expressions
        // bcoz class task mein sirf jo runnable interface h usme method run ki implementation likhi h ek hi run method h that can be written using lambda expression
        // method ko convert to lambda expression -› remove access modifier, return type, name, parameters and body ke beech me arrow Lagao
        // Lambda expression --> USED TO IMPLEMENT FUNCTIONAL INTERFACE
        // FUNCTIONAL INTERFACE --> MEANS THOSE INTERFACE THAT HAS ONLY 1 ABSTRACT METHOD MEANS ONLY 1 METHOD WITH NO BODY (ONLY METHOD DECLARATION)
        // AND WE CAN IMPLEMENT FUNCTIONAL INTERFACE USING LAMBDA EXPRESSION
        // ex runnable interface has @FunctionalInterface with only 1 abstract method as run method
        // ex we have a interface MathOperation which has only 1 method operate w/o lambda expression we will create a class that will implement the MathOperation interface and has the method operation definition like that multiple class like sum,subtract,divide,multiply will come
        // but MathOperation interface is a functional interface with a single abstract method as operate so implement it using lambda expression


        //FROM CLASS SumOperation CONVERT TO LAMBDA EXPRESSION remove access modifier, return type, name, paramters and body ke beech me arraow lagao

        // USING INTERFACE KA REFERENCE MathOperation TO HOLD LAMBDA EXPRESSION HENCE***FUNCTIONAL INTERFACE KA REFERENCE CAN HOLD LAMBDA EXPRESSION***--> FUNCTIONAL PROGRAMMING
        // TREATING FUNCTION AS VARIABLE --> FUNCTIONAL PROGRAMMING
        MathOperation sumOperation = (a,b) -> a + b;//1 line so skip return so also remove curly brackets //remove int also in params
        MathOperation subtractOperation = (a,b) -> a - b;
        //use using DOT OPERATOR


        int res1= sumOperation.operate(1,2);
        int res2 = subtractOperation.operate(4,3);


        System.out.println(res1+" "+res2);


        //1.......PREDICATE --> FUNCTIONAL INTERFACE
        //IN java.util package a interface PREDICATE IS THERE WITH @FunctionalInterface annotation
        //annotation @FunctionalInterface lagana is a good practice tell in future to keep only 1 abstract method
        //1 test method (return type = boolean) abstract method in PREDICATE rest all methods are default
        //Predicate-> Boolean valued function of 1 argument. This is functional interface whose functional method is test


        //write lambda expression which will be implementation of test method Predicate predicate = new Predicate is wrong Predicate is interface

        Predicate<Integer> isEven = x -> x%2==0; //boolean valued function implementation of test method
        System.out.println(isEven.test(4));
        // no need to write method using lambda expression we can check condition


        // TO CHECK ANYTHING --> PREDICATE -→> condition hold krtah -→> condition ko variable me store --› functional programming
        // public static boolean isEven (int x) {
        //return x%2 == 0;
        //}
        //in stream very useful lambda expression

        Predicate<String> isWordStartingWithA = str->str. toLowerCase().startsWith("a"); //boolean valued function implementation of test method

        System.out.println(isWordStartingWithA.test("Abhinav"));//true

        // COMBINE PREDICATES -→> AND , OR , NEGATE

        Predicate<String> isEndingWithV = str-> str. toLowerCase().endsWith("v");

        //AND
        Predicate<String> and = isWordStartingWithA.and(isEndingWithV);

        System.out.println(and.test("Abhinav"));//true
        System.out.println(and.test("Akshay"));//false ends in y not v




        //2.... FUNCTION --> FUNCTIONAL INTERFACE --> in 1.8
        // 1 ABSTRACT APPLY METHOD --> FUNCTION KAAM KREGA WORK FOR YOU

        Function< Integer, Integer> doubleIt = x->x*2; // lambda expression implementation of apply method //doubleIt is function
        System.out.println(doubleIt.apply(100));//200

        // compose method also there (default method)
        // use *andThen* (default method only 1 abstract method --> apply whose definition in lambda expression) to combine 2 functions
        Function<Integer, Integer> tripleIt = x->x*3;
        System.out.println(doubleIt.andThen(tripleIt).apply(20)); // 20*2= 40,  40*3 = 120 andThen mein pehle doublelt then triplelt //same o/p
        System.out.println(doubleIt.compose(tripleIt).apply(20)); // 20*3 = 60, 60*2 = 120 compose mein pehle triplelt then doublelt // same o/p


        // identity() method that is there in Function thats a STATIC METHOD SO CALL WITH help of interface name --> jo denge whi feturn hoga --> useful in stream
        Function<Integer, Integer> identity = Function.identity();
        Integer result = identity.apply(5);
        System.out.println("res "+result);


        //3.... CONSUMER --> FUNCTIONAL INTERFACE
        // 1 ABSTRACT ACCEPT METHOD --> REPRESENTS AN OPERATION THAT ACCEPT SINGLE INPUT ARGUMENT AND RETURNS NO RESULT return type is void

        // KUCH RETURN NHI KRTA i/p LEGA BUT DEGA NHI means use krlega us input ko (consume krega)
        Consumer<Integer> print = x->System.out.println(x);

        print.accept(51); //void return type no need to sout

        List< Integer> list = Arrays.asList(1,2,3);

        Consumer<List<Integer>> printList = x -> {
            for (int i : x) {
                System.out.println(i);
            }
        };

        printList.accept(list);//prints 1 2 3 nothing returns, consumes

        // ***andThen (default method)
        // dusra consumer lera pehle first accept chelga then second accept chlega
        // accept(t); after.accept(t); sequentially manner no return type hence no compose method in CONSUMER


        // 4....... SUPPLIER -->FUNCTIONAL INTERFACE
        // 1 ABSTRACT GET METHOD --> KUCH NHI LEGA BUT RETURN KREGA //ex db se connection Leke aao
        //NO DEFAULT NO STATIC METHODS IN SUPPLIER
        Supplier<String> giveHelloWorld = () -> "Hello World";
        System.out.println(giveHelloWorld.get());//Hello World

        // combined example
        Predicate<Integer> predicate = x -> x%2==0;
        Function<Integer, Integer> function = x -> x*x;
        Consumer< Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())) {//passing 100 from supplier to predicate to test for even number
            Integer res = function.apply(supplier.get()); // since 100 is even no get inside if block and multiply twice hence o/p = 10000
            consumer.accept(res); //print the res as 10000
        }


        //all these PREDICATE, SUPPLIER, CONSUMER, SUPPLIER takes only 1 input parameter but if to pass in 2 input params
        // Use BIPREDICATE BIFUNCTION BICONSUMER no such thing like BISUPPLIER/BIPRODUCER

        BiPredicate<Integer, Integer> biPredicate = (x, y) -> (x+y)%2==0;
        System.out.println(biPredicate.test(5,5));

        BiConsumer<Integer, Integer> biConsumer = (x,y)-> System.out.println(x + "" + y);

        //BIFUNCTION TAKES 3 ARGS, LAST ARE IS RETURN TYPE AND FIRST 2 ARE THE ACTUAL ARGS
        BiFunction<String, String, Integer> biFunction = (x, y) -> (x+y).length();
        System.out.println(biFunction.apply("Shruti","Sakshi"));


        //FUNCTION interface --› integer hi i/p and integer hi o/p (return rka re)duplicate integer integer
        Function<Integer, Integer> a = x -> x*2;

        UnaryOperator<Integer> b= x -> x*2; //FUNCTION
        BinaryOperator<Integer> c = (x, y) -> x+y; //BIFUNCTION
        //ARAM K LIYE H DONT WRITE DUPLICATES IF SAME RETURN TYPE SAME TYPE OF I/P ARGS
        // UNARY OPERATOR --> FUNCTIONAL INTERFACE --> we dont have to write twice Integer Integer bcoz both i/p and o/p is Integer
        // interface extends FUNCTION interface

        // BINARY OPERATOR --> FUNCTIONAL INTERFACE --> similarly we dont have to write thrice Integer Integer Integer bcoz both i/p and o/p is Integer (Same)
        // interface extends BiFunction interface

        // *****************METHOD REFERENCE**********--> use method without invoking and in place of lambda expression

        List<String> students = Arrays.asList("Ram","Shyam","GhanShyam");
        students.forEach(x-> System.out.println(x)); // in forEach it takes in args as Consumer and it will print in 1 line
        // bcoz of sonar lint --> above line says Lambda expression can be replaced with METHOD REFERENCE
        // lambda expression ke jagah use method reference
        // double colon --> method reference
        // use method w/o invoking give method as reference directly no need of x call foreach of the students
        students.forEach(System.out::println); // inside System inside out there is method println iska reference lena h and forEach me patakna h and each student ke Live yeh chalana h

        // METHOD KO AS A PARAMETER --> 1. LAMBDA EXPRESSION 2. METHOD REFERENCE (MORE CONCISE)
        // METHOD REFERENCE --> SHORTCUT --> LAMBDA EXPRESSION NHI LIKHNA JAB


        //****************CONSTRUCTOR REFERENCE*******************************
        // .stream() --> convert any collection to stream
        // in place of lambda expression *******use method reference or constructor reference******

        List<String> names = Arrays. asList("A", "B", "C");
        //CONVERT names list into MobilePhone
        List<MobilePhone> mobilePhones = names.stream().map(x->new MobilePhone(x)).collect(Collectors.toList());
        //convert above line to constructor reference
        List<MobilePhone> mobilePhonesList = names.stream().map(MobilePhone::new).collect(Collectors.toList());//MobilePhone:: new constructor ko refer krra yeh chiz chalani h new means constructor ko refer krra
    }
}
class MobilePhone{
    private String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}
class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("shruti");
    }
}
class SumOperation implements MathOperation{

    @Override
    public int operate(int a, int b) {
        return a+b;
    }
}
//good practice to write @FunctionalInterface annotation at top of MathOperation interface so keep only 1 abstract method don't keep more than that
// if we write 2 methods inside MathOperation with @FunctionalInterface annotation compiler gives error (only 1 method to be there)
//THIS MathOperation IS A FUNCTIONAL INTERFACE ONLY 1 METHOD (ABSTRACT) SO USE LAMBDA EXPRESSION TO IMPLEMENT THIS INSTEAD OF CREATING CLASS
//LAMBDA EXPRESSION IMPLEMENTS FUNCTIONAL INTERFACE *****
@FunctionalInterface
interface MathOperation{
    int operate (int a, int b);
}



//PREDICATE --> FUNCTIONAL INTERFACE --> 1 ABSTRACT TEST METHOD --> PREDICATE CONDITION HOLD/check KRTA H
//FUNCTION  --> FUNCTIONAL INTERFACE --> 1 ABSTRACT APPLY METHOD --> FUNCTION KAAM KREGA WORK FOR YOU
//CONSUMER  --> FUNCTIONAL INTERFACE --> 1 ABSTRACT ACCEPT METHOD --> KUCH RETURN NHI KRTA LEGA BUT DEGA NHI means use Krlega input ko (consume krega)
//SUPPLIER  --> FUNCTIONAL INTERFACE --> 1 ABSTRACT GET METHOD --> KUCH NHI LEGA BUT RETURN KREGA //ex db se connection Leke aao --> NO DEFAULT NO STATIC METHODS


//all these PREDICATE, SUPPLIER, CONSUMER, FUNCTION takes only 1 input parameter but if to pass in 2 input params use BIPREDICATE BIFUNCTION BICONSUMER no such thing like BISUPPLIER/BIPRODUCER

//METHOD KO AS A PARAMETER --> 1. LAMBDA EXPRESSION 2. METHOD REFERENCE (MORE CONCISE)
//METHOD REFERENCE --> SHORTCUT --> LAMBDA EXPRESSION NHI LIKHNA JAB