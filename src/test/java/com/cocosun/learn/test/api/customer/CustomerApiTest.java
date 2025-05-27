package com.cocosun.learn.test.api.customer;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cocosun.learn.common.base.BaseLoginTest;

public class CustomerApiTest extends BaseLoginTest {

    @Test
    void testGetUsersPageDeleteBtnShow() throws Exception {
        mockMvc.perform(get("/api/customers")
                .with(authCookie()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(4)); // 👈 length check
    }
}
