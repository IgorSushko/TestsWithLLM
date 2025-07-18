package miltimodalLLM;

import dataProvider.RequestToLLM;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RecognizeTextOnPictureTest {
    String baseUrl = "http://localhost:1234/v1";
    String endPointMethod = "/chat/completions";

    @Test
    public void recognizeExpectedWordOnPicture() throws IOException {

        String llmResponse = given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(RequestToLLM.getRequestToRecognizeImage())
                .log().all().
                when()
                .post(endPointMethod).
                then()
                .log().all()
                .statusCode(200)
                .extract().body().jsonPath().getString("choices[0].message.content");

        assertThat(llmResponse).as("Response from LLM doesn't equal to expected")
                .isEqualToIgnoringCase("yes");
    }
}
