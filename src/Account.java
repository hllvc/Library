import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {

	private String name;
	private String surname;
	private int number;
	private int bookLoanNumber;
	private ArrayList<Integer> numbers = new ArrayList<>();
	private ArrayList<Book> loanedBooks = new ArrayList<>();
	private LocalDateTime currentDateTime;
	private DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy, HH:mm");
	
	protected Account(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.bookLoanNumber = 0;
		this.generateRandomNumber();
		currentDateTime = LocalDateTime.now();
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
	
	public void addBook(Book book) {
		this.bookLoanNumber++;
		this.loanedBooks.add(book);
		book.setStatus(true);
	}
	
	public void removeBook(Book book) {
		this.bookLoanNumber++;
		this.loanedBooks.remove(book);
		book.setStatus(false);
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

	public void getLoanedBooks() {
		System.out.println("-LOANED BOOKS-\n");
		for (Book book: loanedBooks)
			System.out.println((loanedBooks.indexOf(book) + 1) + ") " + book.getName() + "\n");
	}
	
	public String getCurrentDateTime() {
		return currentDateTime.format(dateTimeFormat);
	}
	
}