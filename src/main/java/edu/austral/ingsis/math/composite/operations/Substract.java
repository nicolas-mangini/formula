package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Operation;

public class Substract implements Operation {
    private final Operation left;
    private final Operation right;

    public Substract(Operation left, Operation right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Double evaluate() {
        return left.evaluate() - right.evaluate();
    }
}
