package entities;

public class Vehicle {
	
	private  Long max_atmosphering_speed;
	private  String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMax_atmosphering_speed() {
		return max_atmosphering_speed;
	}

	public void setMax_atmosphering_speed(Long max_atmosphering_speed) {
		this.max_atmosphering_speed = max_atmosphering_speed;
	}

	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	public Vehicle(String name,Long max) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.max_atmosphering_speed = max;
	}

}
