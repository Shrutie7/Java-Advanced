package Collection.MultiThreading;

public class MainMultiThreading1 {
    public static void main(String[] args) {
        // CPU
        //often referred to as the brain of the computer, is responsible for executing instructions from programs. It performs basic arithmetic, logic, control and input/output operations specified by the instructions
        //program run CPU ke andr hota h
        //EXAMPLE -> A modern CPU like the Intel Core 17 or AMD Ryzen 7

        // CORE
        //A core is an individual processing unit within a CPU. Modern CPUs can have multiple cores, allowing them to perform multiple tasks simultaneously
        //A quad-core processor has four cores, allowing it to perform 4 tasks simultaneously. For instance one core could handle your web browser, another your music player, another a download manager, and another a background system update

        // PROGRAM
        //A program is a set of instructions written in a programming language that tells the computer how to perform a specific task
        //Microsoft Word is a program that allows users to create and edit documents

        //PROCESS
        //A process is an instance of program that is being executed when a program runs the Operating system creates a process to manage its execution
        //When we open Microsoft Word it becomes a process in the Operating System

        // THREAD
        // A thread is the smallest unit of execution within a process. A process can have multiple threads, which share the same resources but can run independently
        // A web browser like Google Chrome might use multiple threads for different tabs, with each tab running as a separate thread

        //MULTITASKING
        // Multitasking allows an operating system to run multiple processes simultaneously.On single-core CPUs, this is done through time-sharing, rapidly switching between tasks
        // On multi-Core CPUs true parallel execution occurs with tasks distributed across cores.
        // The OS Scheduler balances the load, ensuring efficient and responsive system performance

        // Example: We are browsing the internet while listening to music and downloading a file
        //Multitasking utilizes the capabilities of a CPU and its cores. When an operating system performs multitasking, it can assign different tasks to different cores. This is more efficient than assigning all tasks to a single core

        //multitasking me multiple process chal rahe higher level pe // 1 process me multiple threads chal rhe h

        //MULTITHREADING
        // Multithreading refers to the ability to execute multiple threads within a single process concurrently
        // Example: A web browser can use multithreading by having separate threads for rendering the page, running javascript, and managing user inputs. This makes the browser more responsive and efficient

        // multithreading enhances the efficiency of multitasking by breaking down individual tasks into smaller sub-tasks or threads. These threads can be processed simultaneously, making better use of CPU's capabilities.
        // multitasking better hopari multithreading se

        // In a single-core system :
        // Both threads and processes are managed by the OS scheduler through time slicing and context switching (means abhi ye process abhi ye) to create the illusion of simultaneous execution

        // In a multi-Core system:
        // Both threads and processes can run in true parallel on different cores, with the OS scheduler distributing tasks across the cores to optimize performance

        //Time Slicing
        //Definition: Time slicing divides CPU time into small intervals called time slices or quanta
        // Function: The OS Scheduler allocates these time slices to different processes and threads ensuring each gets a fair share of CPU Time.
        // Purpose: This prevents any single process or thread from monopolizing the CPU, improving responsiveness and enabling concurrent execution. (bcoz multiple process are there sabko mauka milne chaiye chalne ka)


        //Context Switching
        //Definition: Context Switching is the process of saving the state of a currently running process or thread and loading the state of the next one to be executed (bahut sare thread/process chal ri jo current chal ra uski state ko pause krna aur dusre execute pe jake wapas ana)
        //Function: When a process or thread's time slice expires(time expire hogya thread/process ka), the OS Scheduler performs a context switch to move the CPU's focus to another process or thread
        //Purpose: This allows multiple processes and threads to share the CPU, giving the appearance of simultaneous execution on a single-core CPU or improving parallelism on multi-Core CPU's


        //Multitasking can be achieved through multithreading where each task is divided into threads that are managed concurrently
        //While Multitasking typically refers to the running of multiple applications, multithreading is more granular dealing with multiple threads within the same application or process

        //Multitasking operates at the level of processes, which are the operating system's primary units of execution
        //Multithreading operates at the level of threads, which are smaller units within a process

        //Multitasking involves managing resources between completely separate programs, which may have independent memory spaces and system resources
        //Multithreading involves managing resources within a single program, where threads share the same memory and resources.

        //Multitasking allows us to run multiple applications simultaneously, improving productivity and system utilization
        //Multithreading allows a single application to perform multiple tasks at the same time, improving application performance and responsiveness

        //ex: The office manager(operating system) assigns different employees(processes) to work on different projects(applications) simultaneously --> multitasking. Each employee works on a different project independently
        //Within a single project(application), a team(process) of employees (threads) work on different parts of the project at the same time, collaborating and sharing resource

        //AMD RYZEN 9 5900HS OCTA CORE MACHINE word chalayah, firefox chalaya h
        // word ka ek process khul jaiga ->user input, spell checker -> these are threads

        // firefox ka ek process chal jaiga -> youtube, music player -> these are threads

        // multithreading happens in word, multithreading happens in firefox
        // word and firefox ek sath chal rhe usko bolrhe h multitasking jo ki manage hori OS se



        // Java provides robust support for multithreading, allowing developers to create applications that can perform multiple tasks simultaneously,
        // improving performance and responsiveness

        // In Java multithreading is the concurrent execution of 2 or more threads to maximize the utilization of CPU.
        // Java's multithreading capabilities are part of java.lang package, making it easy to implement concurrent execution.

        // In a single-core environment, Java's multithreading is managed by the JVM and the OS, which switch between threads to give the illusion of concurrency.
        // The threads share the single core, and time slicing is used to manage thread execution

        // In a multi-core environment, Java's multithreading can take full advantage of the available cores.
        // The JVM can distribute threads across multiple cores, allowing true parallel execution of threads

        // A thread is a lightweight process, the smallest unit of processing. Java supports multithreading through its java.lang.Thread class and the java.lang.Runnable interface
        //WHEN A JAVA PROGRAM STARTS, ONE THREAD BEGINS RUNNING IMMEDIATELY, WHICH IS CALLED THE MAIN THREAD. THIS THREAD IS RESPONSIBLE FOR EXECUTING THE MAIN METHOD OF A PROGRAM
    }

}
