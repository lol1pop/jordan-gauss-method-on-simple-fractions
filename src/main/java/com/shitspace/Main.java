package main.java.com.shitspace;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int n1 = scanner.nextInt();
            int d1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int d2 = scanner.nextInt();

            Fraction f1 = new Fraction(n1, d1);
            String f1Str = f1.toString();
            System.out.println("The first fraction is " + f1Str);
            Fraction f2 = new Fraction(n2, d2);
            String f2Str = f2.toString();
            System.out.println("The second fraction is " + f2Str);
            Fraction temp = new Fraction(f1);

            int comparisonResult = f1.compareTo(f2);
            char relationSign = (comparisonResult > 0) ? '>' : (comparisonResult < 0) ? '<' : '=';
            System.out.println(f1Str + " " + relationSign + " " + f2Str);

            temp.add(f2);
            System.out.println(f1Str + " + " + f2Str + " = " + temp.toString());
            temp.setValue(f1);

            temp.substract(f2);
            System.out.println(f1Str + " - " + f2Str + " = " + temp.toString());
            temp.setValue(f1);

            temp.multiply(f2);
            System.out.println(f1Str + " * " + f2Str + " = " + temp.toString());
            temp.setValue(f1);

            try {
                temp.divide(f2);
                System.out.println(f1Str + " / " + f2Str + " = " + temp.toString());
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
