package net.objecthunter.exp4j.function;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.MathContext;

import net.objecthunter.exp4j.bigdecimal.BigDecimalMath;
import net.objecthunter.exp4j.expression.ExpressionBuilder;

import org.junit.Test;

public class BigDecimalFunctionsTest {
	private static MathContext mc = MathContext.DECIMAL128;

	@Test
	public void testSin1() throws Exception {
		Function<BigDecimal> sine = Functions.getBuiltinFunction("sin",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sine.apply(BigDecimalMath.pi(mc));
		assertEquals(BigDecimal.ZERO, tmp);
	}

	@Test
	public void testSin2() throws Exception {
		Function<BigDecimal> sine = Functions.getBuiltinFunction("sin",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sine.apply(BigDecimal.ZERO);
		assertEquals(BigDecimal.ZERO, tmp);
	}

	@Test
	public void testSin3() throws Exception {
		Function<BigDecimal> sine = Functions.getBuiltinFunction("sin",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sine.apply(BigDecimalMath.pi(mc));
		assertEquals(0, BigDecimal.ZERO.compareTo(tmp));
	}

	@Test
	public void testSin4() throws Exception {
		Function<BigDecimal> sine = Functions.getBuiltinFunction("sin",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sine.apply(BigDecimalMath.pi(mc).divide(
				new BigDecimal(2)));
		assertEquals(0,BigDecimal.ONE.compareTo(tmp));
	}

	@Test
	public void testSin5() throws Exception {
		Function<BigDecimal> sine = Functions.getBuiltinFunction("sin",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sine.apply(BigDecimalMath.pi(mc).divide(new BigDecimal(2)).multiply(new BigDecimal(3)));
		assertEquals(0, BigDecimal.ONE.negate().compareTo(tmp));
	}

	@Test
	public void testSin6() throws Exception {
		Function<BigDecimal> sine = Functions.getBuiltinFunction("sin",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal oneThird = BigDecimal.ONE.divide(new BigDecimal(3,
				mc), mc);
		BigDecimal tmp = sine.apply(oneThird);
		System.out.println(tmp);
		assertEquals(0,
				new BigDecimal("0.32719469679615224417334408526762060")
						.compareTo(tmp));
	}

	@Test
	public void testSqrt1() throws Exception {
		Function<BigDecimal> sqrt = Functions.getBuiltinFunction("sqrt",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sqrt.apply(new BigDecimal(100));
		assertEquals(0, tmp.compareTo(BigDecimal.TEN));
	}

	@Test
	public void testSqrt2() throws Exception {
		Function<BigDecimal> sqrt = Functions.getBuiltinFunction("sqrt",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sqrt.apply(BigDecimal.ONE);
		assertEquals(0, tmp.compareTo(BigDecimal.ONE));
	}

	@Test
	public void testSqrt3() throws Exception {
		Function<BigDecimal> sqrt = Functions.getBuiltinFunction("sqrt",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sqrt.apply(BigDecimal.ZERO);
		assertEquals(0, tmp.compareTo(BigDecimal.ZERO));
	}

	@Test
	public void testSqrt4() throws Exception {
		Function<BigDecimal> sqrt = Functions.getBuiltinFunction("sqrt",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sqrt.apply(new BigDecimal(9d));
		assertEquals(0, tmp.compareTo(new BigDecimal(3d)));
	}

	@Test
	public void testSqrt5() throws Exception {
		Function<BigDecimal> sqrt = Functions.getBuiltinFunction("sqrt",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sqrt.apply(new BigDecimal(2d));
		assertEquals(0, tmp.compareTo(new BigDecimal(
				"1.41421356237309504880168872420969808")));
	}

	@Test
	public void testCos1() throws Exception {
		Function<BigDecimal> cos = Functions.getBuiltinFunction("cos",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = cos.apply(BigDecimalMath.pi(mc));
		assertEquals(0, BigDecimal.ONE.negate().compareTo(tmp));
	}

	@Test
	public void testCos2() throws Exception {
		Function<BigDecimal> cos = Functions.getBuiltinFunction("cos",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = cos.apply(BigDecimal.ZERO);
		assertEquals(BigDecimal.ONE, tmp);
	}

	@Test
	public void testCos3() throws Exception {
		Function<BigDecimal> cos = Functions.getBuiltinFunction("cos",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = cos.apply(BigDecimalMath.pi(mc).divide(new BigDecimal(2)));
		assertEquals(0, BigDecimal.ZERO.compareTo(tmp));
	}

	@Test
	public void testCos4() throws Exception {
		Function<BigDecimal> cos = Functions.getBuiltinFunction("cos",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = cos.apply(BigDecimalMath.pi(mc).divide(new BigDecimal(2), mc).multiply(new BigDecimal(3), mc));
		assertEquals(0, BigDecimal.ZERO.compareTo(tmp));
	}

	@Test
	public void testCos5() throws Exception {
		Function<BigDecimal> cos = Functions.getBuiltinFunction("cos",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal oneThird = BigDecimal.ONE.divide(new BigDecimal(3,
				mc), mc);
		BigDecimal tmp = cos.apply(oneThird);
		System.out.println(tmp);
		assertEquals(0,
				new BigDecimal("0.9449569463147376643882840076758806")
						.compareTo(tmp));
	}

	@Test(expected = ArithmeticException.class)
	public void testSqrtWithNegativeArgument() throws Exception {
		Function<BigDecimal> sqrt = Functions.getBuiltinFunction("sqrt",
				ExpressionBuilder.MODE_BIGDECIMAL);
		BigDecimal tmp = sqrt.apply(new BigDecimal(-1));
	}
}