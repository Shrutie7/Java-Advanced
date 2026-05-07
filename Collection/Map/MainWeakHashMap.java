package Collection.Map;

import java.util.Map;
import java.util.WeakHashMap;

public class MainWeakHashMap {
    public static void main(String[] args) {
        //WeakHashmap extends AbstractMap and implements MAP

        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        //imageCache.put("img1",new Image("Image1"));
        //imageCache.put("img2",new Image("Image2" ));
        //System.out.println(imageCache); //calls internally toString




        // System.gc(); // suggest garbage collection to jvm but wont happen still we will still see the image cache after 10sec
        // BCOZ AN ENTRY IN WEAKHASHMAP WILL AUTOMATICALLY BE REMOVED WHEN ITS KEY IS NO LONGER IN ORDINARY USE ... weak keys*** only keys are garbage collected value garbage collect hogi ya nhi depends on if its strong reference or not depends on JVM

        //nothing removed we still see imageCache after 10sec because key is string literal STORED IN STRING POOL HENCE THEY ARE STRONG REFERENCED AND NOT GARBAGE COLLECTED
        // STRING POOL ME STRING LITERALS **STRONG REFERENCED** THROUGHOUT THE LIFECYCLE OF PROGRAM EVEN IF NO ONE IS USING JAVA KEEPS IN MEMORY TILL PROGRAM IS COMPLETE, SO THAT ANY NEW LITERAL same IS MADE SAY img2 then it can use from same memory same string pool same string literal
        // MAKE NON LITERAL KEYS SO THEY ARE GARBAGE COLLECTED
        // make 2 objects and use them dont use string literals



//        String key1 = new String("img1");
//        String key2 = new String("img2");
//         imageCache.put(new String("img1"),new Image("Image1"));
//         imageCache.put(new String("img2"),new Image("image2"));


        loadCache(imageCache); //we can send weakhashmap in the loadcache function which takes map because map is PARENT CLASS OF WEAK HASHMAP



        //before garbage collection make key1 and key2 as null **so there is no reference of key1 or key2 then imageCache is also null{}
        //key1 = null;
        //key2 = null;
        // BUT WE NEVER DO NULL TO KEY EXPLICITELY SO DONT KEEP STRONG REFERENCE ONLY IN THE FIRST PLACE REMOVE THE STRONG REFERENCE FROM KEY1 AND KEY2 AND KEEP DIRECTLY IN imageCache.put new String so NO STRONG REFERENCE NO NEED OF NULL
        //
        // to keep variable make this in different method loadCache

        System.out.println(imageCache);
        System.gc();

        simulateApplicationRunning();//waits main thread for 10 sec //create this method
        // after use there is no STRONG REFERENCE FOR THESE IMAGES ONLY WEAK REFERENCE

        System.out.println("Cache after running (some entries may be cleared)" + imageCache); //waits 5 sec but no entry will clear



        // use cache if cache miss then we can get data from actual source but place where we use hashmap we start using weakHashMap then its a PROBLEM

    }

    public static void loadCache(Map<String,Image> imageCache){
        //created strong ref but scope is limited to this func
        String k1 = new String("img1") ;
        String k2 = new String("img2") ;
        //even we took strong reference of k1 k2 (created in string pool) but THERE SCOPE IS TILL THIS FUNCTION ONLY not outside
        // jvm dekhega weakhashmap hai but keys are not strong referenced their scope is till here only hence jvm ne hata diya after 10s
        imageCache.put(k1,new Image("Image1"));
        imageCache.put(k2,new Image("image2")) ;

    }
    private static void simulateApplicationRunning(){
        try{
            System.out.println("Simulating Application running: ");
            Thread.sleep(10000);

        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }
}
//if we r using image multiple times then store it in cache so if we r not using this image and using another image we will remove it from cache

class Image{
    private String name;

    public Image(String name){this.name = name;}

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                '}';
    }
}
