package pageobject;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageui.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public RegisterPageObject(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Click to first name field")
    public void clickToFirstName() {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_FIRST_NAME);
        click(driver, RegisterPageUI.XPATH_FIRST_NAME);
    }

    public void clickToLastName() {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_LAST_NAME);
        click(driver, RegisterPageUI.XPATH_LAST_NAME);
    }

    public void clickToEmail() {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_EMAIL);
        click(driver, RegisterPageUI.XPATH_EMAIL);
    }

    public void clickToPassword() {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_PASSWORD);
        click(driver, RegisterPageUI.XPATH_PASSWORD);
    }

    @Step("Click to register submit button")
    public void clickToRegisterSubmitButton() {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_BUTTON_REGISTER);
        click(driver, RegisterPageUI.XPATH_BUTTON_REGISTER);
    }

    public void clickToFemaleRadioButton() {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_FEMALE);
        click(driver, RegisterPageUI.XPATH_FEMALE);
    }

    public void sendKeysToFirstName(String keys) {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_FIRST_NAME);
        sendKeys(driver, RegisterPageUI.XPATH_FIRST_NAME, keys);
    }

    public void sendKeysToLastName(String keys) {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_LAST_NAME);
        sendKeys(driver, RegisterPageUI.XPATH_LAST_NAME, keys);
    }

    public void sendKeysToEmail(String keys) {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_EMAIL);
        sendKeys(driver, RegisterPageUI.XPATH_EMAIL, keys);
    }

    public void sendKeysToPassword(String keys) {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_PASSWORD);
        sendKeys(driver, RegisterPageUI.XPATH_PASSWORD, keys);
    }

    public void selectBirthDayDayDropdown(String value) {
        waitPresenceOfNestedElements(wait, RegisterPageUI.XPATH_BIRTHDAY_DAY, RegisterPageUI.DROPDOWN_TAG_NAME);
        selectDropdownByValue(driver, RegisterPageUI.XPATH_BIRTHDAY_DAY, value);
    }

    public void selectBirthDayMonthDropdown(String value) {
        waitPresenceOfNestedElements(wait, RegisterPageUI.XPATH_BIRTHDAY_MONTH, RegisterPageUI.DROPDOWN_TAG_NAME);
        selectDropdownByValue(driver, RegisterPageUI.XPATH_BIRTHDAY_MONTH, value);
    }

    public void selectBirthDayYearDropdown(String value) {
        waitPresenceOfNestedElements(wait, RegisterPageUI.XPATH_BIRTHDAY_YEAR, RegisterPageUI.DROPDOWN_TAG_NAME);
        selectDropdownByValue(driver, RegisterPageUI.XPATH_BIRTHDAY_YEAR, value);
    }

    @Step("Go to FB link")
    public void getFBLink() {
        getLink(driver, RegisterPageUI.FB_LINK);
    }

    public String getTitle() {
        return getTitle(driver);
    }

    public void quitDriver() {
        quitDriver(driver);
    }

    public int getFirstNameErrorSize() {
        return getSize(driver, RegisterPageUI.XPATH_FIRST_NAME_ERROR);
    }

    public int getEmailErrorSize() {
        return getSize(driver, RegisterPageUI.XPATH_EMAIL_ERROR);
    }

    public int getPhoneFormatErrorSize() {
        return getSize(driver, RegisterPageUI.XPATH_PHONE_FORMAT_ERROR);
    }

    @Step("Click to create account button")
    public void clickToCreateAccountButton() {
        waitElementToBeClickable(wait, RegisterPageUI.XPATH_CREATE_ACC_BUTTON);
        click(driver, RegisterPageUI.XPATH_CREATE_ACC_BUTTON);
    }

    public boolean checkFirstNameErrorDisplayed() {
        return isDisplayed(driver, RegisterPageUI.XPATH_FIRST_NAME_ERROR);
    }

    public boolean checkPhoneFormatErrorDisplayed() {
        return isDisplayed(driver, RegisterPageUI.XPATH_PHONE_FORMAT_ERROR);
    }

    public void waitFacebookTitle() {
        waitTitleIs(wait, RegisterPageUI.FB_TITLE);
    }

    public boolean checkEmailErrorDisplayed() {
        return isDisplayed(driver, RegisterPageUI.XPATH_EMAIL_ERROR);
    }

}
