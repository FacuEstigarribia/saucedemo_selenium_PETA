package home.menu;

import base.BaseTest;
import org.saucedemo.selenium.pages.LoginPage;
import org.saucedemo.selenium.utils.HoverMenu;
import org.testng.annotations.Test;
import org.saucedemo.selenium.pages.AboutPage;
import org.saucedemo.selenium.pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MenuTest extends BaseTest {
//    @Test
//    public void testAllItemsButton(){
//        HoverMenu hoverMenu = goHomePage().selectMenuOptions();
//        assertTrue(hoverMenu.isMenuDisplayed(),"Menu isn't display");
//        hoverMenu.clickAllItems();
//    }
//    @Test
//    public void testAboutButton(){
//        HomePage homePage = goHomePage();
//        AboutPage aboutPage = homePage.selectMenuOptions().clickAboutLink();
//        assertEquals(aboutPage.getTitle(),
//                "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing");
//    }
//    @Test
//    public void testLogOut(){
//        HomePage homePage = goHomePage();
//        HoverMenu hoverMenu = homePage.selectMenuOptions();
//        hoverMenu.clickLogOut();
//    }
//    @Test
//    public void testResetApp(){
//        HomePage homePage = goHomePage();
//        homePage.selectMenuOptions().clickResetApp();
//    }
//    private HomePage goHomePage(){
//        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.setStandardUsername();
//        loginPage.setPassword();
//        return loginPage.clickLoginButton();
//    }
}
