package com.cocosun.learn.junit.test.api.customer;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cocosun.learn.junit.base.BaseWithCookieTest;

public class CustomerApiTest extends BaseWithCookieTest {

    @Test
    void testGetUsersPageDeleteBtnShow() throws Exception {
        mockMvc.perform(get("/api/customers")
                .with(authCookie()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(4)); // 👈 length check
    }
}
