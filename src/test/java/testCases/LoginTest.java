package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class LoginTest extends Base {

	// on le cree a l'interieur de la class prq il soit accessible a ts les methodes
	public WebDriver driver;

	// preconditions
	@BeforeMethod // avant chaque test
	public void setup() {
		driver = initialiserNavigateurEtOuvrirUrl(prop.getProperty("browserName"));

	}

	// postconditions
	@AfterMethod // apres chaque test
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyLoginWithValidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		// creer un cas de test a partir d'un objet cree precedemment
		loginPage.clickMyAccount();
		loginPage.clickLoginMenu();
		loginPage.typeEmail(dataProp.getProperty("validEmail"));
		loginPage.typePassword(dataProp.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
	}

	public void verifyLoginWithValidCredentialsDDT() {
		// ramener les donnees valides a partir d'un fichier excel
	}

	public void verifyLoginWithinValidCredentialsDDT() {
		// ramener les donnees invalides a partir d'un fichier excel
	}
}
