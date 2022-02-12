import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

public class TransactionProcessing {
    //this is for logging
    private final static Logger logger = Logger
            .getLogger(TransactionProcessing.class.getName());

    //arraylist of transactions to collect all types of transactions
    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        //initialize function
        init();
    }

    private static void init(){
        //each of these functions will add transactions to the arraylist
        // based on their type
        addMoneyTransfers();
        addBillsPayments();
        addBuyLoads();
        addAccountCredits();
        addGameCredits();

        //these three functions will log transactions
        showTransactions();
        showTransactions(TransactionTypes.MoneyTransfer);
        checkIfDuplicateBill();
    }

    private static void checkIfDuplicateBill() {
        //Made an arraylist of BillsPayment Class to collect bills payment objects
        ArrayList<BillsPayment> billsPaymentArrayList = new ArrayList<>();

        //Another ArrayList of BillsPayment Class but for collecting duplicate bills
        ArrayList<BillsPayment> duplicatedBills = new ArrayList<>();

        //Add all bills payment transactions first from the Arraylist transactions
        // to billsPaymentArrayList
        for (Transaction transaction: transactions){

            //condition: if the transaction is of the BillsPayment class
            if (TransactionTypes.BillsPayment.name().equals(transaction.getClass().getName())){

                //it is then added to the billsPaymentArrayList
                billsPaymentArrayList.add((BillsPayment) transaction);
            }
        }

        //////////////////////////////////////////////////////////////////////////
        logger.info("UNIQUE BILLS: ");

        //Note by Densel: "The following block of code may require code review
        //                 and I'm open for discussion about this."

        //these for loops are made for comparing bills whether if a bill has a duplicate
        //i - indicates the BillsPayment object to determine if it has a duplicate
        //j - indicates the BillsPayment object for comparing with i

        for (int i = 0; i < billsPaymentArrayList.size(); i++){
            for (int j = 0; j < billsPaymentArrayList.size(); j++){

                //if i has the same attribute values compared to j and
                // i is not comparing itself (i !=j)
                if (billsPaymentArrayList.get(i).equals(billsPaymentArrayList.get(j))
                    && i != j){

                    //add the bill to the duplicatedBills arraylist
                   duplicatedBills.add(billsPaymentArrayList.get(i));

                   //sets j to max hence stops the comparison, increments i by 1,
                    //then moves to the next object
                   j = billsPaymentArrayList.size();
                }

                //after comparing, j will increment by 1 and moves to the next object
                //for comparing again

                //else if i did not have any same BillsPayment object,
                //then it is unique
                else if (j == billsPaymentArrayList.size() -1){

                    //log the unique bill
                    logger.info(billsPaymentArrayList.get(i).toString());
                }

            }
        }
        //////////////////////////////////////////////////////////////////////////

        logger.info("DUPLICATED BILLS: ");
        //logs all the duplicated bills
        for (BillsPayment billsPayment: duplicatedBills){
            logger.info(billsPayment.toString());
        }


    }

    //function for showing all the transactions in the arraylist
    private static void showTransactions() {
        for (Transaction transaction: transactions){
            logger.info(transaction.toString());
        }
    }

    //function for showing only the transactions based on the type passed
    //accepts a transaction type as a parameter
    private static void showTransactions(TransactionTypes transactionTypes) {
        for (Transaction transaction: transactions){
            if (transactionTypes.name().equals(transaction.getClass().getName())){
                logger.info(transaction.toString());
            }
        }
    }

    //function for adding money transfers to the arraylist of transactions
    private static void addMoneyTransfers() {
        MoneyTransfer moneyTransfer1 = new MoneyTransfer(
                98,
                45,
                LocalDate.of(2020, 8, 17)
                        .atTime(8,20,30),
                12,
                new BigDecimal("50.41"),
                "Mang Thomas");
        transactions.add(moneyTransfer1);

        MoneyTransfer moneyTransfer2 = new MoneyTransfer(
                98,
                45,
                LocalDate.of(2020, 8, 17)
                        .atTime(8,20,30),
                12,
                new BigDecimal("50.41"),
                "Mang Thomas");
        transactions.add(moneyTransfer2);

        MoneyTransfer moneyTransfer3 = new MoneyTransfer(
                14,
                6,
                LocalDate.of(2020, 9, 20)
                        .atTime(13,0,2),
                73,
                new BigDecimal("62.15"),
                "John Doe");
        transactions.add(moneyTransfer3);

        MoneyTransfer moneyTransfer4 = new MoneyTransfer(
                34,
                9,
                LocalDate.of(2020, 9, 20)
                        .atTime(13,0,2),
                41,
                new BigDecimal("75.80"),
                "John Doe");
        transactions.add(moneyTransfer4);

        MoneyTransfer moneyTransfer5 = new MoneyTransfer(
                22,
                22,
                LocalDate.of(2022, 2, 2)
                        .atTime(22,22,22),
                22,
                new BigDecimal("222.22"),
                "Juan Dela Cruz");
        transactions.add(moneyTransfer5);
    }

    //function for adding game credits to the arraylist of transactions
    private static void addGameCredits() {
        AddGameCredit addGameCredit = new AddGameCredit(
                85,
                37,
                 LocalDate.of(2021, 10, 19)
                        .atTime(20, 0,0),
                28,
                new BigDecimal("84.15"),
                "XYZ Company"
        );
        transactions.add(addGameCredit);

        AddGameCredit addGameCredit2 = new AddGameCredit(
                12,
                24,
                LocalDate.of(2021, 10, 19)
                        .atTime(20, 0,0),
                36,
                new BigDecimal("48.60"),
                "DEF Company"
        );
        transactions.add(addGameCredit2);

        AddGameCredit addGameCredit3 = new AddGameCredit(
                85,
                37,
                LocalDate.of(2021, 10, 19)
                        .atTime(20, 0,0),
                28,
                new BigDecimal("84.15"),
                "XYZ Company"
        );
        transactions.add(addGameCredit3);

        AddGameCredit addGameCredit4 = new AddGameCredit(
                85,
                37,
                LocalDate.of(2021, 10, 19)
                        .atTime(20, 0,0),
                28,
                new BigDecimal("84.15"),
                "XYZ Company"
        );
        transactions.add(addGameCredit4);

        AddGameCredit addGameCredit5 = new AddGameCredit(
                16,
                61,
                LocalDate.of(2022, 2, 8)
                        .atTime(10, 28,28),
                72,
                new BigDecimal("99.99"),
                "The Company"
        );
        transactions.add(addGameCredit5);
    }

    //function for adding account credits to the arraylist of transactions
    private static void addAccountCredits() {
        AddAccountCredit addAccountCredit = new AddAccountCredit(
                88,
                40,
                LocalDate.of(2021, 10, 5)
                        .atTime(17, 4, 50),
                30,
                new BigDecimal("91.75"),
                "09777489521");
        transactions.add(addAccountCredit);

        AddAccountCredit addAccountCredit2 = new AddAccountCredit(
                68,
                75,
                LocalDate.of(2021, 10, 19)
                        .atTime(14, 37, 26),
                42,
                new BigDecimal("1.00"),
                "09778522587");
        transactions.add(addAccountCredit2);
    }

    //function for adding load transactions to the arraylist of transactions
    private static void addBuyLoads() {
        BuyLoad buyLoad1 = new BuyLoad(
                18,
                21,
                LocalDate.of(2022, 1, 2)
                        .atTime(8, 0, 0),
                35,
                new BigDecimal("21.50"),
                "09773452167");
        transactions.add(buyLoad1);

        BuyLoad buyLoad2 = new BuyLoad(
                23,
                16,
                LocalDate.of(2021, 3, 5)
                        .atTime(9, 30, 14),
                80,
                new BigDecimal("38.40"),
                "09771234567");
        transactions.add(buyLoad2);

        BuyLoad buyLoad3 = new BuyLoad(
                18,
                21,
                LocalDate.of(2022, 1, 2)
                        .atTime(8, 0, 0),
                35,
                new BigDecimal("21.50"),
                "09773452167");
        transactions.add(buyLoad3);

        BuyLoad buyLoad4 = new BuyLoad(
                13,
                56,
                LocalDate.of(2020, 7, 16)
                        .atTime(14, 40, 40),
                41,
                new BigDecimal("61.20"),
                "09779632587");
        transactions.add(buyLoad4);

        BuyLoad buyLoad5 = new BuyLoad(
                13,
                56,
                LocalDate.of(2020, 7, 16)
                        .atTime(14, 40, 40),
                41,
                new BigDecimal("61.20"),
                "09779632587");
        transactions.add(buyLoad5);
    }

    //function for adding bill payments to the arraylist of transactions
    private static void addBillsPayments() {
        BillsPayment billsPayment = new BillsPayment(
                11,
                22,
                LocalDate.of(2019, 9, 9)
                        .atTime(11, 10, 10),
                33,
                new BigDecimal("44.55"),
                "ABC Company",
                new BigDecimal("44.55"));
        transactions.add(billsPayment);

        BillsPayment billsPayment2 = new BillsPayment(
                11,
                22,
                LocalDate.of(2019, 9, 9)
                        .atTime(11, 10, 10),
                33,
                new BigDecimal("44.55"),
                "ABC Company",
                new BigDecimal("44.55"));
        transactions.add(billsPayment2);

        BillsPayment billsPayment3 = new BillsPayment(
                99,
                88,
                LocalDate.of(2019, 9, 9)
                        .atTime(11, 10, 10),
                77,
                new BigDecimal("66.55"),
                "XYZ Company",
                new BigDecimal("66.55"));
        transactions.add(billsPayment3);

    }


}
