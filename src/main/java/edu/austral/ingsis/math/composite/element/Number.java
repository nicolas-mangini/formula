package edu.austral.ingsis.math.composite.element;

import edu.austral.ingsis.math.composite.Function;

public class Number implements Function {
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
