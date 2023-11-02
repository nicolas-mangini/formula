package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.child.Number;
import edu.austral.ingsis.math.composite.child.Variable;
import edu.austral.ingsis.math.composite.operations.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "(1.0 + 6.0)";
        final String result = new Sum(new Number(1.0), new Number(6.0)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "(12.0 / 2.0)";
        final String result = new Div(new Number(12.0), new Number(2.0)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "((9.0 / 2.0) * 3.0)";
        final String result = new Mul(new Div(new Number(9.0), new Number(2.0)), new Number(3.0)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "((27.0 / 6.0) ^ 2.0)";
        final String result = new Pow(new Div(new Number(27.0), new Number(6.0)), new Number(2.0)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "(|value| - 8.0)";
        final String result = new Sub(new Mod(new Variable("value")), new Number(8.0)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "(|value| - 8.0)";
        final String result = new Sub(new Mod(new Variable("value")), new Number(8.0)).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "((5.0 - i) * 8.0)";
        final String result = new Mul(new Sub(new Number(5.0), new Variable("i")), new Number(8.0)).print();

        assertThat(result, equalTo(expected));
    }
}
