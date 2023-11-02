package edu.austral.ingsis.math.visitor;

import java.util.Map;

public interface Function {
    Double evaluate(Map<String, Double> variables);

    String accept(FunctionVisitor functionVisitor);
}
