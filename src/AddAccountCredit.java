import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddAccountCredit extends Transaction{
    private String msisdn;

    public AddAccountCredit(int store_id,
                            int transaction_id,
                            LocalDateTime timestamp,
                            int account_id,
                            BigDecimal amount,
                            String msisdn) {
        super(store_id, transaction_id, timestamp, account_id, amount);
        this.msisdn = msisdn;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    @Override
    public String toString() {
        return "Store ID: " + this.getStore_id() + "\n" +
                "Account ID: " + this.getAccount_id() + "\n" +
                "Transaction ID: " + this.getTransaction_id() + "\n" +
                "Timestamp: " + this.getTimestamp() + "\n" +
                "Amount: " + this.getAmount() + "\n" +
                "MSISDN: " + this.getMsisdn() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        AddAccountCredit that = (AddAccountCredit) obj;

        return this.getAccount_id() == that.getAccount_id()
                && this.getAmount().equals(that.getAmount())
                && this.getTimestamp().equals(that.getTimestamp())
                && this.getTransaction_id() == that.getTransaction_id()
                && this.getStore_id() == that.getStore_id()
                && this.getMsisdn().equals(that.getMsisdn());
    }
}
