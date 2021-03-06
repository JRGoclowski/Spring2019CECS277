package edu.csulb.cecs277;

import java.util.Scanner;
import java.util.Arrays; 
import java.util.InputMismatchException;

public class IOshortcut {
	Scanner s;
	//constructor for the IOshortcut, just makes a scanner 
	public IOshortcut() 
	{ 
		s = new Scanner(System.in);
	}
	
	/**
	 * Allows for user string input. Also checks the user input against an 
	 * array of acceptable inputs, and returns an error 
	 * message if the input is not one of the desired inputs 
	 * @param a - list of acceptable inputs
	 * @return String -the verified input
	 */
	public String stringInUpper(String[] a) 
	{ 
		String response = s.next(); 
		while (!Arrays.asList(a).contains(response.toUpperCase())) 
			{ 
				System.out.println("That is not an acceptable input."); 
				System.out.print("Please input one of the following options: "); 
				
				for (int i = 0; i < a.length - 1; i++) 
					{ 
						System.out.print(a[i] + ", "); 
					} 
				System.out.println(a[a.length]);
				response = s.next(); 
			} 
		
		return response.toUpperCase(); 
	}
	
	/**
	 * A simple method to return a boolean for yes or no questions
	 * @return boolean - true for yes
	 */
	public boolean YesOrNo() 
	{ 
		String[] a = {"Y","N"};
		String response = s.next(); 
		while (!Arrays.asList(a).contains(response.toUpperCase())) 
			{ 
				System.out.println("That is not an acceptable input."); 
				System.out.print("Please input one of the following options: "); 
				
				for (int i = 0; i < a.length; i++) 
					{ 
						System.out.print(a[i] + ", "); 
					} 
				response = s.next(); 
			} 
		if (response.toUpperCase().equals("Y"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * scanner.next shorthand 
	 * @return - the input string of .next
	 */
	public String input() { String response = s.next(); return response; }
	
	/**
	 * scanner.nextline shorthand
	 * @return String - the line input
	 */
	public String inputln() { String response = s.nextLine(); return response; }
	
	/**
	 * Gets the first charater of a string input
	 * @return char - the first character input
	 */
	public char charIn() { char response = s.next().charAt(0); return response;}
	
	/**
	 * .nextInt shorthand
	 * @return int - the integer collected
	 */
	public int intIn()
 
	{ 
		while(true) 
			{ 
				try 
					{  return s.nextInt(); } 
				catch(InputMismatchException exception) 
					{  
						s.next();  
						println("This is not an integer");  
						print("Please input an integer : "); 
					}
			}
	}
	
	/**
	 * .nextInt shorthand with input verification
	 * @param lowerBound - the lowest acceptable integer input
	 * @param upperBound - the highest acceptable integer input
	 * @return int - the verified integer input
	 */
	public int intIn/*Inc*/(int lowerBound, int upperBound) 
	{ 
		while(true) 
			{
				try 
					{ 
						int value = s.nextInt(); 
						while (value < lowerBound || value > upperBound) 
							{ 
								println("That is not within bounds."); 
								print("Please enter a integer within bounds. ("); 
								print(lowerBound); 
								print(" - "); 
								print(upperBound); 
								print(") : "); 
								value = s.nextInt(); 
							} 
						return value; 
					} 
				catch(InputMismatchException exception) 
					{  
						s.next();  
						println("This is not an integer");  
						print("Please input an integer : "); 
					}
			}
	}
	
	 /**
	 * .nextInt shorthand with input verification
	 * @param lowerBound - the lowest acceptable integer input
	 * @param upperBound - the highest acceptable integer input
	 * @return int - the verified integer input
	 */
	public int intInEx(int lowerBound, int upperBound) 
	{ 
		while(true) 
			{
				try 
					{ 
						int value = s.nextInt(); 
						while (value <= lowerBound || value >= upperBound) 
							{ 
								println("That is not within bounds."); 
								print("Please enter a integer within bounds. ("); 
								print(lowerBound); 
								print(" - "); 
								print(upperBound); 
								print(") : "); 
								value = s.nextInt(); 
							} 
						return value; 
					} 
				catch(InputMismatchException exception) 
					{  
						s.next();  
						println("This is not an integer");  
						print("Please input an integer : "); 
					}
			}
	}
	
	/**
	 * .nextDouble shorthand with input verification
	 * @return
	 */
	public double doubleIn()
	 
	{ 
		while(true) 
			{ 
				try 
					{  return s.nextDouble(); } 
				catch(InputMismatchException exception) 
					{  
						s.next();  
						println("This is not a double");  
						print("Please input a double : "); 
					}
			}
	}
	
	/**
	 * .nextDouble shorthand with input verification, with exclusive bounds
	 * @return
	 */
	public double doubleInEx(double lowerBound, double upperBound) 
	{ 
		while(true) 
			{
				try 
					{ 
						double value = s.nextDouble(); 
						while (value <= lowerBound || value >= upperBound) 
							{ 
								println("That is not within bounds."); 
								print("Please enter a double within bounds. ("); 
								print(lowerBound); 
								print(" - "); 
								print(upperBound); 
								print(") : "); 
								value = s.nextDouble(); 
							} 
						return value; 
					} 
				catch(InputMismatchException exception) 
					{  
						s.next();  
						println("This is not a double");  
						print("Please input a double : "); 
					}
			}
	}
	
	/**
	 * .nextDouble shorthand with input verification, with inclusive bounds
	 * @return
	 */
	public double doubleInInc(double lowerBound, double upperBound) 
	{ 
		while(true) 
			{
				try 
					{ 
						double value = s.nextDouble(); 
						while (value < lowerBound || value > upperBound) 
							{ 
								println("That is not within bounds."); 
								print("Please enter a double within bounds. ("); 
								print(lowerBound); 
								print(" - "); 
								print(upperBound); 
								print(") : "); 
								value = s.nextDouble(); 
							} 
						return value; 
					} 
				catch(InputMismatchException exception) 
					{  
						s.next();  
						println("This is not an double");  
						print("Please input an double : "); 
					}
			}
	}
	
	/**
	 * .nextDouble shorthand with input verification, with an exclusive lower bound
	 * @return
	 */
	public double doubleInLowEx(double lowerBound) 
	{ 
		while(true) 
			{
				try 
					{ 
						double value = s.nextDouble(); 
						while (value <= lowerBound) 
							{ 
								println("That is not within bounds."); 
								print("Please enter a double within bounds. (>"); 
								print(lowerBound);  
								print(") : "); 
								value = s.nextDouble(); 
							} 
						return value; 
					} 
				catch(InputMismatchException exception) 
					{  
						s.next();  
						println("This is not a double");  
						print("Please input a double : "); 
					}
			}
	}
	
	/**
	 * .nextDouble shorthand with input verification, with an inclusive lower bound
	 * @return
	 */
	public double doubleInLowInc(double lowerBound) 
	{ 
		while(true) 
			{
				try 
					{ 
						double value = s.nextDouble(); 
						while (value < lowerBound) 
							{ 
								println("That is not within bounds."); 
								print("Please enter a double within bounds. (>="); 
								print(lowerBound);  
								print(") : "); 
								value = s.nextDouble(); 
							} 
						return value; 
					} 
				catch(InputMismatchException exception) 
					{  
						s.next();  
						println("This is not an double");  
						print("Please input an double : "); 
					}
			}
	}
	
	/**
	 * .nextDouble shorthand with input verification, with an exclusive upperBound
	 * @return
	 */
	public double doubleInUpEx(double upperBound) 
	{ 
		while(true) 
			{
				try 
					{ 
						double value = s.nextDouble(); 
						while (value >= upperBound) 
							{ 
								println("That is not within bounds."); 
								print("Please enter a double within bounds. (<="); 
								print(upperBound); 
								print(") : "); 
								value = s.nextDouble(); 
							} 
						return value; 
					} 
				catch(InputMismatchException exception) 
					{  
						s.next();  
						println("This is not a double");  
						print("Please input a double : "); 
					}
			}
	}
	
	/**
	 * .nextDouble shorthand with input verification. with an inclusive upperBound
	 * @return
	 */
	public double doubleInUpInc(double upperBound) 
	{ 
		while(true) 
			{
				try 
					{ 
						double value = s.nextDouble(); 
						while (value > upperBound) 
							{ 
								println("That is not within bounds."); 
								print("Please enter a double within bounds. (<="); 
								print(upperBound); 
								print(") : "); 
								value = s.nextDouble(); 
							} 
						return value; 
					} 
				catch(InputMismatchException exception) 
					{  
						s.next();  
						println("This is not an double");  
						print("Please input an double : "); 
					}
			}
	}
	
	
	
	/**
	 * System.out.print short hand 
	 * @param output
	 */
	public void print(String output) { System.out.print(output); }

	
	/**
	 * System.out.println short hand
	 * @param output - The string to be printed
	 */
	public void println(String output) { System.out.println(output); }
	
	/**
	 * Prints a single character
	 * @param output - The desired character to print
	 */
	public void print(char output) { System.out.print(output); }
	
	/**
	 * Prints a single character then starts a new line
	 * @param output - the desired character to print
	 */
	public void println(char output) { System.out.println(output); }
	
	/**
	 * prints an integer
	 * @param output - the desired integer to print
	 */
	public void print(int output) { System.out.print(output); }
	
	/**
	 * prints an integer then starts a new line
	 * @param output - the desired integer to print
	 */
	public void println(int output) { System.out.println(output); }
	
	/**
	 * prints a double
	 * @param output - the double to be printed
	 */
	public void print(double output) { System.out.print(output); }
}
