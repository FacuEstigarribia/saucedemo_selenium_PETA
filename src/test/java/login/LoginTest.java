package login;

import base.BaseTest;
import base.dataProvider.DataProviderClass;
import org.saucedemo.selenium.pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.saucedemo.selenium.pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(base.Listener.class)
public class LoginTest extends BaseTest {
    @Test(dataProviderClass = DataProviderClass.class , dataProvider = "searchProvider")
    public void testLogIn(String user, String password, String message){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.setUsernameDP(user);
        loginPage.setPasswordDP(password);
        HomePage homePage = loginPage.clickLoginButton();

        if(message.isBlank()){
            assertEquals(homePage.check(),"Products");
        } else if (message.contains("Password is required")) {
            assertEquals(message,"Epic sadface: Password is required");
        } else {
            assertEquals(message,"Epic sadface: Username and password do not match any user in this service");
        }
    }
}
