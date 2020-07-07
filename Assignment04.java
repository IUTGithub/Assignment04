//=============================================== 
// AUTHOR: Ian Utnehmer  
// COURSE: CS 112 Intro to CS II - Java  
// SECTION: 6/28
// ASSIGNMENT: Assignment #04
//=============================================== 

//===============================================  
// Date parsing program.
// Prompt the user to enter a date. If the date
// doesn't fit the set format of MM/DD/YYYY, then
// as, them to enter a different date, formatted
// properly. If the month is entered incorrectly
// less than 1 or greater than 12 ), ask them to
// enter a new month. Do this with month and year,
// with their own respective constraints.
//==============================================

//=============================================== 
// IMPORTS 
//=============================================== 

import java.util.Scanner;

public class Assignment04 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Date newDate;
		
		System.out.printf("Please enter date to parse (MM/DD/YYYY format):\n");
		String date = keyboard.nextLine();
		newDate = new Date(date);
		boolean failedFormatCheck = true;
		// Checks if the format is correct. If not, asks to reenter a new date

		failedFormatCheck = newDate.checkDateFormat();
		
		while(failedFormatCheck) {
			if (failedFormatCheck) {
				date = keyboard.nextLine();
				newDate = new Date(date);
			}
			failedFormatCheck = newDate.checkDateFormat();
		}
		// Checks if the month is correct. If not, asks to reenter a new month.
		failedFormatCheck = newDate.checkMonth(newDate.getMonth()); 
		// While the format check for month is true...
		while(failedFormatCheck) {
			if (failedFormatCheck) {
				try {
				newDate.setMonth(Integer.valueOf(keyboard.nextLine()));
				} catch (NumberFormatException e) {
					// Catch so the program doesn't close due to numberFormatException.
					// Lets the user know that they must only enter integers for the month.
					System.out.printf("\nPlease enter only integers for month.\n");
				}
			}
			// Check if the date is correct.
			failedFormatCheck = newDate.checkMonth(newDate.getMonth());
		}
		// Checks if day is correct, does the same process as we did for checking month
		failedFormatCheck = newDate.checkDays();
		
		while(failedFormatCheck) {
			if (failedFormatCheck) {
				try {
					int newDay = Integer.parseInt(keyboard.nextLine());
					newDate.setDay(Integer.valueOf(newDay));
				} catch (NumberFormatException e) {
					System.out.printf("\nPlease enter only integers for day.\n");
				}
			}
			failedFormatCheck = newDate.checkDays();
		}
		// Same here. Checks if year is within bounds.
		failedFormatCheck = newDate.checkYear();
		
		while(failedFormatCheck) {
			if (failedFormatCheck) {
				try {
					int newYear = Integer.parseInt(keyboard.nextLine());
					newDate.setYear(Integer.valueOf(newYear));
				} catch (NumberFormatException e) {
					System.out.printf("\nPlease enter only integers for year.\n");
				}
			}
			failedFormatCheck = newDate.checkYear();
		}
		// Once all checks are passed, it prints the parsed date.
		System.out.printf("%s", newDate.toString());

		// Converts dates from numerical MM/DD/YYYY format to "month day, year" format 
		// (e.g., 12/25/2020 corresponds to December 25, 2020).
		
	}
}
