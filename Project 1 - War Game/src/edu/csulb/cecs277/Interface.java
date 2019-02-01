package edu.csulb.cecs277;

import java.util.Scanner;
import java.util.Arrays; 
import java.util.InputMismatchException;

public class Interface {
	Scanner s;
	//constructor for the interface, just makes a scanner 
	public Interface() 
	{ 
		s = new Scanner(System.in);
	}
	
	//Allows for user string input. Also checks the user input against 
	//an array of acceptable inputs, and returns an error message 
	//if the input is not one of the desired inputs 
	public String stringInUpper(String[] a) 
	{ 
		String response = s.next(); 
		while (!Arrays.asList(a).contains(response.toUpperCase())) 
			{ 
				System.out.println("That is not an acceptable input."); 
				System.out.print("Please input one of the following options: "); 
				
				for (int i = 0; i < a.length; i++) 
					{ 
						System.out.print(a[i]); 
					} 
				response = s.next(); 
			} 
		
		return response.toUpperCase(); 
	}
	

	/** next shorthand  
	 *  the following ins are shorthand for the methods they call. */ 
	public String input() { String response = s.next(); return response; }
	public String inputln() { String response = s.nextLine(); return response; }
	public char charIn() { char response = s.next().charAt(0); return response;} 
	//Allows for user integer input. If the input is not an integer 
	//returns an error message and requires the user input an integer 
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
	public int intIn(int lowerBound, int upperBound) 
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
	//System.out short hand 
	public void print(String output) { System.out.print(output); }
	public void println(String output) { System.out.println(output); }
	public void print(char output) { System.out.print(output); }
	public void println(char output) { System.out.println(output); }
	public void print(int output) { System.out.print(output); }
	public void println(int output) { System.out.println(output); }
}