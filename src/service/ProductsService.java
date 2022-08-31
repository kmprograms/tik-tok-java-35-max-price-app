package service;

import model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ProductsService {
    private final List<Product> products;

    public ProductsService(List<Product> products) {
        this.products = products;
    }

    public List<Product> getMaxPriceProducts() {
        return products
                .stream()
                .collect(groupingBy(Product::price))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElseThrow();
    }

    public List<Product> getMaxPriceProducts2() {
        var maxPrice = products
                .stream()
                .map(Product::price)
                .max(Comparator.naturalOrder())
                .orElseThrow();

        return products
                .stream()
                .filter(p -> p.price().equals(maxPrice))
                .toList();
    }
}
