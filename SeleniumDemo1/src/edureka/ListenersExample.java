package edureka;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class ListenersExample implements ITestListener{
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Cases Completed");
	}

}
