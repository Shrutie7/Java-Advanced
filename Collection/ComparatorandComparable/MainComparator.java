package Collection.ComparatorandComparable;

import java.util.*;

public class MainComparator {
    public static void main(String[] args) {
        //Comparator is interface which helps to do custom ordering
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(5);
        list.add(11);

        list.sort(null); //comparator send as null //NATURAL ORDER OF SORTING -> ASCENDING
        System.out.println(list);

        list.sort(new IntegerComparator());
        System.out.println(list);

        list.sort((a,b)->b-a);//DESCENDING -> REVERSE KRKE - // ASCENDING AS IS -

        List<String> words = Arrays.asList("banana", "apple", "date");
        words.sort(null);//ascending -> natural order
        System.out.println(words);

        words.sort(new StringLengthComparator());
        System.out.println(words);

        words.sort((a,b) ->b.length()- a.length()); //DESCENDING IN LAMBDA ONLY -> INSTEAD OF WRITING COMPARATOR //REVERSE WAY ascending ka kaam null se
        System.out.println(words);

        //say we need to sort in descending order -> on basis of length of string -> custom logic -> help of COMPARATOR
        // Comparator interface has compare method which compares 2 objects of same type (int compare(T o1, T o2)) and determines their order;
        // has @FunctionalInterface annotation at top of Comparator interface
        // to use this interface we need to make a implementation class or use lambda exp which implements compare method
        // Make StringLengthComparator which implements Comparator interface and override the compare method inside it write logic of how u want to sort
        // call the instance of this stringComparator in sort instead of null -> words.sort(new StringLengthComparator()))
        // SORT METHOD COMPARATOR LETA HAI AND COMPARE METHOD 2 CHIZO KO I/P LETA H
        //public int compare(Object o1, Object o2) -> this int tells relative order of 2 things that is passed in i/p
        // -> -ve -> o1 pehle o2 badh mein
        // -> +ve -> o1 badh mein o2 pehle
        // -> o1==o2 equal h same preference

        //inbuilt class -> String,Integer implements Comparable which has compareTo method
        //custom class like Student
        List<Student> student = new ArrayList<>();
        student.add(new Student("Amy Santiago",4.0));
        student.add(new Student("Jake Peralta",3.5));
        student.add(new Student("Charles Boyle",3.5));
        student.add(new Student("Rosa Diaz",3.4));

        //student. sort(null); //**ERROR** NATURAL ORDERING BUT NOTHING IS THERE in student class like it doesn't implements Comparable and dont have compareTo method

        //sort by descending order of gpa => write comparator in lambda exp inside sort

        //student.sort((a,b) -> (int) (b.getGpa() - a.getGpa())): // ERRORRR -> will come as is ->bcoz gpa is double cast to integer //blunder bcoz everything on - and on casting will turn to 0
        // write conditions so it returns int only

        //1.....
        // DESCENDING ME SORT BY GPA
        student.sort ((o1,o2) -> {
            if (o2.getGpa() - o1.getGpa() > 0) {
                return 1; // +ve mtlb 02 badh mein aaiga 01 ke
            } else if (o2.getGpa() - o1.getGpa() < 0) {
                return -1; //--ve mtlb 02 pehle aaiga o1 ke
            } else {
                //Charles then jake comes
                //compareTo method in String -> o1 pehle aata h dictionary me o2 se then -ve , o1 badh me aata h dictionary mein then +ve, o1 and o2 equal h then 0
                return o1.getName().compareTo(o2.getName()); //sort lexicographically by dictionary in ascending order if gpa is same
            }
        });

        //same gpa wale student jis order me woh create hue h uss order me aaenge
        for ( Student s : student){
            System.out.println(s.getName()+": "+s.getGpa());
        }


        //METHOD REFERENCING AND FUNCTION-> JAVA8
        //Comparator interface has comparing static method which takes a function -> method reference (double colon operator) as input
        //we will get comparator object = comparing pass this in the students.sort(comparator)
        //2.......
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);//student me konsa method call krna h each student pe -> getGpa and unko compare krna h
        // .reversed -> DESCENDING //.thenComparing-> (same GPA wale name se sort kre)
        // write above line in that big if-else also above

        student.sort (comparator); //pass comparator object so sorts by gpa in ASCENDING ORDER

        for ( Student s : student) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }



        //Collection.sort mein comparator object ko pass jo upr create kiye using Comparator.comparing(method ref) and can chain also on this .reversed().thenComparing()...
        Collections.sort(student, comparator);
        //or directly use student.sort (comparator)


        // can also make custom comparator implements Comparator interface and override the compare method or write lambda expression

    }
}

//"ok","bye" -> length of ok less than bye therefore need to come first in same order
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare (String o1, String o2) {
        //write sort logic here
        //return o2.compareTo(o1); //compares dictionary order descending
        //return o1.length()-o2.length(); //-ve mtlb o1 pehle aaega o2 ke // ascending order
        return o2.length() - o1.length(); // +ve mtlb o1 badh mein o2 pehle // descending order
    }
}

//o1 = 5 , o2 = 3 ; => o1-o2 = +ve , o1 badh mein o2 pehle (ascending order)
//o1 = 3 , o2 = 5 ; => o1-o2 = -ve ,o1 pehle o2 badh mein (ascending order)

//o1 = 3,  o2 = 5 => o2-o1 = +ve , o1 badh mein o2 pehle(descending)
//o1 = 5,  o2 = 3 => o2-o1 = -ve , o1 pehle o2 badh mein (descending)

class IntegerComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        //ASCENDING
        // return o1 - o2;

        // DESCENDING
        return o2-o1;
    }
}



class Student implements Comparable<Student>{
    private String name;
    private double gpa;

    public Student(String name, double gpa){
        this.gpa = gpa;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if(obj == null)
        {
            return false;
        }
        if(obj.getClass()!=getClass())
        {
            return false;
        }
        Student other = (Student)obj;
        return Double.compare(gpa,other.gpa)==0 && Objects.equals(name,other.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }



    //4.compareTo (3) //descending-> 4,3 (negative return krega 3-4, 4 pehle aaiga) o1-o2 = -ve o1 pehle aaiga
    //gpa -> double hai hence write this entirely if block // Double class hai compare method inbuilt
    // better to use Double.compare method which takes 2 object has written this complete if block in its own method so no need to write all of it by ourselves
    @Override
    public int compareTo(Student o) {
//        if(o.getGpa()-this.getGpa()<0){
//            return -1;
//        }
//        else if(o.getGpa()-this.getGpa()>0){
//            return 1;
//        }
//        else{
//            return 0;
//        }

        //in Double class inbuilt compare method is there which has the if block use that dont write logic on ur own
        return Double.compare(o.getGpa(),this.getGpa()); // a-b = -ve a before b (gpa 4 before 3 so should come -ve 3-4 = -1 )//a-b = +ve a after b//DESCENDING ORDER
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}