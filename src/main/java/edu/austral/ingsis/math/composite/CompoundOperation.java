package edu.austral.ingsis.math.composite;

import java.util.List;

public class CompoundOperation implements Operation {
    private final List<Operation> operations;

    public CompoundOperation(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public Double evaluate() {
        return null;
    }
}
