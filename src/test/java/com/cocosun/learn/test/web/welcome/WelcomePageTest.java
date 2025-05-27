package com.cocosun.learn.test.web.welcome;

import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cocosun.learn.common.base.BaseLoginTest;

public class WelcomePageTest extends BaseLoginTest {

    @Test
    void testGetUsersPageDeleteBtnShow() throws Exception {
        mockMvc.perform(get("/welcome")
                .with(authCookie()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome, <span>sunny")));
    }
}
