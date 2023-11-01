package edu.austral.ingsis.math.composite.element;

import edu.austral.ingsis.math.composite.Function;


public class Variable implements Function {
    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public Double evaluate() {
        return null;
    }

    @Override
    public String toString() {
        return this.variable;
    }
}
