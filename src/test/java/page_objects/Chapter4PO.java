package page_objects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Chapter4PO {

    private Interactions interactions;
    private static final Logger log = Logger.getLogger(String.valueOf(Chapter4PO.class));

    @FindBy(xpath = (".//a[text()='Chapter4']"))
    private WebElement link_Chapter4;

    public Chapter4PO(WebDriver driver) {
        super();
        PageFactory.initElements(driver,this);
        this.interactions = new Interactions(driver);
        PropertyConfigurator.configure("log4j.properties");
    }


    public void openChapter4Assignment(){
        interactions.click(link_Chapter4);
    }
}
