   import java.util.Scanner;
  public class Login
  {
      public static void main(String[] args) {

          askInfo();
      }

      static public void askInfo() {
          Scanner sc = new Scanner(System.in);

          String user, password;

          System.out.println("Enter username:");
          user = sc.nextLine();

          System.out.println("Enter password:");
          password = sc.nextLine();{


              if(user.equals("Sezin Demir")&& password.equals("654321")){System.out.println("Password is correct!You will be redirected to Home Page");
                  BankingApp obj1=new BankingApp("Sezin Demir","200126");
                  obj1.showMenu();

              }
              else{System.out.println("Username or password is incorrect.Please try again.");
                  System.out.println("************************");
                  askInfo();
                  sc.close();
              }

          }}}
