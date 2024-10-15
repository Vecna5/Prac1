import java.util.ArrayList;

class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return 0;
    }
}

class FoodProduct extends Product {
    public FoodProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getDiscount() {
        return 0;
    }
}

class ElectronicsProduct extends Product {
    public ElectronicsProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getDiscount() {
        return price * 0.15;
    }
}

class ShoppingCart {
    private ArrayList<Product> products;
    private double total;

    public ShoppingCart() {
        products = new ArrayList<>();
        total = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        total += product.getPrice();
    }

    public double calculateTotalWithDiscounts() {
        double discount = 0;
        for (Product product : products) {
            discount += product.getDiscount();
        }
        return total - discount;
    }

    public void displayCart() {
        System.out.println("Чек:");
        for (Product product : products) {
            double discount = product.getDiscount();
            System.out.println(product.getName() + ": " + String.format("%.2f", product.getPrice()) + " грн" +
                    (discount > 0 ? " (Знижка: " + String.format("%.2f", discount) + " грн)" : ""));
        }
        System.out.println("Загальна сума: " + String.format("%.2f", total) + " грн");
        System.out.println("Сума після знижок: " + String.format("%.2f", calculateTotalWithDiscounts()) + " грн");
    }
}

public class Main {
    public static void main(String[] args) {

        Product apple = new FoodProduct("Orange", 1.25);
        Product banana = new FoodProduct("Watermelon", 0.75);
        Product laptop = new ElectronicsProduct("Laptop", 999.99);
        Product smartphone = new ElectronicsProduct("PSP", 799.99);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(apple);
        cart.addProduct(laptop);
        cart.addProduct(smartphone);

        cart.displayCart();
    }
}
