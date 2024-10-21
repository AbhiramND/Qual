package supplychainmanagement.qual.genric.webdriverutility;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Date d = new Date();
		String system_date = d.toString().replace(" ", "_").replace(":", "_");
		System.out.println(system_date);
	}

}
