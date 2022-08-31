import model.Product;
import service.ProductsService;

import java.math.BigDecimal;
import java.util.List;

public class App {
    /*
        Przygotuj strukturę, która przechowa informacje o produkcie (nazwa, cena).
        Następnie z przykładowej kolekcji produktów wyznacz te, które posiadają największą
        cenę.
    */

    public static void main(String[] args) {
        var products = List.of(
                new Product("A", BigDecimal.valueOf(1000)),
                new Product("B", BigDecimal.valueOf(3000)),
                new Product("C", BigDecimal.valueOf(3000)));

        var productsService = new ProductsService(products);
        System.out.println(productsService.getMaxPriceProducts());
        System.out.println(productsService.getMaxPriceProducts2());
    }
}
