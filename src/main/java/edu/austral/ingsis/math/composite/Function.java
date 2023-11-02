package edu.austral.ingsis.math.composite;

import java.util.Map;

public interface Function {
    Double evaluate(Map<String, Double> variables);

    String print();

}
