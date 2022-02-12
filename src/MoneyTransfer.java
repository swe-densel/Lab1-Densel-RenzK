import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MoneyTransfer extends Transaction{
    private String recipient;

    public MoneyTransfer(int store_id,
                         int transaction_id,
                         LocalDateTime timestamp,
                         int account_id,
                         BigDecimal amount,
                         String recipient) {
        //this super() refers to the constructor of Transaction
        super(store_id, transaction_id, timestamp, account_id, amount);
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    //override toString() function to return a String with all the details
    //of an object of this class
    @Override
    public String toString() {
        return "Store ID: " + this.getStore_id() + "\n" +
                "Account ID: " + this.getAccount_id() + "\n" +
                "Transaction ID: " + this.getTransaction_id() + "\n" +
                "Timestamp: " + this.getTimestamp() + "\n" +
                "Amount: " + this.getAmount() + "\n" +
                "Recipient: " + this.getRecipient() + "\n";
    }

    //override equals() function to compare objects if these have the same
    //values on their attributes
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        MoneyTransfer that = (MoneyTransfer) obj;

        return this.getAccount_id() == that.getAccount_id()
                && this.getAmount().equals(that.getAmount())
                && this.getTimestamp().equals(that.getTimestamp())
                && this.getTransaction_id() == that.getTransaction_id()
                && this.getStore_id() == that.getStore_id()
                && this.getRecipient().equals(that.getRecipient());
    }

}
