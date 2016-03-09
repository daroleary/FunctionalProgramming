package procedural;

public class FixedCosts implements QuantityOfInterest {

    private final FunctionOverTime _valueFunction;

    public FixedCosts(FunctionOverTime valueFunction) {
	_valueFunction = valueFunction;
    }

    @Override
    public String getName() {
	return "Fixed Costs";
    }

    @Override
    public double valueAt(final int time) {
	return _valueFunction.valueAt(time);
    }
}
