package Lab3;

public class MyDate {
	private int year;
	private int month;
	private int day;
	private String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
	private String[] DAYS = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	private int[] DAY_IN_MOTNTHS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 100 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isValidDate(int year, int month, int day) {
		if (year < 1 || year > 9999 || month < 1 || month > 12) {
			return false;
		}
		int maxDay = getDaysInMonth(year, month);
		return day >= 1 && day <= maxDay;

	}

	public int getDaysInMonth(int year, int month) {
		if (month == 2 && isLeapYear(year)) {
			return 29;
		}
		return DAY_IN_MOTNTHS[month - 1];
	}

	public int getDayOfWeek(int year, int month, int day) {
		int modunyear = year % 400;
		int firsttwodigit = 0;
		int nummonth = 0;
		if (modunyear >= 100 && modunyear < 200) {
			firsttwodigit = 4;
		} else if (modunyear >= 200 && modunyear < 300) {
			firsttwodigit = 2;
		} else if (modunyear >= 300) {
			firsttwodigit = 0;

		} else {
			firsttwodigit = 6;
		}
		int remaindigit = year % 100;
		if (!isLeapYear(year)) {
			if (month == 1) {
				nummonth = 0;
			} else if (month == 2) {
				nummonth = 3;

			} else if (month == 3) {
				nummonth = 3;

			} else if (month == 4) {
				nummonth = 6;

			} else if (month == 5) {
				nummonth = 1;

			} else if (month == 6) {
				nummonth = 4;
			} else if (month == 7) {
				nummonth = 6;
			} else if (month == 8) {
				nummonth = 2;

			} else if (month == 9) {
				nummonth = 5;
			} else if (month == 10) {
				nummonth = 0;
			} else if (month == 11) {
				nummonth = 3;

			} else {
				nummonth = 5;
			}
		} else {
			if (month == 1) {
				nummonth = 6;
			} else if (month == 2) {
				nummonth = 2;

			} else if (month == 3) {
				nummonth = 3;

			} else if (month == 4) {
				nummonth = 6;

			} else if (month == 5) {
				nummonth = 1;

			} else if (month == 6) {
				nummonth = 4;
			} else if (month == 7) {
				nummonth = 6;
			} else if (month == 8) {
				nummonth = 2;

			} else if (month == 9) {
				nummonth = 5;
			} else if (month == 10) {
				nummonth = 0;
			} else if (month == 11) {
				nummonth = 3;

			} else {
				nummonth = 5;
			}

		}
		return (int) ((firsttwodigit + remaindigit + Math.floor(remaindigit / 4) + nummonth + day) % 7);

	}

	public MyDate(int year, int month, int day) {
		setDate(year, month, day);
	}

	public void setDate(int year, int month, int day) {
		if (!isValidDate(year, month, day)) {
			throw new IllegalArgumentException("Invalid year, month, or day!");
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int year) {
		this.year = year;

	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {

		int l = getDayOfWeek(this.year, this.month, this.day);
		String days = "";
		for (int i = 0; i < 7; i++) {
			if (l == i) {
				days = DAYS[i];
			}
		}
		return days + " " + this.day + " " + this.month + " " + this.year;

	}

	private void normalizeDate() {
		if (!isLeapYear(this.year)) {
			for (int i = 0; i < 12; i++) {
				if (this.month == i + 1) {
					if (day > DAY_IN_MOTNTHS[i]) {
						day = 1;
						month++;
					} else if (day == 0) {
						if (i > 0) {
							day = DAY_IN_MOTNTHS[i - 1];
						} else {
							day = DAY_IN_MOTNTHS[11];
							month = 12;
							year--;
						}

					}
				}
			}
			if (month > 12) {
				month %= 12;
				year++;
			} else if (month == 0) {
				month = 12;
				year--;
			}
		} else {
			DAY_IN_MOTNTHS[1] = 29;
			for (int i = 0; i < 12; i++) {
				if (this.month == i + 1) {
					if (day > DAY_IN_MOTNTHS[i]) {
						day = 1;
						month++;
					} else if (day == 0) {
						if (i > 0) {
							day = DAY_IN_MOTNTHS[i - 1];
						} else {
							day = DAY_IN_MOTNTHS[11];
							month = 12;
							year--;
						}

					}
				}
			}
			if (month > 12) {
				month %= 12;
				year++;
			}
		}

	}

	public MyDate nextDay() {
		day++;
		normalizeDate();
		return this;
	}

	public MyDate nextMonth() {
		month++;
		normalizeDate();
		return this;
	}

	public MyDate nextYear() {
		year++;
		return this;
	}

	public MyDate previousDay() {
		day--;
		normalizeDate();
		return this;
	}

	public MyDate previousMonth() {
		for (int i = 0; i < 12; i++) {
			if (this.month == i + 1) {
				if (day > DAY_IN_MOTNTHS[i - 1]) {
					day = DAY_IN_MOTNTHS[i - 1];
				}
			}
		}
		month--;

		return this;
	}

	public MyDate previousYear() {
		if (isLeapYear(year) && this.month == 2) {
			if (day == 29) {
				day = 28;
			}
		}
		year--;

		return this;
	}

}