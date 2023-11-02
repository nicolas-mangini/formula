package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.*;

public class Sqrt implements Function {
    private final Function radicand;

    public Sqrt(Function radicand) {
        this.radicand = radicand;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitSqrt(this);
    }

    public Function getRadicand() {
        return this.radicand;
    }
}
