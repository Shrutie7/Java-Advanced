package Collection.ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandlingMain6 {
    public static void main(String[] args) {
        //in java 7 to handle resources like buffer reader and fileReader we use Try-With-Resources // no need to write finally

        // wtv we write inside try parenthesis that will close automatically no need to write finally
        // if that object is of class(FileReader) that implements AutoCloseable interface (in hierarchy) wo automatically close hojaigi w/o finally block
        // BufferedReader FileReader inputStream outputStream implements AutoCloseable interface (in hierarchy) wo automatically close hojaigi
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }
}
