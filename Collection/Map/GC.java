package Collection.Map;

import java.lang.ref.WeakReference;

public class GC {
    public static void main(String[] args) {
        Phone phone = new Phone("Apple","17 pro max"); //object created in heap memory phone is reference jisko print kraya and wo kisko point krra//GENERAL REFERENCE - STRONG REFERENCE
        System.out.println(phone);//println calls toString method internally

        phone = null; // phone kisi ko point nhi krra

        // new Phone ("Apple", "17 pro max") yeh ab aisi hi padi hui h no one is pointing on it bcoz we set phone to null
        // jvm sees automatically that memory of new Phone ("Apple", "17 pro max") corresponding to this there is no reference(pointing to it) koi use nhi krra so destroy this memory so memory is available

        //Phone phone = new Phone(); here phone is **STRONG REFERENCE** DIRECTLY WITH THIS REFERENCE WE CAN ACCESS THE OBJECT , phone = null; then new Phone() is garbage(NO ONE POINTING TO IT) JVM WILL COME AND DESTROY IT
        // CALLED GARBAGE COLLECTION

        // System.gc(); // DONT TRY TO BE SMARTER THAN JVM REMOVE THIS CALL TO RUN GARBAGE COLLECTOR WILL THROW A WARNING -> this method suggests jvm to run garbage collection chalana nhi chalana jvm ki marji
        // System.out.println(phone); //null


        // WEAKREFERENCE
        WeakReference<Phone> phoneWeakReference = new WeakReference<>(new Phone("Apple","16 pro max"));

        // jvm dekhega weakreference ko aur kahega its not strong reference so isko uda dete h NOT BEING USED ANYWHERE
        System.out.println(phoneWeakReference.get()); // get method -> jo andr likha hua h wo object aajata h tostring call hota

        //use system.gc() as we r suggesting jvm to garbage collect jvm khud krega nhi krega koi guarantee nhi bcoz weakReference h so jum dekhta ki iski need nhi h itni after 10 sec so null krdega get krne se
        System.gc();
        //sleep main thread for 10sec after 10 sec- //bcoz Its weakRefrence jvm may or may not garbage collect the weak ref so we maybe get null when we do .get()
        try{
            Thread. sleep (10000);
        }catch (Exception ignored){
        }
        System.out.println(phoneWeakReference.get()); //null after 10 sec bcoz weakReference
        // jab tak Strong reference h kisi memory location ke liye tab tak garbage collection nhi hoga, phone = null(in case of strong ref) hoga tab garbage collection hoga


        //weakReference use krteh code me for caching purpose cache miss hojaiga -›cache me data nhi milega toh actual source se data le ainge aisi urgency nhi h uss data ki need h hi then use weakReference.....
        // NOW WEAKHASHMAP TO KNOW WHEN TO USE WEAKREFERENCE ...


    }
}
class Phone{
    String brand;
    String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}