
/**
 * @author Neha
 *
 */
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerValues {

	private static Scanner sc = new Scanner(System.in);
	private static String choice="y";
	private static HashMap<Integer,String> integerValues = new HashMap<Integer,String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int num =0;
		
		integerValues.put(1, "one");
		integerValues.put(2, "two");
		integerValues.put(3, "three");
		integerValues.put(4, "four");
		integerValues.put(5, "five");
		integerValues.put(6, "six");
		integerValues.put(7, "seven");
		integerValues.put(8, "eight");

		
		while (choice.equalsIgnoreCase("y")){
			
			try{
				System.out.print("Enter a number:\t");
				num = sc.nextInt();					
			} catch (InputMismatchException e) {
				System.out.println("Incorrect data type for inputs.");
				sc.nextLine();
				continue;
			}
			if (integerValues.containsKey(num))			
					System.out.println("Response: You entered " + integerValues.get(num));
			else {
				System.out.println("The key does not exist in the record");
				newKey(num);
				System.out.println("Response: You entered " + integerValues.get(num));
			}
			
			System.out.print("would you like to try again? Y/N:");
			choice = sc.next();
			
			if(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")){
				System.out.println("Incorrect input. Ending the Program");
			}
		}
		System.out.println("Good Bye!!");
	}
	
	
	/**
	 * Method to enter the new key in the HashMap
	 * @param num
	 */
	public static void newKey(int num)
	{
		String userChoice="";
		System.out.println("Do you want to add the key in the database? (Y/N)");
		userChoice = sc.next();
		sc.nextLine();
		
		if(!userChoice.equalsIgnoreCase("y") && !userChoice.equalsIgnoreCase("n")){
			System.out.println("Incorrect input. Ending the Program");
		} else if (userChoice.equalsIgnoreCase("y")){
			System.out.println("Enter the value for the key: ");
			integerValues.put(num, sc.next());
		}
	}

}
