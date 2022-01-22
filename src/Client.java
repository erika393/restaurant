import java.util.ArrayList;

public class Client {
    private String name;
    private ArrayList<Products> products = new ArrayList<>();

    public Client(String name, ArrayList<Products> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void addProducts(Products p){
        products.add(p);
    }

    @Override
    public String toString() {
        return "Cliente: " + getName() + "\n Produtos: " + getProducts();
    }
}
