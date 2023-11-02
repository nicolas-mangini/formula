package edu.austral.ingsis.math.composite.element;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
    public List<String> listVariables(List<String> variables) {
        return variables;
    }
}
