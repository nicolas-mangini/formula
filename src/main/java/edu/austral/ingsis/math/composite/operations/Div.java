package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public String print() {
        return "(" + dividend.print() + " / " + divisor.print() + ")";
    }

    @Override
    public Set<String> listVariables(Set<String> variables) {
        Set<String> dividendVariables = dividend.listVariables(variables);
        Set<String> divisorVariables = divisor.listVariables(variables);

        return Stream.concat(dividendVariables.stream(), divisorVariables.stream())
                .collect(Collectors.toSet());
    }
}
