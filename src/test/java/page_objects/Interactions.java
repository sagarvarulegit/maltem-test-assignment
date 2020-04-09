package page_objects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import support.listeners.TestListener;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Interactions {
    private WebDriverWait wait;
    private WebDriver driver;
    private  Actions actions;
    private static final Logger log = Logger.getLogger(Interactions.class);
    public Interactions(WebDriver driver){
        actions = new Actions(driver);
        this.driver  = driver;
        this.wait = new WebDriverWait(driver,30);
        PropertyConfigurator.configure("log4j.properties");
    }

    protected void navigateToURL(String url) {
        try{
            driver.get(url);
        }
        catch (Exception ex){
            log.error("ERROR - Failed to navigate to URL: " + url);
            log.error(ex.getMessage());
            TestListener.getExtentTest().error(ex.getMessage());
        }

    }
    public void sendKeys(WebElement element, String value){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
            actions.moveToElement(element);
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.BACK_SPACE);
            element.sendKeys(value);
        }
        catch (Exception ex){
           log.error("ERROR - Send Key function failed for WebElement: " + element.toString());
           log.error(ex.getMessage());
           TestListener.getExtentTest().error(ex.getMessage());
        }
    }

    public void click(WebElement element){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
            actions.moveToElement(element);
            element.click();
        }
        catch (Exception ex){
            log.error("ERROR - Click function failed for WebElement: " + element.toString());
            log.error(ex.getMessage());
            TestListener.getExtentTest().error(ex.getMessage());
        }
    }

    public boolean elementVisible(WebElement element){
        try{
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        }
        catch (Exception ex){
            log.error("ERROR - Send Key function failed for WebElement: " + element.toString());
            log.error(ex.getMessage());
            TestListener.getExtentTest().error(ex.getMessage());
        }
        return false;
    }

    public void waitTillElementIsNotPresent(By element){
        try{
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

        }
        catch (Exception ex){
            log.error("ERROR - Waiting for Invisibility of element  failed: " + element.toString());
            log.error(ex.getMessage());
            TestListener.getExtentTest().error(ex.getMessage());
        }
    }

    public WebDriver getDriverInstance(){
        return this.driver;
    }

    public String getElementText(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).getText();
        } catch (Exception ex) {
            log.error("ERROR -Get Element Text function failed for WebElement: " + element.toString());
            log.error(ex.getMessage());
            TestListener.getExtentTest().error(ex.getMessage());
        }
        return null;
    }

    public void selectFromDropDown(WebElement element, String text) {
        try{
              click(element);
              List<WebElement> elements = driver.findElements(By.xpath(".//*[text()='"+ text +"']"));
            for (WebElement e:elements) {
                if(e.isDisplayed()) e.click();
            }

        }
        catch (Exception ex){
            log.error("ERROR - Select dropdown failed for WebElement: " + element.toString());
            log.error(ex.getMessage());
            TestListener.getExtentTest().error(ex.getMessage());
        }
    }

    public void selectDate(WebElement element, String date){
        try {
            //There is bug we cant change the to exact date using control. Waiting for it to get fixed
//            String[] str = date.split("-");
            click(element);
            List<WebElement> ele = driver.findElements(By.xpath(".//*[@title='Next month (PageDown)']"));
            List<WebElement> ele1;
            for (WebElement e:ele) {
                if(e.isDisplayed()){
                    e.click();
                    ele1 = driver.findElements(By.xpath(".//div[text()='25']"));
                    for (WebElement e1:ele1) {
                        if (e1.isDisplayed()){
                            e1.click();
                        }
                    }
                }
            }
        }
        catch (Exception ex){
            log.error("ERROR - Select DATE failed for WebElement: " + element.toString());
            log.error(ex.getMessage());
            TestListener.getExtentTest().error(ex.getMessage());
        }
    }

    public void searchCodeAndSelectValue(WebElement element, String code,String value) {
        try{
           sendKeys(element,code);
           WebElement val = driver.findElement(By.xpath(".//span[contains(text(),'"+value+"')]"));
           click(val);
        }
        catch (Exception ex){
            log.error("ERROR - Search Code and Select Value failed for WebElement: " + element.toString());
            log.error(ex.getMessage());
            TestListener.getExtentTest().error(ex.getMessage());
        }
    }


}

