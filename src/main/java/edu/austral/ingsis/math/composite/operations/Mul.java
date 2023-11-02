package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mul implements Function {
    private final Function left;
    private final Function right;

    public Mul(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return left.evaluate(variables) * right.evaluate(variables);
    }

    @Override
    public String print() {
        return "(" + left.print() + " * " + right.print() + ")";
    }

    @Override
    public Set<String> listVariables(Set<String> variables) {
        Set<String> leftVariables = left.listVariables(variables);
        Set<String> rightVariables = right.listVariables(variables);

        return Stream.concat(leftVariables.stream(), rightVariables.stream())
                .collect(Collectors.toSet());
    }
}
