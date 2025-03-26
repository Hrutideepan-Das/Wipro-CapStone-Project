package Demowebshop.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<String> browserType = new ThreadLocal<>();

    public static void setBrowser(String browser) {
        browserType.set(browser);
        initializeDriver();  // Initialize driver when browser is set
    }

    private static void initializeDriver() {
        if (driver.get() == null) {
            String browser = browserType.get();
            if (browser == null) {
                throw new IllegalStateException("Browser type not set!");
            }

            WebDriver newDriver;
            switch (browser.toLowerCase()) {
                case "chrome":
                    newDriver = new ChromeDriver();
                    System.out.println("Launching Chrome browser...");
                    break;
                case "edge":
                    newDriver = new EdgeDriver();
                    System.out.println("Launching Edge browser...");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }

            newDriver.manage().window().maximize();
            newDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.set(newDriver);
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("WebDriver not initialized! Ensure browser is set in TestRunner.");
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
    
    
}
