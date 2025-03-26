package Demowebshop.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id= 'termsofservice']")
    private WebElement checkBox;
    
    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    private WebElement checkoutButton;
    
//    @FindBy(xpath = "//input[@class = 'button-1 checkout-as-guest-button']")
//    private WebElement checkoutGuestBtn;
    
    @FindBy(xpath = "//select[@id='billing-address-select']")  
    private WebElement billingAddressDropdown;

    @FindBy(xpath  = "//input[@id = 'BillingNewAddress_FirstName']")
    private WebElement firstNameField;

    @FindBy(xpath  = "//input[@id = 'BillingNewAddress_LastName']")
    private WebElement lastNameField;
    
    @FindBy(xpath  = "//input[@id = 'BillingNewAddress_Email']")
    private WebElement emailField;

    @FindBy(xpath  = "//input[@id = 'BillingNewAddress_Address1']")
    private WebElement addressField;

    @FindBy(xpath  = "//input[@id= 'BillingNewAddress_City']")
    private WebElement cityField;
    
    @FindBy(xpath = "//select[@id = 'BillingNewAddress_CountryId']" )
    private WebElement countryDropdown;
    
//    @FindBy(xpath = "//option[@value='41']")
//    private WebElement selectCountry;
    
    @FindBy(xpath  = "//input[@id= 'BillingNewAddress_ZipPostalCode']")
    private WebElement zipCodeField;
    
    @FindBy(xpath  = "//input[@id= 'BillingNewAddress_PhoneNumber']")
    private WebElement phoneNoField;

    @FindBy(xpath = "(//input[@class = 'button-1 new-address-next-step-button'])[1]")
    private WebElement continueButton;
    
    @FindBy(xpath = "(//input[@class = 'button-1 new-address-next-step-button'])[2]")
    private WebElement continueButton2;
    
    @FindBy(xpath = "//input[@class = 'button-1 shipping-method-next-step-button']")
    private WebElement shippingMethodBtn;
    
    @FindBy(xpath = "//input[@class = 'button-1 payment-method-next-step-button']")
    private WebElement paymentMethodBtn;
    
    @FindBy(xpath = "//input[@class = 'button-1 payment-info-next-step-button']")
    private WebElement paymentInfoBtn;
    
    @FindBy(xpath = "//input[@class = 'button-1 confirm-order-next-step-button']")
    private WebElement confirmOrderBtn;

    @FindBy(xpath = "//span[@class = 'field-validation-error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
    private WebElement orderConfirmationMessage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton() {
    	checkBox.click();
        checkoutButton.click();
//        checkoutGuestBtn.click();
    }
    
//    public void clickCheckoutAsGuest() {
//    	checkoutGuestBtn.click();
//    }
    
    public void selectNewBillingAddress() {
        Select select = new Select(billingAddressDropdown);
        select.selectByVisibleText("New Address");
    }
    
    public void selectCountry(String countryName) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(countryName);
    }
    
    public void enterInvalidShippingDetails(String firstName, String lastName, String email, String country, String city, String zip, String phone) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        emailField.clear();
        emailField.sendKeys(email);
        selectCountry(country);
        addressField.clear();
//        addressField.sendKeys(address);
        cityField.clear();
        cityField.sendKeys(city);
        zipCodeField.clear();
        zipCodeField.sendKeys(zip);
        phoneNoField.clear();
        phoneNoField.sendKeys(phone);
        continueButton.click();
    }
    
    
    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }
    
    
    
    public void enterValidShippingDetails(String firstName, String lastName, String email, String country,String address, String city, String zip, String phone  ) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        emailField.clear();
        emailField.sendKeys(email);
        selectCountry(country);;
        addressField.clear();
        addressField.sendKeys(address);
        cityField.clear();
        cityField.sendKeys(city);
        zipCodeField.clear();
        zipCodeField.sendKeys(zip);
        phoneNoField.clear();
        phoneNoField.sendKeys(phone);
        continueButton.click();
    }
    

    public void clickContinueShippingAddress() {
    	continueButton2.click();
    }
    
    public void clickContinueShippingMethod() {
    	shippingMethodBtn.click();
    }
    
    public void clickContinuePaymentMethod() {
    	paymentMethodBtn.click();
    }
    
    public void clickContinuePaymentInfo() {
    	paymentInfoBtn.click();
    }
    
    public void clickConfirmOrderButton() {
    	confirmOrderBtn.click();
    }


    public boolean isOrderConfirmed() {
        return orderConfirmationMessage.isDisplayed();
    }

}
