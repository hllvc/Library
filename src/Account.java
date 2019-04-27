import java.util.ArrayList;

public class Account {

	private String name;
	private String surname;
	private int number;
	private int bookLoanNumber;
	private ArrayList<Integer> numbers = new ArrayList<>();
	
	protected Account(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.bookLoanNumber = 0;
		this.generateRandomNumber();
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
	
	public void addBook(int numberOfBooks) {
		this.bookLoanNumber += numberOfBooks;
	}
	
	public void removeBook(int numberOfBooks) {
		this.bookLoanNumber -= numberOfBooks;
	}
	
	public boolean checkForNumber(int number) {
		boolean existing;
		do {
			existing = false;
			for (int x: this.numbers)
				if (x == number) {
					existing = true;
					break;
				}
		} while (existing);
		return existing;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public int getBookLoanNumber() {
		return this.bookLoanNumber;
	}

	public int getNumber() {
		return this.number;
	}
	
}
