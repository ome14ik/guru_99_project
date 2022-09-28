package base_test;

import ui_engine.Enums.driverfactory.BrowserType;
import ui_engine.pages.BasePage;
import ui_engine.common.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui_engine.pages.RegistrationPage;
import ui_engine.pages.MainMenuPage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;



public class TestBase {
    /**
     * get token
     * @return
     * @throws IOException
     */
        WebDriver driver;
        Properties PROP = new Properties();
        FileInputStream fis;

        RegistrationPage registrationPage = new RegistrationPage();

        @BeforeSuite
        public void initializeDriver() throws FileNotFoundException {
            fis = new FileInputStream("src/test/java/config/config.properties");
            driver = DriverFactory.getDriver(BrowserType.CHROME);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            BasePage.setDriver(driver);
        }

        @AfterSuite
        public void closeDriver(){
            driver.close();
            driver.quit();
        }

        public void navigate(String URL){

            driver.get(PROP.getProperty(URL));
        }

    /**
     * Initialize page to test class
     * @param page
     */
//    public Object pageInitializer(Object page) throws Exception {
//
//
//        switch (page){
//            case registrationPage:
//                return new RegistrationPage();
//                break;
//            Object MainMenuPage;
//            case MainMenuPage:
//                return new MainMenuPage();
//                break;
//            default:
//                throw new Exception("Unknown object");
//                break;
//        }
//
//        }

}
