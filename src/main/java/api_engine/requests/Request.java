package api_engine.requests;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class Request {

    private String url = "http://demo.guru99.com";
    private String bathPath = "/V4/sinkministatement.php";

    @Test
    public void getResponse(){


        given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();

        int statusCode = given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .baseUri(url)
                .basePath(bathPath)
                .when().get().statusCode();

        given().when().get(url).then().assertThat().statusCode(200);

        Response get = get(url);

        Headers a = get.then().extract().headers();
        System.out.println(a);

        System.out.println("");
        System.out.println("Milliseconds: " + get.timeIn(TimeUnit.MILLISECONDS) );

        System.out.println("");

        System.out.println("content Type: " + get.then().extract().contentType());

        System.out.println();


//        ArrayList<String> amounts = when().get(url).then().extract().path("result.statements.AMOUNT") ;
//        int sumOfAll=0;
//        for(String c:amounts){
//
//            System.out.println("The amount value feidtched is "+a);
//            sumOfAll=sumOfAll+Integer.valueOf(a);
//        }
//        System.out.println("The total amount is "+sumOfAll);


        String b = "new";
    }

    @Test
    public void getResponseWithBasePath(){
         ValidatableResponse a = given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .baseUri(url)
                .basePath(bathPath)
                 .when().get().then().log().body();
        System.out.println(a);



    }

}
