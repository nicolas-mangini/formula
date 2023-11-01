package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

public class Pow implements Function {
    private final Function function1;
    private final Function function2;

    public Pow(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public Double evaluate() {
        return Math.pow(function1.evaluate(), function2.evaluate());
    }

    @Override
    public String toString() {
        return "(" + function1.toString() + " ^ " + function2.toString() + ")";
    }
}
