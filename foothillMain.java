import java.util.*;
public class foothillMain {
	
	public static int interact() {
		Scanner myScan = new Scanner(System.in);
		System.out.println("Enter a Animal ID Tag");
		int animalTag = myScan.nextInt();

		return(animalTag);
		
	}
	
	
	
	public static void main (String[] args){
		
		int idTag = interact();
		
		
		Clownfish animalOne = new Clownfish();
		animalOne.setIdTag(idTag);
		
		int idTagTwo = interact();
		
		Beaver animalTwo = new Beaver();
		animalTwo.setIdTag(idTagTwo);

		
		ArrayList<iAnimal> zoo = new ArrayList<iAnimal>();
		
		
		for (int i = 0; i < zoo.size(); i++) {
			if (animalOne.compareTo(zoo.get(i)) == false) {
				System.out.print("This is a duplicate ");
				break;
			}
				
		}
		zoo.add(animalOne);
		
		
		for (int i = 0; i < zoo.size(); i++) {
			if (animalTwo.compareTo(zoo.get(i)) == false) {
				System.out.print("This is a duplicate 1 ");
				break;
			}
				
		}
		zoo.add(animalTwo);
		
		
		for (int i = 0; i < zoo.size(); i++) {
			zoo.get(i);
			System.out.println("Animal Type: " + zoo.get(i).getAnimalType());
			System.out.println("ID Tag: " + zoo.get(i).getIdTag());
			System.out.println("Min Temp: " + zoo.get(i).getMinTemperature());
			System.out.println("Max Temp: " + zoo.get(i).getMaxTemperature());
			System.out.println();

			
				
		}		
	   }
	

}
