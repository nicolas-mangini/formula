package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.*;

import java.util.Map;

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
    public String accept(FunctionVisitor functionVisitor) {
        return functionVisitor.visitSum(this);
    }

    public Function getLeft() {
        return this.left;
    }

    public Function getRight() {
        return this.right;
    }
}
