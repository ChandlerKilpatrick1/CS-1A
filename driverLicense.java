/*
 
 
 
 */


public class driverLicense{

	public String name;
	public int address;
	public double height;
	public int weight;
	public String eyeColor;
	public String hairColor;
	public String driverLicenseNum;
	
	public static int licenseCount = 1000;
	
	/* CONSTRUCTOR */ 
	public driverLicense(String name, int address, double height, int weight, String eyeColor, String hairColor) {
		
		this.name = name;
		this.address = address;
		this.height = height;
		this.weight = weight;
		this.eyeColor = eyeColor;
		this.hairColor = hairColor;
		licenseCount++;
		driverLicenseNum = this.numberGenerator();
	}
	
	public driverLicense(String name) {
		
		this.name = name;
		licenseCount++;
		driverLicenseNum = this.numberGenerator();
	}
	
	public driverLicense(driverLicense driver) {
		this.name = driver.getName();
		this.address = driver.getAddress();
		this.height = driver.getHeight();
		this.weight = driver.getWeight();
		this.eyeColor = driver.getEyeColor();
		this.hairColor = driver.getHairColor();
		licenseCount++;
	}

	public String numberGenerator() {
		String state_ab = "CA";
		return(state_ab + licenseCount);
		
	}
/* GETTERS AND SETTERS */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getDriverLicenseNum() {
		return driverLicenseNum;
	}

	public void setDriverLicenseNum(String driverLicenseNum) {
		this.driverLicenseNum = driverLicenseNum;
	}

	@Override
	public String toString() {
		return "driverLicense [name = " + name + ", address = " + address + ", height = " + height + ", weight = "
	+ weight + ", eyeColor = " + eyeColor + ", hairColor = " + hairColor + ", driverLicenseNum =" + 
	driverLicenseNum + "]";
	}
    
	
}



