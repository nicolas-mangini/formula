package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Mod implements Function {
    private final Function function;

    public Mod(Function function) {
        this.function = function;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return (function.evaluate(variables) > 0) ? function.evaluate(variables) : -function.evaluate(variables);
    }

    @Override
    public String print() {
        return "|" + function.print() + "|";
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        return Stream.concat(variables.stream(), Stream.of(function.print())).toList();
    }
}
