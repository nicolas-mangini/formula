package edu.austral.ingsis.math.composite.element;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;


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


    public String print() {
        return this.variable;
    }
}
