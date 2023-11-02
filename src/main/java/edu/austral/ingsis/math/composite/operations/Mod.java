package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;

public class Mod implements Function {
    private final Function number;

    public Mod(Function number) {
        this.number = number;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return (number.evaluate(variables) > 0) ? number.evaluate(variables) : -number.evaluate(variables);
    }

    public String print() {
        return "|" + number.print() + "|";
    }
}
