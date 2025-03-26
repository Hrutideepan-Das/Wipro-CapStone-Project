package TestRunners;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Demowebshop.Base.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)

//@io.cucumber.junit.CucumberOptions(
//		features = "src\\test\\resources\\Features\\Login.feature",
//		glue = {"StepDefinitions", "Demowebshop.Pages", "Demowebshop.Base"}
//		)

@CucumberOptions(
		features = "src/test/resources/Features/DemoWebShop.feature",
		glue = {"StepDefinitions", "Demowebshop.Pages", "Demowebshop.Base"},
				plugin = {"pretty", "html:target/cucumber-reports.html"}
		)


public class OCTestrunner extends AbstractTestNGCucumberTests {
    
    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        System.out.println("TestRunner: Setting browser to " + browser);
        DriverManager.setBrowser(browser);
    }
}
