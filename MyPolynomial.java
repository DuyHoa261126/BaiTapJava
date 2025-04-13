package Lab3;

public class MyPolynomial {
	private double[] coeffs;

	public MyPolynomial(double... coeffs) {
		this.coeffs = coeffs;
	}

	public int getDegree() {
		return this.coeffs.length - 1;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = this.coeffs.length - 1; i >= 0; i--) {
			if (coeffs[i] != 0) {
				if (i != 0) {
					sb.append(coeffs[i]).append("x^").append(i).append("+");
				} else {
					sb.append(coeffs[i]);
				}
			}
		}
		return sb.toString();
	}

	public double evaluate(double x) {
		double result = 0;
		for (int i = 0; i <= this.coeffs.length - 1; i++) {
			result += coeffs[i] * Math.pow(x, i);
		}
		return result;
	}

	public MyPolynomial add(MyPolynomial right) {
		int maxDegree = Math.max(right.getDegree(), this.getDegree());
		double[] newPolynomial = new double[maxDegree + 1];
		for (int i = 0; i <= maxDegree; i++) {
			double thiscoeffs = (i < this.getDegree() + 1) ? this.coeffs[i] : 0;
			double anothercoeffs = (i < right.getDegree() + 1) ? right.coeffs[i] : 0;
			newPolynomial[i] = thiscoeffs + anothercoeffs;
		}
		return new MyPolynomial(newPolynomial);
	}

	public MyPolynomial multiply(MyPolynomial right) {
		int maxDegree = this.getDegree() + right.getDegree();
		double[] mulPolynomial = new double[maxDegree + 1];
		for (int i = 0; i <= this.getDegree(); i++) {
			for (int j = 0; j <= right.getDegree(); j++) {
				double elements = (this.coeffs[i] != 0 && right.coeffs[j] != 0) ? this.coeffs[i] * right.coeffs[j] : 0;
				mulPolynomial[i + j] += elements;
			}
		}
		return new MyPolynomial(mulPolynomial);
	}
}