package pageui;

public interface RegisterPageUI {

	String XPATH_FIRST_NAME = "//input[@name='firstname']";
	String XPATH_LAST_NAME = "//input[@name='lastname']";
	String XPATH_EMAIL = "//input[contains(@aria-label,'Mobile number or email')]";
	String XPATH_PASSWORD = "//input[@aria-label='New password']";
	String XPATH_BUTTON_REGISTER = "//button[@name='websubmit']";
	String XPATH_FIRST_NAME_ERROR = "//div[contains(text(),'s your name?')]";
	String XPATH_EMAIL_ERROR = "//div[contains(text(),'use this when you log in')]";
	String XPATH_PHONE_FORMAT_ERROR = "//div[contains(text(),'Please enter a valid mobile number1')]";
	String XPATH_CREATE_ACC_BUTTON = "//a[@data-testid='open-registration-form-button']";
	String XPATH_FEMALE = "//label[text()='Female']/following-sibling::input";
	String XPATH_CONFIRMATION_CODE_INPUT = "//h2[@class='uiHeaderTitle']";
	String XPATH_BIRTHDAY_DAY = "//select[@name='birthday_day']";
	String XPATH_BIRTHDAY_MONTH = "//select[@name='birthday_month']";
	String XPATH_BIRTHDAY_YEAR = "//select[@name='birthday_year']";

	String FB_LINK = "https://www.facebook.com/";
	String DROPDOWN_TAG_NAME = "option";
	String FB_TITLE = "Facebook";
}
