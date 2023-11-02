package edu.austral.ingsis.math.validator;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.behaviours.PrinterVisitor;
import edu.austral.ingsis.math.visitor.functions.Number;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    private PrinterVisitor printerVisitor;

    @Before
    public void setUp() {
        printerVisitor = new PrinterVisitor();
    }

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "(1.0 + 6.0)";
        final Function function = new Sum(new Number(1.0), new Number(6.0));
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "(12.0 / 2.0)";
        final Function function = new Div(new Number(12.0), new Number(2.0));
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "((9.0 / 2.0) * 3.0)";
        Function function = new Mul(new Div(new Number(9.0), new Number(2.0)), new Number(3.0));
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "((27.0 / 6.0) ^ 2.0)";
        final Function function = new Pow(new Div(new Number(27.0), new Number(6.0)), new Number(2.0));
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "(|value| - 8.0)";
        final Function function = new Sub(new Mod(new Variable("value")), new Number(8.0));
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "(|value| - 8.0)";
        Function function = new Sub(new Mod(new Variable("value")), new Number(8.0));
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "((5.0 - i) * 8.0)";
        Function function = new Mul(new Sub(new Number(5.0), new Variable("i")), new Number(8.0));
        final String result = printerVisitor.print(function);

        assertThat(result, equalTo(expected));
    }
}
