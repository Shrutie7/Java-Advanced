package Collection.Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


//when we do map.get() to retrieve data it traverses through linked list and checks key to match it in 0(n) time
//check happens using ** equals() method checks equality ** and returns value corresponding to that key //HASHCODE METHOD GENERATES HASHCODE
// every class implements object class and object has hashcode()-›memory address and equals() -›Reference
// both method by default checks address only
//***MAKE SURE WHENEVER U MAKE CUSTOM CLASS AND PASS IN CUSTOM OBJECT IN MAP INSTEAD OF PREDEFINED CLASS(STRING/INTEGER) THEN ALWAYS WRITE hashcode() method and equals() method***
//in case of set also write hashcode() and equals() method bcoz it will store unique values only if we dont write it will create 2 different alice
// principle of hashmap used in set
public class HashCodeAndEqualsMethod {
    public static void main(String[] args) {
        //hashmap with person (custom object) & their designation
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person ("Alice",1);
        Person p2 = new Person ("Bob",2);
        Person p3 = new Person ("Alice",1);
        //p1 and p3 objects are same name same id; hashcode generate hota usse index aata yaha pe PERSON CLASS OBJECT KO EXTEND KRII H OBJECT KE ANDR HASHCODE KYA RAKHA HUA H
        // creates 3 different entries inside map bcoz using new keyword when creating p3 and p1 object so not same anymore they'll be kept at different index BCOZ NEW KEYWORD SE 3 DIFFERENT HASHCODE GENERATE HOGE BCOZ HAMNE NHI LIKHI H HASHCODE KI DEFINITION JAB TAK
        // hashcode different for p1 and p3 and index different //its not like p3 will replace p1 in map since they r not same unless equals and hashcode method there

        map.put(p1,"Engineer");//hashcodel -> index1
        map.put (p2, "Designer"); //hashcode2 -> index2
        map.put (p3,"Manager");;//hashcode3 -> index3(w/o) (object ke andr hashcode memory ke sath khelte hence different) (w/o equals and w/o hashcode); hashcode1 -> index1 --> equals() p3.equals(p1) checks name and id (same) --> replaces and map size back to 2 bcoz of hashcode and equals method
        //in object hashcode plays with memory index1 and index3 are different when no equals() and no hashcode() method
        System.out.println(map.size());//3 (w/o)//2 bcoz of equals() and hashcode() method otherwise 3

        Map<String, Integer> map1 = new HashMap<>();
        //here entry of Shubham in map is same hence same hashcode same index will be generated so we check equals method to check equality to get the value of key shubham in bucket array
        map1.put("Shubham", 90);//hashcode1 -> index1
        map1.put("Anaya", 85); //hashcode2 -> index
        map1.put("Subham",99);//hashcode1 -> index1 -> equals() --›replace (bcoz String class ka apna hashcode method h)
        System.out.println(map1.size()); //2
        System.out.println(map.get(p1)); //Engineer (w/o) //Manager if equals() and hashcode() method written
        System.out.println(map.get(p3)); //Manager

        // by default println uses toString() method otherwise gives a memory address
        System.out.println(p1); // with toString method gives the person otw memory address
        // every person different hashcode and when equality check for id as well as name



    }
}
class Person{
    private String name;

    private int id;

    //constructor setter isi me
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //generate override methods

    @Override
    public boolean equals(Object obj) {
        //checking 3 edge cases same object check, current object checked with null, getClass() method in object not equal to object class means checking 2 different instance of class
        if (this == obj)
        {
            return true; // same object check
        }
        if (obj == null){
            return false; // current object being checked with null
        }
        if(getClass() != obj.getClass()){
            return false; // getClass() method in object not equal to object class means checking 2 different instance of class
        }
        //main part here
        // Objects is utility class different than Object class
        // cast object to person
        Person person = (Person) obj;
        //check id of current instance matches with id of other
        //in string check equality using .equals() to avoid null pointer exception bcoz name can be null so do Objects.equals(Objects different than Object class)
        return id == person.id && Objects.equals(name, person.getName());
    }

    @Override
    public int hashCode() {
        //Objects is utility class
        return Objects.hash(name, id); // uses internally Arrays.hashcode and make sure that hashcode generated is input same output same
    }

    // by default println uses toString() method otherwise gives a memory address
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

//difference between equals and hashcode
//1. equals() check logical equality between 2 objects, boolean, override for object equality , you call/collection, a.equals (b)
//2. hashcode() returns hashvalue, integer, must override *****if equals() method overridden****, collection calls internally, a.hashCode()

//********must override hashcode() method if equals() method overridden ************* if not hashmap fails 2 equal person may go to different bucket (should go to same bucket index)

//calls hashcode() to find bucket index
// calls equals() to check for equality and (find the value of the key )to compare keys in case of collision

//hashcode - bucket index
// equals - exact match

//equal objects must have equal hashcode