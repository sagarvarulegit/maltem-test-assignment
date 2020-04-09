package support.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static DriverFactory driverFactoryInstance;
    public static WebDriver driver = null;

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        if (driverFactoryInstance == null) {
            driverFactoryInstance = new DriverFactory();
            driverFactoryInstance.getWebDriver();
        }
        return driverFactoryInstance;
    }


    private WebDriver getWebDriver() {
        try {
            if (driver == null) {
                Properties prop = new Properties();
                FileInputStream fileInputStreamip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\env.properties");
                prop.load(fileInputStreamip);
                String browserName = prop.getProperty("browser");
                if (browserName.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\browser_drivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                }
                if (browserName.equals("edge")) {
                    System.out.println("launching Microsoft Edge browser");
                    System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\browser_drivers\\MicrosoftWebDriver.exe");
                    driver = new EdgeDriver();
                }
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

}
