package main.java.com.shitspace;

class Arithmetics {
    /**
     * Returns the greatest common divisor of two numbers
     * @param a the first number
     * @param b the second number
     * @return the greatest common divisor of two numbers
     */
    public static int gcd(int a, int b)
    {
        return (b == 0 ? a : gcd(b, a % b));
    }
}
