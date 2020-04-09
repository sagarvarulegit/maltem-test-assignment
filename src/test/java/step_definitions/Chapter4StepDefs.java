package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import page_objects.Chapter2PO;
import page_objects.Chapter4PO;
import support.utils.DriverFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class Chapter4StepDefs {

    private WebDriver driver;
    private static final Logger log = Logger.getLogger(Chapter4StepDefs.class);
    private HashMap<String, String> data;
    private Properties prop;
    private Chapter4PO chapter4PO;

    public Chapter4StepDefs() {
        driver =  DriverFactory.getInstance().driver;
    }

    @Given("I am on chapter four assignment page")
    public void i_am_on_chapter_four_assignment_page() {
        chapter4PO = new Chapter4PO(driver);
        chapter4PO.openChapter4Assignment();
    }

    @When("I enter {string} in text box")
    public void i_enter_in_text_box(String string) {
        driver.findElement(By.id("blurry")).sendKeys(string);
    }

    @Then("Verify alert box also has text {string}")
    public void verify_alert_box_also_has_text(String expect_string) {
       driver.findElement(By.className("mainheading")).click();
       String alerttext = driver.switchTo().alert().getText();
       Assert.assertEquals(alerttext.trim(),expect_string);
        driver.switchTo().alert().dismiss();
    }

    @Then("Verify Select box also has values {string}")
    public void verify_Select_box_also_has_values(String values) {
       String[] str_arry = values.split(",");
       Select select = new Select(driver.findElement(By.id("selecttype")));
       List<WebElement> webElementList  = select.getOptions();
        for (String str: str_arry) {
            Assert.assertNotNull(webElementList.stream().filter(e -> e.getText().equalsIgnoreCase(str.trim())).findFirst().orElse(null));
        }
    }

}


