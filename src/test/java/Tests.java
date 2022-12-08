import base_test.TestBase;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static ui_engine.Enums.EnvironmentUrls.REGISTRATION_URL;

public class Tests extends TestBase {

    @Test
    public void runDemoGuru_99() throws Exception {
        try {
//            navigate(REGISTRATION_URL.toString());
//
//            registrationPage.enterEmailToField("email@ddd.com");
//            registrationPage.clickToSubmitButton();
//
//            String login = registrationPage.getUserLogin();
//            String password = registrationPage.getUserPassword();
//            String a = null;

            String date = String.valueOf(LocalDate.now() +"$"+ LocalTime.now());

            try {
                File myObj = new File("src/main/java/filename.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }

                FileWriter myWriter = new FileWriter("src/main/java/filename.txt", true);
                myWriter.write( "\r\n"+ date +" $ "+"1Files in Java might be tricky, but it is fun enough!");
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

//****** read line by one Scanner
                Scanner sc = new Scanner(myObj);
                List<String> line = new LinkedList<String>();
                while (sc.hasNextLine()) {
                    line.add(sc.nextLine());
                    }
                int i = 0;
                for (String a: line) {
                    i++;
                    System.out.println(i + " - " + a);
                }

                System.out.println(line.get(line.size()-1));

                String lines [] = line.get(line.size()-1).split("\\$");
                for (String line1 : lines) {


                        System.out.println(line1);

                    //System.out.println(line1.split(" "));
                }
/**
 * 1. зайти на юай
 * 2. ввести имейл
 * 3. нажать кнопку получения новых креденшлов
 * 4. забрать новые креденшл с юай
 * 5. поставить дату и креденшлы в одну строку в тхт файле через $
 * 6. метод закоторый проверяет есть креденшлам 20 и более дней
 * 7. метод который автоматом запускает создание нового пользователя
 */

//                myObj.canWrite();
//                Scanner myReader = new Scanner(myObj);
//                while (myReader.hasNextLine()) {
//                    String data = myReader.nextLine();
//                    System.out.println(data);
//                }
//                myReader.close();

//********


//                FileInputStream inputStream = new FileInputStream("src/main/java/filename.txt");
//                InputStreamReader reader = new InputStreamReader(inputStream, "UTF-16");
//                int character;
//
//                while ((character = reader.read()) != -1) {
//                    System.out.print((char) character);
//                }
//                reader.close();

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
            // put it to the file TXT  - lo
            // use cred from file
            //
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
