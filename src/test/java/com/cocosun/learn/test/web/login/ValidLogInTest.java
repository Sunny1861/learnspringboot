package com.cocosun.learn.test.web.login;

import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cocosun.learn.common.base.BaseLoginTest;

public class ValidLogInTest extends BaseLoginTest {

    @Test
    void testGetUsersPageDeleteBtnShow() throws Exception {
        mockMvc.perform(get("/users")
                .with(authCookie()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Delete")));
    }
}
