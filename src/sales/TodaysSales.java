package sales;

import sales.random.RandomSale;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TodaysSales {

    static final List<Sale> _sales = Arrays.asList(
	    new Sale(Store.KANSAS_CITY, new Date(), Optional.of("Sarah"),
		     Collections.singletonList(
			     new Item("carrot", 12.00)
		     )),
	    new Sale(Store.ST_LOUIS, new Date(), Optional.empty(),
		     Arrays.asList(
			     new Item("carrot", 12.00),
			     new Item("lizard", 99.00),
			     new Item("cookie", 1.99)
		     )),
	    new Sale(Store.ST_LOUIS, new Date(), Optional.of("Jamie"),
		     Arrays.asList(
			     new Item("banana", 3.49),
			     new Item("cookie", 1.49)
		     )));

    static Stream<Sale> saleStream() {
	return RandomSale.streamOf(100);
    }

    public static void main(String[] args) {
	// how many sales?
	long saleCount = saleStream().count();
	System.out.println("Count of sales: " + saleCount);

	// any sales over $100?
	boolean bigSaleDay = saleStream().anyMatch(sale -> sale.total() > 100.00);
	System.out.println("Big sale today? " + bigSaleDay);

	// maximum sale amount?
	DoubleSummaryStatistics stats = saleStream()
		.mapToDouble(Sale::total)
		.summaryStatistics();
	System.out.println("Max sale amount: " + stats.getMax());
	System.out.println("Stats on total" + stats);

	// how many items were sold today?
	Supplier<Stream<Item>> itemStream = () ->
		saleStream().flatMap(sale -> sale.items.stream());

	long itemCount = itemStream.get().count();
	System.out.println("Count of items: " + itemCount);

	// how many different items were sold today?
	String uniqueItems = itemStream.get()
		.map(item -> item.name)
		.distinct()
		.collect(Collectors.joining(" & "));
	System.out.println("Count of distinct items: " + uniqueItems);

	// summarize sales by store
	Map<Store, DoubleSummaryStatistics> summary = saleStream()
		.collect(Collectors.groupingBy(sale -> sale.store,
					       Collectors.summarizingDouble(Sale::total)));
	System.out.println("Summary by store: " + summary);

	summary.keySet().stream()
		.forEach(store ->
		System.out.println(store + " stats: " + summary.get(store)));
    }
}
