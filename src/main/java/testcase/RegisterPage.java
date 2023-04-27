package testcase;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.RegisterPageObject;
import utils.extendreports.ExtentTestManager;
import utils.listeners.ExtentReportListener;
import utils.listeners.TestListener;
import utils.record.RecordVideo;

@Listeners({ExtentReportListener.class, TestListener.class})
@Epic("Regression Tests")
@Feature("Register Tests")
public class RegisterPage extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private RegisterPageObject registerPO;
    private static ExtentTest extentTest;

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    @BeforeClass
    public void beforeClass() throws Exception {
//        initializeTestBaseSetup("chrome", "https://google.com");
        driver = getDriver();
        wait = getWait();
        registerPO = new RegisterPageObject(driver, wait);
//        RecordVideo.startRecord("Register Page");
    }

    @Test(priority = 0, description = "Invalid Register Scenario with empty input")
//    @Description("Test Description: Invalid Register Scenario with empty input")
    @Story("Empty input")
    public void TC_01_RegisterWithEmptyData() {
        extentTest = ExtentTestManager.getTest();
        extentTest.log(Status.INFO, "User Name: ltnminh");
        registerPO.getFBLink();
        registerPO.clickToCreateAccountButton();
        registerPO.clickToRegisterSubmitButton();
        registerPO.clickToFirstName();

        if (registerPO.getFirstNameErrorSize() > 0) {
            Assert.assertTrue(registerPO.checkFirstNameErrorDisplayed());
        } else {
            System.out.println("Failed firstname input");
            Assert.fail();
        }

        registerPO.clickToEmail();

        if (registerPO.getEmailErrorSize() > 0) {
            Assert.assertTrue(registerPO.checkEmailErrorDisplayed());
        } else {
            System.out.println("Failed email input");
            Assert.fail();
        }
    }

    @Test
    @Story("Register with invalid phone number")
    public void TC_02_RegisterWithInvalidPhoneNumber() {
        registerPO.getFBLink();
        registerPO.clickToCreateAccountButton();

        registerPO.sendKeysToFirstName("Luong");
        registerPO.sendKeysToLastName("Minh");
        registerPO.sendKeysToEmail("03488888");
        registerPO.sendKeysToPassword("Test@12345");

        registerPO.selectBirthDayDayDropdown("12");
        registerPO.selectBirthDayMonthDropdown("2");
        registerPO.selectBirthDayYearDropdown("2000");
        registerPO.clickToFemaleRadioButton();

        registerPO.clickToRegisterSubmitButton();

        if (registerPO.getPhoneFormatErrorSize() > 0) {
            Assert.assertTrue(registerPO.checkPhoneFormatErrorDisplayed());
            extentTest.fail("Phone format error");
        } else {
            System.out.println("Failed phone number input");
            Assert.fail();
        }
    }


    @Test
    public void TC_03_LoginFormDisplayed() {
        registerPO.getFBLink();
        registerPO.clickToCreateAccountButton();

        registerPO.sendKeysToFirstName("Luong");
        registerPO.sendKeysToLastName("Minh");
        registerPO.sendKeysToEmail("0348886789");
        registerPO.sendKeysToPassword("Test@123456");

        registerPO.selectBirthDayDayDropdown("24");
        registerPO.selectBirthDayMonthDropdown("2");
        registerPO.selectBirthDayYearDropdown("2000");
        registerPO.clickToFemaleRadioButton();

        registerPO.clickToRegisterSubmitButton();
        registerPO.waitFacebookTitle();
        Assert.assertEquals(registerPO.getTitle(), "Facebook");
    }


    @AfterClass
    public void afterClass() throws Exception {
//        RecordVideo.stopRecord();
        registerPO.quitDriver();
    }
}
