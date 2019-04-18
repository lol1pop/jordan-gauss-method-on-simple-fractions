package main.java.com.shitspace;
import java.util.Scanner;

class Fraction {
    private int n, d;

    /**
     * @param n is an integer number
     */
    public Fraction(int n) { setValue(n); }
    /**
     * @param n is the numerator of a fraction
     * @param d is the denominator of a fraction
     */
    public Fraction(int n, int d) throws IllegalArgumentException {
        setValue(n, d);
    }
    public Fraction(Fraction f) {
        setValue(f);
    }

    public int getNumerator() { return n; }
    public int getDenominator() { return d; }

    public void setNumerator(int n) { setValue(n, this.d); }
    public void setDenominator(int d) { setValue(this.n, d); }
    /**
     * Assigns a new fraction from an integer number
     */
    public void setValue(int n) { this.n = n; this.d = 1; }
    /**
     * Assigns a new value to the fraction
     * @param n is the new numerator of a fraction
     * @param d is the new denominator of a fraction
     */
    public void setValue(int n, int d) throws IllegalArgumentException {
        if (d == 0)
            throw new IllegalArgumentException("Error: Denominator cannot be equal to zero");
        this.n = n;
        this.d = d;
        reduce();
    }
    public void setValue(Fraction f) { this.n = f.n; this.d = f.d; }

    private void reduce() {
        int gcd = Arithmetics.gcd(n, d);
        n /= gcd;
        d /= gcd;
        if (d < 0) { d *= -1; n *= -1; }
    }
    private void add(int n, int d) {
        this.n = this.n * d + n * this.d;
        this.d *= d;
        reduce();
    }
    private void substract(int n, int d) {
        add(n * -1, d);
    }
    private void multiply(int n, int d) {
        this.n *= n;
        this.d *= d;
        reduce();
    }
    private void divide(int n, int d) {
        this.n *= d;
        this.d *= n;
        reduce();
    }

    /**
     * Adds an integer number to the fraction
     * @param n is a number
     */
    public void add(int n) {
        add(n, 1);
    }
    /** Adds another fraction to the fraction
     * @param f is another fracton
     */
    public void add(Fraction f) {
        add(f.n, f.d);
    }

    /**
     * Subsracts an integer number from the fraction
     * @param n is a number
     */
    public void substract(int n) { add(n * -1); }
    /** Substracts another fraction from the fraction
     * @param f is another fracton
     */
    public void substract(Fraction f) {
        substract(f.n, f.d);
    }

    /**
     * Multiplies the fraction by an integer number
     * @param n is a number
     */
    public void multiply(int n) {
        multiply(n, 1);
    }
    /** Multiplies the fraction by another fraction
     * @param f is another fracton
     */
    public void multiply(Fraction f) {
        multiply(f.n, f.d);
    }

    /**
     * Divides the fraction by an integer number
     * @param n is a number
     */
    public void divide(int n) throws ArithmeticException {
        if (n == 0) throw new ArithmeticException("Error: Division by zero");
        divide(n, 1);
    }
    /** Divides the fraction by another fraction
     * @param f is another fracton
     */
    public void divide(Fraction f) throws ArithmeticException {
        if (f.n == 0) throw new ArithmeticException("Error: Division by zero");
        divide(f.n, f.d);
    }

    /**
     * Compares the fraction to another fraction by equality
     * @param f is another fraction
     * @return true in case of equuality or false otherwise
     */
    public boolean equals(Fraction f) {
        return (n == f.n && d == f.d);
    }
    /**
     * Compares the fraction to another fraction
     * @param f is another fraction
     * @return 0 if the fraction equals to another fraction, 1 if greater, -1 if lesser
     */
    public int compareTo(Fraction f) {
        return (equals(f)) ? 0 : (n * f.d - f.n * d > 0) ? 1 : -1;
    }

    /**
     * String representation of the fraction
     * @return the string representation of the fraction in such form: numerator/denominator
     */
    public String toString() {
        return n + "/" + d;
    }
}

