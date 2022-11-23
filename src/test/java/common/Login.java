package common;

import base_test.TestBase;
import org.testng.annotations.Test;
import ui_engine.pages.objects.Credentials;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Locale;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static ui_engine.Enums.EnvironmentUrls.LOGIN_URL;
import static ui_engine.Enums.EnvironmentUrls.REGISTRATION_URL;

public class Login extends TestBase {

    String filename = "filename";
    Credentials credentials = new Credentials();
    public void loginToMainPage(boolean userIdValid, boolean passwordValid) throws Exception {
        try {

            String date = String.valueOf(LocalDate.now() +"$"+ LocalTime.now());

            File myFile = createNewFileOrUseOld(filename);

            if (userIdValid || passwordValid){
                credentials = getLastCredential(myFile);

                methodLocalData1();

                boolean newRegistration = isNewRegistrationNeed(credentials);

                if (newRegistration){
                    credentials = getNewCredAndWriteToAFile(date, myFile);
                }
            }
            //****** read line by one Scanner

            // put it to the file TXT  - lo
            // use cred from file
            //
        }
        catch (Exception e){
            throw new Exception("Test not started. " + e);
        }
        try {
            String alertMessage;
            /**
             *login to account with credentials
             * 1. get credential from file
             * 2. do we need close prew page if yes close it
             * 3. open login page
             * 4. type credential and login
             **/
            if (userIdValid && passwordValid){
                // open login page -> enter parameters - > login to system
                loginToSystem(credentials.getUserId(), credentials.getPassword());
                //String mainPageTitle = mainMenuPage.getMainPageTitle();
                mainMenuPage.isCabinetAreaExist();
            }else if (userIdValid){
                loginToSystem(credentials.getUserId(), credentials.getPassword()+"Er");
                alertMessage = loginPage.getAlertMessage();
                loginPage.acceptAlertMessage();
            }else if(passwordValid){
                loginToSystem("Er"+ credentials.getUserId(), credentials.getPassword());
                alertMessage = loginPage.getAlertMessage();
                loginPage.acceptAlertMessage();
            }else{
                loginToSystem(credentials.getUserId()+"Er", credentials.getPassword()+"Er");
                alertMessage = loginPage.getAlertMessage();
                loginPage.acceptAlertMessage();
            }
            //******
//                if (myObj.delete()) {
//                    System.out.println("Deleted the file: " + myObj.getName());
//                } else {
//                    System.out.println("Failed to delete the file.");
//                }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        catch(Exception e){
            throw new Exception("Smth went wrong. Error:" + e);
        }
    }

    public void methodLocalData1(){
        Locale.setDefault(Locale.FRANCE);
        // no problem now, DateTimeFormatter always uses Locale.US
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.US);

        String date = "16-Aug-2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);

        System.out.println(formatter.format(localDate));

// для работы с датами не зависимо какого они формата и региона
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();


    }

    public void methodDate1(String lines) throws ParseException {
        //работа со старым объектом даты
        SimpleDateFormat formatter1=new SimpleDateFormat("YYYY-MM-dd");
        Date startDate = formatter1.parse(lines);
        //
    }

    /**
    write line to txt file
     */
public void writeLineToFile(String date, File myObj, String newLogin, String newPassword) throws IOException {
    FileWriter myWriter = new FileWriter("src/main/java/filename.txt", true);
    myWriter.write( "\r\n"+ date +"$"+newLogin+"$"+newPassword);
    myWriter.close();
    System.out.println("Successfully wrote to the file.");

    if (myObj.exists()) {
        System.out.println("File name: " + myObj.getName());
        System.out.println("Absolute path: " + myObj.getAbsolutePath());
        System.out.println("Writeable: " + myObj.canWrite());
        System.out.println("Readable " + myObj.canRead());
        System.out.println("File size in bytes " + myObj.length());
    } else {
        System.out.println("The file does not exist.");
    }

    //                List<String> lines = Files.readAllLines(Paths.get(fileName));
//                System.out.println(lines);

    //***** Read/Create  FileWriter

//                FileWriter writer = new FileWriter("MyFile.txt", true);
//                writer.write("Hello World");
//                writer.write("\r\n");   // write new line
//                writer.write("Good Bye!");
//                writer.close();
//
//                FileReader reader = new FileReader("src/main/java/filename.txt");
//                BufferedReader bufferedReader = new BufferedReader(reader);
//
//                String line1;
//
//                while ((line1 = bufferedReader.readLine()) != null) {
//                    System.out.println(line1);
//                }
//                reader.close();

}

    /**
     * create new file or use old one and return file object
     * write txt file name without .txt index
     * @param filename
     * @throws IOException
     */
    public File createNewFileOrUseOld(String filename) throws IOException {
    File myObj = new File("src/main/java/"+filename+".txt");
    if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
    } else {
        System.out.println("File already exists.");
    }

    return myObj;
}

    /**
     * Get credentials
     * read and return last line of txt file parsing to Credentials object
     * or parse false to Credentials existCredentials value
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public Credentials getLastCredential(File file) throws FileNotFoundException {
    //****** read line by one Scanner
    Credentials credentials = new Credentials();
    Scanner sc = new Scanner(file);

    List<String> line = new LinkedList<String>();

    /**
     * read all line from txt  file and add to list<string>
     */
    while (sc.hasNextLine()) {
        line.add(sc.nextLine());
    }
    sc.close();

    /**
     * if line has not zero and get last line of file and split it by $ to array
     * or if line has zero, add null to first element to array
     */
    if(line.size() != 0){

        String lines [] = line.get(line.size()-1).split("\\$");
        credentials.setCredExist(true);
        credentials.setUserId(lines[2]);
        credentials.setPassword(lines[3]);
        credentials.setCreatedDate(lines[0]);
        credentials.setCreatedTime(lines[1]);

    }else {
        credentials.setCredExist(false);
    }

    return credentials;
    //********


//                FileInputStream inputStream = new FileInputStream("src/main/java/filename.txt");
//                InputStreamReader reader = new InputStreamReader(inputStream, "UTF-16");
//                int character;
//
//                while ((character = reader.read()) != -1) {
//                    System.out.print((char) character);
//                }
//                reader.close();

}

    /**
     * get new credential and write new credential to filename.txt and return Credentials
     * @return
     * @throws Exception
     */
    public Credentials getNewCredAndWriteToAFile(String date, File myFile) throws Exception {

        Credentials credentials = new Credentials();

        navigate(REGISTRATION_URL.toString());

        registrationPage.enterEmailToField("email@ddd.com");
        registrationPage.clickToSubmitButton();
    //
        String login = registrationPage.getUserLogin();
        String password = registrationPage.getUserPassword();

        writeLineToFile(date, myFile, login, password);

        credentials.setUserId(login);
        credentials.setPassword(password);
        credentials.setCreatedDate(date);
        credentials.setCredExist(true);

    return credentials;
}

    /**
     * Login to system with UserId and password
     */
    public void loginToSystem (String userId, String password) throws Exception {
        navigate(LOGIN_URL.toString());

        loginPage.typeToUserIdField(userId);
        loginPage.typeToPasswordField(password);
        loginPage.clickLoginButton();

    }

/**
 * Define last date and define if it needs new one registration
 */
public boolean isNewRegistrationNeed(Credentials credentials){
    LocalDate nowDate = LocalDate.now();
    LocalDate lastStartDate;
    boolean needNewReg = true;


    /**
     * if less than 20 days, default value is "false"
     */
    if (credentials.isCredExist()){
        lastStartDate = LocalDate.parse(credentials.getCreatedDate());
        int amountOfDays = lastStartDate.getDayOfYear() - nowDate.getDayOfYear();
        if ( amountOfDays < 20){
            needNewReg = false;
        }

    }

    return needNewReg;
}

}
