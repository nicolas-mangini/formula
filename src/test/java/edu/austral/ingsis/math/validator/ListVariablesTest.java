package edu.austral.ingsis.math.validator;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.behaviours.VariableListerVisitor;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Number;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {
    private VariableListerVisitor variableListerVisitor;

    @Before
    public void setUp() {
        variableListerVisitor = new VariableListerVisitor();
    }

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function function = new Sum(new Number(1.0), new Number(6.0));
        final Set<String> result = variableListerVisitor.listVariables(function);

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function function = new Div(new Number(12.0), new Variable("div"));
        final Set<String> result = variableListerVisitor.listVariables(function);

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Function function = new Mul(new Div(new Number(9.0), new Variable("x")), new Variable("y"));
        final Set<String> result = variableListerVisitor.listVariables(function);

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function function = new Pow(new Div(new Number(27.0), new Variable("a")), new Variable("b"));
        final Set<String> result = variableListerVisitor.listVariables(function);

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function function = new Pow(new Variable("z"), new Div(new Number(1.0), new Number(2.0)));
        final Set<String> result = variableListerVisitor.listVariables(function);

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function function = new Sum(new Variable("value"), new Number(8.0));
        final Set<String> result = variableListerVisitor.listVariables(function);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Function function = new Sum(new Variable("value"), new Number(8.0));
        final Set<String> result = variableListerVisitor.listVariables(function);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function function = new Mul(new Sum(new Number(5.0), new Variable("i")), new Number(8.0));
        final Set<String> result = variableListerVisitor.listVariables(function);

        assertThat(result, containsInAnyOrder("i"));
    }

    /**
     * Extra case: same variable in different places
     * case (5 - x) * x
     */
    @Test
    public void shouldListVariablesFunction9() {
        Function function = new Mul(new Sub(new Number(5.0), new Variable("x")), new Variable("x"));
        final Set<String> result = variableListerVisitor.listVariables(function);

        assertThat(result, containsInAnyOrder("x"));
    }
}
