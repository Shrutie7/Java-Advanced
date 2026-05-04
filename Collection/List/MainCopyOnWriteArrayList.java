package Collection.List;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainCopyOnWriteArrayList {
    public static void main(String[] args) {
        //ARRAYLIST, LINKEDLIST ARE NOT THREAD SAFE IF WE DO CONCURRENT MODIFICATIONS WE GET INCONSISTENT RESULTS
        // VECTOR STACK -> SYNCHRONIZED H BUT BCOZ OF LOCK WE DONT GET MUCH PERFORMANCE
        // CopyOnWriteArrayList came
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        //"Copy On Write" means that whenever a write operation
        // like adding or removing an element
        // instead of directly modifying the existing list
        // a new copy of the list is created and the modification is applied to that copy
        // This ensures that other threads reading the list while its being modified are unaffected

        // READ OPERATIONS: FAST AND DIRECT, ORIGINAL LIST SE CHIZE READ HONGI, SINCE THEY HAPPEN ON A STABLE LIST WITHOUT INFERENCE FROM MODIFICATIONS

        //WRITE OPERATIONS: A NEW COPY OF THE LIST IS CREATED FOR EVERY MODIFICATION
        //                  THE REFERENCE TO THE LIST IS THEN UPDATED SO THAT SUBSEQUENT READS USE THIS NEW LIST

        // NOTEPAD --> NOTEPAD -COPY

        // USE THIS WHEN WE HAVE READ INTENSIVE CHIZE BCOZ ON EVERY WRITE WE WILL HAVE A NEW COPY SO A LOT OF MEMORY CONSUMPTION WRITE KAM READ ZYADA

        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("Bread");
        shoppingList.add("eggs");
        shoppingList.add("milk");
        System.out.println("Initial array list: "+shoppingList);

        for (String item: shoppingList) {
            System.out.println(item);
//            if (item.equals("eggs")){
//                shoppingList.add("butter");
//                System.out.println("Added butter while reading");
//            }
        }
        //System.out.println("Updated shopping list: "+shoppingList);//error **ConcurrentModificationException//means arraylist modify hogyi h while we r iterating
        // arraylist stable hona chaiye iterate knte time java expects stable photo in case of arraylist
        // change to copyOnWriteArrayList

        List<String> shoppingList1 = new CopyOnWriteArrayList<>();
        shoppingList1.add ("Bread");
        shoppingList1.add("eggs");
        shoppingList1.add ("milk");
        System.out.println("Initial array list: "+shoppingList1);

        for (String item : shoppingList1){
            System.out.println(item);

            if(item.equals("eggs")){
                shoppingList1.add ("butter");
                System.out.println("Added butter while reading");
            }
        }
        System.out.println("Updated shopping list: "+shoppingList1);

        //BENEFIT OF copyOnWriteArrayList -> READING AND MODIFYING SAME TIME PE HORHE H
        // read horahah snapshot pe and jo modify(write) hora wo dusri copy/photo pe horaha h

        // loop jo chal naha wo original list pe chal rahah //jab loop khatam hojaiaga then only shoppingListl reference wo nayi modified list ke barabar hoga

        // loop me stable snapshot of shoppingListl fir modifiy hoga new photo create krega, loop keep on running on old stable shoppingListl once loop ends then only shoppingList1 is modified and points to new modified List
        // purani = new -> LOOP SE NIKALNE KE BADH

        // THIS IS ALL SINGLE THREADED

        // CREATE A LIST, create 2 thread -> READER THREAD AND WRITER THREAD
        List<String> sharedList = new ArrayList<>();
        //CopyOnWriteArrayList<String> sharedList = new CopyOnWriteArrayList<>();

        sharedList.add("Item1");
        sharedList.add("Item2");
        sharedList.add("Item3");

        //list me iteration bar bar item ko print kre
        // infinite loop chal haha and shared list ko padh rhe h bar bar usi time hamne write knne ki koshish kri (Add and remove ele)
        Thread readerThread = new Thread(()-> {
            try {
                while (true) {
                    for (String item : sharedList) {
                        System.out.println("Reading item: " + item);
                        Thread.sleep(100); //SMALL DELAY TO SIMULATE WORK
                    }
                }

            } catch (Exception e) {
                System.out.println("Exception in reader thread: " + e);
            }
        });

    //in writer thread add new item 4 and removing item
    Thread writerThread = new Thread (()->{
    try {
        Thread.sleep(500); //Delay to allow reading to start first //0.5sec Lg ra
        sharedList.add("Item4");
        System.out.println("Item4 added to list");

        Thread.sleep(500);
        sharedList.remove("Item1");
        System.out.println("Removed Item from the list");
    }catch(Exception e){
        e.printStackTrace();
    }
    });

    readerThread.start();
    writerThread. start();
    //EXCEPTION: CONCURRENT MODIFICATION EXCEPTION

     //bcoz writer thread ne modify kone ka try kiva while the reading thread is iterating over the list beez array list dont support this
     // but when we write CopyOnWriteArrayList no exception will come................. infinite loop works
    }
}