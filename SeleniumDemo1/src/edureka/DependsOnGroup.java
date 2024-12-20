package edureka;

import org.testng.annotations.Test;

public class DependsOnGroup {
	
	@Test(groups ={"Vivo"})
	public void vivo1() {
		System.out.println("Vivo1");
	}
	
	@Test(groups ={"Vivo"})
	public void vivo2() {
		System.out.println("Vivo2");
	}
	
	@Test(groups ={"Oppo"})
	public void oppo1() {
		System.out.println("Oppo1");
	}
	
	@Test(groups ={"Oppo"})
	public void oppo2() {
		System.out.println("Oppo2");
	}
	
	@Test(groups ={"Apple"})
	public void apple1() {
		System.out.println("Apple1");
	}
	
	@Test(groups ={"Apple"})
	public void apple2() {
		System.out.println("Apple2");
	}
}
