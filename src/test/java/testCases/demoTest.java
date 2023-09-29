package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Utilities;

public class demoTest {
	@Test(dataProvider="testData") //dataProvider est un attribut TestNg
	public void lireData(String username, String password, String email) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(email);

	}
	// on met object pcq on ne sait pas quel type de donnees est dans le fichier
		// excel
	@DataProvider(name="testData")
	public Object[][] fournirData() throws Exception {
		Object[][] data = Utilities.getDataFromExcel("login"); // gerer l'exception
		// login est le nom de notre sheet feuille excel cree dans le fichier excel ninjaTestData
		return data;

	}

}
