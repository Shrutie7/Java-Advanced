package Collection.ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//finally --> chahe try chale ya catch chale finally zarur chalega // useful in return scenario
public class ExceptionHandlingMain5 {
    public static void main(String[] args) {
        int a = 4, b = 0;
        System.out.println(divide(a, b));
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("example.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch(IOException e) {
                System.out.println("I0Exception caught: " + e.getMessage());
        }
        finally {
            try {
                if (reader!=null){
                    reader.close();
                }
            }catch (IOException e){
                System.out.println("Error occurred: " + e.getMessage());
            }
        }
        //if not given finally and there is return in try and catch toh kabhi neeche nhi aiga hence always close in finally block
    }


    public static int divide(int a, int b){
        try{
            return a/b;
        }catch (Exception e){
            System.out.println(e);
            return -1;

        }finally {
            System.out.println("Bye");
        }
    }
}
// Reader -> ka object close hona chaiye always so put in finally block