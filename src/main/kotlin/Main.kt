package main.kotlin

import java.util.Scanner

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
//            val scanner = Scanner(System.`in`)
//            val n1 = scanner.nextInt()
//            val d1 = scanner.nextInt()
//            val n2 = scanner.nextInt()
//            val d2 = scanner.nextInt()
//
//            val f1 = Fraction(n1, d1)
//            val f1Str = f1.toString()
//            println("The first fraction is $f1Str")
//            val f2 = Fraction(n2, d2)
//            val f2Str = f2.toString()
//            println("The second fraction is $f2Str")
//            val temp = Fraction(f1)
//
//            val comparisonResult = f1.compareTo(f2)
//            val relationSign = if (comparisonResult > 0) '>' else if (comparisonResult < 0) '<' else '='
//            println("$f1Str $relationSign $f2Str")
//
//            temp.add(f2)
//            println(f1Str + " + " + f2Str + " = " + temp.toString())
//            temp.setValue(f1)
//
//            temp.substract(f2)
//            println(f1Str + " - " + f2Str + " = " + temp.toString())
//            temp.setValue(f1)
//
//            temp.multiply(f2)
//            println(f1Str + " * " + f2Str + " = " + temp.toString())
//            temp.setValue(f1)
//
//            try {
//                temp.divide(f2)
//                println(f1Str + " / " + f2Str + " = " + temp.toString())
//            } catch (e: ArithmeticException) {
//                println(e.message)
//            }
//            println("The first fraction array")
//            val matrix : Array<Array<Fraction>>? = null
//            val m : Array<Array<Fraction>> = Array(3,{Array(5,{Fraction(1,2)})})
//            for (a in m){
//                for(f in a)
//                    print(" $f")
//            println()
//            }
//
//            println(m.size)
//            println(m[0].size)
//            val n : Int = 1;
//            val d : Int = 3;
//            println( n.toDouble() / d)
//            val arr : Array<Fraction> = arrayOf(Fraction(1),Fraction(1),Fraction(1))
//            val arr2 : Array<Fraction> = Array(3,{Fraction(1)})
//            for(el in arr2){
//                println(el.toString())
//            }

            val Matrix1 = arrayOf(
                arrayOf(3, 2, 5, 4, 3),
                arrayOf(1, -1, -1, -4, -2),
                arrayOf(4, 1, 4, 0, 2)
            )
            val Matrix2 = arrayOf(
                arrayOf(4, -3, -2, 1, -2),
                arrayOf(3, -1, -2, 0, 1),
                arrayOf(2, 1, -2, -1, 4)
            )
            val Matrix3 = arrayOf(
                arrayOf(1, 4, 0, -1, 5),
                arrayOf(2, -3, 1, 1, 3),
                arrayOf(1, 0, 2, -1, 3),
                arrayOf(0, 2, -3, 2, 3)
            )
            val Matrix4 = arrayOf(
                arrayOf(2, -1, 1, 2, 3, 2),
                arrayOf(6, -3, 2, 4, 5, 3),
                arrayOf(6, -3, 2, 4, 5, 3),
                arrayOf(4, -2, 1, 1, 2, 1)
            )
            val Matrix5 = arrayOf(
                arrayOf(4, -17, -6, -5, -17),
                arrayOf(43, 24, -1, 3, 28),
                arrayOf(0, 1, 2, 1, 9),
                arrayOf(2, 1, 0, 0, 1)
            )
            val Matrix6 = arrayOf(
                arrayOf(3L, 1L, 5L, -2L, 3L, 35L),
                arrayOf(4L, 3L, -7L, 5L, 6L, 54L),
                arrayOf(-7L, 5L, 4L, 1L, -1L, -96L),
                arrayOf(1L, 4L, 1L, -3L, -10L, -71L),
                arrayOf(6L, 2L, 10L, -4L, 6L, 7L)
            )

            var test = Moonlight(Matrix6)
            test.computation()
            println("::===============================================::")
//            test = Moonlight(Matrix2)
//            test.computation()
//            println("::===============================================::")
//            test = Moonlight(Matrix3)
//            test.computation()
//            println("::===============================================::")
//            test = Moonlight(Matrix4)
//            test.computation()
//            println("::===============================================::")
//            test = Moonlight(Matrix5)
//            test.computation()
//            println("::===============================================::")


        } catch (e: IllegalArgumentException) {
            println(e.message)
        }

    }
}
