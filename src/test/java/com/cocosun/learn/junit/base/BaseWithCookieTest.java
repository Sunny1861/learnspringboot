package com.cocosun.learn.junit.base;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import jakarta.servlet.http.Cookie;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseWithCookieTest extends BaseTest {

    // @Autowired
    // private Environment environment;
    protected String jwtCookie;

    @BeforeAll
    void authenticateAndStoreJwtCookie() throws Exception {

        // For enterprise project test, should keep the login information security, 2 options
        // option 1, for CICD, stored credential on CICD server, then get this env on automation
        // option 2, for test on local, save username and password in system env,read it if needed
        // Access via Environment
        // String tokenFromEnv = environment.getProperty("MY_SECURITY_TOKEN");
        //    **************I just hard code here for test practice, it is learn purpose.
        MvcResult result = mockMvc.perform(post("/api/auth/login")
                .contentType("application/json")
                .content("""
                    {
                        "username": "sunny",
                        "password": "sunny"
                    }
                """))
                // .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        jwtCookie = extractJwtFromCookieString(result.getResponse().getHeader("Set-Cookie"));
        assertNotNull(jwtCookie, "JWT cookie should not be null");
    }

    protected RequestPostProcessor authCookie() {
        return request -> {
            request.setCookies(new Cookie(cookieName, jwtCookie));
            return request;
        };
    }

    public String extractJwtFromCookieString(String cookieString) {
        for (String part : cookieString.split(";")) {
            part = part.trim();
            if (part.startsWith(cookieName + "=")) {
                return part.substring((cookieName + "=").length());
            }
        }
        return null;
    }
}
