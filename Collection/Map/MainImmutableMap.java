package Collection.Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainImmutableMap {
    public static void main(String[] args) {
        //Immutable Map -> map whose content cannot be changed/modified once it is instantiated cannot add/remove/update

        Map<String ,Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        // convert hashmap to unmodifiable map --> ***** use Collection.unmodifiableMap() *******
        Map<String, Integer> map2 = Collections.unmodifiableMap(map1); // Returns unmodifiable view of the specified map

        //can read but if you attempt to modify map2 returned map --> u will get UNSUPPORTEDOPERATIONEXCEPTION
        // map1 -> modify krsakte //map2 --> nhi modify krsakte

        System.out.println(map2);
        // map2.put("C",3);// throws EXCEPTION UNSUPPORTEDOPERATIONEXCEPTION cannot modify

        //DOWNSIDE of THIS bcoz we made view of original map map1 if someone modifies map1 below code or by mistake map.put("C",3)
        //so it creates mess that one map we can modify one we cant modify
        // so Map.of method came IN java 9
        // Map.of --> cleaner way to create immutable/unmodifiable map --> returns an unmodifiable map containing 2 mappings
        Map<String, Integer> map3 = Map.of("Shubham",98,"Vivek",89);
        System.out.println(map3);
        //map3. put ("Akshit", 88); // THROWS EXCEPTION UNSUPPORTEDOPERATIONEXCEPTION

        // LIMITATION OF Map.of -> only 10 key value pairs can be stored
        //so use Map.ofEntries -> unlimited entry can be stored
        Map<String, Integer> map4 = Map.ofEntries(Map.entry("Shubham",98), Map. entry("Vivek",89));
        System.out. println(map4);
        //map4. put ("Akshit", 88);// THROWS EXCEPTION UNSUPPORTEDOPERATIONEXCEPTION

    }
}
