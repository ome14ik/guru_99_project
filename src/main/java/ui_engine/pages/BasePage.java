package ui_engine.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Properties;



public class BasePage {
    private static WebDriver driver;
    Properties PROP = new Properties();
    FileInputStream fis;

    public static void setDriver (WebDriver webDriver) {
        driver = webDriver;
    }
    protected WebDriver getDriver(){
        return this.driver;
    }

    /**
     * get alert message
     * @return
     * @throws Exception
     */
    public String getAlertMessage () throws Exception {
        try{
            return getDriver().switchTo().alert().getText();
        }
        catch (Exception e){
            throw new Exception("Impossible get alert message. Error:"+ e);
        }
    }

    /**
     * get alert message
     * @return
     * @throws Exception
     */
    public void acceptAlertMessage () throws Exception {
        try{
            getDriver().switchTo().alert().accept();
        }
        catch (Exception e){
            throw new Exception("Impossible get alert message. Error:"+ e);
        }
    }


    public void openUrl(String url) throws Exception {
        try {
            driver.get(url);
        }
        catch (Exception e){
            throw new Exception("Impossible to open URL: " + url + ". Error: "+ e);
        }
    }

    /**
     * get element by xpath
     * @param xpath
     * @return
     * @throws Exception
     */
    public WebElement getElementByXpath(String xpath) throws Exception {
        try {
            return driver.findElement(By.xpath(xpath));
        } catch (Exception e) {
            throw new Exception("Impossible to find Element by Xpath - " + xpath + " Error: " + e);
        }
    }

    /**
     * Get elements by xpath
     * @param element
     * @return
     * @throws Exception
     */
    public List<WebElement> getElementsByXpath(String element) throws Exception {
        try {
            List<WebElement> elements = driver.findElements(By.xpath(element));
            return elements;
        } catch (Exception e) {
            throw new Exception("Impossible to find Elements by Xpath - " + element + " Error: " + e);
        }
    }

    /**
     * Type text to element
     * @param element
     * @param text
     * @throws Exception
     */
    public void inputText(WebElement element, String text) throws Exception {
        try{
            element.sendKeys(text);
        }
        catch (Exception e){
            throw new Exception("Failed to %text type " + text + " to field. Error: " + e );
        }

    }

    /**
     * Click on element by xpath
     **/
    protected void clickOn(String xpath) throws Exception {
        try{
            getElementByXpath(xpath).click();
        }
        catch (Exception e){
            throw new Exception("Failed to click on element. Error: " + e );
        }
    }


    /**
     * Click on element by xpath
     **/
    protected void clickOn(WebElement element) throws Exception {
        try{
            element.click();
        }
        catch (Exception e){
            throw new Exception("Failed to click on element. Error: " + e );
        }
    }

    /**
     * Get property value by name
     **/
    public String getConfigProperty(String key) throws Exception {
       try {
           fis = new FileInputStream("src/test/java/config/config.properties");
           PROP.load(fis);
           return PROP.getProperty(key);
       }
       catch (Exception e){
           throw new Exception("Failed to get property by name: " + key + ". Error:" + e);
       }

    }

    /**
     * Get property value by name and value
     **/
    public String getConfigProperty(String key, String value) throws Exception {
        try {
            fis = new FileInputStream("src/test/java/config/config.properties");
            PROP.load(fis);
            return PROP.getProperty(key, value);
        }
        catch (Exception e){
            throw new Exception("Failed to get property by name '" + key + "' and value '"+ value +"'. Error:" + e);
        }
    }


    /**
     * Custom element waiter
     * @param xPath
     * @param waitTimeSecond
     */
    public void isElementDisplayed(String xPath, int waitTimeSecond) throws Exception {

        LocalTime startTime = LocalTime.now();
        while (!isElementExist(xPath)) {
            LocalTime time = LocalTime.now();
            if (time.getSecond() >= (startTime.getSecond()+waitTimeSecond )){
                throw new Exception("Element still does not exist after " + waitTimeSecond + " seconds waite.");
            }
        }
    }

    /**
     * Verify element is it displayed
     * @param xPath
     * @return
     */
    private boolean isElementExist(String xPath){
        try {
            WebElement element = getElementByXpath(xPath);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
