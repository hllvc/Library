import java.util.ArrayList;

public class Text {
	
	public static void mainMenu() {
		System.out.print("__________________\n\n"
				+ "---MAIN MENU---\n\n"
				+ "1) Create New Account\n"
				+ "2) Add New Book To Library\n"
				+ "3) Loan Book\n"
				+ "4) Return Book\n"
				+ "5) Accounts Details\n\n"
				+ "0) Exit\n\n"
				+ "Your Choice: ");
	}
	
	public static void createAccount() {
		System.out.println("__________________\n\n"
				+ "--CREATE ACCOUNT--\n");
	}
	
	public static void nameInput() {
		System.out.print("Enter Your Name: ");
	}
	
	public static void surnameInput() {
		System.out.print("Enter Your Surname: ");
	}
	
	public static void successfullyCreatedAcc() {
		System.out.println("**Your Have Created Account In Our Library.\n");
	}
	
	public static void accountInfo(Account account) {
		System.out.println("--ACCOUNTS INFO--\n\n"
				+ " -Name: " + account.getName() + "\n"
				+ " -Surname: " + account.getSurname() + "\n"
				+ " -Created: " + account.getCurrentDateTime() + "\n"
				+ " -Account Number: *" + account.getNumber() + "*\n"
				+ " -Number Of Loaned Books: " + account.getBookLoanNumber());
	}
	
	public static void addBook() {
		System.out.println("__________________\n\n"
				+ "--ADD NEW BOOK--\n");
	}
	
	public static void bookNameInput() {
		System.out.print("Enter Name Of A New Book: ");
	}
	
	public static void bookInfo(Book book) {
		System.out.println("__________________\n\n"
				+ "--BOOK INFO--\n\n"
				+ " -Name: " + book.getName() + "\n"
				+ " -Added: " + book.getLoanedDateTime() + "\n"
				+ " -Book Number: *" + book.getNumber() + "*\n");
	}
	
	public static void loanBook() {
		System.out.println("__________________\n\n"
				+ "--LOAN BOOK--\n");
	}
	
	public static void returnBook() {
		System.out.println("__________________\n\n"
				+ "--RETURN BOOK--\n");
	}
	
	public static void accNumberInput() {
		System.out.print("Enter Your Account Number: ");
	}
	
	public static void bookNumberInput() {
		System.out.print("Enter Your Book Number: ");
	}
	
	public static void allAccounts() {
		System.out.println("__________________\n\n"
				+ "--LIST OF ALL ACCOUNTS--\n");
	}
	
	public static void exit() {
		System.out.println("\n**You Have Exited Library");
	}
	
	public static void noOptions() {
		System.out.println("\n**There Are No Available Options!");
	}
	
	public static void numberLenght() {
		System.out.println("\n**Lenght Of Number Is 4 (FOUR)!");
	}
	
	public static void noAccount() {
		System.out.println("\n**Account With Entered Number Doesn't Exist!");
	}
	
	public static void noBook() {
		System.out.println("\n**Book With Entered Number Doesn't Exist!");
	}
	
	public static void noBooks() {
		System.out.println("\n**There Are No Added Books In Library!");
	}
	
	public static void noAccounts() {
		System.out.println("\n**There Are No Created Accounts In Library!");
	}
	
	public static void allLoaned() {
		System.out.println("\n**All Books Have Been Loaned!");
	}
	
	public static void bookLoaned(Book book) {
		System.out.println("\n**You Have Loaned \"" + book.getName() + "\"\n"
				+ " -Loan Date: " + book.getLoanedDateTime() + "\n"
				+ " -Return Date: " + book.getReturnDateTime() + "\n");
	}
	
	public static void taken() {
		System.out.println("\n**Wanted Book Is Already Loaned!");
	}
	
	public static void limit() {
		System.out.println("\n**You Have Reached Limit Of 3 (THREE) Loaned Books!");
	}
	
	public static void noLoanedBooks() {
		System.out.println("\n**There Are No Loaned Books");
	}
	
	public static void allBooksList(ArrayList<Book> allBooks) {
		System.out.println("\n--ALL BOOKS--\n\n");
		for (Book book : allBooks)
			System.out.println((allBooks.indexOf(book) + 1) + ") " + book.getName() + "\n"
					+ " -Return Date: " + book.getReturnDateTime() + "\n");
		System.out.print("\nYour Choice: ");
	}
	
	public static void notList() {
		System.out.println("\n**No Book On Selected Number!");
	}
	
	public static void returnedBook() {
		System.out.println("\n**The Book Has Been Returned!");
	}
	
}
