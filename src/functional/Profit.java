package functional;

public class Profit {
    private final Sales _sales;
    private final IncrementalCosts _incrementalCosts;
    private final FixedCosts _fixedCosts;

    public Profit(Sales sales, IncrementalCosts incrementalCosts, FixedCosts fixedCosts) {
	_sales = sales;
	_incrementalCosts = incrementalCosts;
	_fixedCosts = fixedCosts;
    }

    public String getName() {
	return "Profit!!";
    }

    public double valueAt(final int time) {
	return _sales.valueAt(time) -
	       (_incrementalCosts.valueAt(time) +
		_fixedCosts.valueAt(time));
    }
}
