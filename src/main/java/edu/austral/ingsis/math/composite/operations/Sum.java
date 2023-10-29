package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Operation;

public class Sum implements Operation {
    private final Operation operation1;
    private final Operation operation2;

    public Sum(Operation operation1, Operation operation2) {
        this.operation1 = operation1;
        this.operation2 = operation2;
    }

    @Override
    public Double evaluate() {
        return operation1.evaluate() + operation2.evaluate();
    }
}
