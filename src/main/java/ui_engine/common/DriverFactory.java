package ui_engine.common;

import ui_engine.Enums.driverfactory.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class DriverFactory {

public static WebDriver getDriver(BrowserType type){
    WebDriver driver = null;

    switch (type){
        case CHROME:
            System.setProperty("webdriver.chrome.driver","src/main/resource/chromedriver.exe");
            driver = new ChromeDriver();
            break;
        case FIREFOX:
            System.setProperty("mozila.gecko/.driver","src/main/resource/geckodriver.exe");
            driver = new FirefoxDriver();
            break;
        default:
            Assert.fail("Incorrect platform or browser: "+ type);
    }

    return driver;
}


}
