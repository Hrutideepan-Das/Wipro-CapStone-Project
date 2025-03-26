package Demowebshop.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passField;
	
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Log out')]")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//div[@class='message-error']")
	WebElement errorMssg;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    public void enterEmail(String email) {
    	emailField.clear();
    	emailField.sendKeys(email);
    }
    
    public void enterPassword(String pass) {
    	passField.clear();
    	passField.sendKeys(pass);
    }
    
    public void clickLoginButton() {
    	loginBtn.click();
    }
    
    public boolean isLogoutButtonDisplayed() {
    	return logoutBtn.isDisplayed();
    }
    
    public String getErrorMessage() {
    	return errorMssg.getText();
    }
}
