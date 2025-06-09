package com.cocosun.learn.common.dataprovider;

import org.testng.annotations.DataProvider;

public class TestestngDataProvider {

    @DataProvider(name = "loginDataProvider")
    public Object[][] dataProvider4Login() {
        return new Object[][]{
            {"user1", "pass1", 5},
            {"user2", "password2", 8},
            {"user3", "password3", 9},
            {"user4", "password4", -6}};
    }

    @DataProvider(name = "searchDataProvider")
    public Object[][] dataProvider4Research() {
        return new Object[][]{
            {"New job"},
            {"issues"},
            {"help me"}
        };
    }
}
