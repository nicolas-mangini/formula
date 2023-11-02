package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.*;

import java.util.Map;

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
    public String accept(FunctionVisitor functionVisitor) {
        return functionVisitor.visitMul(this);
    }

    public Function getLeft() {
        return this.left;
    }

    public Function getRight() {
        return this.right;
    }
}
