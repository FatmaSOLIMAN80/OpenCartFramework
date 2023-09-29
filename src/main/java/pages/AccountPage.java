package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
	WebDriver driver;
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccount;
	@FindBy(linkText="Change your password")
	private WebElement changeYourPassword;
	@FindBy(linkText="Modify your address book entries")
	private WebElement modifyYourAddress;
	@FindBy(linkText="Modify your wish list")
	private WebElement modifyYourWishList;
	

}
