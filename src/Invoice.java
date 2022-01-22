import java.util.ArrayList;

public class Invoice {
    private double total;
    private double amount_paid;
    private double change;

    public Invoice(double total, double amount_paid, double change) {
        this.total = total;
        this.amount_paid = amount_paid;
        this.change = change;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getAmount_paid() {
        return amount_paid;
    }

    public void setAmount_paid(double amount_paid) {
        this.amount_paid = amount_paid;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public void tax10(){
        double tax = 10.0 / 100.0;
        double totalwithtax = total + (tax * total);
    }

    @Override
    public String toString() {
        return "\nTotal: " + getTotal() + "\nValor Recebido: " + getAmount_paid() + "\nTroco: " + getChange();
    }
}
