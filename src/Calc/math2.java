package Calc;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class math2 {

	@Test
	@Parameters({ "mp1", "mp2", "mp3" })
	public void mul(int mp1, int mp2, int mp3) {
		int mul = 0;
		mul = mp1 * mp2;
		System.out.println("Multiplication=" + mul);
		Assert.assertEquals(mul, mp3);
	}

	@Test
	@Parameters({ "dp1", "dp2", "dp3" })
	public void div(int a, int b, int c) {
		int div = 0;
		div = a / b;
		System.out.println("Division=" + div);
		Assert.assertEquals(div, c);
	}

}
