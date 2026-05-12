package Collection.MultiThreading;

public class CounterSynchronization6 {
    private int count = 0 ;

    //1. synchronized method
    //with synchronized keyword now ajso object is 1 and being shared between 2 threads t1 and t2 but synchronized keyword makes sure ki ek baar ek thread chala rahah us method ko dusra nhi chalaega
    synchronized public void increment(){
        count++;
    }

    //synchronized block
    //no need to synchronize entire method can also use synchronized block with (this) -> means of 1 instance jispe increment call horah, if multiple threads r accessing it ek bar me ek hi thread access krpaiga
//    public void increment() {
//        synchronized (this) {
//            count++;
//        }
//    }

    public int getCount(){
        return count;
    }


}
