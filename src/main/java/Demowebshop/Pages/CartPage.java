package Demowebshop.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(), 'Shopping cart')]")
    private WebElement shoppingCartLink;

    @FindBy(xpath = "//table[@class='cart']//tbody/tr")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//span[@class='product-subtotal']")
    private List<WebElement> productSubtotals;

    @FindBy(xpath = "//span[@class='product-price order-total']")
    private WebElement totalPriceElement;
    
    @FindBy(xpath = "//input[@name= 'discountcouponcode']")
    private WebElement couponCodeField;
    
    @FindBy(xpath = "//input[@name= 'applydiscountcouponcode']")
    private WebElement applyCouponBtn;
    
    @FindBy(xpath = "//div[@class= 'message']")
    private WebElement errorMessage;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCart() {
        shoppingCartLink.click();
    }

    public boolean isProductInCart(String productName) {
        for (WebElement item : cartItems) {
            if (item.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }

    
    public boolean isTotalPriceDisplayed() {
    	return totalPriceElement.isDisplayed();
    }
    
    
//    public double getTotalPrice() {
//        String priceText = totalPriceElement.getText().replace("$", "").trim();
//        return Double.parseDouble(priceText);
//    }
//
//    public double calculateExpectedTotal() {
//        double total = 0.0;
//        for (WebElement priceElement : productSubtotals) {
//            total += Double.parseDouble(priceElement.getText().replace("$", "").trim());
//        }
//        return total;
//    }
    
    public void enterCouponCode(String code) {
    	couponCodeField.clear();
    	couponCodeField.sendKeys(code);
    }
    
    public void clickApplyCouponCodeButton() {
    	applyCouponBtn.click();
    }
    
    public boolean isValidationMessageDisplayed() {
    	return errorMessage.isDisplayed();
    }
    
}

