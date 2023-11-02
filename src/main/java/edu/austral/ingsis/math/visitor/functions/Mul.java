package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.*;

public class Mul implements Function {
    private final Function left;
    private final Function right;

    public Mul(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitMul(this);
    }

    public Function getLeft() {
        return this.left;
    }

    public Function getRight() {
        return this.right;
    }
}
