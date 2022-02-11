import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
    private int store_id;
    private int transaction_id;
    private LocalDateTime timestamp;
    private int account_id;
    private BigDecimal amount;

    public Transaction() {
    }

    public Transaction(int store_id, int transaction_id, LocalDateTime timestamp, int account_id, BigDecimal amount) {
        this.store_id = store_id;
        this.transaction_id = transaction_id;
        this.timestamp = timestamp;
        this.account_id = account_id;
        this.amount = amount;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Transaction that = (Transaction) obj;

        return this.getAccount_id() == that.getAccount_id()
                && this.getAmount().equals(that.getAmount())
                && this.getTimestamp().equals(that.getTimestamp())
                && this.getTransaction_id() == that.getTransaction_id()
                && this.getStore_id() == that.getStore_id();
    }
}
