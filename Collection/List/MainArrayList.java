package Collection.List;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//ITERABLE-java.util- ROOT INTERFACE OF COLLECTION INTERFACE - CAN USE FOR EACH LOOP ON THE OBJECT OF CLASS THAT IMPLEMENTS IT -
// COLLECTION INTERFACE -> LIST, SET, QUEUE -> MAP SEPERATE INTERFACE
//LIST interface -> java.util -> EXTENDS COLLECTION INTERFACE(methods extend) -> ordered collection, duplicates allowed
// class implements LIST -> HAS TO IMPLEMENT ALL METHODS > ArrayList, LinkedList, vector, Stack
// LIST interface -> key feat-> ORDER PRESERVATION , INDEX BASED ACCESS, ALLOW DUPLICATES
// ARRAYLIST IMPLEMENTS LIST INTERFACE(LIST EXTENDS COLLECTION)
//Iterable(root) interface -> collection interface extends iterable -› List interface extends collection ->
// AbstractList class implements List and extends AbstractCollection(which implements collection) -> ArrayList class extends AbstractList
public class MainArrayList {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException{
        //ARRAY - size known already
        int[] arr = new int[10];

        //LIST -> dynamically size increases unlike Arrays
        //ARRAYLIST →> GENERIC CLASS PROVIDE TYPE OF WHAT U STORE. TO MAKE IT TYPE SAFE
        ArrayList<Integer> list = new ArrayList<>();// size = 0, capacity = 10 (INTERNAL ARRAY)
        // OR List is parent class so can write like below also .....
        List<Integer> list2 = new ArrayList<>();

        list2.add(2) ;
        list2.add(1);
        list2.add(7);

        //add at end
        list.add(1);
        list.add(5);
        list.add(80);
        list.add(80);
        //add at specific index
        list.add( 0,  0) ;

        //get (0 based indexing)
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        //list.get(3); //EXCEPTION NOT THERE

        //size
        System.out.println(list.size());

        //print all ele - iterate
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        //for each loop -> iterate over collection
        for(int i : list){
            System.out.println(i);
        }

        //check existence
        System.out.println(list.contains(5));
        System.out.println(list.contains(80));

        //remove element at particular index
        list.remove(2);

        //remove by value (remove firstOccurence of element) // make sure calling object one not index one call in WRAPPER CLASS
        list.remove(Integer.valueOf(80));
        System.out.println(list.toString());

        //insert in between konse index pe konsa elem -> khiskege ele towards right
        list.add(2,50);

        //set -> replace hoga 80 khiskega nhi
        list.set(2,50);

        //w/o loop print ele
        System.out.println(list.toString()); // print all element // ARRAYLIST EXTENDS ABSTRACTLIST (WHICH EXTENDS ABSTRACT COLLECTION(which implements COLLECTION) THAT HAS toString()) AND IMPLEMENTS LIST

        //INTERNAL WORKING
        //unlike regular array which has FIXED SIZE, ARRAYLIST CAN GROW/SHRINK AS ELEMENTS ARE ADDED OR REMOVED
        //THIS DYNAMIC RESIZING IS ACHIEVED BY CREATING A NEW ARRAY WHEN CURRENT ARRAY IS FULL AND COPYING ELEMENTS TO NEW ARRAY
        //internally ARRAYLIST IS IMPLEMENTED AS ARRAY OF OBJECT REFERENCES. WHEN WE ADD ELEMENTS TO ARRAYLIST ESSENTIALLY STORING ELEMENTS IN THIS INTERNAL ARRAY

        // ***WHEN WE CREATE ARRAYLIST INITIAL CAPACITY = 10 (DEFAULT) CAPACITY = SIZE OF INTERNAL ARRAY THAT CAN HOLD ELEMENTS BEFORE NEEDING TO RESIZE, *but when we just create a new arraylist size = 0 ****


        //ADDING ELEMENTS TO ARRAYLIST
        //1. CHECK CAPACITY - before adding new element Arraylist checks if enough space in internal array(elementData ->transient Object[] elementData) if array full need to RESIZE
        //2. RESIZE IF NECESSARY - If the internal array is full, ARRAYLIST WILL CREATE A NEW ARRAY WITH LARGER CAPACITY(USUALLY 1.5 TIMES CURRENT CAPACITY) AND COPY ELEMENTS FROM OLD ARRAY TO NEW ARRAY
        //3.  ADD THE ELEMENT - New element is then added to internal array at appropriate index and size is incremented

        //RESIZING THE ARRAY
        // 1. INITIAL CAPACITY - by default initial capacity = 10. means internal array can hold upto 10 elements before it needs to grow
        // 2. GROWTH FACTOR - when internal array is full, new array is created with size 1.5 times old array. growth factor balances memory efficiency and resizing cost
        // 3. COPYING ELEMENTS - When resizing occur all elements from old array copied to new array which is 0(n) operation, where n= no of ele in arraylist

        // REMOVING ELEMENTS
        // 1. CHECK BOUNDS - array list first checks if index is within valid range (index exists bhi krta h check)
        // 2. REMOVE THE ELEMENTS - element is removed and all elements to right of removed element are shifted one position to left to fill gap
        // 3. REDUCE SIZE - size is decremented by 1


        // ARRAYLIST DON'T AUTOMATICALLY SHRINK SIZE BUT WE CAN MAKE IT SHRINK TO SAVE MEMORY(save overhead); SO SET INITIAL CAPACITY WHILE CREATING

        ArrayList<Integer> list3 = new ArrayList<>(1000);
        System.out.println(list3.size());// = 0; not 1000 bcoz initialcapacity is 1000 means uptil 1000 elements the internal array can store no need to RESIZE UNTIL 1000 ELEMENTS
        //System.out.println(list3.get(0));//error ind out of bound exception

        ArrayList<Integer> list4 = new ArrayList<> (11);
        list4.add(1);
        list4.add(1);
        list4.add(1);
        list4.add(1);
        list4.add(1);
        list4.add(1);
        list4.add(1);
        list4.add(1);
        list4.add(1);
        list4.add(1);
        list4.add(1);// initial capacity of internal array = 11 no resizing (default = 10)
        //list4.add(1);// internal array size increases by 1.5 times initial capacity = 11*1.5 = 16 (integer)

        System.out.println(list4.size()); // 12

        //NO METHOD TO PRINT CAPACITY
        //USING REFLECTION -> to print capacity
        // ADD VM OPTIONS IN EDIT CONFIGURATION INTELLIJ -> --add-opens java.base/java.util=ALL-UNNAMED
        Field field = ArrayList.class.getDeclaredField("elementData"); //elementData is array package private h that's why do setAccesible true to access it using reflection
        field.setAccessible(true); // bcoz private
        Object[] elementData = (Object[]) field.get(list4);
        System.out.println("ArrayList capacity "+ elementData.length); //11

        list4.add(1);
        elementData = (Object[]) field.get(list4);
        System.out.println("ArrayList capacity "+ elementData.length); //capacity should increase (because initial capacity = 11) = 1.5*11 = 16

        //even if I remove element make the size back to 11 but the arrayList capacity stays 16 does not shrink automatically

        //till now size of list4 = 12
        list.remove(2);
        list.remove(2);
        list.remove(2);
        list.remove(2);

        //size of list4 = 8
        elementData = (Object[])field.get(list4);
        System.out.println("ArrayList capacity: "+ elementData.length); //16 (size apne ap shrink nhi hoga)

        //to shrink size of ArrayList //throw exception from the class and modify vm options in edit config
        list4.trimToSize(); // now internal array size will become 8(bcoz we removed 4 el from 12 el) to save memory or how many the ele are there now in arraylist

        elementData = (Object[])field.get(list4);
        System.out.println("ArrayList capacity: "+ elementData.length);

        //CREATING ARRAYLIST
        // 1. default constructor, creates an empty ArrayList with default capacity = 10
        ArrayList<String> arrayList = new ArrayList<>();
        List<String> arrayList1 = new ArrayList<>();
        System.out.println(arrayList1.getClass().getName()); //java.util.ArrayList

        //2. Creating ArrayList with specified initial capacity CAN GIVE CAPACITY OR ANOTHER COLLECTION
        ArrayList<String> listWithCapacity = new ArrayList<>(20) ;

        //3. Creating ArrayList from another collection
        // create on the fly list use Arrays, asList with comma separated returns list not ArrayList
        List<String> days = Arrays.asList("Monday", "Tuesday");//wrong if you write left side as ArrayList it return parent List not child ArrayList
        System.out.println(days.getClass().getName()); //java.util.Arrays$ArrayList
        // days.add("Wednesday"); //***EXCEPTION => BCOZ asList Returns a fixed-size list backed by the specified array.// CANNOT ADD / REMOVE CAN REPLACE
        days.set(1, "Wednesday"); //Tuesday replaced by wednesday
        System.out.println(days.get(1));

        String[] fruitsArray = {"Apple", "Mango", "Orange"};
        List<String> fruits = Arrays.asList(fruitsArray);
        System.out. println(fruits.getClass().getName()); //java.util.Arrays$ArrayList //nested static private class

        List<String> fruitList = new ArrayList<>(fruits); //can give in constructor initialCapacity or another collection
        fruitList.add("Avacado"); // can add this way
        fruitList.add("Apple");
        System.out.println(fruitList.toString());

        // remove by value (remove firstOccurence)
        fruitList.remove("Apple");
        System.out.println(fruitList);

        //new version of java-9
        List<Integer> integers = List.of(1, 2, 3, 4, 5); //Returns an unmodifiable list containing five elements(can add many ele as u want)

        //integers.set(2,33); //Immutable object is modified //UNSUPPORTED OPERATION EXCEPTION
        // Arrays.asList -> atleast replace allowed but with List.of its unmodifiable list nothing allowed*** List.of cannot contain null values

        //add all method -> pass collection
        list.addAll(integers);
        System.out.println(list);

        //integers.addAll(list); // Immutable object is modified //UNSUPPORTED OPERATION EXCEPTION


        // CONVERTING LIST TO ARRAY
        // CAN MENTION TYPE ALSO

        Object[] array = list2.toArray();
        Integer[] array1 = list2.toArray(new Integer[0]);// create new array we pass 0(convention) such that to tell we want which type of array(Integer/String)

        //SORTING AND ARRAYLIST
        Collections.sort(list2); //not needed for now use list.sort(null)
        // same as
        list2.sort(null); //null is COMPARATOR
        System.out.println(list2.toString());

        //TIME COMPLEXITY
        // ACCESS BY INDEX (get) is O(1)
        // ADDING AN ELEMENT IS O(n) in the worst case when resizing occurs(sare elements dubara se copy kone pad jaye)
        // REMOVING ELEMENT CAN BE O(n) because it may involve shifting elements(if first element remove kiya toh sare element khaskane pad jaenge)
        // ITERATION IS O(n)

    }
}
