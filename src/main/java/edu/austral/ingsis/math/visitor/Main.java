package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.behaviours.EvaluateVisitor;
import edu.austral.ingsis.math.visitor.behaviours.PrinterVisitor;
import edu.austral.ingsis.math.visitor.behaviours.VariableListerVisitor;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Number;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PrinterVisitor printerVisitor = new PrinterVisitor();
        Function function = new Sum(new Number(3.0), new Number(4.0));
        System.out.println(printerVisitor.print(function));

        Function function2 = new Pow(new Sum(new Number(3.0), new Variable("x")), new Mod(new Number(-5.0)));
        System.out.println(printerVisitor.print(function2));

        VariableListerVisitor variableListerVisitor = new VariableListerVisitor();
        System.out.println(variableListerVisitor.listVariables(function2));

        Map<String, Double> map = new HashMap<>();
        map.put("x", 3d);
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor(map);
        System.out.println(evaluateVisitor.evaluate(function2));
    }
}
