package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(WebDriver driver, String xpathLocator) {
        driver.findElement(By.xpath(xpathLocator)).click();
    }

    public void sendKeys(WebDriver driver, String xpathLocator, CharSequence keys) {
        driver.findElement(By.xpath(xpathLocator)).sendKeys(keys);
    }

    public int getSize(WebDriver driver, String xpathLocator) {
        return driver.findElements(By.xpath(xpathLocator)).size();
    }

    public boolean isDisplayed(WebDriver driver, String xpathLocator) {
        return driver.findElement(By.xpath(xpathLocator)).isDisplayed();
    }

    public void getLink(WebDriver driver, String link) {
        driver.get(link);
    }

    public String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public void selectDropdownByValue(WebDriver driver, String xpathLocator, String value) {
        new Select(driver.findElement(By.xpath(xpathLocator))).selectByValue(value);
    }

    public void waitElementToBeClickable(WebDriverWait wait, String xpathLocator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
    }

    public void waitElementToBeVisibility(WebDriverWait wait, String xpathLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
    }

    public void waitPresenceOfNestedElements(WebDriverWait wait, String xpathSelectLocator, String tagName) {
        wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.xpath(xpathSelectLocator), By.tagName(tagName)));
    }

    public void waitTitleIs(WebDriverWait wait, String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
    }
}
