package main.kotlin

internal class Fraction {
    private var n: Long = 0
    private var d: Long = 0

    var numerator: Long
        get() = n
        set(n) = setValue(n, this.d)
    var denominator: Long
        get() = d
        set(d) = setValue(this.n, d)

    constructor(n: Long) {
        setValue(n)
    }
    /**
     * @param n is the numerator of a fraction
     * @param d is the denominator of a fraction
     */
    @Throws(IllegalArgumentException::class)
    constructor(n: Long, d: Long) {
        setValue(n, d)
    }
    constructor(f: Fraction) {
        setValue(f)
    }

    fun setValue(n: Long) {
        this.n = n
        this.d = 1
    }

    @Throws(IllegalArgumentException::class)
    fun setValue(n: Long, d: Long) {
        if (d == 0L)
            throw IllegalArgumentException("Error: Denominator cannot be equal to zero")
        this.n = n
        this.d = d
        reduce()
    }

    fun setValue(f: Fraction) {
        this.n = f.n
        this.d = f.d
    }

    private fun reduce() {
        val gcd = Arithmetics.gcd(n, d)
        n /= gcd
        d /= gcd
        if (d < 0) {
            d *= -1
            n *= -1
        }
    }

    private fun add(n: Long, d: Long) {
        this.n = this.n * d + n * this.d
        this.d *= d
        reduce()
    }

    private fun substract(n: Long, d: Long) {
        add(n * -1, d)
    }

    private fun multiply(n: Long, d: Long) {
        this.n *= n
        this.d *= d
        reduce()
    }

    private fun divide(n: Long, d: Long) {
        this.n *= d
        this.d *= n
        reduce()
    }

    fun add(n: Long) {
        add(n, 1)
    }

    fun add(f: Fraction) {
        add(f.n, f.d)
    }

    fun substract(n: Long) {
        add(n * -1)
    }

    fun substract(f: Fraction) {
        substract(f.n, f.d)
    }

    fun multiply(n: Long) {
        multiply(n, 1)
    }

    fun multiply(f: Fraction) {
        multiply(f.n, f.d)
    }

    @Throws(ArithmeticException::class)
    fun divide(n: Long) {
        if (n == 0L) throw ArithmeticException("Error: Division by zero")
        divide(n, 1)
    }

    @Throws(ArithmeticException::class)
    fun divide(f: Fraction) {
        if (f.n == 0L) throw ArithmeticException("Error: Division by zero")
        divide(f.n, f.d)
    }

    fun equals(f: Fraction): Boolean {
        return n == f.n && d == f.d
    }

    operator fun compareTo(f: Fraction): Int {
        return if (equals(f)) 0 else if (n * f.d - f.n * d > 0L) 1 else -1
    }

    override fun toString(): String {
        return if(d != 1L) "$n/$d" else " $n "
    }
     fun toDouble() : Double{
        return n.toDouble() / d
    }

}

