package edu.austral.ingsis.math.composite.element;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class Variable implements Function {
    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        if (variables.containsKey(variable))
        return variables.get(variable);
        else throw new RuntimeException("Variable " + variable + " not found");
    }

    @Override
    public String print() {
        return this.variable;
    }

    @Override
    public List<String> listVariables(List<String> variables) {
        return Stream.concat(variables.stream(), Stream.of(variable)).toList();
    }
}
