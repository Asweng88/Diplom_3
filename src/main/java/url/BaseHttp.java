package url;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class BaseHttp {

    private final String baseUrl = "https://stellarburgers.nomoreparties.site/";

    private final String JSON = "application/json";

    protected ValidatableResponse doPostRequest(String uri, Object body) {
        return given()
                .header("Content-Type", JSON)
                .body(body)
                .post(baseUrl + uri)
                .then();
    }

    protected ValidatableResponse doDeleteRequest(String uri, String accessToken) {
        return given()
                .header("Content-Type", JSON)
                .header("authorization", accessToken)
                .delete(baseUrl + uri)
                .then();
    }
}
