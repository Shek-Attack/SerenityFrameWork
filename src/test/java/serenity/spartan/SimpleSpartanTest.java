package serenity.spartan;
import io.restassured.RestAssured;
import static net.serenitybdd.rest.SerenityRest.*;
import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.*;
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

    }

}
