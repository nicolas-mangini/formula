package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;

public class Pow implements Function {
    private final Function function1;
    private final Function function2;

    public Pow(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return Math.pow(function1.evaluate(variables), function2.evaluate(variables));
    }

    public String print() {
        return "(" + function1.print() + " ^ " + function2.print() + ")";
    }
}
