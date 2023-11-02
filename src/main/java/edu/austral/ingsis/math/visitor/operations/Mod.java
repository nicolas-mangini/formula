package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.*;

import java.util.Map;

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
    public String accept(FunctionVisitor functionVisitor) {
        return functionVisitor.visitMod(this);
    }

    public Function getFunction() {
        return this.function;
    }
}
