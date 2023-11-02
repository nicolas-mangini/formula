package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.child.Number;
import edu.austral.ingsis.math.composite.child.Variable;
import edu.austral.ingsis.math.composite.operations.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Map<String, Double> map = new HashMap<>();
        map.put("x", 3.0);
        final Function function = new Sum(new Number(1.0), new Variable("x"));
        final Double result = function.evaluate(map);

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Map<String, Double> map = new HashMap<>();
        map.put("div", 4.0);
        final Function function = new Div(new Number(12.0), new Variable("div"));
        final Double result = function.evaluate(map);

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Map<String, Double> map = new HashMap<>();
        map.put("x", 3.0);
        map.put("y", 4.0);
        final Function function = new Mul(new Div(new Number(9.0), new Variable("x")), new Variable("y"));
        final Double result = function.evaluate(map);

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Map<String, Double> map = new HashMap<>();
        map.put("a", 9.0);
        map.put("b", 3.0);
        final Function function = new Pow(new Div(new Number(27.0), new Variable("a")), new Variable("b"));
        final Double result = function.evaluate(map);

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Map<String, Double> map = new HashMap<>();
        map.put("z", 36.0);
        final Function function = new Pow(new Variable("z"), new Div(new Number(1.0), new Number(2.0)));
        final Double result = function.evaluate(map);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Map<String, Double> map = new HashMap<>();
        map.put("value", 8.0);
        final Function function = new Sub(new Mod(new Variable("value")), new Number(8.0));
        final Double result = function.evaluate(map);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Map<String, Double> map = new HashMap<>();
        map.put("value", 8.0);
        final Function function = new Sub(new Mod(new Variable("value")), new Number(8.0));
        final Double result = function.evaluate(map);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Map<String, Double> map = new HashMap<>();
        map.put("i", 2.0);
        final Function function = new Mul(new Sub(new Number(5.0), new Variable("i")), new Number(8.0));
        final Double result = function.evaluate(map);

        assertThat(result, equalTo(24d));
    }
}
