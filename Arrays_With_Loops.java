import java.util.Scanner;

public class Arrays_With_Loops extends Object
{
   public static void main(String[] args)
   {
      // First: Create an array
      double[] myAr;
      myAr = new double[5];

      // Second: Use a while loop to set the array elements' values
      int i = 0;
      Scanner input = new Scanner(System.in);
      while (i < 5)
      {
         System.out.println("Enter a grade:");
         myAr[i] = input.nextDouble();
         i++;

      }
      double total = 0;
      // Third: Use a for loop to print out the array
      for (int j = 0; j < 5; j++)
      {
         System.out.println(myAr[j]);
      }

      for (int j = 0; j < 5; j++)
      {
         total = total + myAr[j];
      }
      System.out.println("The average grade is: " + total / 5);
      System.out.println("Enter wanted grade: ");
      double wantedGrade = 0;
      wantedGrade = input.nextDouble();
      for (int j = 0; j < 5; j++)
      {
         if (wantedGrade == myAr[j])
         {
            System.out.println("Your grade was found at index: " + j);
         }
      }

      input.close();
   }
}