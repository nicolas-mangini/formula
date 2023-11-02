package edu.austral.ingsis.math.visitor.behaviours;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Number;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VariableListerVisitor implements Visitor<Set<String>> {
    public Set<String> listVariables(Function function) {
        return function.accept(this);
    }

    @Override
    public Set<String> visitNumber(Number number) {
        return new HashSet<>();
    }

    @Override
    public Set<String> visitVariable(Variable variable) {
        return new HashSet<>(Set.of(variable.getVariable()));
    }

    @Override
    public Set<String> visitSum(Sum sum) {
        Set<String> left = sum.getLeft().accept(this);
        Set<String> right = sum.getRight().accept(this);

        return Stream.concat(left.stream(), right.stream()).collect(Collectors.toSet());
    }

    @Override
    public Set<String> visitSub(Sub sub) {
        Set<String> left = sub.getLeft().accept(this);
        Set<String> right = sub.getRight().accept(this);

        return Stream.concat(left.stream(), right.stream()).collect(Collectors.toSet());
    }

    @Override
    public Set<String> visitMul(Mul mul) {
        Set<String> left = mul.getLeft().accept(this);
        Set<String> right = mul.getRight().accept(this);

        return Stream.concat(left.stream(), right.stream()).collect(Collectors.toSet());
    }

    @Override
    public Set<String> visitDiv(Div div) {
        Set<String> dividend = div.getDividend().accept(this);
        Set<String> divisor = div.getDivisor().accept(this);

        return Stream.concat(dividend.stream(), divisor.stream()).collect(Collectors.toSet());
    }

    @Override
    public Set<String> visitPow(Pow pow) {
        Set<String> base = pow.getBase().accept(this);
        Set<String> exponent = pow.getExponent().accept(this);

        return Stream.concat(base.stream(), exponent.stream()).collect(Collectors.toSet());
    }

    @Override
    public Set<String> visitSqrt(Sqrt sqrt) {
        return new HashSet<>(sqrt.getRadicand().accept(this));
    }

    @Override
    public Set<String> visitMod(Mod mod) {
        return new HashSet<>(mod.getFunction().accept(this));
    }
}
