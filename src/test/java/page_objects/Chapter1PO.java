package page_objects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import support.listeners.TestListener;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Chapter1PO {
    private Interactions interactions;
    private static final Logger log = Logger.getLogger(String.valueOf(Chapter1PO.class));

    public Chapter1PO(WebDriver driver) {
        super();
        PageFactory.initElements(driver,this);
        this.interactions = new Interactions(driver);
        PropertyConfigurator.configure("log4j.properties");
    }

    @FindBy(xpath = (".//a[text()='Chapter1']"))
    private WebElement link_Chapter1;

    @FindBy(id = ("divontheleft"))
    private WebElement div_textToVerify;

    @FindBy(id = ("loadajax"))
    private WebElement link_LoadAjax;

    @FindBy(id = ("ajaxdiv"))
    private WebElement div_AjaxContent;

    @FindBy(id="multiplewindow")
    List<WebElement> links_multipleWindows;

    public void openChapter1Assignment(){
        interactions.click(link_Chapter1);
    }

    public String getTextToVerify(){
        String str = interactions.getElementText(div_textToVerify);
        return str;
    }

    public void launchNewWindows() {
        for (WebElement element :links_multipleWindows) {
            element.click();
        }
    }

    public boolean verifyTextPresentOnNewWindow(String expectedtext) {
       WebDriver driver = interactions.getDriverInstance();
       String parentWindow = driver.getWindowHandle();
        String subWindowHandler = null;
       Set<String> windowsPopUps = driver.getWindowHandles();
       Iterator<String> iterator = windowsPopUps.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
            if(!subWindowHandler.equalsIgnoreCase(parentWindow)){
                driver.switchTo().window(subWindowHandler);
                if(!driver.findElement(By.id("popuptext")).getText().trim().equalsIgnoreCase(expectedtext.trim())) return false;
                driver.findElement(By.id("closepopup")).click();
            }
        }
        driver.switchTo().window(parentWindow);
       return true;
    }

    public void clickAJAXLink() {
        interactions.click(link_LoadAjax);
    }

    public boolean verifyTextPresentAJAXBox(String exp_str) {
        if(!div_AjaxContent.findElement(By.tagName("p")).getText().trim().equalsIgnoreCase(exp_str)) return false;
        return true;
    }
}
