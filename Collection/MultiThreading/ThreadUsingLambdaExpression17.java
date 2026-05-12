package Collection.MultiThreading;

public class ThreadUsingLambdaExpression17 {
    //To create a new thread in java, you can either 1. extend the Thread class or 2. implement the Runnable interface
    public static void main(String[] args) {

        //create thread on the fly using anonymous class
        // interface -- has static / default / abstract methods
        // Lambda expression is an anonymous function (no name, no data type, no return type, no access modifier small brackets and curly brackets ke beech me arrow -> )
        // Runnable interface is a FUNCTIONAL INTERFACE MEANS HAS A SINGLE ABSTRACT METHOD(1 method jiski koi body nhi h) means FUNCTIONAL INTERFACE is implemented using Lambda expression

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        //----translated function public abstract void run(); to lambda expression runnable task

        // kyuki runnable interface is functional interface uske andr sinf ek single abstract method h called run method
        // toh jo lambda expression k andr likhah that is the implementation of run method
        // anonymous func(lambda exp) written in front of functional interface

        Runnable task2 = () -> System.out.println("hello");
        Thread t2 = new Thread (task2 , "Thread 2");

        //can also put above directly:
        Thread t3 = new Thread(()-> System.out.println("hello"));

        Thread t4 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello world");
            }
        });// likha hua h implementation of runnable run method lambda expression can be assigned to functional interface ke reference ko / runnable ke reference ko

        Thread t1 = new Thread (task,"Thread1");





    }
}
