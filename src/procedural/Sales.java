package procedural;

public class Sales implements QuantityOfInterest {

    private final FunctionOverTime _valueFunction;

    public Sales(FunctionOverTime valueFunction) {
	_valueFunction = valueFunction;
    }

    public String getName() {
	return "Sales";
    }

    @Override
    public double valueAt(int time) {
	return _valueFunction.valueAt(time);
    }
}
