package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Sum implements Function {
    private final Function left;
    private final Function right;

    public Sum(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return left.evaluate(variables) + right.evaluate(variables);
    }

    @Override
    public String print() {
        return "(" + left.print() + " + " + right.print() + ")";
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        List<String> leftVariables = left.listVariables(variables);
        List<String> rightVariables = right.listVariables(variables);

        return Stream.concat(leftVariables.stream(), rightVariables.stream()).toList();
    }
}
