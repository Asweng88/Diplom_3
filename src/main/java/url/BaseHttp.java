package url;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class BaseHttp {

    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";

    private static final String JSON = "application/json";

    protected ValidatableResponse doPostRequest(String uri, Object body) {
        return given()
                .header("Content-Type", JSON)
                .body(body)
                .post(BASE_URI + uri)
                .then();
    }

    protected ValidatableResponse doDeleteRequest(String uri, String accessToken) {
        return given()
                .header("Content-Type", JSON)
                .header("authorization", accessToken)
                .delete(BASE_URI + uri)
                .then();
    }
}
