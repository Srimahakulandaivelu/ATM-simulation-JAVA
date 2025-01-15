import java.util.Scanner;

public class ATMsimulation{
    private int balance;
    private int pin = 1234;

    public ATMsimulation(int balance,int pin){
        this.balance = balance;
        this.pin = pin;
    }

    public void display(){
            System.out.println("1. Account balance\n");
            System.out.println("2. Amount deposit\n");
            System.out.println("3. Amount withdrawal\n");
            System.out.println("4. Change pin\n");
            System.out.println("5. Exit / End transaction\n");
    }

    public void accountBalance(){
        System.out.println("Current balance:" + balance);
    }

    public void deposit(int amount){
        balance += amount; 
        System.out.println("Current balance:" + balance);
    }

    public void withdrawal(int amount){
        if(amount > balance){
            System.out.println("Insufficient balance");
        }
        else{
            balance -= amount;
            System.out.println("Current balance:" + balance);
        }
    }

    public boolean  validate(int enteredpin){
       return (enteredpin == pin);
    }
     
    public void changePin(int newpin){
        pin = newpin;
        System.out.println("The pin has been changed");
    }

    public void end(){
        System.out.println("Thank you for using us");
    }

    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        ATMsimulation atm = new ATMsimulation(30000,1234);
        System.out.println("Enter your pin:");
        int pin = scan.nextInt();

        if(atm.validate(pin)){
            String ch;
            int choice;
            do{
                atm.display();
                System.out.println("Enter your choice:");
                choice = scan.nextInt();
                switch(choice){
                    case 1:
                       atm.accountBalance();
                       break;
                    case 2:
                       System.out.println("Enter the amount to deposit:");
                       int d_amount = scan.nextInt();
                       atm.deposit(d_amount);
                       break;
                    case 3:
                       System.out.println("Enter the amount to withdraw:");
                       int w_amount = scan.nextInt();
                       atm.withdrawal(w_amount);
                       break;
                    case 4:
                       System.out.println("Enter your new pin:");
                       int newpin = scan.nextInt();
                       atm.changePin(newpin);
                       break;
                    case 5:
                       atm.end();
                       break;
                    default:
                       System.out.println("Invalid choice");
                }
                System.out.println("Do you wnat to continue? (y/n)");
                ch = scan.next(); 

            } while(choice > 0 && choice < 6 && (ch.equalsIgnoreCase("y")));
    
        }
        else{
            System.out.println("Incorrect pin");
        }
    }
}