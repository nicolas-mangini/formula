package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

public class Sqrt implements Function {
    private final Function element;

    public Sqrt(Function element) {
        this.element = element;
    }

    @Override
    public Double evaluate() {
        return Math.sqrt(element.evaluate());
    }

    @Override
    public String toString() {
        return "sqrt(" + element.toString() + ")";
    }
}
