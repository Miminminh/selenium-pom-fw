package com.allure;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcase1 {
    @Test
    public void testMethod1(){
        Assert.assertTrue(true);
        System.out.println("Test method1 is not working as expected");
    }
}
