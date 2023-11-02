package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;

public class Sqrt implements Function {
    private final Function element;

    public Sqrt(Function element) {
        this.element = element;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return Math.sqrt(element.evaluate(variables));
    }

    public String print() {
        return "sqrt(" + element.print() + ")";
    }
}
