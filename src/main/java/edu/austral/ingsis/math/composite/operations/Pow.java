package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pow implements Function {
    private final Function base;
    private final Function exponent;

    public Pow(Function base, Function exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return Math.pow(base.evaluate(variables), exponent.evaluate(variables));
    }

    @Override
    public String print() {
        return "(" + base.print() + " ^ " + exponent.print() + ")";
    }

    @Override
    public Set<String> listVariables(Set<String> variables) {
        Set<String> baseVariables = base.listVariables(variables);
        Set<String> exponentVariables = exponent.listVariables(variables);

        return Stream.concat(baseVariables.stream(), exponentVariables.stream())
                .collect(Collectors.toSet());
    }
}
