package Collection.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool19 {
    //collection of pre-initialised threads that r ready to perform a task, no need to create a new thread everytime a new task has to be done use preinitialised thread pool

    // why?
    // 1. Resource Management -› Creating & destroying a thread can be expensive for a task bcoz a overhead is formed each time creating/destroying happen(aave na aaye mile na mitt
    // 2. Response Time → increases with thread pool (no need to create thread from scratch bcoz thread already there)
    // 3. control over thread count -> puts limit on maximum number of thread created hence control there that dont create threads more than this for this task

    //to create thread pool use Executors Framework

    // Executors Framework
    // introduced in java 5 in java.util.concurrent package
    // to simplify development of concurrent applications by abstracting away many of the complexities involved in creating and managing threads.
    // chize aasan banara no need to create thread manually use executor framework to create thread easily

    // problems prior to Executors Framework with
    // 1. manual thread mgmt -- bina thread pool ke threads r created & destroyed there is overhead bcoz of thread bcoz of this memory/processor is going

    // 2. Resource Management

    // 3. Scalability

    // 4. Thread Reuse

    // 5. Error Handling -- manual creation threads complexity high

    // Executors Framework
    // 3 core interface --> 1. Executor 2. ExecutorService 3. ScheduledExecutorService

    // 1. Executor-> has .execute method
    // 2. child interface ExecutorService, ScheduledExecutorService
    // 3.Executors class -> withh utility methods -> newScheduledThreadPool), newSingleThreadExecutor(), newFixedThreadPool(), newCachedThreadPool)
    public static void main(String[] args) {
        Executors.newScheduledThreadPool(1);
        Executors.newSingleThreadExecutor();

        Executors.newFixedThreadPool(2);
        ExecutorService executorService = Executors.newCachedThreadPool();// dynamically adjust pool size --› for variable load, load is short lived use newCachedThreadPool()
        // --> risk also can create as many threads as no fixed pool
        // threads created acc to need if thread is no longer needed then it terminates after 60s of inactivity

    }
}
