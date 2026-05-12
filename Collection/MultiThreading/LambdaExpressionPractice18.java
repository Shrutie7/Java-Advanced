package Collection.MultiThreading;

interface Student{
    String getBio(String name);
}
public class LambdaExpressionPractice18 {

    //instead of creating implementation class of Student implementing here only on fly
    public static void main(String[] args) {
        Student student = new Student() {
            @Override
            public String getBio(String name) {
                return name +" studies bio";
            }
        };

        String bio = student.getBio("Shruti");
        System.out.println(bio);


        //converted to lambda expression because interface Student is having only 1 abstract method so whatever we write in lambda expression is the implementation of that abstract method
        Student lawStudent = (name) -> name + " is law student ";

        //ek hi statement write in 1 line only inline bracket hata diya means yeh hi return krana chahte h

        // no need to write return bcoz statement lambda expression can be replaced with expression lambda so inline hoga also bcoz 1 line only in body remove bracket and remove bracket ke sath hi return aaiga
        // automatically means yeh hi return krana chahte h inline
        String bio1 = lawStudent.getBio("Ram");
        System.out.println(bio1);

    }
}
