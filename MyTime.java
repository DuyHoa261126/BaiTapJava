package Lab3;

public class MyTime {
	private int hour;
	private int minute;
	private int second;

	public MyTime(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public void setTime(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getSecond() {
		return second;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (second == 60) {
			second = 0;
			minute++;
			if (minute == 60) {
				minute = 0;
				hour++;
				if (hour == 24) {
					hour = 0;
				}
			}
		}
		sb.append(String.format("%02d:%02d:%02d", hour, minute, second));
		return sb.toString();
	}

	public MyTime nextSecond() {
		second++;
		if (second == 60) {
			second = 0;
			minute++;
		}
		return this;
	}

	public MyTime nextMinute() {
		minute++;
		if (minute == 60) {
			second = 0;
			hour++;
		}
		return this;
	}

	public MyTime nextHour() {
		hour++;
		if (hour == 24) {
			hour = 0;
		}
		return this;
	}

	public MyTime previousSecond() {
		second--;
		if (second < 0) {
			second = 59;
			minute--;
		}
		return this;
	}

	public MyTime previousMinute() {
		minute--;
		if (minute < 0) {
			minute = 59;
			hour--;
		}
		return this;
	}

	public MyTime previousHour() {
		hour--;
		if (hour < 0) {
			hour = 23;
		}
		return this;
	}

}