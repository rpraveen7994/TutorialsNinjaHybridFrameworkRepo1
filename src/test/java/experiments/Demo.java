package experiments;

import java.util.Date;

public class Demo {

	public static void main(String[] args) {

		Date date = new Date();
		
//		String dateText = date.toString();
//		String dateTextWithoutSpaces = dateText.replace(" ", "_");
//		String dateTextWithoutSpacesAndColon = dateTextWithoutSpaces.replace(":", "_");
//		System.out.println(dateTextWithoutSpacesAndColon);
		
		System.out.println(date.toString().replace(" ", "_").replace(":", "_")); //method chaining
		
		
		
		
	}

}
