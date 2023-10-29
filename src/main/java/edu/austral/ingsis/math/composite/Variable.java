package edu.austral.ingsis.math.composite;

public class Variable implements Operation {
    private final Double number;

    public Variable(Double number) {
        this.number = number;
    }

    @Override
    public Double evaluate() {
        return this.number;
    }
}
