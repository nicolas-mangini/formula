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
        VariableListerVisitor variableListerVisitor = new VariableListerVisitor();
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor(new HashMap<>());

        Function function = new Sum(new Number(3d), new Number(22d));
        System.out.println(printerVisitor.print(function));
        System.out.println(evaluateVisitor.evaluate(function));

        Function function1 = new Sum(new Mod(new Number(-9d)), new Variable("x"));
        System.out.println(printerVisitor.print(function1));

        Map<String, Double> map = new HashMap<>();
        map.put("x", 3d);
        EvaluateVisitor evaluateVisitor2 = new EvaluateVisitor(map);
        System.out.println(evaluateVisitor2.evaluate(function1));
    }
}
