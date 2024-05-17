import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.selenium.pages.HomePage;
import org.saucedemo.selenium.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;
import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class ParallelizationTest {
    private static final Log LOGGER = LogFactory.getLog(HomePage.class);
    private WebDriver driver;
    protected LoginPage loginPage;
    String gridUrl = "http://localhost:4444/wd/hub";

    String url = "https://www.saucedemo.com";

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
            driver.get(url);
            loginPage= PageFactory.initElements(driver, LoginPage.class);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
            driver.get(url);
            loginPage= PageFactory.initElements(driver, LoginPage.class);
        } else {
            throw new IllegalArgumentException("Browser parameter is invalid: " + browser);
        }
    }
    @Test
    public void testWithSpecifiedBrowser() {
        LOGGER.info("Title in " + driver.getClass().getSimpleName() + ": " + driver.getTitle());
        loginPage.setStandardUsername();
        loginPage.setPassword();
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertFalse(homePage.isCartPresent());
    }
    @Test
    public void testProblemUser(){
        loginPage.setProblemUsername();
        loginPage.setPassword();
        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void quitChrome(){
        driver.quit();
    }
    @AfterMethod
    public void quitFirefox(){
        driver.quit();
    }
}

