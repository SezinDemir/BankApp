 import org.junit.jupiter.api.Test;

 import static org.junit.jupiter.api.Assertions.assertEquals;

    public class BankingAppTest {

        @Test
        void testMain() {
            BankingApp obj3=new BankingApp("Sezin Demir","200126");
            String output=BankingApp.customerName;
            assertEquals("Sezin Demir",output);
        }
        @Test
        void testMain2() {
            BankingApp obj3=new BankingApp("Sezin Demir","200126");
            double output=obj3.ca1;
            assertEquals(10000.00,output);
        }

        @Test
        void testDeposit() {
            BankingApp obj1=new BankingApp();
            double output=obj1.deposit1(100.5);
            assertEquals(100.5,output);
        }

        @Test
        void testWithdraw() {
            BankingApp obj2=new BankingApp();
            double output=obj2.withdraw2(200.5);
            assertEquals(200.5,output);
        }

        @Test
        void testPreTransaction() {
            BankingApp obj2=new BankingApp();
            if (obj2.preTransaction==100){
            double output=obj2.getPreTransaction();}

        }
        }

