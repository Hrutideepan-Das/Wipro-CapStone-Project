package Demowebshop.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Fetch WebDriver from DriverManager (already initialized by TestRunner)
        driver = DriverManager.getDriver();
        
        // Set up explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open the website
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
