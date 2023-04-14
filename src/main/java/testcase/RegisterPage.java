package testcase;

import action.BaseSetup;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.RegisterPageObject;
import utils.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Register Tests")
public class RegisterPage extends RegisterPageObject {
    @Test (priority = 0, description="Invalid Register Scenario with empty input")
//    @Description("Test Description: Invalid Register Scenario with empty input")
    @Story("Empty input")
    public void TC_01_RegisterWithEmptyData() {
        getFBLink();
        clickToCreateAccountButton();

//		clickToFirstName();
//		clickToLastName();
//		clickToEmail();
//		clickToPassword();
        clickToRegisterSubmitButton();

        clickToFirstName();

        if (getFirstNameErrorSize() > 0) {
            Assert.assertTrue(checkFirstNameErrorDisplayed());
        } else {
            System.out.println("Failed firstname input");
            Assert.fail();
        }

        clickToEmail();

        if (getEmailErrorSize() > 0) {
            Assert.assertTrue(checkEmailErrorDisplayed());
        } else {
            System.out.println("Failed email input");
            Assert.fail();
        }
    }

    @Test
    @Story("Register with invalid phone number")
    public void TC_02_RegisterWithInvalidPhoneNumber() {
        getFBLink();
        clickToCreateAccountButton();

        sendKeysToFirstName("");
        sendKeysToLastName("Minh");
        sendKeysToEmail("03488888");
        sendKeysToPassword("Test@12345");

        selectBirthDayDayDropdown("12");
        selectBirthDayMonthDropdown("2");
        selectBirthDayYearDropdown("2000");
        clickToFemaleRadioButton();

        clickToRegisterSubmitButton();

        if (getPhoneFormatErrorSize() > 0) {
            Assert.assertTrue(checkPhoneFormatErrorDisplayed());
        } else {
            System.out.println("Failed phone number input");
            Assert.fail();
        }
    }

//
//    @Test
//    public void TC_03_LoginFormDisplayed() {
//        getFBLink();
//        clickToCreateAccountButton();
//
//        sendKeysToFirstName("Luong");
//        sendKeysToLastName("Minh");
//        sendKeysToEmail("0348886789");
//        sendKeysToPassword("Test@123456");
//
//        selectBirthDayDayDropdown("24");
//        selectBirthDayMonthDropdown("2");
//        selectBirthDayYearDropdown("2000");
//        clickToFemaleRadioButton();
//
//        clickToRegisterSubmitButton();
//
//        waitFacebookTitle();
//        Assert.assertNotEquals(getTitle(), "Facebook");
//    }


    @AfterClass
    public void afterClass() {
        quitDriver();
    }
//
//    @Test (priority = 0, description="Invalid Register Scenario with empty input")
//    @Description("Test Description: Invalid Register Scenario with empty input")
//    public void TC_01_RegisterWithEmptyData() {
//        Allure.step("Testttttttttttttttt");
//        registerPO.getFBLink();
//        registerPO.clickToCreateAccountButton();
//
////		clickToFirstName();
////		clickToLastName();
////		clickToEmail();
////		clickToPassword();
//        registerPO.clickToRegisterSubmitButton();
//
//        registerPO.clickToFirstName();
//
//        if (registerPO.getFirstNameErrorSize() > 0) {
//            Assert.assertTrue(registerPO.checkFirstNameErrorDisplayed());
//        } else {
//            System.out.println("Failed firstname input");
//            Assert.fail();
//        }
//
//        registerPO.clickToEmail();
//
//        if (registerPO.getEmailErrorSize() > 0) {
//            Assert.assertTrue(registerPO.checkEmailErrorDisplayed());
//        } else {
//            System.out.println("Failed email input");
//            Assert.fail();
//        }
//    }
//
//    @Test
//    public void TC_02_RegisterWithInvalidPhoneNumber() {
//        registerPO.getFBLink();
//        registerPO.clickToCreateAccountButton();
//
//        registerPO.sendKeysToFirstName("Luong");
//        registerPO.sendKeysToLastName("Minh");
//        registerPO.sendKeysToEmail("03488888");
//        registerPO.sendKeysToPassword("Test@12345");
//
//        registerPO.selectBirthDayDayDropdown("12");
//        registerPO.selectBirthDayMonthDropdown("2");
//        registerPO.selectBirthDayYearDropdown("2000");
//        registerPO.clickToFemaleRadioButton();
//
//        registerPO.clickToRegisterSubmitButton();
//
//        if (registerPO.getPhoneFormatErrorSize() > 0) {
//            Assert.assertTrue(registerPO.checkPhoneFormatErrorDisplayed());
//        } else {
//            System.out.println("Failed phone number input");
//            Assert.fail();
//        }
//    }
}
