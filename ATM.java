//Just for understanding oops concept in java using super keyword, this keyword, constructor ,class ,object, inheritance
import java.io.*;
import java.util.*;
class bankAccount
{
    private double balance;
    bankAccount(double balance)
    {
        this.balance=balance;			//this keyword refers to the current object
    }
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount)
    {
        if(amount>0)
        {
            balance+=amount;
            System.out.println("Money deposit successfully");
        }
        else
        {
            System.out.println("Invalid amount!!");
        }
    }
    public boolean withdraw(double amount)
    {
        if(amount<balance || amount>0)
        {
            balance-=amount;
            System.out.println("Money withdraw successfully..");
            return true;
        }
        else
        {
            System.out.println("Insufficient balance");
            return false;
        }
    }
}
class ATM_MACHINE extends bankAccount
{
    ATM_MACHINE(double balance)
    {
        super(balance);					//super keyword refers to the immediate parent class object, methods or constructor
    }
    Scanner sc=new Scanner(System.in);
    int pin=123;
    public void start()
    {
        System.out.print("Enter your pin:");
        int enteredPin=sc.nextInt();
        if(enteredPin==pin)
        {
            menu();
        }
        else
        {
            System.out.println("Sorry you entered wrong pin!!");
            //     start();
        }
    }
    public void menu()
    {
        int ch;
        do
        {
            System.out.println("1.Check Balance \n 2.Deposit Money \n 3.Withdraw Money \n 4.Exit");
            System.out.println("Enter Your choice:");
            ch=sc.nextInt();
            switch(ch)
            {
            
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit:");
                    int amount=sc.nextInt();
                    deposit(amount);
                    break;
                case 3:
                    System.out.println("Enter the amount to withdraw:");
                    int amt=sc.nextInt();
                    withdraw(amt);
                    break;
                case 4:
                    System.out.println("Thanks for using our ATM..Have a nice day..");
                    break;
                default:
                    System.out.print("Sorry Invalid choice");
            }
        }
        while(ch!=4);
        
    }
    public void checkBalance()
    {
        double balance=super.getBalance();
        System.out.println("Your account balance:"+balance);
    }
    public void deposit(double amount)
    {
        super.deposit(amount);
    }
    public boolean withdraw(double amount)
    {
        boolean status=super.withdraw(amount);
        if(status)
        {
            System.out.println("Please take your cash..");
        }
        return true;
    }
}
public class ATM
{
    public static void main(String args[])
    {
        double balance=500.00;
        ATM_MACHINE ob=new ATM_MACHINE(balance);
        ob.start();
    }
}