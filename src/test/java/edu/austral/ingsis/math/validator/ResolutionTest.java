package edu.austral.ingsis.math.validator;


import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.behaviours.EvaluateVisitor;
import edu.austral.ingsis.math.visitor.functions.*;
import edu.austral.ingsis.math.visitor.functions.Number;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {
    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor(null);
        final Function function = new Sum(new Number(1.0), new Number(6.0));
        final Double result = evaluateVisitor.evaluate(function);
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor(null);
        final Function function = new Div(new Number(12.0), new Number(2.0));
        final Double result = evaluateVisitor.evaluate(function);
        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor(null);
        final Function function = new Mul(new Div(new Number(9.0), new Number(2.0)), new Number(3.0));
        final Double result = evaluateVisitor.evaluate(function);
        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor(null);
        final Function function = new Pow(new Div(new Number(27.0), new Number(6.0)), new Number(2.0));
        final Double result = evaluateVisitor.evaluate(function);
        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor(null);
        final Function function = new Pow(new Number(36.0), new Div(new Number(1.0), new Number(2.0)));
        final Double result = evaluateVisitor.evaluate(function);
        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor(null);
        final Function function = new Mod(new Number(136.0));
        final Double result = evaluateVisitor.evaluate(function);
        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor(null);
        final Function function = new Mod(new Number(-136.0));
        final Double result = evaluateVisitor.evaluate(function);
        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        EvaluateVisitor evaluateVisitor = new EvaluateVisitor(null);
        final Function function = new Mul(new Sub(new Number(5.0), new Number(5.0)), new Number(8.0));
        final Double result = evaluateVisitor.evaluate(function);
        assertThat(result, equalTo(0d));
    }
}
