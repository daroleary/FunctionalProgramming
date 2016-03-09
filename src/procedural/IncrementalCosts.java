package procedural;

public class IncrementalCosts implements QuantityOfInterest {

    private final FunctionOverTime _valueFunction;

    public IncrementalCosts(FunctionOverTime valueFunction) {
	_valueFunction = valueFunction;
    }

    public String getName() {
	return "Incremental Costs";
    }

    @Override
    public double valueAt(final int time) {
	return _valueFunction.valueAt(time);
    }
}
