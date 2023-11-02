package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.*;

import java.util.Map;

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
    public String accept(FunctionVisitor functionVisitor) {
        return functionVisitor.visitPow(this);
    }

    public Function getBase() {
        return this.base;
    }

    public Function getExponent() {
        return this.exponent;
    }
}
