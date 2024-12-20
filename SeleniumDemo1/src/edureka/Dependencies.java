package edureka;

import org.testng.annotations.Test;

public class Dependencies {
	@Test()
	public void carStart() {
		System.out.println("Car Start");
	}
	
	@Test(dependsOnMethods = "carStart")
	public void gear1() {
		System.out.println("gear1");
	}
	
	@Test(dependsOnMethods = "gear1")
	public void gear2() {
		System.out.println("gear2");
	}
	
	@Test(dependsOnMethods = "gear2")
	public void gear3() {
		System.out.println("gear3");
	}
	
	@Test(dependsOnMethods = "gear3")
	public void stopCar() {
		System.out.println("Stop Car");
	}
	
	@Test(dependsOnMethods = "carStart")
	public void playMusic() {
		System.out.println("Play Music");
	}
}
