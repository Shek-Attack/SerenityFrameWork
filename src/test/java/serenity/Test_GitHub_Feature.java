package serenity;

import static net.serenitybdd.rest.SerenityRest.given;

import io.restassured.http.ContentType;
import static org.hamcrest.core.Is.is;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@SerenityTest
public class Test_GitHub_Feature {

    @DisplayName("This is serenity way of providing details")
    @Test
    @Tag("tag1")
    public void testGitHubGetOneUserEndpoitTest(){
       given()
                .contentType(ContentType.JSON)
                .pathParam("username","CybertekSchool")
        .when()
                .get("https://api.github.com/users/{username}")
         .then()
                .assertThat()
                .statusCode(200)
               // .log().all();
        ;
       //this is serenity way we can generate custome report for validation steps
        Ensure.that("Response was succesful ( instead of saying 200: )"
                , response -> response.statusCode(200)
        );

        Ensure.that("Test my GitHub Return the data1",
                response -> response.body("login",is("CybertekSchool")));


    }

}
