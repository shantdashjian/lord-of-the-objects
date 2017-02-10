package project;

public abstract class Gear {
	private String name;
	
	public Gear(String name){
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public abstract void use();
}
