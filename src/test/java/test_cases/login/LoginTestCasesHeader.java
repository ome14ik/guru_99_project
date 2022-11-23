package test_cases.login;

import common.Login;
import org.openqa.selenium.bidi.log.Log;
import org.testng.annotations.Test;

public class LoginTestCasesHeader extends Login{

    @Test
    public void loginWithValidCredentialsToMainPage() throws Exception {
        loginToMainPage(true, true);
    }

    @Test
    public void enterInvalidUserAndInvalidPassword() throws Exception {
        loginToMainPage(false, false);
    }

    @Test
    public void enterValidUserAndInvalidPassword() throws Exception {
        loginToMainPage(true, false);
    }

    @Test
    public void enterInvalidUserAndValidPassword() throws Exception {
        loginToMainPage(false, true);
    }
}
