package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	WebDriver driver;
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean getDisplayStatusOfEditYourAccountInformationOption() {
		//this will return a boolean value true or false
		boolean displaStatus= editYourAccountInformationOption.isDisplayed();
		return displaStatus;
	}

}

