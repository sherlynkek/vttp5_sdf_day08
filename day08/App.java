package day08;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;

public class App {
    public void main(String[] args) {
        
        List<Product> products = new ArrayList<>();

        LocalDate isCreated = LocalDate.of(2024, 10, 21);
        Date createDt = Date.from(isCreated.atStartOfDay(ZoneId.systemDefault()).toInstant());

        products.add(new Product(1L, "null", null, null, null, createDt));
        products.add(new Product(1L, "mouse", "For click UI onscreen", "Computer", 99.0f, createDt));
        products.add(new Product(2L, "keyboard", "device that allows alpha numerics inputs", "Computer", 235.5f, createDt));
        products.add(new Product(3L, "15.6 inch monitor", "Extended display panel", "Computer", 157.5f, createDt));
        products.add(new Product(4L, "Huawei Pura 70 Ultra", "Huawei phone", "Mobile", 900.0f, createDt));
        products.add(new Product(5L, "Huawei Mate 50 Pro", "Huawei Phone", "Mobile", 1200.0f, createDt));
        products.add(new Product(6L, "iPhone 16 Pro", "iPhone", "Mobile", 2000.0f, createDt));
        products.add(new Product(7L, "iPhone 14 Pro", "iPhone", "Mobile", 1800.0f, createDt));

        List<Product> filteredProducts = new ArrayList<>();
        filteredProducts = products.stream().filter(p -> p.getProdCat().equals("Mobile") && (p.getPrice() > 1500.0f)).collect(Collector.toList());
        filteredProducts.forEach(System.out::println);
        

    }
}
