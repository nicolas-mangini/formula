package edu.austral.ingsis.math.composite;

import java.util.Map;
import java.util.Set;

public interface Function {
    Double evaluate(Map<String, Double> variables);

    String print();

    Set<String> listVariables(Set<String> variables);
}
