import java.util.Random;

import becker.robots.*;


public class A2_Part_3 extends Robot
{
    
   
   public A2_Part_3(City arg0, int arg1, int arg2, Direction arg3, int i) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
   
   // The method will have the robot move forward until a wall is hit.
   public void keepGoing()
   {
      while( this.frontIsClear() )
      {
         this.move();
      }
   } 
   
   // This method will turn the robot 180 degrees.
   public void turnAround()
   {
	   this.turnLeft();
	   this.turnLeft();
	   
   }
   
   // This method will maneuver the robot to the next line.
   public void nextLine()
   {
	   this.turnLeft();
	   this.move();
	   this.turnLeft();
	   
   }
   
   // This method will place each item in the correct location.
   public void putDown()
   {
	   this.move();
	   this.putThing();
	   
   }
   
   // This method will turn the robot right.
   public void turnRight()
   {
	   this.turnLeft();
	   this.turnLeft();
	   this.turnLeft();
   }
   
   // This method will have the robot move back to the starting position.
   public void finish()
   {
	   this.turnAround();
	   this.keepGoing();
	   this.turnRight();
	   this.keepGoing();
	   this.turnRight();
	   
   }
   
   // This method runs the program.
   public void doEverything()
   {
	   // This sets i equal to zero.
       int i = 0;
       // This while loop will navigate and pickup collect objects for the first 4 pipes.
       while (i < 4) {
       	this.keepGoing();
       	this.pickThing();
       	this.turnAround();
       	this.keepGoing();
       	this.nextLine();
       	i++;
       	
       }
       // This while loop will place the four items.
       while (i < 8) {
       	this.putDown();
       	i++;
       }
       // This will return the robot to it's starting location.
       this.finish();
     
   }
   
   public static void main(String[] args)
    {
        City wallville = new City(6, 12);
        A2_Part_3 rob = new A2_Part_3(wallville, 1, 2, Direction.EAST, 0);

        A2_Part_3.BuildCity(wallville); // this calls the "BuildCity" method, below

       // This is calling the program to run. 
       rob.doEverything();
      
      
   }

    /////////////////////////////////////////////////////////////////////////////////////////
    // No need to touch any of the code below.
    // All it does is construct the maze in the city.
    /////////////////////////////////////////////////////////////////////////////////////////
    public static void BuildCity(City wallville)
    {
        // Width and height must be at least 2 (each)
        // Feel free to change these numbers, and see how your racetrack changes

        Random randomNumberGenerator = new Random();
        int top = 1;
        int left = 2;
        int height = 4;
        int width = 7 + randomNumberGenerator.nextInt(4);

        int streetNumber = top;
        while (streetNumber <= height)
        {
            if (streetNumber == 1)
            {
                // the topmost line:
                new Wall(wallville, streetNumber, left, Direction.NORTH);
            } else if (streetNumber == height)
            {
                // generate the 'holding spot' thing at the bottom:

                // the corner:
                new Wall(wallville, streetNumber + 1, left, Direction.WEST);
                new Wall(wallville, streetNumber + 1, left, Direction.SOUTH);
                int spotNum = left + 1;
                int counter = 0;
                while (counter < height)
                {
                    new Wall(wallville, streetNumber + 1, spotNum, Direction.NORTH);
                    new Wall(wallville, streetNumber + 1, spotNum, Direction.SOUTH);
                    // Uncomment the next line for a 'final state' picture (i.e., the second picture
                    // in the assignment)
                    // new Thing(wallville, streetNumber + 1, spotNum);
                    ++spotNum;
                    ++counter;
                }
                new Wall(wallville, streetNumber + 1, spotNum, Direction.WEST);
            }

            // the most western, vertical line:
            new Wall(wallville, streetNumber, left, Direction.WEST);
            // the most eastern, vertical line:
            new Wall(wallville, streetNumber, width, Direction.EAST);
            // the Thing at the end of the tunnel
            new Thing(wallville, streetNumber, width);

            int aveNum = left + 1;
            while (aveNum <= width)
            {
                new Wall(wallville, streetNumber, aveNum, Direction.NORTH);
                new Wall(wallville, streetNumber, aveNum, Direction.SOUTH);
                ++aveNum;
            }

            ++streetNumber;
        }
    }
}
