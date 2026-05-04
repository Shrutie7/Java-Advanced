package Collection.List;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainLinkedList {
    public static void main(String[] args) {

        //List interface ki implementation class hai linked list (like arraylist -›internal array-> ele contiguously memory me stored h / sequential memory address h )
        //arraylist -> get(i) > O(1) time (using index lagatar stored )

        //Arraylist mein ek chiz store h har jagah, Linked list mein har ek jagah 2 chize store h -> element and pointer to next (pata agle ka)

        //The LinkedList class in Java is a part of the Collection framework and implements the List interface.
        //Unlike an ArrayList which uses a dynamic array to store elements, a LinkedList stores its elements as nodes in a doubly linked list, this provides different performance characteristics and usage scenarios compared to ArrayList

        //LINKEDLIST -> EACH ELEMENT CALLED NODE EACH NODE HAS -> 1. DATA 2. POINTER/REFERENCE

        //Each node has data store and address to next node and when linked list ends it points to null at end
        //SINGLY LINKED LIST          -> EACH NODE POINTS TO ONLY NEXT NODE
        //DOUBLY LINKED LIST          -> EACH NODE HAS DATA PREVIOUS AND NEXT
        //CIRCULAR SINGLY LINKED LIST -> LAST NODE WHICH POINTS TO NULL NOW POINTS TO FIRST NODE
        //CIRCULAR DOUBLY LINKED LIST -> LAST NODE WHICH POINTS TO NULL NOW POINTS TO FIRST NODE AND FIRST NODE WHICH POINTS TO NULL POINTS TO LAST

        Node node1 = new Node();
        Node node2 = new Node();

        node2.value = 2;
        node2.next = null;
        node1.value = 1;
        node1.next = node2;

        //here we are creating the linked list with 2 node but in java its inbuilt
        //java has doubly linked list by default
        // A linked list is a linear data structure where each element is a separate object called a node(box jaisa) Each node (fundamental unit/container) contains 2 parts:
        //DATA: THE VALUE STORED IN THE NODE
        //POINTERS: TWO POINTERS, ONE POINTING TO NEXT NODE (NEXT) AND THE OTHER POINTING TO THE PREVIOUS NODE (PREVIOUS)


        LinkedList<Integer> linkedList = new LinkedList<>();

        //ADD
        //INTERNALLY CREATING NODE WITH DATA IN EM AS 1,2,3
        linkedList.add (1);
        linkedList.add (2);
        linkedList.add (3);
        //ADD AT PARTICULR INDEX
        linkedList.add(3,4);

        //ADDALL, ADDLAST, ADDFIRST

        linkedList.addLast(5); //O(1) but in arraylist it is O(n) bcoz aage khiskane padte
        linkedList.addFirst(0); //O(1)


        // GET
        // LINKED LIST DOES NOT STORE IN CONTIGUOUS MEMORY LOCATION SO CANT GET USING INDEX DIRECTLY USE LOOP WE ONLY HAVE HEAD(START OF LINKED LIST) & SIZE
        // GET NOT POSSIBLE WITH OUR CREATED (custom) LINKED LIST BUT JAVA HAS DONE THAT ALSO
        linkedList.get(0); //O(n) need need to traverse(loop) no contiguous memory loc, O(1) in Arraylist
        // GETFIRST GETLAST (bcoz doubly linked list)
        linkedList.getFirst();
        linkedList.getLast();
        System.out.println(linkedList);


        // REMOVE
        // ARRAYLIST ME RHS KE ELEMENT KO LEFT KHISKANA PADTA THA BUT IN LINKED LIST SIRF POINTER KO POINT KRANA H NEW NODE SE
        // DELETION VERY EASY AND INSERTION IN BETWEEN VERY EASY (NEW NODE KO POINT KRA DENA) //ARRAYLIST ME ELEMENT KO SHIFT KRNA PADTA THA ONLY CHANGE POINTER
        // REMOVEFIRST, REMOVELAST, REMOVE WITH INDEX, REMOVE WITH OBJECT (REFERENCE) , REMOVEFIRSTOCCURENCE, REMOVELASTOCCURENCE, REMOVEALL, REMOVEIF (JAVA 8 -> PREDICATE PASS CONDITION EX: PUT EVEN/ODD)
        linkedList.removeIf(x->x%2==0); //if any ele fulfil this condition then wo remove hojainge (even remove)

        System.out.println(linkedList);

        //on fly create Linkedlist
        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "elephant"));
        LinkedList<String> animalsToRemove = new LinkedList<> (Arrays.asList ("Dog", "Lion"));

        // REMOVEALL -> TAKES ANOTHER COLLECTION IN IT (THERE IN ARRAYLIST ALSO)
        animals.removeAll(animalsToRemove);
        System.out.println(animals);




        //PERFORMANCE CONSIDERATIONS
        //Linked list has different characteristics compared to ArrayList
        // 1. INSERTIONS AND DELETIONS: LinkedList is better for frequent insertions and deletions in the middle of the list because it does not require shifting elements, as in ArrayList
        // 2. RANDOM ACCESS : LinkedList has slower random access(get(int index)) (O(n))compared to ArrayList(O(1)) bcoz it has to traverse the list from beginning to reach desired index(no contiguous memory location)
        // 3. MEMORY OVERHEAD : LinkedList requires more memory than ArrayList bcoz each node in a LinkedList requires extra memory to store reference to next and previous nodes



        // CAN ALSO WRITE LIST BCOZ IT PARENT OF LINKEDLIST WHILE CREATION
        List<Integer> LinkedList1 = new LinkedList<>();
        //CANNOT ACCESS ADDLAST, ADDFIRST, GETLAST, GETFIRST bcoz reference is parent(hence use LinkedList to use these methods) List only access those methods which r in LIST INTERFACE(add,get)


        // LINKEDLIST PADHA HAI AS LIST CAN BEHAVE LIKE STACK AND QUEUE ALSO ....

    }
}

class Node{
    public int value;
    public Node next; //REFERENCE TO NEXT NODE
}