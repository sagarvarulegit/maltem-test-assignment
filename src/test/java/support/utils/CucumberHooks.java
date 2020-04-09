package support.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {
    private WebDriver driver;

    public CucumberHooks(WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public void beforeScenario(){
        driver = DriverFactory.getInstance().driver;
    }

    @After
    public void afterScenario(){
        driver.close();
    }

}
