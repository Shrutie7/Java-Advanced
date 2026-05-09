package Collection.MultiThreading;

public class ThreadLifeCycle3 {
    public static void main(String[] args) {
        //state h thread ke -› create hua, run hua then terminate hogaya -→> called LIFECYCLE OF THREAD
        // The lifecycle of a thread in Java consists of several states, which a thread can move through during its execution

        //5 states
        //1. NEW : A thread is in this state when it is created but not yet started
        //2. RUNNABLE: After the start method is called, the thread becomes runnable. It's ready to run and is waiting for CPU time
        //3. RUNNING: The thread is in this state when it is executing jab cpu ko time milega tab running state me aaiga
        //4.BLOCKED/WAITING/Timed-waiting: A thread is in this state when it is waiting for a resource or for another thread to perform an action.
        //5. TERMINATED: A thread is in this state when it has finished executing
        World1 t1 = new World1();//NEW STATE (just created)

        t1.start();//RUNNABLE STATE (chla nhi h wait krra h CPU ka chal sakta h)

        // RUNNING STATE (jaise hi cpu ko time milega then class ka run method chal jaiga)
        System.out.println(Thread.currentThread().getName());
    }
}
