package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static String projectPath = System.getProperty("user.dir");

    private WebDriver driver;
    private WebDriverWait wait;

    public void setDriver(String browser, String appURL) {
        switch (browser) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("browser : " + browser + " is invalid, Launching Chrome as browser of choice...");
                driver = initFirefoxDriver(appURL);
        }
    }

    public void setWait() {
        wait = new WebDriverWait(driver, 30);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    private WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome...");
        System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
        return driver;
    }

    private WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching firefox...");
        System.setProperty("webdriver.gecko.driver", projectPath + "\\drivers\\chromedriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
        return driver;
    }

    @Parameters({"browserType", "appURL"})
    @BeforeClass
    public void initializeTestBaseSetup(@Optional("chrome")String browserType, @Optional("https://google.com") String appURL) {
        try {
            setDriver(browserType, appURL);
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
