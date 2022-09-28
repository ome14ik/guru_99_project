package ui_engine.pages;

import org.openqa.selenium.WebElement;

public class MainMenuPage extends BasePage {
    /**
     * get email field element
     * @return
     * @throws Exception
     */
    private WebElement getEmailFieldElement() throws Exception {
        try{
            return getElementByXpath("//input[@onkeyup='validateEmail();']");
        }
        catch (Exception e){
            throw new Exception("Failed to get Email field element. Error: " + e);
        }
    }
}
