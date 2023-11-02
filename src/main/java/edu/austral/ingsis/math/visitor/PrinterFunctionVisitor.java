package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.child.Number;
import edu.austral.ingsis.math.visitor.child.Variable;
import edu.austral.ingsis.math.visitor.operations.*;

public class PrinterFunctionVisitor implements FunctionVisitor {
    public String print(Function function) {
        return function.accept(this);

/*        if (function instanceof Number) {
            return visit((Number) function);
        } else if (function instanceof Variable) {
            return visit((Variable) function);
        } else if (function instanceof Sum) {
            return visit((Sum) function);
        } else if (function instanceof Sub) {
            return visit((Sub) function);
        } else if (function instanceof Mul) {
            return visit((Mul) function);
        } else if (function instanceof Div) {
            return visit((Div) function);
        } else if (function instanceof Pow) {
            return visit((Pow) function);
        } else if (function instanceof Sqrt) {
            return visit((Sqrt) function);
        } else if (function instanceof Mod) {
            return visit((Mod) function);
        } else {
            throw new RuntimeException("Unknown function type");
        }*/
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
