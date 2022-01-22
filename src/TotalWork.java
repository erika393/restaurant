public class TotalWork {
    private double total;

    public TotalWork(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "FIM DO EXPEDIENTE" + "\nGanhos: " + getTotal();
    }
}
