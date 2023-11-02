package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.*;

public class Div implements Function {
    private final Function dividend;
    private final Function divisor;

    public Div(Function dividend, Function divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitDiv(this);
    }

    public Function getDividend() {
        return this.dividend;
    }

    public Function getDivisor() {
        return this.divisor;
    }
}
