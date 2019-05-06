import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

public class Book {

	private String name;
	private int number;
	private boolean status;
	private String loanDate;
	private String returnDate;
	private ArrayList<Integer> numbers = new ArrayList<>();
	private Calendar currentDateTime;
	private DateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy, HH:mm");
	
	protected Book(String name) {
		this.name = name;
		this.generateRandomNumber();
		this.status = false;
		this.loanDate = this.getLoanedDateTime();
		this.returnDate = this.getReturnDateTime();
		
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
	
	public void setNumber(int number) {
		this.number = number;
		this.numbers.add(this.number);
	}

	private String getLoanedDateTime() {
		this.currentDateTime = Calendar.getInstance();
		return myFormat.format(currentDateTime.getTime());
	}
	
	private String getReturnDateTime() {
		this.currentDateTime.add(Calendar.MONTH, 1);
		return myFormat.format(currentDateTime.getTime());
	}

	public boolean isStatus() {
		return this.status;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getLoanDate() {
		return this.loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
}
