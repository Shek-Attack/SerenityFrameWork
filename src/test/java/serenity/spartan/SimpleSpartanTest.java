package serenity.spartan;
import io.restassured.RestAssured;
import static net.serenitybdd.rest.SerenityRest.*;
import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

@SerenityTest
public class SimpleSpartanTest {

    @BeforeAll
    public static void setUp(){
         RestAssured.baseURI = "http://52.90.53.91:8000";
         RestAssured.basePath = "/api";
    }

    @AfterAll
    public static void cleanUp(){

        reset();
}

    @DisplayName("Sending hello using Spartan")
    @Test
    public void testingHelloEndPoint(){
        SerenityRest.
                when()

                .get("/hello")
//        .then()
//                .log().all()
//                .statusCode(200)
//                .contentType(ContentType.TEXT)
//                .body( is("Hello from Sparta") )
                ;
        //Serenity's way of generating some steps for verification
        // in the report using Ensure class
        Ensure.that("Make sure endpoint works",
                response -> response.
                         statusCode(200)
                        .contentType(ContentType.TEXT)
                        .body( is("Hello from Sparta"))
                );

        Ensure.that("Success response was recieved",
                thenResponse -> thenResponse
                        .statusCode(200) )

                        .andThat("I got text response",
                                blaResponse ->blaResponse
                                        .contentType(ContentType.TEXT)
                                )

                        .andThat("I got hello from Sparta",
                                vResponse -> vResponse
                                        .body(is("Hello from Sparta"))
                        )

                        .andThat("I got my response within 2 seconds",
                                vResponse -> vResponse.time(is(2L), TimeUnit.SECONDS)
                                )
                ;

    }

}
