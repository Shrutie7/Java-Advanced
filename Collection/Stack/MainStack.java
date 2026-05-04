package Collection.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MainStack {
    public static void main(String[] args) {
        // STACK -> EXTENDS VECTOR
        // STACK FOLLOW LIFO LAST IN FIRST OUT PRINCIPLE -> LAST ITEM ADDED IN STACK IS FIRST ITEM TO BE REMOVED

        //EACH CLASS HAS DIFFERENT USE CASE
        //1. ARRAY LIST -> SEQUENTIAL -> GET -> O(1)
        //2. LINKED LIST -> EFFICIENT INSERTION AND DELETION
        //3. VECTOR -> SEQUENTIAL ->  GET-> O(1) -> THREAD SAFE SYNCHRONIZED METHODS
        //4. STACK -> LIFO -> SINCE STACK EXTENDS VECTOR IT IS SYNCHRONIZED MAKING IT THREAD SAFE

        // LIFO STRUCTURE: STACK FOLLOWS THE LAST IN FIRST OUT PRINCIPLE WHERE THE LAST ELEMENT ADDED IS THE FIRST ONE TO BE REMOVED
        // INHERITENCE: STACK IS A SUBCLASS OF VECTOR, WHICH MEANS IT INHERITS ALL FEATURES OF A DYNAMIC ARRAY BUT IS CONSTRAINED BY THE STACK'S LIFO NATURE

        // all methods of stack are SYNCHRONIZED -> PUSH POP PEEK EMPTY SEARCH
        //can do anything in stack its not limited bcoz extends vector has all prop of vector also
        Stack<Integer> stack = new Stack<>();
        //ADD -> PUSH METHOD
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

       // REMOVE LAST ELE-> POP METHOD RETURN ELE
        Integer removedElement = stack.pop();
        System.out.println(removedElement);

        //TO SEE WHAT IS IN TOP -> PEEK
        Integer peek = stack.peek();

        System.out.println(peek);
        System.out.println(stack);
        //CHECK IF STACK IS EMPTY -> IsEmpty System.out.println(stack.isEmpty());
        System.out.println(stack.empty());

        //CHECK SIZE
        System.out. println(stack.size());

        // SEARCH ->1 BASED INDEXING, INDEX GOES IN PARAM
        int search = stack.search(3); //top se index nikalega -> 2
        System.out.println(search);
        //4
        //3
        //2
        //1

         //BECAUSE STACK EXTENDS VECTOR WE CAN USE THE METHODS IN VECTOR -> ADD, ADD AT INDEX, REMOVE INDEX, REMOVE OBJECT

        // LINKEDLIST AS STACK
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);//push //aakhni me add kree
        linkedList.removeLast();//pop //akhri se remove kre
        linkedList.getLast();//peek
        linkedList.isEmpty();
        linkedList.size();

        //stack -> can be implemented with STACK CLASS OR LINKED LIST CLASS
        // internally stack also has internally array (as extends vector and vector has internally array)
        // Linkedlist bcoz its double ended linked list - we have pointer to tail (last element)
        // if java linked list was singly linked list we could not have been able to do this

        //bcoz stack is synchronized (overhead) in single threaded environment use Linkedlist

        // ARRAYLIST AS STACK ?
        // no dedicated methods -> arraylist stack ke implementation ke liye nhi bani h
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);//pop
        arrayList.add(1);
        arrayList.add(1);
        arrayList.get(arrayList.size()-1);//peek
        arrayList.remove(arrayList.size()-1);//push

        //ARRAYDEQUE -> use this bcoz it is recommendation and memory management is good here......

    }
}
