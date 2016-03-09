package procedural;

abstract class MonthByMonthQuantity implements QuantityOfInterest {

    private final double[] _values;

    protected MonthByMonthQuantity(final double[] values) {
	_values = values;
    }

    @Override
    public double valueAt(final int time) {
	return _values[time - 1];
    }
}
