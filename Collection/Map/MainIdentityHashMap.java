package Collection.Map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class MainIdentityHashMap {
    public static void main(String[] args) {
        //STRING IS A PRIMITIVE CLASS NOT CUSTOM CLASS IN JAVA WHICH INTERNALLY HAS HASHCODE METHOD AND EQUALS METHOD HENCE IT WILL REPLACE
        // if class don't have hashcode function it uses the hashcode of Object class(which is the memory address play)
        // bcoz string class has its own definition of hashcode hence for both key1 and key2 hashcode will be same index same and index me already there (bcoz equal h unequal hota then collision linked list) so it will replace
        String key1 = new String("key");
        String key2 = new String("key");
        //BOTH ADDRESS OF KEY1 AND KEY2 DIFFERENT
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 1);//key, 1
        map.put(key2, 2);//key , 2
        System.out.println(key1.equals(key2)); //true hence replace

        //equal check kiya jata h equals() method se //we wrote in custom class in Person class, internally it is checking this if (node.key.equals(key)){ //KEY MATCHES RETURN VALUE return node.value}
        System.out.println(map); // {key =2}

        //in case of identity hashmap both keys will come replace dont happen
        // hashcode and equals method

        // ****whether your class has hashcode or not**** in IDENTITY HASHMAP Object hashcode will only work means String class ka khud ka hashcode method h but idenetityhashmap will use Object class ke andr ka hashcode which plays with memory address that is used **

        //hence hashcode different hoga dono ka hashcode (memory diff) object class ka hoga hence index/bucket different -> String key3 = new String("key"); String key4 = new String("key");
        String key3= new String("key"); // hashcode = 1
        String key4 = new String("key"); //hashcode = 1
        Map<String, Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(key3,1);//key, 1
        identityHashMap.put(key4,2);//key , 2
        // say if hashcode comes to be same for both key3 and key4 then equality is not checked using ** .equals method(no content check)** equality check is done with == (REFERENCE MEMORY ADDRESS CHECK) in IDENTITYHASHMAP

        // IDENTITYHASHMAP //***** IDENTITYHASHCODE -> (Object class ka hashcode CHALEGA) AND == (equality check) not equals method
        // == true replace existing entry (same memory address)
        // == false creates a new entry (diff memory address)

        System.out.println(identityHashMap); //  (key=1,key=2} both will come no replacement



        //System.identityHashCode() method gives the hashcode of the object class irrespective of whether the class overrides the hashcode method of object class hence both come different and 2 entries are created in identityHashMap
        System.out.println(System.identityHashCode(key3));
        System.out.println(System.identityHashCode(key4));


        //This below will call hashcode method of String class hence both are same
        System.out.println(key3.hashCode());
        System.out.println(key4.hashCode());


        //HASHMAP -> IF CLASS HAS HASHCODE METHOD IT WILL USE THAT IF NOT USES OBJECT CLASS KA HASHCODE METHOD
    }
}
