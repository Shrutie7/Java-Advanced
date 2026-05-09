package Collection.ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandlingMain3 {
    public static void main(String[] args) throws FileNotFoundException {
        //checked and unchecked exceptions
        // unchecked -> exception not being checked at compile time, runtime pe exception aega
        // all the runtimeExceptions --> Arithmetic/NullPointer/index0ut0fBounds are all unchecked exceptions not checked by compiler
        // exception checked at compile time --> checked exception --> ex : fileReader --> fileNotFound exception under ioexception
        try {
            FileReader fileReader = new FileReader("abc.txt"); //gives Unhandled exception: java.io.IOException
        }catch (IOException e){
                System.out.println(e);
        }

        //give exception in method signature using ****throws**** or handle in try catch block
        FileReader fileReader1 = new FileReader ("abc.txt"); // gives Unhandled exception: java.io.IOException

        method1();
}
public static void method1() throws FileNotFoundException {
        method2();
}
public static void method2() throws FileNotFoundException {
        FileReader fileReader = new FileReader("abc.txt"); // kahi na kahi toh try catch dena hoga gives exception The system cannot find the file specified unless it find the file it'll give this error
}
}
