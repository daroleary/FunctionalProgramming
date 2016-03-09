package functional;

public class FixedCosts {

    private final FunctionOverTime valueFunction;

    public FixedCosts(FunctionOverTime valueFunction) {
	this.valueFunction = valueFunction;
    }

    public String getName() {
	return "Fixed Costs";
    }

    public double valueAt(final int time) {
	return valueFunction.valueAt(time);
    }
}
