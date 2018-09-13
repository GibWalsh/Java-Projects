import java.util.Scanner;
import java.text.DecimalFormat;
/**
* Takes the time in seconds and shows other units of time.
*
* @author Gibson Lee Walsh
* @version 9/5/2018
*/
public class FormulaEval {

   /**
   * Prints the different units of time.
   *
   * @param args Command line arguments (not used)
   */
   public static void main(String[] args) {
      
      Scanner systemInput = new Scanner(System.in);
      double x = 0.0;
      double firstResult = 0.0;
      double secondResult = 0.0;
      int leftCharacters = 0;
      int rightCharacters = 0;
      String stringResult = "";
      DecimalFormat y = new DecimalFormat("#,##0.0####");
      String formattedResult = "";
      
      System.out.print("Enter a value for x: ");
      x = systemInput.nextDouble(); 
      
      // Math part
      if (x < 0) {
         
         firstResult = 1000 * x + Math.sqrt(-1 * (3.9 * Math.pow(x, 5)
           - Math.pow(x, 3) + 1));
         secondResult = firstResult / (1.6 * Math.pow(x, 2) + 2.7 * x
             + 3.8);         
      }
      else { 
         firstResult = 1000 * x + Math.sqrt(3.9 * Math.pow(x, 5)
           - Math.pow(x, 3) + 1);
         secondResult = firstResult / (1.6 * Math.pow(x, 2) + 2.7 * x + 3.8);
      }
      // Decimal
      stringResult = Double.toString(secondResult);
      rightCharacters = stringResult.length() - 1 - stringResult.indexOf(".");
      leftCharacters = stringResult.length() - 1 - rightCharacters;
      formattedResult = y.format(secondResult);
      
      // Print statements
      System.out.println("Result: " + secondResult);
      System.out.println("# of characters to left of decimal poin"
         + "t: " + leftCharacters);
      System.out.println("# of characters to right of decimal poin"
         + "t: " + rightCharacters);
      System.out.println("Formatted Result: " + formattedResult);
   }

}