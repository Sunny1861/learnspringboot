package com.cocosun.learn.test.web.admin;

import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cocosun.learn.common.base.BaseLoginTest;

public class ActiveUsersListTest extends BaseLoginTest {

    @Test
    void testGetUsersPageDeleteBtnShow() throws Exception {
        mockMvc.perform(get("/admin/active-users")
                .with(authCookie()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(redisKeyPrefix + "sunny")));
    }
}
