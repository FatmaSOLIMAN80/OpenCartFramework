package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage{
	//Le console de POM
	WebDriver driver;
	//creer le constructeur de cette methode pour initialiser la variable driver
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		// classe PageFactory pr mettre tous les webelements à jour
		PageFactory.initElements(driver,this);
	}
	//creer des private weblement qui constitue la page Register
	//First Name
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	@FindBy(id="input-email")
	private WebElement emailField;
	@FindBy(id="input-password")
	private WebElement passwordField;
	@FindBy(id="input-newsletter")
	private WebElement NewsletterButton;
	@FindBy(xpath="//input[@name='agree']")
	private WebElement PrivacyPolicyButton;
	@FindBy(css="button[type='submit']")
	private WebElement buttonContinue;
	@FindBy(id="error-firstname")
	private WebElement errorFirstNameField;
	@FindBy(id="error-lastname")
	private WebElement errorLastNameField;
	@FindBy(id="error-email")
	private WebElement errorEmailField;
	@FindBy(id="error-password")
	private WebElement errorPasswordField;
	@FindBy(id="alert")
	private WebElement policyWarning;
	@FindBy(xpath="//a[text()\"='login page']")
	private WebElement LoginPageRedirectLink;
	
	//creer les methodes
	//1- saisir le First Name
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
		
	}
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void selectSubscribe() {
		PrivacyPolicyButton.click();
	}
	public void agreePolicy() {
		NewsletterButton.click();
	}
	public void clickOnContinueButton() {
		buttonContinue.click();
	}
	// ecrire des methodes pour les messages d'erreur
	public String getFirstNameError() {
		//String firstNameError=errorFirstNameField.getText();
		//return firstNameError;
		return errorFirstNameField.getText();
	}
	public String getLastNameError() {
		return errorLastNameField.getText();
	}
	public String getEmailError() {
		return errorEmailField.getText();
	}
	public String getPasswordError() {
		return errorPasswordField.getText();
	}
	public String getPrivacyPolicyError() {
		return policyWarning.getText();
	}
	public void navigateToLoginPage() {
		LoginPageRedirectLink.click();
	}
	//creer une methode preparation de test pour la saisie de tous les champs obligatoires
	public void registerWithAllRequiredFields(String fname, String lName, String email, String pass)  {
		firstNameField.sendKeys(fname);
		lastNameField.sendKeys(lName);
		emailField.sendKeys(email);
		passwordField.sendKeys(pass);
	}
}
