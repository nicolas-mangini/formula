package edu.austral.ingsis.math.visitor.behaviours;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Number;

import java.util.Map;

public class EvaluateVisitor implements Visitor<Double> {
    private final Map<String, Double> variables;

    public EvaluateVisitor(Map<String, Double> variables) {
        this.variables = variables;
    }

    public Double evaluate(Function function) {
        return function.accept(this);
    }

    @Override
    public Double visitNumber(Number number) {
        return number.getValue();
    }

    @Override
    public Double visitVariable(Variable variable) {
        if (variables.containsKey(variable.getVariable()))
            return variables.get(variable.getVariable());
        else throw new RuntimeException("Variable " + variable + " not found");
    }

    @Override
    public Double visitSum(Sum sum) {
        return sum.getLeft().accept(this) + sum.getRight().accept(this);
    }

    @Override
    public Double visitSub(Sub sub) {
        return sub.getLeft().accept(this) - sub.getRight().accept(this);
    }

    @Override
    public Double visitMul(Mul mul) {
        return mul.getLeft().accept(this) * mul.getRight().accept(this);
    }

    @Override
    public Double visitDiv(Div div) {
        return div.getDividend().accept(this) / div.getDivisor().accept(this);
    }

    @Override
    public Double visitPow(Pow pow) {
        return Math.pow(pow.getBase().accept(this), pow.getExponent().accept(this));
    }

    @Override
    public Double visitSqrt(Sqrt sqrt) {
        return Math.sqrt(sqrt.getRadicand().accept(this));
    }

    @Override
    public Double visitMod(Mod mod) {
        return (mod.getFunction().accept(this) > 0) ? mod.getFunction().accept(this) : -mod.getFunction().accept(this);
    }
}
