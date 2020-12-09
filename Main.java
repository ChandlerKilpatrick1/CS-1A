import java.util.*; 

	public class Main
	{
	   public static void main (String[] args) 
	   {
		   Tourist t1 = new Tourist("Chandler", 1234, "Boston");
		   Tourist t2 = new Tourist("Logan", 5678, "Chicago");
		   Tourist t3 = new Tourist("Graham", 1357, "LA");
	     

	   } 
	}

	class Tourist
	{
	   List<Tourist> tlist = new LinkedList<Tourist>();
	   private String name;
	   private Integer passport;
	   private String destination;
	   
	   
	   
	   public Tourist(String name, Integer passport, String destination) {
		this.name = name;
		this.passport = passport;
		this.destination = destination;
	}

	public String getName()
	   {
	      return name;
	   }
	  
	   public String getPass()
	   {
	      return passport.toString();
	   }
	   
	   public String getDestination()
	   {
		   return destination.toString();
	   }
	   
	   
	   private class Node
	   {
	      

	      public void addFirst(String touristName, int passportNumber, 
	    		  String destinationCity) {
	    	  
			  Tourist t1 = new Tourist(touristName, passportNumber,
					  destinationCity);

	    	  tlist.add(1, t1);
	    	  
	      }
	      
	      public int size()
	      {
	    	  return tlist.size();
	      }
	      
	      public String findNode(String touristName)
	      {
	    	  for(int i = 0; i < tlist.size(); i++) {
	    		  if(tlist.get(i).name == touristName) {
	    			  return tlist.get(i).destination;
	    		  }
	    		  
	    	  }
	    	  return "None";
	      }
	      
	      
	      
	   }
	}
 