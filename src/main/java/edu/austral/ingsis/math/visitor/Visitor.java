package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.functions.Number;
import edu.austral.ingsis.math.visitor.functions.*;

public interface Visitor<T> {
    T visitNumber(Number number);

    T visitVariable(Variable variable);

    T visitSum(Sum sum);

    T visitSub(Sub sub);

    T visitMul(Mul mul);

    T visitDiv(Div div);

    T visitPow(Pow pow);

    T visitSqrt(Sqrt sqrt);

    T visitMod(Mod mod);
}
