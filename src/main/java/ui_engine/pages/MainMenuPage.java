package ui_engine.pages;

import org.openqa.selenium.WebElement;

public class MainMenuPage extends BasePage {
   private String mainPageTitleElement = "//h2[@class ='barone']";
   private String cabinetArea = "//ul[@class = 'menusubnav']";


    /**
     * Get title name
     * @return
     * @throws Exception
     */
    public String getMainPageTitle() throws Exception {
        WebElement element = getMainPageTitleElement();
        String title = element.getText();

        return title;
    }

    /**
     * Verify exist main page title or not. If yes return true if not return exception
     * @return
     */
    public void isMainPageTitleExist() throws Exception {
        try {
            isElementDisplayed(mainPageTitleElement,3);
        }
        catch (Exception e){
            throw new Exception("Main page title not displayed"+". Error: " + e);
        }
    }

    /**
     * Verify exist cabinet area or not. If yes return true if not return exception
     * @return
     */
    public void isCabinetAreaExist() throws Exception {
        try {
            isElementDisplayed(cabinetArea,3);
        }
        catch (Exception e){
            throw new Exception("Main page title not displayed"+". Error: " + e);
        }
    }

    /**
     * get main page title element
     * @return
     */
    private WebElement getMainPageTitleElement() throws Exception {
        try {
            return getElementByXpath(mainPageTitleElement);
        }
        catch (Exception e){
            throw new Exception("Failed to get mainPageTitleElement -" + mainPageTitleElement + " ." + "Error: " + e);
        }
    }
}
