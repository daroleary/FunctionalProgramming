package procedural;

public class Profit implements QuantityOfInterest {

    private final FunctionOverTime _valueFunction;

    public Profit(Sales sales,
		  IncrementalCosts incrementalCosts,
		  FixedCosts fixedCosts) {
	// ignore, just to get past compilation issues.
	_valueFunction = new FunctionOverTime() {
	    @Override
	    public Double valueAt(Integer time) {
		return null;
	    }
	};
	/*_valueFunction = QuantityCombination.of3(sales, fixedCosts, incrementalCosts, new QuantityCombination.FunctionOf3() {
	    @Override
	    public double apply(Double s, Double fc, Double ic) {
		return s - fc - ic;
	    }
	});*/
    }

    @Override
    public String getName() {
	return "Profit";
    }

    @Override
    public double valueAt(final int time) {
	return _valueFunction.valueAt(time);
    }
}
