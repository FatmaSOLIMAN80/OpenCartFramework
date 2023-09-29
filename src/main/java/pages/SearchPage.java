//dans ce package pages on definit les webelements , les localisateurs de chaque page: 
//c le POM ou le page factory usine des objets qui constituent les pages de notre projet
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	// on ajoute cette partie, pour naviguer (back et forward) entre les pages de l'application 
	//sans exception error message: stale element exception; StaleElementReferenceException
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	//annotations page factory
	//creer les webelements de la search page
	@FindBy(xpath="//div[@class='description']//a")
	private WebElement validProduct;
	@FindBy(xpath="//h2//following-sibling::p")
	private WebElement noProductMessage;
	
//On cree des methodes pour manipuler les webElements de cette page
	public String retrieveNoProductMessageText() {
		//String noProductMessag=noProductMessage.getText();
		return noProductMessage.getText();
	}
	
	public boolean displayOfValidProduct() {
		return validProduct.isDisplayed();
	}

}
