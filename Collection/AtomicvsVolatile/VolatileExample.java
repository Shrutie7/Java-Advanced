package Collection.AtomicvsVolatile;

// *****every THREAD keeps LOCAL COPY of variables SAVED IN ITS CACHE for performance reasons**
//VOLATILE --> JITNE BHI THREADS HAI UNKO DIRECTLY VALUE MAIN MEMORY SE UTHANI H YA WRITE KRNI H --> NOT BLOCKING
// PR VOLATILE ME 2 THREADS EK SATH ACCESS KRR RHE H VARIABLE KO BLOCKING NHI H DIKKAT H (SYNCHRONIZED KRYWORD TABHI toh AAYA)



class SharedObj{
    private volatile boolean flag=false;

    //writer chalaega setFlagTrue() method

    public void setFlagTrue() {
        System.out.println("Writer thread made the flag true");
        flag = true;
    }

    //reader chalaega PrintIfFlagTrue() method
    public void PrintIfFlagTrue(){
        while (!flag){
            //do nothing
        }
        System.out.println("Flag is true");
    }

}
public class VolatileExample {
    public static void main(String[] args) throws InterruptedException {
        //boolean flag is there initially false,2 threads are there reader thread and writer thread
        // writer thread flag ko true krega and reader thread flag ko read krega

        SharedObj sharedObj = new SharedObj();
        Thread WriterThread = new Thread(() -> {
            try {
                Thread.sleep(1000);//1s wait, chahte h writerThread flag ko true krne se pehle hi reader thread chl jaye and while loop me fas jaye
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedObj.setFlagTrue();
        });
        Thread ReaderThread = new Thread(() -> sharedObj.PrintIfFlagTrue());
        WriterThread.start();
        ReaderThread.start();

        //output me Writer thread made the flag true aaiga print hoga and flag true bhi hoga but reader Thread ko nhi dikh rhah flag true hogya toh wo loop me hi h
        // readerThred ko nhi dikh rhah flag true bcoz **every thread keeps local copy of variables apne cache mein save krletah for performance reasons**
        // flag changed in main memory but in readerThread the flag is cached as FALSE WO CHANGE NHI HUA H
        // BCOZ FLAG IS SHARED ONE PLACE WE WRITE AND ONE PLACE WE READ




        // ********TO NOT CACHE THE VARIABLE IN A THREAD WHENEVER WE HAVE TO READ/WRITE MAIN MEMORY SE HI READ/WRITE KRIYE****************
        // *************************************SO WRITE VOLATILE IN THE VARIABLE*********************************************************
        // then after 1s writer thread will make flag true and reader thread ko dikh jaiga flag true hogya wo loop se bahar ajiaga bcoz flag variable hamne volatile banai h
        // so readerthread apne local cache se data nhi leke main memory se data lera


        // LIMITATIONS OF VOLATILE --> SYNCHRONIZE OR LOCKS BCOZ THREADS ARE NOT BLOCKING HERE
        // USE VOLATILE-> USE AS SIMPLE FLAG WHICH TELL STATE CHANGE LIKE IN THIS EXAMPLE/ MULTIPLE THREADS KO DEKHNA H not for COMPLEX
    }
}
