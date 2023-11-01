package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

public class Div implements Function {
    private final Function left;
    private final Function right;

    public Div(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Double evaluate() {
        return left.evaluate() / right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " : " + right.toString() + ")";
    }
}
