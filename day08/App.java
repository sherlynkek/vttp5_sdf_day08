package day08;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    public void main(String[] args) throws IOException {
        
        List<Product> products = new ArrayList<>();

        LocalDate ldCreated = LocalDate.of(2024, 10, 21);
        Date createDt = Date.from(ldCreated.atStartOfDay(ZoneId.systemDefault()).toInstant());

        products.add(new Product(1L, "mouse", "For click UI onscreen", "Computer", 99.0f, createDt));
        products.add(new Product(2L, "keyboard", "device that allows alpha numerics inputs", "Computer", 235.5f, createDt));
        products.add(new Product(3L, "15.6 inch monitor", "Extended display panel", "Computer", 157.5f, createDt));
        products.add(new Product(4L, "Huawei Pura 70 Ultra", "Huawei phone", "Mobile", 900.0f, createDt));
        products.add(new Product(5L, "Huawei Mate 50 Pro", "Huawei Phone", "Mobile", 1200.0f, createDt));
        products.add(new Product(6L, "iPhone 16 Pro", "iPhone", "Mobile", 2000.0f, createDt));
        products.add(new Product(7L, "iPhone 14 Pro", "iPhone", "Mobile", 1800.0f, createDt));

        List<Product> filteredProducts = new ArrayList<>();
        filteredProducts = products.stream().filter(p -> p.getCategory().equals("mobile") && (p.getPrice() > 1500.0f)).collect(Collectors.toList());
        filteredProducts.forEach(System.out::println);
        
        // write the list of filtered objects to a file
        FileWriter fw = new FileWriter(args[0], false);
        BufferedWriter bw = new BufferedWriter(fw);

        Iterator<Product> iterator = filteredProducts.iterator();
        while (iterator.hasNext()) {
            bw.append(iterator.next().toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        fw.close();

        // using Comparator to perform sorting
        // single column comparison
        Comparator<Product> comparator = Comparator.comparing(Product::getName);
        products.sort(comparator);
        products.forEach(System.out :: println);

        products.sort(comparator.reversed());
        products.forEach(System.out::println);

        // sort out array of string
        // sort assending and print
        // sort descending and print

        String arr[] = {"Ben", "Zac", "Alpha", "Sam", "Chris"};
        Arrays.sort(arr);
        

    }
}
