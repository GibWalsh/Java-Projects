import java.util.Scanner;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.util.Random;
/**
* Takes the time in seconds and shows other units of time.
*
* @author Gibson Lee Walsh
* @version 9/5/2018
*/
public class FootballTicket {

    /**
    * Prints the different units of time.
    *
    * @param args Command line arguments (not used)
    */
   public static void main(String[] args) {
     
      // Variable
      Scanner userInput = new Scanner(System.in);
      String ticketNumber = "";
      String game = "";
      String date = "";
      String time = "";
      String section = "";
      String row = "";
      String seat = "";
      Double price = 0.0;
      String category = "";
      double cost = 0.0;
      Random generator = new Random();
      int prizeNumber = generator.nextInt(9999999);
      DecimalFormat df = new DecimalFormat("###.##");
     
      // User input
      System.out.print("Enter your ticket code: ");
      ticketNumber = userInput.nextLine().trim();
     
      if (ticketNumber.length() < 24) {
         System.out.print("\nInvalid Ticket Code."
            + "\nTicket code must have at least 25 characters.");
      }
      else {
         // Variable are taken from the user input   
         price = Double.parseDouble(ticketNumber.substring(1, 6));
         game = ticketNumber.substring(24);
         date = ticketNumber.substring(10, 18);
         time = ticketNumber.substring(6, 10);
         section = ticketNumber.substring(22, 24);
         row = ticketNumber.substring(20, 22);
         seat = ticketNumber.substring(18, 20);
         category = ticketNumber.substring(0, 1);     
     
         // Cost is calculated
         price = price / 100;
         if (category.equals("s")) {
            cost = price * (.33);
         }
         else if (category.equals("f")) {
            cost = price * (.8);
         }
         else { cost = price; }
     
         // Strings and Doubles are Formatted
         NumberFormat currencyFmt = NumberFormat.getCurrencyInstance();
         DecimalFormat dollarFmt = new DecimalFormat("$###.00");
         time = time.substring(0, 2) + ":" + time.substring(2, 4);
         date = date.substring(0, 2) + "/" + date.substring(2, 4) + "/"
            + date.substring(4, 8);
         DecimalFormat prizeFmt = new DecimalFormat("#######");
         if (section.substring(0, 1).equals("0")) {
            section = section.substring(1); 
         }
          
         // Ticket is shown
         System.out.print("\nGame: " + game);
         System.out.print("   Date: " + date);
         System.out.print("   Time: " + time);
         System.out.print("\nSection: " + section);
         System.out.print("   Row: " + row);
         System.out.print("   Seat: " + seat);
         System.out.print("\nPrice: " + dollarFmt.format(price));
         System.out.print("   Category: " + category);
         System.out.print("   Cost: " + dollarFmt.format(cost));
         System.out.print("\nPrize Number: " + prizeNumber);
      }
   }

}