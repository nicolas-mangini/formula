package edu.austral.ingsis.math.visitor.child;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.FunctionVisitor;

import java.util.Map;

public class Number implements Function {
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return this.value;
    }

    @Override
    public String accept(FunctionVisitor functionVisitor) {
        return functionVisitor.visitNumber(this);
    }

    public Double getValue() {
        return this.value;
    }
}
