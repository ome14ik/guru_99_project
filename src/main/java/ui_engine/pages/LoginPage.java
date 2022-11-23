package ui_engine.pages;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
String userIdFieldElement = "//input[@onkeyup='validateuserid();']";
String passwordFieldElement = "//input[@onkeyup='validatepassword();']";
String loginButtonElement = "//input[@name='btnLogin']";
String resetButtonElement = "//input[@name='btnReset']";
String errorLoginMessageElement = "";
    /**
     * Type User id to User Id field
     * @param userId
     * @throws Exception
     */
    public void typeToUserIdField(String userId) throws Exception {
        try {
         inputText(getUserIdFieldElement(), userId);

        }
        catch (Exception e){
            throw new Exception("Failed type UserID." + e);
        }
    }

    /**
     * Type password to User id field
     * @param password
     * @throws Exception
     */
    public void typeToPasswordField(String password) throws Exception {
        try {
            inputText(getPasswordFieldElement(), password);

        }
        catch (Exception e){
            throw new Exception("Failed type Password." + e);
        }
    }

    /**
     * Click Login button
     */
    public void clickLoginButton() throws Exception {
        clickOn(loginButtonElement);
    }

    /**
     * Click Login button
     */
    public void clickResetButton() throws Exception {
        clickOn(resetButtonElement);
    }

    /**
     * Verify error login message
     */
    public void isErrorLoginMessageExist() throws Exception {
        try {
            isElementDisplayed(errorLoginMessageElement,3);
        }
        catch (Exception e){
            throw new Exception("Smth went wrong with error login message detection." + " Error: " + e);
        }

    }

//    /**
//     * get alert message
//     * @return
//     * @throws Exception
//     */
//    public String getAlertMessage () throws Exception {
//        try{
//        return getDriver().switchTo().alert().getText();
//        }
//        catch (Exception e){
//            throw new Exception("Impossible get alert message. Error:"+ e);
//        }
//    }

    /**
     * Get userID field element
     * @return
     * @throws Exception
     */
    private WebElement getUserIdFieldElement() throws Exception {
        try {
            return getElementByXpath(userIdFieldElement);
        }
        catch (Exception e){
            throw new Exception("Failed to get userIdFieldElement -" + userIdFieldElement + " ." + "Error: " + e);
        }
    }

    /**
     * Get password field element
     * @return
     * @throws Exception
     */
    private WebElement getPasswordFieldElement() throws Exception {
        try {
            return getElementByXpath(passwordFieldElement);
        }
        catch (Exception e){
            throw new Exception("Failed to get passwordFieldElement -" + passwordFieldElement + " ." + "Error: " + e);
        }
    }

    /**
     * get login button element
     * @return
     * @throws Exception
     */
    private WebElement getLoginButtonElement() throws Exception {
        try {
            return getElementByXpath(loginButtonElement);
        }
        catch (Exception e){
            throw new Exception("Failed to get loginButtonElement -" + loginButtonElement + " ." + "Error: " + e);
        }
    }

    /**
     * get reset button element
     * @return
     * @throws Exception
     */
    private WebElement getResetButtonElement() throws Exception {
        try {
            return getElementByXpath(resetButtonElement);
        }
        catch (Exception e){
            throw new Exception("Failed to get resetButtonElement -" + resetButtonElement + " ." + "Error: " + e);
        }
    }



}
