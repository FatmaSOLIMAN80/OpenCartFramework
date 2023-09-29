package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//div[@class='dropdown']/a[@href='']")
	private WebElement myAccountDropMenu;
	@FindBy(xpath = "//a[@href='http://localhost/opencart/upload/index.php?route=account/login&language=en-gb' and @class='dropdown-item']")
	private WebElement loginDropMenu;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMyAccountDropMenu() {
		myAccountDropMenu.click();
	}

	public void clickOnLoginOption() {
		loginDropMenu.click();
	}
}
