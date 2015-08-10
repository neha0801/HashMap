/**
 * @author Neha
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
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
		
		int num;

		String filePath = "C:/Users/rvhu321018ur/Desktop/GIT Files/Hashmap Application/Hashmap/myIntegers.txt";
		int key;
		String value="";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));

			String line;
			while((line=reader.readLine())!=null){
				key = Integer.parseInt(line.split("\\s")[1]);
				line = reader.readLine();
				value = line.split("\\s")[1];
				integerValues.put(key, value);
			}
			reader.close();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		
		String fileName = (System.getProperty("user.dir") + File.separatorChar +"myIntegers.txt");
		PrintWriter writer;
		
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
		try{
			writer = new PrintWriter(fileName);
			for(Integer k : integerValues.keySet()){
				writer.println("Key " + k +"\nValue " + integerValues.get(k));
		      }
			 writer.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
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
			sc.nextLine();
		}
	}

}
