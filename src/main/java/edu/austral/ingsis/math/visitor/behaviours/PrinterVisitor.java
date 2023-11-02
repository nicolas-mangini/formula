package edu.austral.ingsis.math.visitor.behaviours;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.functions.Number;
import edu.austral.ingsis.math.visitor.functions.Variable;
import edu.austral.ingsis.math.visitor.functions.*;

public class PrinterVisitor implements Visitor<String> {
    public String print(Function function) {
        return function.accept(this);
    }

    @Override
    public String visitNumber(Number number) {
        return String.valueOf(number.getValue());
    }

    @Override
    public String visitVariable(Variable variable) {
        return variable.getVariable();
    }

    @Override
    public String visitSum(Sum sum) {
        return "(" + sum.getLeft().accept(this) + " + " + sum.getRight().accept(this) + ")";
    }

    @Override
    public String visitSub(Sub sub) {
        return "(" + sub.getLeft().accept(this) + " - " + sub.getRight().accept(this) + ")";
    }

    @Override
    public String visitMul(Mul mul) {
        return "(" + mul.getLeft().accept(this) + " * " + mul.getRight().accept(this) + ")";
    }

    @Override
    public String visitDiv(Div div) {
        return "(" + div.getDividend().accept(this) + " / " + div.getDivisor().accept(this) + ")";
    }

    @Override
    public String visitPow(Pow pow) {
        return "(" + pow.getBase().accept(this) + " ^ " + pow.getExponent().accept(this) + ")";
    }

    @Override
    public String visitSqrt(Sqrt sqrt) {
        return "sqrt(" + sqrt.getRadicand().accept(this) + ")";
    }

    @Override
    public String visitMod(Mod mod) {
        return "|" + mod.getFunction().accept(this) + "|";
    }
}
