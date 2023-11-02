package edu.austral.ingsis.math.composite.element;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;

public class Number implements Function {
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return this.value;
    }

    public String print() {
        return String.valueOf(value);
    }
}
