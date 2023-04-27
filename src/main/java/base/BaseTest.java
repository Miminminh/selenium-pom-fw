package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static String projectPath = System.getProperty("user.dir");

    private WebDriver driver;
    private WebDriverWait wait;

    public void setDriver(String browser, String appURL, boolean headlessFlag) {
        switch (browser) {
            case "chrome":
                driver = initChromeDriver(appURL, headlessFlag);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL, headlessFlag);
                break;
            case "edge":
                driver = initEdgeDriver(appURL, headlessFlag);
                break;
            default:
                System.out.println("browser : " + browser + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURL, headlessFlag);
        }
    }

    public void setWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    private WebDriver initChromeDriver(String appURL, boolean headlessFlag) {
        System.out.println("Launching google chrome...");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // set chrome as Headless
        if (headlessFlag) {
            options.addArguments("--headless");
        }
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
        return driver;
    }

    private WebDriver initFirefoxDriver(String appURL, boolean headlessFlag) {
        System.out.println("Launching firefox...");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        // set firefox as Headless
        if (headlessFlag) {
            options.setHeadless(true);
        }
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
        return driver;
    }

    private WebDriver initEdgeDriver(String appURL, boolean headlessFlag) {
        System.out.println("Launching edge...");
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();


        // set edge as Headless
        if (headlessFlag) {
            options.addArguments("--headless");
        }
        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
        return driver;
    }

    @BeforeTest
    public void removeOldAllureReports() throws IOException {
        File file = new File("./allure-results");
        if (file.exists()) {
            FileUtils.cleanDirectory(file);
        }
    }

    @Parameters({"browserType", "appURL", "headlessFlag"})
    @BeforeClass
    public void initializeTestBaseSetup(@Optional("chrome") String browserType, @Optional("https://google.com") String appURL, @Optional("false") boolean headlessFlag) {
        try {
            setDriver(browserType, appURL, headlessFlag);
            setWait();
        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
