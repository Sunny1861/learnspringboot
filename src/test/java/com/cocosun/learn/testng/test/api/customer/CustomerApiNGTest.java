package com.cocosun.learn.testng.test.api.customer;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import com.cocosun.learn.testng.test.base.BaseNGWithCookieTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerApiNGTest extends BaseNGWithCookieTest {

    @Test
    public void testGetCustomerById() {
        RestAssured.given()
                .baseUri("http://localhost:9080")
                .cookies(new Cookies(getAuthCookie()))
                .with()
                .accept(ContentType.JSON)
                .when()
                .get("/api/customers/2")
                .then()
                .statusCode(200)
                .body("name", equalTo("Alex"));
    }

    @Test
    public void testGetAllCustomerss() {
        RestAssured.given()
                .baseUri("http://localhost:9080")
                .cookies(new Cookies(getAuthCookie()))
                .accept(ContentType.JSON)
                .when()
                .get("/api/customers")
                .then()
                .statusCode(200)
                .body("name", equalTo(Arrays.asList("John", "Alex", "Leonid", "Kobi")));
    }
}
