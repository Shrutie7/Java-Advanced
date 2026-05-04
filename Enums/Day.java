package Enums;

public enum Day {
//COMMA SEPERATED
//these are all final instances of Day class

// make constructor bcoz it will call default constructor only internally
// this in turn will call out constructor given inside enum
// there r 2 constructor one which is default and another written by us that will be called
// can give multiple values also and make constructor accordingly

    SUNDAY (  "Sunday",  "shanivaan"),
    MONDAY (  "Monday",  "somwaar"),
    TUESDAY (  "Tuesday",  "somwaar"),
    WEDNESDAY ("Wednesday",  "somwaar"),
    THURSDAY (  "Thursday",  "somwaar"),
    FRIDAY ( "Friday",  "somwaar"),
    SATURDAY ( "Saturday",  "somwaar");

    // bcoz internally enum is converted to class we can write method inside it // we can also make field also
    //BUT THE FIRST THING IN ENUM BODY IS ENUMCONSTANTS THEN MAKE FIELD AND METHOD //with every instance we can run the display() method

    private String lower;
    private String hindi;

    private Day(String lower, String hindi) {
        System.out.println("Our constructor called");
        this.lower = lower;
        this.hindi = hindi;
    }

    public String getLower() {
        return lower;
    }

    public String getHindi() {
        return hindi;
    }

    public void display() { System.out.println( "Today is" + this.name()); }

}

//At compile time the code becomes Day becomes final class no one can extend this bcoz we want it to be a fixed set of constant
//public final class Day extends java.lang. Enum<Day> {
//public static final Day SUNDAY = new Day ("SUNDAY", 0); // constructor me string and ordinal (index)
//public static final Day MONDAY= new Day ("MONDAY", 1);
// public static final Day TUESDAY= new Day ("TUESDAY", 2);
//public static final Day WEDNESDAY= new Day ("WEDNESDAY", 3);
//public static final Day THURSDAY= new Day ("'THURSDAY", 4);
//public static final Day FRIDAY= new Day ("FRIDAY", 5);
// public static final Day SATURDAY= new Day ("SATURDAY", 6);

//private static final Day[] VALUES={SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};

//public static Day[] values {return VALUES.clone() } // returns clone of $VALUES
//public static Day valueOf(String name) {
//    for (Day day: VALUES) {
//        if (day.name().equals(name)){
//       return day;
//    }
//}
// throw new IllegalArgumentException ("No enum constant" + name)
//}
//constructor
//private Day(String name, int ordinal) {
//super (name, ordinal);
//}
//}
