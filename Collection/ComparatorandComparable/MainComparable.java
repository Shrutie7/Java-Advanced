package Collection.ComparatorandComparable;

import java.util.ArrayList;
import java.util.List;

public class MainComparable {
    public static void main(String[] args) {
            //o1-o2 = -ve -> o1 before o2 , // o1-o2 = +ve -> o1 after o2 // o1-o2 = 0 -> o1 equal to o2 same in both comparator and comparable
            /*comparator ->implements Comparator<T> interface compare (2 objects) outside the class -› custom sort logic */
            /*comparable -> implement comparable<T> interface compareTo (1 object) inside class -› natural ordering sort*/ // in Double class inbuilt compare method is there which has the if block use that dont write logic on ur own
            //custom sorting logic (not natural ordering) - comparator interface -> class ke bahar compare 2 objects if not given then comparable compareTo method will run(written within class)
            //comparator -> has compare method which takes 2 object of same type and compares //multiple criteria se sort krasakte  .thenComparing..
            //class ko batana aise sort krna (natural ordering batane ka tareeka) (custom class pe) - comparable interface // has compareTo method which takes the class object// single criteria se sort -> need to write within class
            //so when we do list.sort on custom class it knows what to sort by natural order(IF IMPLEMENTS Comparable) that logic is there within Comparable within that class when u put null


            // class ko batana iss tarah se sort krna
            List<Student> studentList = new ArrayList<>();

            studentList.add(new Student("Amy Santiago",3.7));
            studentList.add(new Student("Jake Peralta",3.5));
            studentList.add(new Student("Charles Boyle",3.4));
            studentList.add(new Student("Rosa diaz",3.4));

            //cannot be cast to comparable bcoz we didn't pass comparator(custom logic) we gave null(natural ordering) as comparator in custom class
            // for natural ordering to work so add implements Comparable interface(which takes type param T1) to Student(custom) class
            studentList.sort(null); // custom class throws exception // Collection.ComparatorandComparable.Student cannot be cast to class java.lang.Comparable //bcoz student class dont implement Comparable

            System.out.println(studentList);

            // for Integer (Primitive class) it will work with comparator as null
             List<Integer> integerList = new ArrayList<>();
             integerList.add(1);
             integerList.add(2);
             integerList.add(99);
             integerList.sort(null);// null as comparator does natural ordering //ASCENDING bcoz integer is PRIMITIVE CLASS
    }
}
