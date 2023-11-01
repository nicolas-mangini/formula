package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.element.Number;
import edu.austral.ingsis.math.composite.element.Variable;
import edu.austral.ingsis.math.composite.operations.Mul;
import edu.austral.ingsis.math.composite.operations.Pow;
import edu.austral.ingsis.math.composite.operations.Sum;

public class Main {
    public static void main(String[] args) {
        Function function = new Sum(new Number(3.0), new Number(22.0));
        System.out.println(function);

        Function function1 = new Pow(new Sum(new Number(3.0), new Variable("x")), new Mul(new Number(2.0), new Number(9.0)));
        System.out.println(function1);
    }
}
