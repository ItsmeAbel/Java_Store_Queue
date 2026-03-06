package lab4;


public class Person {
	private String name;
	//varor ska ändras till int
	private int varor;
	private int indx;
	private boolean inStore;
	//avaror ska ändras till int
	public Person(String aName, int aVaror, int aIndx) {
		name = aName;
		varor = aVaror;
		indx = aIndx;
		inStore = true;
	}
	
	public String getName() {
		return name;
	}
	
	//String ska ändras till int
	public int getVaror() {
		return varor;
	}
	
	public void setIndx(int aIndx) {
		indx = aIndx;
	}
	
	public int getIndx() {
		return indx;
	}
	
	
	
	public void LeaveStore() {
		inStore = false;
	}
	
	public boolean isInStore() {
		return inStore;
	}
	
	public String toString() {
		return (varor +", "+ name);
	}
}
