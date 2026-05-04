package Collection.Iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainIterable {
    public static void main(String[] args) {
        //ITERABLE -> interface -> has iterable method that returns iterator -> to traverse over collection one by one  (also with for each loop and this also )
        // any class which implements iterable has functionality of for-each loop

        // how does that functionality come
        // create arrayList -> ArrayList implements List--> List extends Collection interface --> Collection interface extends Iterable interface

        // list me foreach use krpare --> bcoz ArrayList implements iterable and has method iterator creates object itr
        List<Integer> list = new ArrayList<>();

        //java internally translates below code to list. iterator()
            for (int i: list){
            System.out. println(i);
        }
        //to below code internally foreach aise
        // iterator method is implementation of iterable interface which returns iterator ka object hasNext help to iterate -› agar next h then ya end agya h
        Iterator<Integer> iterator = list.iterator(); //iterator type ka object lake do
        while (iterator.hasNext()) { // iterator point krta h collection me rkhe elements ko
            System.out.println(iterator.next()); // next element ko leke aata aur iterator ko ek position khiska deta h
        }

        // iterator - interface - which has methods hasNext, next and remove
        // iterator provides remove functionality while iterating and does not give ConcurrentModificationException so we use copyOnWriteArrayList that removes after this loop

        // copyOnWriteArrayList -> also wont give concurrentModification -> but loop ke badh remove hoga
        // iterator remove also will happen while iterating --> wont give concurrentModification --> loop chalte chalte will remove elements -->BENEFIT OF ITERATOR *

        List<Integer> numbers = new ArrayList<>(); //concurrentModification exception
        numbers.add (1);
        numbers.add (2);
        numbers.add (3);
        numbers.add (4);
        numbers.add (5);
        for (Integer num: numbers) {
            if (num % 2 == 0) {
                numbers.remove(num);
            }
        }
        //numbers se liya iterator ka object
            Iterator<Integer> itr = numbers.iterator();
            while (itr.hasNext()) {
                Integer num = itr.next();
                if (num % 2 == 0) {
                    itr.remove();
                }
            }
        System.out.println(numbers); // removes all even

        // listIterator object extends iterator interface has more methods hasNext() hasPrevious() ,nextIndex(), previousIndex() etc
        ListIterator<Integer> integerListIterator = numbers. listIterator();//use listIterator to loop in reverse order

        integerListIterator.hasNext();
        //set or replace current element --> using listIterator while
        while(integerListIterator.hasNext()) {
      //      integerListIterator.set(); //Replaces the last element returned by next or previous with the specified element
        }


    }
}
