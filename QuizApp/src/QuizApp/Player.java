package QuizApp;

import java.util.Scanner;

public class Player{
	String name;
	String city;
	
	void playerDetails(Scanner sc) {
		System.out.println("Enter your name:");
		name = sc.nextLine();
		System.out.println("Enter your hometown:");
		city = sc.nextLine();
	}	
}