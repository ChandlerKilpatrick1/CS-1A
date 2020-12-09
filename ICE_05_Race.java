import becker.robots.*;

// STudents: Don't worry about these next import statements
import java.util.Random; // to generate random numbers

public class ICE_05_Race extends Object
{
   public static void main(String[] args)
   {
        City RaceCity = new City(4, 11);
        Random numberGenerator = new Random(); // don't worry about this line

        Thing baton = new Thing(RaceCity, 3, 0);

        // karel is the first racer (at the left)
		  // and always starts directly above the baton
        Robot karel = new Robot(RaceCity, 3, 0, Direction.EAST, 0);

        // bob is the second racer (in the middle)
        Robot bob = new Robot(RaceCity, 2, 2 + numberGenerator.nextInt(3), Direction.EAST, 0);
		  bob.setColor(java.awt.Color.blue);
        // mary is the third racer (at the right)
        Robot mary = new Robot(RaceCity, 3, 5 + numberGenerator.nextInt(3), Direction.EAST, 0);
		  mary.setColor(java.awt.Color.green);

        /* karel should pick up the baton, then move to the intersection that bob is in.
           karel should drop the baton, bob should pick it up, and bob should then move
           to the intersection that mary is in. bob should drop the baton, mary should
           pick it up, and mary should then move 2 intersections east, and drop the baton.  */

   }
}


