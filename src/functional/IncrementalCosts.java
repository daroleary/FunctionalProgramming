package functional;

public class IncrementalCosts {

    private final FunctionOverTime valueFunction;

    public IncrementalCosts(FunctionOverTime valueFunction) {
	this.valueFunction = valueFunction;
    }

    public String getName() {
	return "Incremental Costs";
    }

    public double valueAt(final int time) {
	return valueFunction.valueAt(time);
    }
}
