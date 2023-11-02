package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.*;

import java.util.Map;

public class Div implements Function {
    private final Function dividend;
    private final Function divisor;

    public Div(Function dividend, Function divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return dividend.evaluate(variables) / divisor.evaluate(variables);
    }

    @Override
    public String accept(FunctionVisitor functionVisitor) {
        return functionVisitor.visitDiv(this);
    }

    public Function getDividend() {
        return this.dividend;
    }

    public Function getDivisor() {
        return this.divisor;
    }
}
