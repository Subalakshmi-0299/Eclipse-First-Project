package Edureka;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedTestCases {
	@Test
	public void testcase1() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void testcase2() {
		Assert.assertEquals(true, false);
	}
}
