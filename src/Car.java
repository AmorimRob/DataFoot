
public class Car {
	private String model;
	private int  year;
	private String manufacturer;
	private String color;
	public Car(String randomModel2, int randomYear2, String randomManufacturer2,
			String randomColor2) {
		this.model = randomModel2;
		this.year = randomYear2;
		this.manufacturer = randomManufacturer2;
		this.color = randomColor2;
	}
	
	public Car(){}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	

}
