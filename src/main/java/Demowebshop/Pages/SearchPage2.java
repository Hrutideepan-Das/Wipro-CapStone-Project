package Demowebshop.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage2 {
private WebDriver driver;
	
	@FindBy(xpath = "//input[@id= 'small-searchterms']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//input[@class= 'button-1 search-box-button']")
	private WebElement searchBtn;
	
//	@FindBy(xpath = "//div[@class= 'product-item']")
//	private WebElement searchResult;
	
//	@FindBy(xpath = "//input[@id= 'add-to-cart-button-31']")
//	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//input[@id= 'add-to-cart-button-13']")
	private WebElement addToCartBtn1;
	
	@FindBy(xpath = "//input[@id= 'add-to-cart-button-43']")
	private WebElement addToCartBtn2;
//	@FindBy(xpath = "//input[@id='addtocart_31_EnteredQuantity']")
//    private WebElement quantityBox;
	
//	@FindBy(xpath = "//p[@class= 'content']")
//	private WebElement addedSuccessMessage;
	
	@FindBy(xpath = "//h2[@class ='product-title' ]")
	private WebElement searchResult;
	
	
	public SearchPage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterInput(String search) {
		searchBox.clear();
		searchBox.sendKeys(search);
	}
	
	public void clickSearchButton() {
		searchBtn.click();
	}
	
	
//    public void clickSearchElement(String productName) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement resultElement = driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]"));
//        
//        wait.until(ExpectedConditions.visibilityOf(resultElement));
//        wait.until(ExpectedConditions.elementToBeClickable(resultElement));
//        
//        resultElement.click();
//    }
	
	public void clickSearchElement() {
		searchResult.click();
	}
	
	
//    public void setProductQuantity(int quantity) {
//        quantityBox.clear();
//        quantityBox.sendKeys(String.valueOf(quantity));
//    }
	
    
    
//	public void clickAddToCartButton() {
//		addToCartBtn.click();
//	}
	
	public void clickAddToCartButton1() {
		addToCartBtn1.click();
	}
	
	public void clickAddToCartButton2() {
		addToCartBtn2.click();
	}
	
//	public boolean isAddedSuccessfully() {
//		return addedSuccessMessage.isDisplayed();
//	}
}
