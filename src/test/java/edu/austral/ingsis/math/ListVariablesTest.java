package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.element.Number;
import edu.austral.ingsis.math.composite.element.Variable;
import edu.austral.ingsis.math.composite.operations.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function function = new Sum(new Number(1.0), new Number(6.0));
        final List<String> result = function.listVariables(new ArrayList<>());

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function function = new Div(new Number(12.0), new Variable("div"));
        final List<String> result = function.listVariables(new ArrayList<>());

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Function function = new Mul(new Div(new Number(9.0), new Variable("x")), new Variable("y"));
        final List<String> result = function.listVariables(new ArrayList<>());

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function function = new Pow(new Div(new Number(27.0), new Variable("a")), new Variable("b"));
        final List<String> result = function.listVariables(new ArrayList<>());

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function function = new Pow(new Variable("z"), new Div(new Number(1.0), new Number(2.0)));
        final List<String> result = function.listVariables(new ArrayList<>());

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function function = new Sum(new Variable("value"), new Number(8.0));
        final List<String> result = function.listVariables(new ArrayList<>());

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Function function = new Sum(new Variable("value"), new Number(8.0));
        final List<String> result = function.listVariables(new ArrayList<>());

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function function = new Mul(new Sum(new Number(5.0), new Variable("i")), new Number(8.0));
        final List<String> result = function.listVariables(new ArrayList<>());

        assertThat(result, containsInAnyOrder("i"));
    }
}
