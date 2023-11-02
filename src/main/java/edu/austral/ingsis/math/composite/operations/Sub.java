package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;

public class Sub implements Function {
    private final Function left;
    private final Function right;

    public Sub(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return left.evaluate(variables) - right.evaluate(variables);
    }

    public String print() {
        return "(" + left.print() + " - " + right.print() + ")";
    }
}
