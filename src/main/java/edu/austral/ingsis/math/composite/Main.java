package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.element.Number;
import edu.austral.ingsis.math.composite.element.Variable;
import edu.austral.ingsis.math.composite.operations.Mod;
import edu.austral.ingsis.math.composite.operations.Mul;
import edu.austral.ingsis.math.composite.operations.Pow;
import edu.austral.ingsis.math.composite.operations.Sum;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Function function = new Sum(new Number(3d), new Number(22d));
        System.out.println(function.print());
        System.out.println(function.evaluate(new HashMap<>()));

        Function function1 = new Sum(new Mod(new Number(-9d)), new Variable("x"));
        System.out.println(function1.print());
        Map<String, Double> map = new HashMap<>();
        map.put("x", 3d);
        System.out.println(function1.evaluate(map));
    }
}
