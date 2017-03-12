package wdsr.exercise1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilModuloTest {
	private Calculator calculator;
	private CalculatorUtil calcUtil;

	@Before
	public void init() {
		calculator = Mockito.mock(Calculator.class);
		calcUtil = new CalculatorUtil(calculator);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testModuloByZero() {
		// given
		doThrow(new ArithmeticException()).when(calculator).modulo(anyInt(), eq(0));
		
		// when
		calcUtil.getModuloText(4, 0);
		
		// then
		// empty - exception expected
	}

	@Test
	public void testModulo16By4() {
		// given
		doReturn(0).when(calculator).modulo(anyInt(), anyInt());
		
		//when
		String result = calcUtil.getModuloText(16, 4);
		
		//then
		assertThat(result, equalTo("16 % 4 = 0"));
		verify(calculator).modulo(anyInt(), anyInt());
	}
}
