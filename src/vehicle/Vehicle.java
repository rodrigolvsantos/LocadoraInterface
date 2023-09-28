package vehicle;

public class Vehicle {
     
	private String model;
	private String color;
	private String plate;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String model, String color, String plate) {
		this.model = model;
		this.color = color;
		this.plate = plate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	
}
