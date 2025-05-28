package com.cocosun.learn.testng.test.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class BaseNGWithCookieTest extends BaseNGTest {

    @BeforeClass
    public void setup() {
        // Should use security way to pass user name and passowrd, example set env or call credential in CICD environment
        jwtToken = fetchTokenFromLoginApi("sunny", "sunny");
    }

    private String fetchTokenFromLoginApi(String username, String password) {
        Response response = RestAssured
                .given()
                .baseUri("http://localhost:9080")
                .contentType("application/json")
                .body("{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }")
                .when()
                .post("api/auth/login")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();

        // Extract from Set-Cookie header
        String setCookie = response.getHeader("Set-Cookie");
        if (setCookie != null) {
            Pattern pattern = Pattern.compile(cookieName + "=([^;]+);");
            Matcher matcher = pattern.matcher(setCookie);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }

        throw new RuntimeException("Failed to get JWT token from login API.");
    }

    protected Cookie getAuthCookie() {
        return new Cookie.Builder(cookieName, jwtToken).build();
    }
}
