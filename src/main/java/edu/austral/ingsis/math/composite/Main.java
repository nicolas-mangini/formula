package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.operations.Sum;

public class Main {
    public static void main(String[] args) {
        Operation operation2 = new Sum(new Variable(3.0), new Variable(22.0));
        System.out.println(operation2);
    }
}
