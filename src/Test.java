import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	private static Account account;
	private static Book book;
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Account> allAccounts = new ArrayList<>();
	private static ArrayList<Book> allBooks = new ArrayList<>();
	private static File file;
	
	private static void createAccount() {
		Text.createAccount();
		Text.nameInput();
		String name = input.nextLine();
		Text.surnameInput();
		String surname = input.nextLine();
		account = new Account(name, surname);
		allAccounts.add(account);
		Text.accountInfo(account);
	}
	
	private static void addNewBook() {
		Text.addBook();
		Text.bookNameInput();
		String name = input.nextLine();
		book = new Book(name);
		allBooks.add(book);
		Text.bookInfo(book);
	}
	
	public static boolean checkNumberLenght(int number) {
		if (Integer.toString(number).length() != 4)
			return true;
		return false;
	}
	
	public static boolean checkForBooks() {
		if (allBooks.isEmpty())
			return true;
		return false;
	}
	
	public static boolean checkForAccounts() {
		if (allAccounts.isEmpty())
			return true;
		return false;
	}
	
	public static boolean checkForLoaned() {
		boolean loaned = true;
		for (Book book: allBooks)
			if (!book.isStatus())
				loaned = false;
		return loaned;
	}
	
	public static boolean checkBookStatus(Book book) {
		if (book.isStatus())
			return true;
		return false;
	}
	
	public static boolean checkLoanedNumber(Account account) {
		if (account.getBookLoanNumber() < 3)
			return false;
		return true;
	}
	
	private static void findAccountByNumber() {
		int accNumber;
		try {
			do {
				Text.accNumberInput();
				accNumber = input.nextInt();
				if (checkNumberLenght(accNumber)) {
					Text.numberLenght();
					continue;
				}
				account = null;
				for (Account x: allAccounts)
					if (x.getNumber() == accNumber) {
						account = x;
						break;
					}
				if (account == null)
					Text.noAccount();
			} while (checkNumberLenght(accNumber) || account == null);
		} catch (Exception e) {
			System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
			input.nextLine();
			findAccountByNumber();
		}
	}
	
	private static void loanBook() {
		if (checkForBooks() || checkForAccounts() || checkForLoaned()) {
			if (checkForAccounts())
				Text.noAccounts();
			else if (checkForBooks())
				Text.noBooks();
			else if (checkForLoaned())
				Text.allLoaned();
			return;
		}
		Text.loanBook();
		findAccountByNumber();
		if (checkLoanedNumber(account)) {
			Text.limit();
			return;
		}
		byte choice = 0;
		ArrayList<Book> notLoanedBooks = new ArrayList<>();
		do {
			try {
				for (Book book : allBooks) {
					if (!book.isStatus())
						notLoanedBooks.add(book);
				}
				Text.notLoanedBooks(notLoanedBooks);
				choice = input.nextByte();
				if (choice < 1 || choice > notLoanedBooks.size())
					Text.notList();
				} catch (Exception e) {
				System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
				input.nextLine();
				}
		} while (choice < 1 || choice > notLoanedBooks.size());
		account.addBook(notLoanedBooks.get(--choice));
		Text.bookLoaned(book);
	}
	
	private static void returnBook() {
		if (checkForBooks() || checkForAccounts()) {
			if (checkForAccounts())
				Text.noAccounts();
			else if (checkForBooks())
				Text.noBooks();
			return;
		}
		Text.returnBook();
		findAccountByNumber();
		if (account.checkLoanedBooks()) {
			Text.noLoanedBooks();
			return;
		}
		byte choice = 0;
		do {
			try {
				account.getLoanedBooks();
				System.out.print("Your Choice: ");
				choice = input.nextByte();
				if (choice < 1 || choice > account.getLoanedBookSize())
					Text.notList();
				} catch (Exception e) {
				System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
				input.nextLine();
				}
		} while (choice < 1 || choice > account.getLoanedBookSize());
		account.returnBook(choice);
		Text.returnedBook();
	}
	
	private static void allAccInfo() {
		if (checkForAccounts()) {
			Text.noAccounts();
			return;
		}
		Text.allAccounts();
		for (Account x: allAccounts) {
			Text.accountInfo(x);
			x.getLoanedBooks();
		}
	}
	
	private static void mainMenu() {
		byte choice;
		try {
			do {
				Text.mainMenu();
					choice = input.nextByte();
				input.nextLine();
				switch (choice) {
				case 1:
					createAccount();
					break;
				case 2:
					addNewBook();
					break;
				case 3:
					loanBook();
					break;
				case 4:
					returnBook();
					break;
				case 5:
					allAccInfo();
					break;
				default:
					if (choice != 0)
						Text.noOptions();
				}
			} while (choice != 0);
		} catch (Exception e) {
			System.out.println("\n**NUMBER INPUT IS REQUIRED!**");
			input.nextLine();
			mainMenu();
		}
	}
	
	private static void readFiles() {
		try {
			file = new File(".libraryData/.Books");
			Scanner readFile = new Scanner(file);
			try {
				while (readFile.hasNextLine() && readFile.hasNext()) {
					book = new Book(readFile.nextLine());
					book.setNumber(readFile.nextInt());
					readFile.nextLine();
					book.setLoanDate(readFile.nextLine());
					book.setReturnDate(readFile.nextLine());
					book.setStatus(readFile.nextBoolean());
					readFile.nextLine();
					readFile.nextLine();
					allBooks.add(book);
				}
			} catch (Exception e) {
				System.out.println("\n**Error While Loading Books Data!");
			}
			readFile.close();
			file = new File(".libraryData/.Accounts");
			readFile = new Scanner(file);
			try {
				while (readFile.hasNextLine() && readFile.hasNext()) {
					account = new Account(readFile.nextLine(), readFile.nextLine());
					account.setNumber(readFile.nextInt());
					readFile.nextLine();
					account.setDateCreated(readFile.nextLine());
					readFile.nextLine();
					allAccounts.add(account);
				}
			} catch (Exception e) {
				System.out.println("\n**Error While Loading Accounts Data!");
			}
			readFile.close();
			for (Account account : allAccounts) {
				file = new File(".libraryData/.accountsLoanList/" + account.getNumber());
				readFile = new Scanner(file);
				int bookNumber;
				try {
					while (readFile.hasNextLine() && readFile.hasNext()) {
						bookNumber = readFile.nextInt();
						for (Book book : allBooks)
							if (bookNumber == book.getNumber())
								account.addBook(book);
					}
				} catch (Exception e) {
					System.out.println("\n**Error While Loading Accounts Loan List Data!");
				}
				readFile.close();
			}
		} catch (Exception e) {
			System.out.println("\n**Hello!\n**Welcome To Your Digital Library\n**Enjoy!\n");
		}
	}
	
	private static void writeFiles() {
		try {
			PrintWriter output = new PrintWriter(".libraryData/.Books");
			try {
				for (Book book : allBooks) {
					output.println(book.getName());
					output.println(book.getNumber());
					output.println(book.getLoanDate());
					output.println(book.getReturnDate());
					output.println(book.isStatus());
					output.println();
				}
			} catch (Exception e) {
				System.out.println("\n**Can Not Store Your Accounts Data.\n**ALL DATA WILL BE LOST!");
			}
			output.close();
			output = new PrintWriter(".libraryData/.Accounts");
			PrintWriter loanOutput;
			try {
				for (Account acc : allAccounts) {
					output.println(acc.getName());
					output.println(acc.getSurname());
					output.println(acc.getNumber());
					output.println(acc.getDateCreated());
					output.println();
					loanOutput = new PrintWriter(".libraryData/.accountsLoanList/" + acc.getNumber());
					allBooks = acc.getBooks();
					try {
						for (Book book : allBooks)
							loanOutput.println(book.getNumber());
					} catch (Exception e) {
						System.out.println("\n**No Such File!");
					}
					loanOutput.close();
				}
			} catch (Exception e) {
				System.out.println("\n**Can Not Store Your Accounts Data.\n**ALL DATA WILL BE LOST!");
			}
			output.close();
		} catch (Exception e) {
			System.out.println("\n**File Not Found!");
		}
	}
	
	private static void createDir() {
		file = new File(".libraryData/.accountsLoanList");
		if (!file.exists()) {
			file.mkdirs();
			System.out.println("\n**Created Directories For Data Storage!!");
		}
	}
	
	public static void main(String[] args) {
		
		createDir();
		readFiles();
		
		mainMenu();
		input.close();
		Text.exit();
		
		writeFiles();
		
	}
	
}
