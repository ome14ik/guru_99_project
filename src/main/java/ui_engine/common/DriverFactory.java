package ui_engine.common;

import ui_engine.Enums.driverfactory.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import ui_engine.Enums.driverfactory.SystemType;


public class DriverFactory {

public static WebDriver getDriver(BrowserType type, SystemType sysType){
    WebDriver driver = null;

    switch (type){
        case CHROME:
            System.setProperty("webdriver.chrome.driver", sysType != SystemType.MacOS? "src/main/resources/chromedriver.exe" : "src/main/resources/chromedriver");
            driver = new ChromeDriver();
            break;
        case FIREFOX:
            System.setProperty("mozila.gecko/.driver","src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            break;
        default:
            Assert.fail("Incorrect platform or browser: "+ type);
    }

    return driver;
}


}
