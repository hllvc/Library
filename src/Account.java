import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

public class Account {

	private String name;
	private String surname;
	private int number;
	private int bookLoanNumber;
	private String dateCreated;
	private ArrayList<Integer> numbers = new ArrayList<>();
	private ArrayList<Book> loanedBooks = new ArrayList<>();
	private Calendar currentDateTime;
	private DateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy, HH:mm");
	
	protected Account(String name, String surname) {
		this.name = name;
		this.surname = surname;
		this.bookLoanNumber = 0;
		this.generateRandomNumber();
		this.dateCreated = this.getCurrentDateTime();
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
		this.bookLoanNumber--;
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
	
	public void setBookLoanNumber(int bookLoanNumber) {
		this.bookLoanNumber = bookLoanNumber;
		this.numbers.add(this.number);
	}

	public int getNumber() {
		return this.number;
	}
	
	public void setNumber(int number) {
		this.number = number;
		this.numbers.add(this.number);
	}

	public void getLoanedBooks() {
		System.out.println("-LOANED BOOKS-\n");
		if (loanedBooks.isEmpty()) {
			System.out.println("Empty");
			return;
		}
		for (Book book: this.loanedBooks)
			System.out.println((this.loanedBooks.indexOf(book) + 1) + ") \"" + book.getName() + "\"\n"
					+ " -Return Date: " + book.getReturnDate() + "\n");
	}
	
	private String getCurrentDateTime() {
		this.currentDateTime = Calendar.getInstance();
		return myFormat.format(currentDateTime.getTime());
	}
	
	public boolean checkLoanedBooks() {
		if (loanedBooks.isEmpty())
			return false;
		return true;
	}
	
	public String getDateCreated() {
		return this.dateCreated;
	}
	
	public void setDateCreated(String date) {
		this.dateCreated = date;
	}
	
}