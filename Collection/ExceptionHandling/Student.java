package Collection.ExceptionHandling;

public class Student {

    public static int count = 0;

    static {
        System.out.println("Hello");
    }

    public Student(){
        count++;
    }
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    @Override
    public String toString(){
        return String.valueOf(id);
    }
}
