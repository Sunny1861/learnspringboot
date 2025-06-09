package com.cocosun.learn.testng.test.api.login;

import org.testng.annotations.Test;

import com.cocosun.learn.common.dataprovider.TestestngDataProvider;
import com.cocosun.learn.testng.test.base.BaseTestNG;

public class LoginNGTest extends BaseTestNG {

    @Test(dataProvider = "loginDataProvider", dataProviderClass = TestestngDataProvider.class)
    public void loginTest(String user, String pass, int index) {
        System.out.println("--------------" + user + " " + pass + " " + index);
    }
}
