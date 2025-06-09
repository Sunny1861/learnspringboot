package com.cocosun.learn.testng.test.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

@SpringBootTest
public abstract class BaseNGTest extends AbstractTestNGSpringContextTests {

    @Value("${jwt.cookie.name}")
    protected String cookieName;

    @Value("${jwt.redis.key.prefix}")
    protected String redisKeyPrefix;

    @Value("${spring.base.url}")
    protected String testBasicUri;

    protected String jwtToken;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("[LOG] Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("[LOG] Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("[LOG] Before Class: " + this.getClass().getSimpleName());
    }

    @BeforeMethod
    public void beforeMethod(java.lang.reflect.Method method) {
        System.out.println("[LOG] Before Method: " + method.getName());
    }

    @AfterMethod
    public void afterMethod(java.lang.reflect.Method method) {
        System.out.println("[LOG] After Method: " + method.getName());
    }

    @AfterClass
    public void afterClass() {
        System.out.println("[LOG] After Class: " + this.getClass().getSimpleName());
    }

    @AfterTest
    public void afterTest() {
        System.out.println("[LOG] After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("[LOG] After Suite");
    }
}
