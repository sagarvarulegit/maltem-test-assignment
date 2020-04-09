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
import support.utils.DriverFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class Chapter1StepDefs {

    private WebDriver driver;
    private static final Logger log = Logger.getLogger(Chapter1StepDefs.class);
    private HashMap<String, String> data;
    private Properties prop;
    private Chapter1PO chapter1PO;

    public Chapter1StepDefs() {

        driver =  DriverFactory.getInstance().driver;
    }

    @Given("I have open the automated tester website")
    public void i_have_open_the_automated_tester_website() {
        driver.get("http://book.theautomatedtester.co.uk");
    }

    @Given("I am on chapter one assignment page")
    public void i_am_on_chapter_one_assignment_page() {
        chapter1PO = new Chapter1PO(driver);
        chapter1PO.openChapter1Assignment();
    }

    @Then("Verify {string} is present")
    public void verify_is_present(String expected_string) {
        Assert.assertEquals(chapter1PO.getTextToVerify(),expected_string);
    }

    @When("I click on link to launch another window")
    public void i_click_on_link_to_launch_another_window() {
        chapter1PO.launchNewWindows();
    }

    @Then("Verify {string} is present in new windows")
    public void verify_is_present_in_new_windows(String expectedtext) {
        Assert.assertTrue(chapter1PO.verifyTextPresentOnNewWindow(expectedtext)); ;
    }

    @When("I click on AJAX link to load page")
    public void i_click_on_AJAX_link_to_load_page() {
        chapter1PO.clickAJAXLink();
    }

    @Then("Verify {string} is present in new AJAX box")
    public void verify_is_present_in_new_AJAX_box(String string) {
        chapter1PO.verifyTextPresentAJAXBox(string);
    }

    @Then("Verify button is present")
    public void verify_button_is_present() {
         Assert.assertTrue(driver.findElement(By.id("verifybutton")).isDisplayed());
    }

    @Then("Verify following chapters {string} are present")
    public void verify_following_are_present(String exp_str) {
       List<WebElement> elementList =  driver.findElements(By.xpath(".//ul/li//a"));
       Assert.assertNotNull(elementList.stream().filter(e -> e.getText().equalsIgnoreCase(exp_str)).findFirst().orElse(null));
    }
}


