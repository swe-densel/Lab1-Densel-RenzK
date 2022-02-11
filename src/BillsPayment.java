import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class BillsPayment extends Transaction{
    private String company_name;
    private BigDecimal bills_charge;

    public BillsPayment(int store_id,
                        int transaction_id,
                        LocalDateTime timestamp,
                        int account_id,
                        BigDecimal amount,
                        String company_name,
                        BigDecimal bills_charge) {

        super(store_id, transaction_id, timestamp, account_id, amount);
        this.company_name = company_name;
        this.bills_charge = bills_charge;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public BigDecimal getBills_charge() {
        return bills_charge;
    }

    public void setBills_charge(BigDecimal bills_charge) {
        this.bills_charge = bills_charge;
    }

    @Override
    public String toString() {
        return "Store ID: " + this.getStore_id() + "\n" +
                "Account ID: " + this.getAccount_id() + "\n" +
                "Transaction ID: " + this.getTransaction_id() + "\n" +
                "Timestamp: " + this.getTimestamp() + "\n" +
                "Amount: " + this.getAmount() + "\n" +
                "Company Name: " + this.getCompany_name() + "\n" +
                "Bills Charge: " + this.getBills_charge() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        BillsPayment that = (BillsPayment) obj;

        return this.getAccount_id() == that.getAccount_id()
                && this.getAmount().equals(that.getAmount())
                && this.getTimestamp().equals(that.getTimestamp())
                && this.getTransaction_id() == that.getTransaction_id()
                && this.getStore_id() == that.getStore_id()
                && this.getBills_charge().equals(that.getBills_charge())
                && this.getCompany_name().equals(that.getCompany_name());
    }
}
