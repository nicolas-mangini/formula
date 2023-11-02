package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Sqrt implements Function {
    private final Function radicand;

    public Sqrt(Function radicand) {
        this.radicand = radicand;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return Math.sqrt(radicand.evaluate(variables));
    }

    @Override
    public String print() {
        return "sqrt(" + radicand.print() + ")";
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        return Stream.concat(variables.stream(), Stream.of(radicand.print())).toList();
    }
}
