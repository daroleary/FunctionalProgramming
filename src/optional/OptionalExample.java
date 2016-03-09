package optional;

import sales.Sale;
import sales.Store;
import sales.random.RandomSale;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalExample {

    public static void main(String[] args) {
	System.out.println("Who bought a carrot? "
	+ carrotCustomer().orElse("I can't say"));
    }

    static Stream<Sale> saleStream() {
	return RandomSale.streamOf(3);
    }

    static Optional<Sale> findSaleOf(String itemName) {
	return saleStream()
		.filter(sale ->
		sale.items.stream().anyMatch(item ->
		item.name.equals(itemName)))
		.findFirst();
    }

    // Customer who brought a carrot
    static Optional<String> carrotCustomer() {
	return findSaleOf("carrot")
		.flatMap(sale -> sale.customer);
    }

    // Store that sold a carrot
    static Optional<Store> carrotStore() {
	return findSaleOf("carrot")
		.map(sale -> sale.store); // only perfomed is optional is not empty
    }

}
