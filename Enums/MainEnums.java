package Enums;

public class MainEnums {

    // within class also we can make enum
    //enums are inherently STATIC no need to add Static keyword BCOZ ENUMS ARE ATTACHED TO CLASS NA KI CLASS KE INSTANCE SE

    public enum Months {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static void main (String[] args)  {
       //Enums means Enumeration means listing things --› saal me kitne mahine, hafte me kitne din, college me kitne departments

       //IN OUR CODE IF A STRING IS USED MULTIPLE TIMES THEN MAKE IT A ENUM DEFINE A CONSTANT INSTEAD OF DUPLICATING LITERAL "SUNDAY" SO MANY TIMES BCOZ IN FUTURE U MAY MAKE MISTAKE
       // INTERFACE HAS automatically public STATIC final fields


       //frequently used data make it constant
        System.out.println(DayClass.MONDAY);
        System.out.println(DayClass.MONDAY);
        System.out.println(DayClass.SATURDAY);
        System.out.println(DayClass.SATURDAY);

        //MAKE AN ENUM AND GIVE VALUES COMMA SEPERATED

        System.out.println(Day.TUESDAY);
        System.out.println(Day.MONDAY);

        Day monday = Day.MONDAY;// internally likha h new Day ("MONDAY",1)
        //monday was instance of day so methods on it
        // methods
        //1. ordinal - index
        int ordinal = monday.ordinal();//monday ka index 1 h
        System.out.println(ordinal);

        //2.name --> same as enum given in String so as to run string operations like toLowerCase
        String name = monday.name();
        System.out.println(name.toLowerCase());

        //3. toString --> same as name method given enum in String
        String string = monday.toString();
        System.out.println(string.toLowerCase());

        //method on enum Day
        //1. valueOf() string ko enum me convert
        //if the string passed in valueOf matches the one present in enum then we get the o/p
        Day enumDay = Day.valueOf("MONDAY"); //MONDAY match hua h enum me thats y we get o/p in enumDay otw error as No enum constant IllegalArgumentException
        System.out.println(enumDay);// tostring internally chalta h
        // Day enumDay2 = Day.valueDf("MoNDAY");
        //System.out.println(enumDay2); //exception comes

        //2. values() give array
        Day [] values = Day.values();

        for(Day i : values) {
            System.out.println(i); // will print all from SUNDAY .....SATURDAY
        }

        System.out.println(monday.getLower()); // MONDAY string given in parameter of our constructor is called

        System.out.println(monday.getHindi());

        //switch case
        Day day = Day. MONDAY;

        // in new java version java 12 no need of break statement use ->
        // handle all cases unlike old switch because here we return wer not printing
        //in new switch version default is directly written instead of case default


        String res = switch (day){
        case SUNDAY -> "SU";
        case MONDAY -> "M";
        case TUESDAY -> "T";
        case WEDNESDAY -> "W";
        case THURSDAY -> "TH";
        case FRIDAY -> "F";
        case SATURDAY ->"S";
        default -> "Weekend";
    };
    System.out. println(res);


    System.out.println(Months.JANUARY);// in different class write Main.Months

    }
}
