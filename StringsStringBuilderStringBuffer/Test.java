package StringsStringBuilderStringBuffer;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //STRING, STRINGBUILDER, STRINGBUFFER --> ALL 3 CLASSES STORE SEQUENCE OF CHARACTER
        // ONE IS MUTABLE ONE IS DESIGNED FOR PERFORMANCE ONE IS DESIGNED FOR THREAD SAFETY

        //STRING *****
        //IMMUTABLE THREAD SAFE
        String str1 = "Hello";
        // String str1 = new String ("Hello");
        //stored in String pool
        //instead of string literal giving new String then also by design String is immutable only
        //INTERNAL FIELDS OF STRING CLASS ARE FINAL CANNOT BE CHANGED WHETHER U GIVE LITERAL OR NEW STRING

        str1.concat("World");
        System.out.println(str1); // will not concatenate because String is immutable will not get modified

        String str2 = str1.concat("World");
        System.out.println(str2); //original string is immutable when we store in another string it will concatenate

        String result = "";

        for (int i = 0; i < 10000; i++) {
            result = result + "HELLO";// new string created in memory and assigned
        }
        System.out.println(result);//THIS CODE WILL CREATE 10000 TEMPORARY STRING IN MEMORY which will lead to poor performance

        //***Thats y stringBuilder and StringBuffer came to avoid creating Temporary strings which are mutable they can be modified without creating new String

        //STRINGBUILDER********
        //1. MUTABLE
        //2. METHOD CHAINING (bcoz each method returns a reference)
        //3. not thread safe

        StringBuilder sb = new StringBuilder ("Hello");
        //has lot of methods append, insert(at a pos also), reverse, replace, charAt,
        sb.append(" World").append(" !"); // same sb(object) getting modified no temporary string // allows method chaining

        sb. append ("2"). replace(1, 2, "ok").reverse();// allows method chaining
        // sb. append ("Hello"); //Append text
        // sb. insert(1, "Java");//Insert at position element
        // sb. replace (1,3, "world"); //Replace
        // sb. delete(1,4); // Delete range
        // sb. reverse(); // Reverse string
        //sb. charAt(0); //Get character at particular index
        // sb. length(); //Get length
        // sb. substring(1,4); //Get Substring

        // to get String object use -→> toString() making it again immutable
        String string = sb.toString();
        System.out.println(string);

        //Internal working of StringBuilder
        //Has internally char Array of default capacity is ( 16 )
        //once array full then array size doubles and a new char Array is created of double the size and old char Array elements are put into new Char Array

        //DONO t1 and t2 THREAD me passing shared resource that is sb and in both thread 1000 times a is appended so final length should be 2000
        //but will not come 2000 it will come random Length bcoz NO THREAD SAFETY IN STRINGBUILDER
        //because if both threads t1 t2 enters the for loop at same time it will append only once so counted only once hence not coming 2000 length
        // hence String buffer came for Thread safety
        Task t1 = new Task(sb);
        Task t2 = new Task(sb);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final length: "+ sb. length());

        //STRINGBUFFER******
        //1. Thread Safe
        //uses Synchronized keyword in all methods
        StringBuffer sbf = new StringBuffer();
        Task2 t3 =  new Task2(sbf) ;
        Task2 t4 = new Task2 (sbf);
        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("Final length: "+sbf.length());//2000 bcoz String Buffer is thread safe

        // 3 have their own useCase
        //1. MUTABLITY & THREAD SAFETY -> STRING BUFFER --> OPERATION SLOW BCOZ OF SYNCHRONIZED OVERHEAD
        //2. MUTABLITY & NO THREAD SAFETY & PERFORMANCE --> STRING BUILDER
        //3. IMMUTABILITY & CONSTANT CHIZE CHAIYE --> STRINGS

        //STRING --> IMMUTABLE, THREAD SAFETY, SLOW PERFORMANCE(DUE TO IMMUTABILITY), STORED IN STRING POOL (FOR LITERALS), USED FOR SMALL FIXED TEXTS
        //STRINGBUILDER --> MUTABLE, NO THREAD SAFETY, FAST PERFORMANCE (No Synchronization), STORED IN HEAP, USED FOR SINGLE-THREADED APPS
        //STRINGBUEFER --> MUTABLE, THREAD SAFETY, SLOW PERFORMANCE(DUE TO Synchronization), STORED IN HEAP, USED FOR MULTI-THREADED APPS
    }
}
class Task extends Thread {
    private StringBuilder sb;

    public Task(StringBuilder sb) {

        this.sb = sb;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            sb.append("a");
        }
    }
}


class Task2 extends Thread {

    private StringBuffer sb;

    public Task2(StringBuffer sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            sb.append("a");
        }
    }
}