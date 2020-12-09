import java.util.*;


public class boundedStack {
	
	
	private ArrayDeque<Double> myStack = new ArrayDeque<Double>();
	   
	public void load() {
		Scanner myScanner = new Scanner(System.in);
		while(true) {
		
			System.out.println("Enter a Spell (Enter 0 to Exit)");

			Double spell = myScanner.nextDouble();  // Read user input
			if (spell == 0) {
				break;
			}
			if(myStack.size() > 50) {
				myStack.removeFirst();
				
				
				
			}
			myStack.add(spell);
			
	    
		}
		myScanner.close();
	
	}
	public void pop() {
		System.out.print(myStack.remove());
	}
	
	public void unload() {
		while(myStack.isEmpty() == false)
		{
			System.out.println(myStack.remove());
		}
	}
}
