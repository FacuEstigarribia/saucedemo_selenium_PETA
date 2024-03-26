import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.selenium.pages.HomePage;
import org.saucedemo.selenium.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumGridTest {
    protected WebDriver driver;
    String gridUrl="http://localhost:4444";
    protected LoginPage loginPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage= PageFactory.initElements(driver, LoginPage.class);
    }


    @Test
    public void testLoginSampleGrid(){
        loginPage.setStandardUsername();
        loginPage.setPassword();
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isCartPresent(), "Cart icon is not present. Home page was not opened");
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }
}
