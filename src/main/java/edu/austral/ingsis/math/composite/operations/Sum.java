package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

public class Sum implements Function {
    private final Function function1;
    private final Function function2;

    public Sum(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public Double evaluate() {
        return function1.evaluate() + function2.evaluate();
    }

    @Override
    public String toString() {
        return "(" + function1.toString() + " + " + function2.toString() + ")";
    }
}
