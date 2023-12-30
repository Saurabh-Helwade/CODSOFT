import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if(amount > 0) {
            balance = balance + amount;
            System.out.println("Amount has been deposited successfully. \nUpdated Balance :- " + balance);
        }
        else {
            System.out.println("Invalid Amount.");
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance = balance - amount;
            System.out.println("Amount has been withdrawl successfully. \nUpdated Balance :- " + balance);
            return true;
        }
        else {
            System.out.println(" Transaction Declined Due To Insufficient Balance ");
            return false;
        }
    }
}

public class ATM {
    private BankAccount bankAccount;
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void userinterface() {
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("     Welcome To State Bank Of India ATM     ");
        System.out.println("---------------------------------------------");
        System.out.println("\n --ATM Main Menu--");
        System.out.println("1. Balance Inquiry");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");

    }
    public void services(int option , Scanner scanner) {
        switch(option) {
            case 1:
                //Check Balance
                System.out.println("\nYour Transaction Is Successfull !");
                System.out.println("Available Balance :- Rs."+ bankAccount.getBalance());
                break;

            case 2:
                // Withdraw
                System.out.print("Enter The Amount To Withdrawal (Cash Available : Rs.100 , Rs.500) :- Rs.");
                double withdrawAmount = scanner.nextDouble();
                boolean success = bankAccount.withdraw(withdrawAmount); 
                if (success) {
                    System.out.println("\nAmount Rs."+withdrawAmount+ " Has Been Withdrawal Successfully.");
                    System.out.print("Would You Like To Display the Balance on the screen ? (yes/no) :- ");
                    String input = scanner.next();
                    if(input.equals("yes")){
                        System.out.println("Available Balance :- Rs." +bankAccount.getBalance());
                    }
                    else {
                        System.out.println("Thank You For Using SBI ATM !");
                    }
                } else {
                    System.out.println("\nSorry , Transaction Declined Due To Insufficient Balance In You Account.");
                }
                break;

            case 3:
                //deposit
                System.out.print("Enter Amount To Be Deposited In Account :- Rs.");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("\nAmount Rs." +depositAmount+ " Has Been Deposited Succesfully ! \nUpdataed Balance :- Rs." +bankAccount.getBalance());
                break;

            case 4:
                System.out.println("\nExiting ATM. Thank You For Using SBI Services ! Have A Nice Day\n");
                System.exit(0);
                break;

            default:
                System.out.println("\nTransaction Declined Due To Invalid Option");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter The Intial Balance Of Your Bank Account :- Rs.");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while(true) {
            atm.userinterface();
            System.out.print("Select Banking Option :- ");
            int option = scanner.nextInt();
            atm.services(option, scanner);
        }
        
    }
    
}
