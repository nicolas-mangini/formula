package edu.austral.ingsis.math.composite.child;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;
import java.util.Set;

public class Number implements Function {
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return this.value;
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }

    @Override
    public Set<String> listVariables(Set<String> variables) {
        return variables;
    }
}
