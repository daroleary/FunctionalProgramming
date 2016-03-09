package procedural;

abstract class PolynomialQuantity implements QuantityOfInterest {

    private final double[] _coefficients;

    public PolynomialQuantity(double[] coefficients) {
	_coefficients = coefficients;
    }

    @Override
    public double valueAt(final int time) {
	double value = 0.0;
	for (int i = 0; i < _coefficients.length; i++) {
	    value += _coefficients[i] * Math.pow(time, i);
	}
	return value;
    }
}
