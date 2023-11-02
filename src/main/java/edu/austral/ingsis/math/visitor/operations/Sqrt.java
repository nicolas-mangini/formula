package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.*;

import java.util.Map;

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
    public String accept(FunctionVisitor functionVisitor) {
        return functionVisitor.visitSqrt(this);
    }

    public Function getRadicand() {
        return this.radicand;
    }
}
