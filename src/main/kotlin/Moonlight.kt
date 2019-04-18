package main.kotlin
import com.sun.org.apache.xpath.internal.operations.Bool
import jdk.nashorn.internal.runtime.regexp.JoniRegExp
import java.nio.file.Files.delete
import kotlin.ranges.*
import kotlin.math.*

internal class Moonlight(inputMatrix :Array<Array<Long>>) {
    private var height : Int
    private var weight : Int
    private val numMatrix :Array<Array<Long>>
    private var matrix : Array<Array<Fraction>>
    private var resMatrix : Array<Array<Fraction>>
    private var counter : Int

    init {
            height = inputMatrix.size
            weight = inputMatrix[0].size
            numMatrix = inputMatrix
            matrix = Array(height,{ Array(weight,{Fraction(0)}) })
            resMatrix = Array(height,{ Array(weight,{Fraction(0)}) })
            counter = 0
    }

    private fun initMatrix(){
        for (i in 0 until height) {
            for(j in 0 until weight)
                matrix[i][j] = Fraction(numMatrix[i][j])
        }
        printMatrix()
    }

    fun computation(){
        initMatrix()
        var row  = 0
        var colum  = 0
        var coutn  = 0
        var element = Fraction(0)

        while(colum < weight - 1 && row < height){
            element.setValue(matrix[row][colum])
            println("::step ${coutn + 1} :: element $element")
            if(element.numerator ==  0L){
                ++colum
                continue
            }
            for (i in 0 until height) {
                if (i != row) {
                    resMatrix[i][colum].setValue(Fraction(0))
                } else {
                    resMatrix[i][colum].setValue(Fraction(1))
                }
            }
            for(i in colum + 1 until weight){
                    var num = Fraction(matrix[row][i])
                    num.divide(element)
                    resMatrix[row][i].setValue(num)
            }

            for(i in 0 until height){
                if(i != row){
                    for(j in colum + 1 until weight){
                        var mult1 = Fraction(matrix[i][colum])
                        var mult2 = Fraction(matrix[row][j])
                        var desired = Fraction(matrix[i][j])
                        mult1.multiply(mult2)
                        mult1.divide(element)
                        desired.substract(mult1)
                        resMatrix[i][j].setValue(desired)

                    }
                }
            }
            row++
            colum++
            coutn++
            castling(resMatrix)
            println("===== $row  $colum  $coutn $weight $height ======")
            printMatrix()
        }
        result()
    }

    fun printMatrix(){
        for ( i in 0 until height){
            print("| ")
            for ( j in 0 until weight){
            print("${matrix[i][j]} ")
            if ((j+2) == weight) print("| ")
        }
           println("|")
        }

    }

    fun castling(inputMatrix :Array<Array<Fraction>>){
        var delRow = 0
        for( i in 0 until inputMatrix.size){
            if (checkZeroRow(inputMatrix[i])){
                delRow++
                continue
            }
            for(j in  0 until inputMatrix[0].size){
            matrix[i - delRow][j].setValue(inputMatrix[i][j])
        }
        }
        if(delRow != counter){
            height -= delRow
        counter++}
        //resMatrix  = Array(height,{ Array(weight,{Fraction(0)}) })
    }

    fun checkZeroRow(inputMatrix :Array<Fraction>) : Boolean {

         var zeroRow : Boolean = true
        for( j in 0 until inputMatrix.size)
            if (!inputMatrix[j].equals(Fraction(0))){
                zeroRow = false
                    break
                }
        return zeroRow
    }

    val eps = 0.000000000000001
    fun result(){
        println("===result:::" )
        val zero = Fraction(0)
        val singl = Fraction(1)

        for ( i in 0 until height){
            var invalid = true
            for ( j in 0 until weight - 1)    {
                if (!matrix[i][j].equals(zero)) {
                    invalid = false
                    break
                }
            }
            if (invalid && !(matrix[i][weight-1].equals(zero))){
                println("There is no result!" )
                return
            }
        }
        for(i in 0 until height){
            for(j in 0 until weight - 1){
             //  println("${(matrix[i][j].equals(Fraction(1)))} && ${abs(matrix[i][j].toDouble() - 1.0)} ")
                if (matrix[i][j].equals(singl)){
                    print("x${j+1} = ")
                    for(k in j+1 until weight-1){
                        if (!matrix[i][k].equals(zero)){
                            var  result = Fraction(matrix[i][k].numerator, matrix[i][k].denominator)
                            var  minus = Fraction(-1,1)
                            result.multiply(minus)
                            print(" $result x${k+1} + ")
                        }
                    }
                    println(matrix[i][weight-1].toString())
                    break
                }
            }
        }
    }

}