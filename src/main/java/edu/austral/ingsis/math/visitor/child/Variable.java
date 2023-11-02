package edu.austral.ingsis.math.visitor.child;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.FunctionVisitor;

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

    @Override
    public String accept(FunctionVisitor functionVisitor) {
        return functionVisitor.visitVariable(this);
    }

    public String getVariable() {
        return this.variable;
    }
}
