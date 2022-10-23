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
    public void clickToSubmitButton() throws Exception {
        try{
            clickOn("//input[@type = 'submit']");
        }
        catch(Exception e){
            throw new Exception("Failed to click on submit button. Error: "+ e);
        }
    }

    public String getUserLogin () throws Exception {
        try{
            String text;
            WebElement element = getElementByXpath("//td[contains(text() , 'User ID')]/following-sibling::td[@align = 'center']");

            text = element.getText();

            return text;
        }
        catch (Exception e){
            throw new Exception("Exception");
        }
    }

    public String getUserPassword () throws Exception {
        try{
            String text;
            WebElement element = getElementByXpath("//td[contains(text() , 'Password')]/following-sibling::td[@align = 'center']");

            text = element.getText();

            return text;
        }
        catch (Exception e){
            throw new Exception("Exception");
        }
    }

}
