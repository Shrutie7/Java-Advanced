package Collection.ExceptionHandling;

//StackTrace -->
//main() calls level1(), level1() calls level2(), level2() calls level3() which throws ArrayIndex0utOfBoundsException
// so this exception will propagate to level2() then level1() then main & program terminates w/o try catch
// stack trace --> provide detailed information of method calls that led to exception // snapshot of callstack
public class ExceptionHandlingMain2 {
    public static void main(String[] args) {
        try{
            level1();
        }catch (Exception o) {
//            StackTraceElement [] stackTrace = o. getStackTrace() ;
//            for (int i = 0; i < stackTrace.length; i++) {
//                System.out.println(stackTrace[i]);
//            }
            //instead
            o.printStackTrace();
        }

    }
    public static void level3(){
        int[] arr = new int[3];
        arr[5] = 10; //ArrayIndex0utOfBoundsException
    }
    public static void level2(){
        level3();
    }

    public static void level1(){
        level2();
    }

}
