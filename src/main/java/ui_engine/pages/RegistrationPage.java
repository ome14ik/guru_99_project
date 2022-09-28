package ui_engine.pages;

import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage{

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

    /**
     * enter email address to 'Email' field
     * @param email
     */
    public void enterEmailToField(String email) throws Exception {
        try {
            WebElement fieldElement = getEmailFieldElement();
            inputText(fieldElement, email);
        }
        catch (Exception e){
            throw new Exception("Failed enter email - '" + email + "'- to field. Error: "+ e);
        }
    }

    /**
     * Click to submit button
     */
    public void clickToSubmitButton(){
        try{
            clickOn("//input[@type = 'submit']");
        }
        catch(Exception e){

        }
    }
}
