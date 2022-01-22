public class Products {
    private String name;
    private String description;
    private double price;

    public Products(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double total(){
        return price++;
    }

    public void menu(){}

    @Override
    public String toString() {
        return "\n" + getName() + "\n" + getDescription() + "\n" + "R$" + getPrice();
    }
}


