package restAction;

import static io.restassured.RestAssured.given;

public class LocalLLMActions {
    private final String baseUrl;
    private final String endPoint;

    public LocalLLMActions(String baseUrl, String endPoint) {
        this.baseUrl = baseUrl;
        this.endPoint = endPoint;
    }

    public String sendImageRecognitionRequest(String requestBody) {
        return given()
                .baseUri(baseUrl)
                .contentType("application/json")
                .body(requestBody)
                .log().all()
                .when()
                .post(endPoint)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("choices[0].message.content");
    }

}
