package valiation;

public class check {
	public static boolean checkID( String id) {
		if(id.matches("[a-zA-Z]+")) {
			return true;
		}
		return false;
	}
	
	public static boolean checkLength(String text,int length) {
		if(text.length()<=length) {
			return true;
		}
		return false;
	}
	
	public static boolean checkpositive(String number) {
		if(number.matches("[0-9]+")&&Integer.parseInt(number)>=0) {
			return true;
		}
		return false;
	}
	
	public static boolean checkpositiveFloat(String number) {
		if(number.matches("^[-+]?\\d*\\.?\\d*$")&&Float.parseFloat(number)>=0) {
			return true;
		}
		return false;
	}

}
