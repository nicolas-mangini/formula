package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

public class Mod implements Function {
    private final Function number;

    public Mod(Function number) {
        this.number = number;
    }

    @Override
    public Double evaluate() {
        return (number.evaluate() > 0) ? number.evaluate() : -number.evaluate();
    }

    @Override
    public String toString() {
        return "|" + number.toString() + "|";
    }
}
