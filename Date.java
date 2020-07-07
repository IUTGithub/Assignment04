// TODO: ADD STYLESHEET HERE!!!! IMPORTANTE!!!
public class Date {
	private String dateString;
	private static int[] partsOfDate;
	int maxDays;
	private String strMonth;
	public Date (String date) {
		this.dateString = date;
		partsOfDate = new int[3];
	}
	
	public int getMonth() {
		return Integer.valueOf(this.partsOfDate[0]);
	}
	
	public void setMonth(int newMonth) {
		this.partsOfDate[0] = newMonth;
	}
	
	public String getMonthString() {
		return this.strMonth;
	}
	
	public int getYear() {
		return this.partsOfDate[2];
	}
	
	public void setYear(int newYear) {
		partsOfDate[2] = newYear;
	}
	
	public int getDay() {
		return partsOfDate[1];
	}
	
	public void setDay(int newDay) {
		partsOfDate[1] = newDay;
	}
	
	public boolean checkDateFormat() {
		// Count is equal to the amount of integers that have been successfully caught
		int count = 0;
		for (String stringInteger: dateString.split("/")) {
			try {
				if (count > 2) {
					throw new FormatException();
				}
				try {
					partsOfDate[count] = Integer.valueOf(Integer.parseInt(stringInteger));
				} catch (NumberFormatException e) {
					System.out.printf("\nPlease enter only integers for month, date, and year. (MM/DD/YYYY)\n");
					return true;
				}
				// Once the checks are complete and passed, we have successfully
				// created a new date, formatted correctly.
				count++;
			} catch (FormatException e) {
				// Format exception if there's more than 4 forwardslashes,
				// as well as if ONLY slashes are submitted.
				System.out.printf("%s\n", e.getMessage());
				return true;
			}
		}
		
		try {
			if (count < 3) {
				// Also throws exception if it was unable to capture
				// at least 3 items.
				throw new FormatException();
			}
			if (count == 3) {
				// If 3 items are captured, then return false. (Passed check)
				return false;
			}
		} catch (FormatException f) {
			System.out.printf("\n%s\n", f.getMessage());
		}
		
	return true;
	}
	
	
	public boolean checkMonth(int month) {
		try {
			// Takes in the user's month and compares it to the constraints.
			if (this.getMonth() < 1 || this.getMonth() > 12) {
				throw new MonthException();
			} else {
				this.setMonth(month);
				return false;
			}
		} catch (MonthException e) {
			System.out.printf("\n%s\n", e.getMessage());
			return true;
		}
	}
	
	public boolean checkYear() {
		try {
			// Same process for month, but with year.
			if (this.getYear() < 1000 || this.getYear() > 3000) {
				throw new YearException();
			} 
		} catch (YearException e) {
			System.out.println(e.getMessage());
			return true;
		}
		return false;
	}
	
	boolean leapYear(int year) {

	    return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

	}
	
	public boolean checkDays() {
		int month = this.getMonth();
		switch(month) {
		case 1:
			strMonth = "January";
			maxDays = 31;
			break;
		case 2:
			strMonth = "February"; // Checks for leapyear
			if (this.leapYear(this.getYear())) {
				maxDays = 29;
				break;
			} else {
				maxDays = 28;
				break;
			}
		case 3:
			strMonth = "March";
			maxDays = 31;
			break;
		case 4:
			strMonth = "April";
			maxDays = 30;
			break;
		case 5:
			strMonth = "May";
			maxDays = 31;
			break;
		case 6:
			strMonth = "June";
			maxDays = 30;
			break;
		case 7:
			strMonth = "July";
			maxDays = 31;
			break;
		case 8:
			strMonth = "August";
			maxDays = 31;
			break;
		case 9:
			strMonth = "September";
			maxDays = 30;
			break;
		case 10:
			strMonth = "October";
			maxDays = 31;
			break;
		case 11:
			strMonth = "November";
			maxDays = 30;
			break;
		case 12:
			strMonth = "December";
			maxDays = 31;
			break;
		default:
			strMonth = "Error: No month detected";
			maxDays = 30;
		}
		try {
			// Day check
			if (Integer.valueOf(this.getDay()) > maxDays || Integer.valueOf(this.getDay()) < 1) {
				throw new DayException();
			}
		} catch(DayException e) {
			System.out.printf("\n%s\n", e.getMessage());
			return true;
		}
		return false;
	}

	
	public String toString() {
		return String.format("Parsed date: %s %d, %d", this.strMonth, this.getDay(), this.getYear());
	}
}