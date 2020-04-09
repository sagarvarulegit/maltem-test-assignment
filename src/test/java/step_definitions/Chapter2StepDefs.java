package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page_objects.Chapter1PO;
import page_objects.Chapter2PO;
import support.utils.DriverFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class Chapter2StepDefs {

    private WebDriver driver;
    private static final Logger log = Logger.getLogger(Chapter2StepDefs.class);
    private HashMap<String, String> data;
    private Properties prop;
    private Chapter2PO chapter2PO;

    public Chapter2StepDefs() {

        driver =  DriverFactory.getInstance().driver;
    }

    @Given("I am on chapter two assignment page")
    public void i_am_on_chapter_two_assignment_page() {
        chapter2PO = new Chapter2PO(driver);
        chapter2PO.openChapter2Assignment();
    }

    @Then("Verify following elements with attribute {string} and {string} are present")
    public void verify_following_elements_with_attribute_and_are_present(String attribute, String value) {
        switch (attribute){
            case "id" :
                Assert.assertTrue(driver.findElement(By.id(value)).isDisplayed());break;

            case "xpath":
                Assert.assertTrue(driver.findElement(By.xpath(value)).isDisplayed());break;

            case "name":
                Assert.assertTrue(driver.findElement(By.name(value)).isDisplayed());break;

            case "value":
                Assert.assertTrue(driver.findElement(By.xpath(".//*[@value='"+value+"']")).isDisplayed());break;

            default:break;
        }

    }

}


