import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Book {

	private String name;
	private int number;
	private boolean status;
	private ArrayList<Integer> numbers = new ArrayList<>();
	private LocalDateTime currentDateTime;
	private DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy, HH:mm");
	
	protected Book(String name) {
		this.name = name;
		this.generateRandomNumber();
		this.status = false;
		this.currentDateTime = LocalDateTime.now();
	}
	
	private void generateRandomNumber() {
		boolean existing;
		do {
			existing = false;
			this.number = (int)(Math.random() * 8999 + 1000);
			for (int x: this.numbers)
				if (x == this.number) {
					existing = true;
					break;
				}
		} while (existing);
		numbers.add(this.number);
	}

	public String getName() {
		return this.name;
	}

	public int getNumber() {
		return this.number;
	}

	public String getCurrentDateTime() {
		return currentDateTime.format(dateTimeFormat);
	}

	public boolean isStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
