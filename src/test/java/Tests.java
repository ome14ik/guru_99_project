import base_test.TestBase;
import org.testng.annotations.Test;

import static ui_engine.Enums.EnvironmentUrls.REGISTRATION_URL;

public class Tests extends TestBase {

    @Test
    public void runDemoGuru_99() throws Exception {
        try {
            navigate(REGISTRATION_URL.toString());

            //registrationPage;
        }
        catch (Exception e){
            throw new Exception("Test not started. " + e);
        }
        try {

        }
        catch(Exception e){
            throw new Exception("Smth went wrong. Error:" + e);
        }
    }

}
