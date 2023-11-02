package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.*;

public class Pow implements Function {
    private final Function base;
    private final Function exponent;

    public Pow(Function base, Function exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitPow(this);
    }

    public Function getBase() {
        return this.base;
    }

    public Function getExponent() {
        return this.exponent;
    }
}
