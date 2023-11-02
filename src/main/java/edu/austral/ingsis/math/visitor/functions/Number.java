package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;


public class Number implements Function {
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitNumber(this);
    }

    public Double getValue() {
        return this.value;
    }
}
