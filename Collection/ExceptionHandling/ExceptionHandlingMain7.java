package Collection.ExceptionHandling;

public class ExceptionHandlingMain7 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(200);
        try {
            bankAccount.withdraw(400);
        }catch (InsufficientFundsException e){
            System.out.println(e);//java.lang.Exception: Insufficient Balance create custom exception - InsufficientFundsException
            // can also do e. getAmount
            System.out.println(e.getAmount());
        }

    }
}
class BankAccount{
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount>balance){
            //throw new Exception("Insufficient Funds");
            throw new InsufficientFundsException(amount);

        }
        balance-=amount;
    }
}

//custom exception -› 1. extends Exception 2. make constructor super // bcoz exception generalized h difficult to search custom exception se easy to log


class InsufficientFundsException extends Exception{
    private double amount;

    public InsufficientFundsException(double amount) {
        //super("What do you want? You dont have enough money!!");
        this.amount = amount;
    }
    public double getAmount() {
        return this.amount;
    }

    //instead of constructor can also use toString() method for custom exception //RECOMMENDED IS CONSTRUCTOR there we can set detail message so in detailmessage variable it will come and toString chl jaye class name: msg
    @Override
    public String toString() {
        return "What do you want? You dont have enough money!!";
    }
}