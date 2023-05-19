package Calc;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class math1 {

	@Test
	@Parameters({"ap1","ap2","ap3"})
	public void add(int a, int b,int c) {
		int sum = 0;
		sum = a + b;
		System.out.println("addition=" + sum);
		Assert.assertEquals(sum, c);
	}

	@Test
	@Parameters({"sp1","sp2","sp3"})
	public void sub(int s1, int s2, int s3) {
		int res = 0;
		res = s1-s2;
		System.out.println("subtraction=" + res);
		Assert.assertEquals(res, s3);
	}
}
