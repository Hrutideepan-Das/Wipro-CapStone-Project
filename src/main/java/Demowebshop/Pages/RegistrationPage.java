package Demowebshop.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id = 'gender-male']")
	private WebElement genderMBtn;
	
	@FindBy(xpath = "//input[@id = 'gender-female']")
	private WebElement genderFBtn;
	
	@FindBy(xpath = "//input[@id = 'FirstName']")
	private WebElement firstNameField;
	
	@FindBy(xpath = "//input[@id = 'LastName']")
	private WebElement lastNameField;
	
	@FindBy(xpath = "//input[@id = 'Email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//input[@id = 'Password']")
	private WebElement passwordField;
	
	@FindBy(xpath ="//input[@id = 'ConfirmPassword']")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "//input[@id = 'register-button']")
	private WebElement registerBtn;
	
	@FindBy(xpath = "//div[contains(text(), 'Your registration completed')]")
	WebElement registrationSuccessMessage;
	
	@FindBy(xpath  = "//li[contains(text(), 'The specified email already exists' )]")
	private WebElement emailErrorMessage;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("male")) {
			genderMBtn.click();
		} else {
			genderFBtn.click();
		}
	}
	
	public void enterFirstName(String fName) {
		firstNameField.clear();
		firstNameField.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        lastNameField.clear();
        lastNameField.sendKeys(lName);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void confirmPassword(String password) {
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(password);
    }
	

    public void clickRegister() {
        registerBtn.click();
    }
    
    public boolean isRegistrationSuccessful() {
        return registrationSuccessMessage.isDisplayed();
    }
    
    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }
}
