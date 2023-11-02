package edu.austral.ingsis.math.visitor.functions;

import edu.austral.ingsis.math.visitor.*;

public class Mod implements Function {
    private final Function function;

    public Mod(Function function) {
        this.function = function;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitMod(this);
    }

    public Function getFunction() {
        return this.function;
    }
}
