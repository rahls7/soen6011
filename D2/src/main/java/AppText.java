import java.util.Scanner;

public class AppText {
	 /**
	  * Main function to launch CLI UI
	  * Note: Use this to calculate function with negative exponents
	  * @param args
	  */
	public static void main(String[] args) {
		Model model = new Model();
		Scanner input = new Scanner(System.in);;
		System.out.println("Enter the value of a: ");
		String a = input.next();
		System.out.println("Enter the value of b: ");
		String b = input.next();
		System.out.println("Enter the value of x: ");
		String x = input.next();
		double result =  Double.parseDouble(a) * model.calculateExponent(Double.parseDouble(b), Double.parseDouble(x));
		
		System.out.println("Your result is : " + Double.toString(result));
	}
}
