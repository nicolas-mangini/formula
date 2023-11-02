package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.child.*;
import edu.austral.ingsis.math.visitor.child.Number;
import edu.austral.ingsis.math.visitor.operations.*;

public interface FunctionVisitor {
    String visitNumber(Number number);

    String visitVariable(Variable variable);

    String visitSum(Sum sum);

    String visitSub(Sub sub);

    String visitMul(Mul mul);

    String visitDiv(Div div);

    String visitPow(Pow pow);

    String visitSqrt(Sqrt sqrt);

    String visitMod(Mod mod);
}
