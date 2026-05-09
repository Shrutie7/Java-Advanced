package Collection.ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionHandlingMain4 {
    public static void main(String[] args) throws FileNotFoundException {
        //throw keyword --> forcefully exception throw krane ke liye use throw
        method1();
    }
    public static void method1() throws FileNotFoundException {
        method2();
    }
    public static void method2() throws FileNotFoundException {
        try {
            FileReader fileReader = new FileReader("abc.txt");
        } catch (FileNotFoundException e) {
            // e.getMessage();
            System.out.println("File not found");
            throw new FileNotFoundException ("oops"); // throw keyword -> forcefully exception throw new object bana rhe h of FileNotFoundException --> msg give in constructor
        }
    }

    public static void method3(){
        throw new ArithmeticException();//ArithmeticException unchecked exception h no need to write throws in method signature
    }
}

