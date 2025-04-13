package Lab3;

public class Mycomplex {
	private double real;
	private double imag;

	public Mycomplex() {
		real = 0.0;
		imag = 0.0;
	}

	public Mycomplex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public void setValue(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	@Override
	public String toString() {
		return real + "+" + imag + "i";
	}

	public boolean isReal() {
		if (imag == 0) {
			return true;
		}
		return false;
	}

	public boolean isImaginary() {
		if (real == 0) {
			return true;
		}
		return false;
	}

	public boolean equals(double real, double imag) {
		if (this.real == real && this.imag == imag) {
			return true;
		}
		return false;
	}

	public boolean equals(Mycomplex another) {
		if (another.imag == this.imag && another.real == this.real) {
			return true;
		}
		return false;
	}

	public double magnitude() {
		return Math.sqrt(imag * imag + real * real);
	}

	public double argument() {
		return Math.atan2(real, imag);
	}

	public Mycomplex add(Mycomplex right) {
		this.imag += right.imag;
		this.real += right.real;
		return this;
	}

	public Mycomplex addNew(Mycomplex right) {
		double newi = this.imag + right.imag;
		double newr = this.real + right.real;
		Mycomplex mc = new Mycomplex(newr, newi);
		return mc;
	}

	public Mycomplex subtract(Mycomplex right) {
		this.imag -= right.imag;
		this.real -= right.real;
		return this;
	}

	public Mycomplex subtractNew(Mycomplex right) {
		double newi = this.imag - right.imag;
		double newr = this.real - right.real;
		Mycomplex mc = new Mycomplex(newr, newi);
		return mc;
	}

	public Mycomplex multiply(Mycomplex right) {
		double a = this.real * right.real - this.imag * right.imag;
		double b = this.real * right.imag + this.imag * right.real;
		Mycomplex mc = new Mycomplex(a, b);
		return mc;
	}

	public Mycomplex divide(Mycomplex right) {
		double a = (this.real * right.real + this.imag * right.imag)
				/ (right.real * right.real + right.imag * right.imag);
		double b = (this.imag * right.real - this.real * right.imag)
				/ (right.real * right.real + right.imag * right.imag);
		Mycomplex mc = new Mycomplex(a, b);
		return mc;
	}

	public Mycomplex conjugate() {
		Mycomplex mc = new Mycomplex(this.real, -this.imag);
		return mc;
	}
}
