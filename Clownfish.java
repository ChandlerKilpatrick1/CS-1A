

public class Clownfish implements iAnimal {
	
	String animalType = "Clownfish";

	 int minTemperature = 75;

	 int maxTemperature = 80;

	 int IdTag;
	
	
	public String getAnimalType(){
			return(animalType);
	}
	
	public void setIdTag(int anIdTag){
		IdTag = anIdTag;
	}
	
	public int getIdTag(){
		 return(IdTag);
		
	}
	
	public int getMinTemperature() {
		return(minTemperature);
	}
	
	public int getMaxTemperature() {
		return(maxTemperature);
	}
	// Returns true if the object CAN be added to the list.
	public boolean compareTo(iAnimal animal) {
		if ((getAnimalType() == animal.getAnimalType()) && (getIdTag() == animal.getIdTag()) && 
				(getMinTemperature() == animal.getMinTemperature()) && 
				(getMaxTemperature() == animal.getMaxTemperature()) ) 
			return false;

		
	return true;	
		
	}
}
