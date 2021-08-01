import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.TreeMap;


public class BankingApp {
    public BankingApp() {
    }
    public static void main(String[] args) {
            BankingApp obj1=new BankingApp("Sezin Demir","200126");
             obj1.showMenu();
        }
        static Logger log= LoggerFactory.getLogger(BankingApp.class);
        static String customerName;
        static String customerId;
        double preTransaction;

        BankingApp(String cName, String cId){
            customerName=cName;
            customerId=cId;
        }

    // this is for checking account
    int ca=333777 ;
    double ca1=10000.00;
    //this is for savings account
    int sa=333666;
    double sa1=10000.00;

    double deposit1(double amount) {
        if (amount>0) {ca1=ca1+amount;
            preTransaction=amount;
        }else {System.out.println("Error!Deposit amount must be greater than zero");
        }
        return amount;
    }
    void deposit2(double amount) {
        if (amount>0) {sa1=sa1+amount;
            preTransaction=amount;
        }else { System.out.println("Error!Deposit amount must be greater than zero");
          }
    }
    void withdraw1(double amount) {
        if(ca1>amount) {ca1=ca1-amount;
            preTransaction=-amount;
        }else {System.out.println("Error!Insufficient funds");
        }
    }
    double withdraw2(double amount) {
        if(sa1>amount) {sa1=sa1-amount;
            preTransaction=-amount;
        }else {System.out.println("Error!Insufficient funds");
        }
        return amount;
    }
    double getPreTransaction(){
        if (preTransaction>0) {System.out.println("Deposited amount:"+"$"+preTransaction);}
        else if(preTransaction<0) {System.out.println("Withdrawn amount:"+"$"+Math.abs(preTransaction));}
        else {System.out.println("No transaction occurred");}
        return 0;
    }
    void calculateInterest(int years,int contribution) {

        double interestRate=0.0056;
        //x is how much money we put in our account in relevant years(total contribution)
        int x=contribution*12*years;
        //first part is calculated interest,second part is our savings:
        double newBalance=((x+sa1)*interestRate*years)+(x+sa1);
        System.out.println("Your current savings account balance:"+"$"+sa1);
        System.out.println("The current interest rate is :"+(100*interestRate)+"%");
        System.out.println("After "+years+" years,your Savings account balance will be :"+"$"+newBalance);

    }

    void showMenu() {
        log.info("Starting Banking App");

        char option='\0';
        Scanner scanner=new Scanner(System.in);
        System.out.println("***********************");
        System.out.println("Welcome  "+customerName);
        System.out.println("Your customer Id is:"+customerId);
        System.out.println('\n');
        System.out.println("PLEASE SELECT AN OPTION");
        System.out.println("***********************");
        System.out.println("A.Checking and Savings Account Information");
        System.out.println("B.Deposit");
        System.out.println("C.Withdrawal");
        System.out.println("D.Previous Transaction");
        System.out.println("E.Calculate interest for Savings Account");
        System.out.println("F.Exit");
        System.out.println("***********************");
        do {
            option=scanner.next().charAt(0);
            System.out.println('\n');

            switch(option) {
                case 'A':
                    log.info("CUSTOMER INFORMATION:");
                    TreeMap<String, String> treemap;
                    treemap   = new TreeMap<String, String>();
                    treemap.put("Customer Name",customerName);
                    treemap.put("Customer Id",customerId);
                    System.out.println(treemap);
                    System.out.println('\n');
                    System.out.println("Checking account amount:"+"$"+ca1);
                    System.out.println("Checking account number:"+ ca);
                    System.out.println('\n');
                    System.out.println("Savings account amount:"+"$"+sa1);
                    System.out.println("Savings account number:"+ sa);

                    System.out.println('\n');
                    break;

                case 'B':
                    System.out.println("Enter an amount to deposit:");
                    double amount=scanner.nextDouble();
                    if(amount>0) {
                        System.out.println("Please choose an account to deposit :1-Checking 2-Savings");
                        int account=scanner.nextInt();
                        if(account==1)
                        { deposit1(amount);
                            System.out.println("Your Checking Account balance after transaction is: "+"$"+ca1);}
                        if(account==2)
                        { deposit2(amount);
                            System.out.println("Your Savings Account balance after transaction is: "+"$"+sa1);}
                        if (account!=1 && account!=2){log.warn("INVALID OPTION!"); System.out.println("Invalid option.Please try again.");}
                    }
                    else { log.error("ERROR!");
                        System.out.println("Error!Deposit amount must be greater than zero");
                        System.out.println("Transaction cancelled");}
                    break;


                case 'C':
                    System.out.println("Enter an amount to withdraw:");
                    double amount2=scanner.nextDouble();
                    if (ca1>amount2 || sa1>amount2) {System.out.println("Please choose an account to withdraw :1-Checking 2-Savings");
                        int account2=scanner.nextInt();
                        if(account2==1) {withdraw1(amount2);
                            System.out.println("Your Checking Account balance after transaction is: "+"$"+ca1);}
                        if(account2==2){withdraw2(amount2);
                            System.out.println("Your Savings Account balance after transaction is: "+"$"+sa1);}
                        if(account2!=1 && account2!=2){log.warn("INVALID OPTION!");System.out.println("Invalid option.Please try again.");}
                    }
                    else { log.error("ERROR!");
                        System.out.println("Error! Insufficient funds");
                        System.out.println("Transaction cancelled");}
                    System.out.println('\n');
                    break;

                case 'D':
                    getPreTransaction();
                    System.out.println('\n');
                    break;

                case 'E':
                    System.out.println("Please enter how many years do you want to save money: ");
                    int years=scanner.nextInt();
                    System.out.println("Please enter monthly contribution amount:" );
                    int contribution=scanner.nextInt();
                    calculateInterest(years,contribution);
                    System.out.println('\n');
                    break;

                case 'F':
                    System.out.println("Exiting the menu");
                    break;

                default:
                    log.warn("INVALID OPTION!");
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }while (option!='F');
        System.out.println("Thank you for using our services.");
        //This part is written just to show which thread is in use(and it will redirect to homepage afterwards):
        for (int i=5; i>0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        } System.out.println(Thread.currentThread().getName()+" thread is done,you will be redirected to Home Page");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        BankingApp obj1=new BankingApp("Sezin Demir","200126");
        obj1.showMenu();

        scanner.close();
    }
}

