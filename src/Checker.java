
public class Checker {

	public static boolean checkNumberLenght(int number) {
		if (Integer.toString(number).length() != 4)
			return true;
		return false;
	}
	
}
