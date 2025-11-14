import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Product {
    String name;
    String category;
    double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " | " + category + " | " + price;
    }
}

public class ProductStreamProcessing {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 55000),
                new Product("Mobile", "Electronics", 25000),
                new Product("Shirt", "Clothing", 1500),
                new Product("Jeans", "Clothing", 2000),
                new Product("Fridge", "Home Appliances", 30000),
                new Product("Washing Machine", "Home Appliances", 28000)
        );

        Map<String, List<Product>> groupedByCategory =
                products.stream()
                        .collect(groupingBy(p -> p.category));

        System.out.println("Products Grouped by Category:");
        groupedByCategory.forEach((category, list) -> {
            System.out.println(category + " -> " + list);
        });

        Map<String, Optional<Product>> maxPriceProduct =
                products.stream()
                        .collect(groupingBy(
                                p -> p.category,
                                maxBy(Comparator.comparingDouble(p -> p.price))
                        ));

        System.out.println("\nMost Expensive Product in Each Category:");
        maxPriceProduct.forEach((cat, prod) ->
                System.out.println(cat + " -> " + prod.get()));

        double avgPrice =
                products.stream()
                        .collect(averagingDouble(p -> p.price));

        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
