package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.child.Number;
import edu.austral.ingsis.math.visitor.operations.Mod;
import edu.austral.ingsis.math.visitor.operations.Pow;
import edu.austral.ingsis.math.visitor.operations.Sum;

public class Main {
    public static void main(String[] args) {
        PrinterFunctionVisitor printerVisitor = new PrinterFunctionVisitor();
        Function function = new Sum(new Number(3.0), new Number(4.0));
        System.out.println(printerVisitor.print(function));

        Function function2 = new Pow(new Sum(new Number(3.0), new Number(4.0)), new Mod(new Number(-5.0)));
        System.out.println(printerVisitor.print(function2));
    }
}
