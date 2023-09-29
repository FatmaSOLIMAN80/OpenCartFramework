package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='d-none d-md-inline' and text()='My Account']")
	private WebElement MyAccount;
	@FindBy(xpath="//a[@href='http://localhost/opencart/upload/index.php?route=account/login&language=en-gb']")
	private WebElement LoginMenu;
	@FindBy(id="input-email")
	private WebElement emailAddress;
	@FindBy(id="input-email")
	private WebElement passWord;
	@FindBy(css="button[type='submit']")
	private WebElement loginButton;
	@FindBy(css="alert-dismissible")
	private WebElement warningLogin;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickMyAccount() {
		MyAccount.click();
	}
	public void clickLoginMenu() {
		LoginMenu.click();
	}
	public void typeEmail(String email) {
		emailAddress.sendKeys(email);
	}
	public void typePassword(String password) {
		passWord.sendKeys(password);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public String getErrorLoginMessage() {
		return warningLogin.getText();
	}
	//methode pour regrouper les elements, pour notre fonctionalite login
	public void login(String eMail, String pass) {
		emailAddress.sendKeys(eMail);
		passWord.sendKeys(pass);
		loginButton.click();
	}

}
