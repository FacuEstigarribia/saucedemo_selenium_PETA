package home.filter;

import base.BaseTest;
import org.testng.annotations.Test;
import org.saucedemo.selenium.pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FilterTests extends BaseTest {
    @Test
    public  void testAZFilterOrder(){
        HomePage homePage = goHomePage();
        homePage.selectFromDropdown("az");
        var selectedOptions = homePage.getSelectedOptions();

        assertEquals(selectedOptions.size(),1,"Incorrect number of items.");
        assertTrue(selectedOptions.contains("A to Z"), "Option not selected");
    }
    @Test
    public  void testZAFilterOrder(){
        HomePage homePage = goHomePage();
        homePage.selectFromDropdown("za");
        var selectedOptions = homePage.getSelectedOptions();

        assertEquals(selectedOptions.size(),1,"Incorrect number of items.");
        assertTrue(selectedOptions.contains("Z to A"), "Option not selected");
    }
    @Test
    public void testLowHighPriceFilterOrder(){
        HomePage homePage = goHomePage();
        homePage.selectFromDropdown("lohi");
        var selectedOptions = homePage.getSelectedOptions();

        assertEquals(selectedOptions.size(),1,"Incorrect number of items.");
    }
    @Test
    public void testHighLowPriceFilterOrder(){
        HomePage homePage = goHomePage();
        homePage.selectFromDropdown("hilo");
        var selectedOptions = homePage.getSelectedOptions();

        assertEquals(selectedOptions.size(),1,"Incorrect number of items.");
    }


    private HomePage goHomePage(){
        loginPage.setStandardUsername();
        loginPage.setPassword();
        return loginPage.clickLoginButton();
    }
}
