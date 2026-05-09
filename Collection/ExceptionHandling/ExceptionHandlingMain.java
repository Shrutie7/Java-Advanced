package Collection.ExceptionHandling;

public class ExceptionHandlingMain {
    public static void main(String[] args) {
        //syntax error --> wont compile all statement ends with semi colon check at compilation intellij complies at real time but notepad doesnt doing by programmer
        //logical error --> compile but error comes wrong mathematical doing by programmer
        //Runtime error --> chlne ke dauran error --> program will crash during runtime errors

        // program will run except some cases so we handle those exception cases
        // ExceptionHandling is a way to handle runtime error so that normal flow of the application can be maintained // exception ke badh wale statements chalenge hi nhi
        // EXCEPTION -> an event that disrupts normal flow of program.It is an object which is thrown at runtime by JVM (e is the obj)

        int[] numerators = {10,200,30,40};
        int [] denominators = {1,2,0,4};
        for (int i = 0; i < numerators. length; i++) {
        System.out.println(divide(numerators[i], denominators[i])); // exception (division by zero) Arithmetic exception (30/0 == exception) --> RUNTIME ERROR 3rd time me code fatega aage nhi chlega
        }

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(divide(numerators[i], denominators[i])); // exception (division by zero) Arithmetic exception (30/0 == exception) --> RUNTIME ERROR 3rd time me code fatega aage nhi chlega
            } catch (Exception e) {
                System.out.println(e); // 6 bar exception aega IndexOutOfBoundsException 4 bar print hoga
            }
        }// gives array index out of bounds exception 4 tak chlega so give try catch
        System.out.println("job done :)");

        Student student = new Student();
        student.setId (123);
        System.out.println(student); // internally sout calls the toString() method of Student class



    }

    public static int divide(int a, int b){
        //write try catch to handle exception, exception aiga toh catch mein jaiga
        try{
            Student student = null; // null pointer exception
            student.setId(123);
            System.out.println(student.getId());
            return a/b;

        }catch (NullPointerException | ArithmeticException e){
            System.out.println(e);
            return -1;
        }
        //parent class last me dalna
        catch (Exception e){//in catch we can give RuntimeException (parent) of ArithmeticException// or Exception // dont write Throwable

            //ArithmeticException extends--> RuntimeException which extends--> Exception which extends Throwable that has .toString() which runs on sout
            // when error (divide by 0) comes JVM does constructor call in ArithmeticException with message and then constructor calls of RuntimeException then constructor calls of Exception then constructor calls of Throwable then detailMessage is initialized and stack trace is filled

            System.out.println(e);//prints class ka nam and error msg (msg -> calls getLocalizedMessage() which calls getMessage() which returns detailMessage string in Throwable class
            return -1;
        }
    }
}

//in JAVA all in-built classes / custom classes extend Object class there is toString() method in Object class


//Object class --> throwable class --› java.lang.Error , java.Lang.Exception

//java.lang.Error --> java.lang.VirtualMachineError-->(java.lang.Out0fMemoryError,stackOverflowError), Java.lang.LinkageError(java.lang.classFormatError,noClassDefFoundError) --> JVM handles on its own this error
//java.lang. Exception --> java.lang.RuntimeException->(Arithmetic,null pointer, index out of bounds, illegalArgument) , Java.io.IOException, Java.lang.reflect.InvocationTargetException, java.SQL.SQLException etc
// polymorphism --> if we are giving reference of parent class we can make object of child class means in catch we can give RuntimeException also bcoz ArithmeticException extends RuntimeException we can give Exception also (most parent) dont give Throwable its not clear
// in try block there can be multiple exceptions give multiple catch block but if u gave parent exception at top no need to give child exceptions in below catch bcoz it will get caught in first catch block only
// error aega bcoz parent class Exception h 1st catch me exception will be caught so give it last

//What r exceptions // handling exceptions // hierarchy // multiple catch block //toString