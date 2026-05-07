package Collection.Map;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class MainEnumMap {
    public static void main(String[] args) {
        //internal array of size same as enum
        //[_,_,_,_,_,_,_] --> WHEN WE PUT --> PEHLE ORDINAL NIKLEGA THEN WE GO TO THAT INDEX AND INSERT THERE --> [_, "Swimming",_,_,_,_,_,_] // same in get also pehle ordinal and then go to index and get that value
        //NO HASHING
        //ordinal/index is used
        //FASTER THAN HASHMAP
        //MEMORY EFFICIENT

        //ENUMMAP DIRECTLY IMPLEMENTS MAP INTERFACE -- no hashing needed unique index automatically aata h from index/ordinal hashing function jisse unique value generate hoti h
        //EnumMap is very fast access insertion very fast no collision no hashing no hashcode no rb tree no linked list
        // key is enum Day
        Map<Day, String> map = new HashMap<>();// sonar issue NON-COMPLIANT convert this map to ENUMMAP
        //If all keys in MAP are from single enum it is recommended to use an ENUMMAP AS THE SPECIFIC IMPLEMENTATION AN ENUM MAP HAS ADVANTAGE OF KNOWING ALL KEYS IN ADVANCED MORE EFFECIENT
        //MAKE ENUMMAP INSTEAD OF HASHMAP AND IN CONSTRUCTOR GIVE ENUM.CLASS
        //in hashmap need to resize rehash in EnumMap all keys known so it has them no need to resize or rehash in hashmap bucket index comes
        //here enum is there it has internal array inside which has index called ORDINAL (ORDINAL IS INDEX)
        Map<Day, String> enumMap = new EnumMap<>(Day.class);
        enumMap.put(Day.TUESDAY, "Swimming"); // here key ka hashcode nhi niklega maps to index of enum
        enumMap.put(Day.MONDAY, "Gym");
        //also order in enum is maintained wtv in enum same order it will print
        System.out.println(Day.TUESDAY.ordinal());//1
        System.out.println(enumMap);
        String s = enumMap.get(Day.TUESDAY);
        System.out.println(s);
    }
}

enum Day{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}