import java.util.ArrayList;

public class Book {

	private String name;
	private int number;
	private boolean status;
	private ArrayList<Integer> numbers = new ArrayList<>();
	
	protected Book(String name) {
		this.name = name;
		this.generateRandomNumber();
		this.status = false;
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

	public boolean isStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
