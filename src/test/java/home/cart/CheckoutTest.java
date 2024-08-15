package home.cart;

import base.BaseTest;
//import base.dataProvider.CheckOutData;
import base.dataProvider.DataProviderClass;
import login.LoginTest;
import org.saucedemo.selenium.pages.*;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Listeners(base.Listener.class)
public class CheckoutTest extends BaseTest {
//    @Test(dataProviderClass = DataProviderClass.class , dataProvider = "searchProvider")
//    public void testData(String name, String surname, String zipCode, String message){
//        CheckoutPage checkoutPage = goCheckOutPage();
//        checkoutPage.typeFirstName(name);
//        checkoutPage.typeLastName(surname);
//        checkoutPage.typeZip(zipCode);
//        CheckoutOverviewPage checkOutOverview = checkoutPage.clickContinueButton();
//
//        if(message.isBlank()){
//            assertEquals(checkOutOverview.check(),"Checkout: Overview");
//        } else if (message.contains("First Name")) {
//            assertEquals(checkoutPage.textResult(),"Error: First Name is required");
//        } else if (message.contains("Last Name")) {
//            assertEquals(checkoutPage.textResult(),"Error: Last Name is required");
//        } else {
//            assertEquals(checkoutPage.textResult(),"Error: Postal Code is required");
//        }
//    }

//    @BeforeClass
//    public void setup() {
//        if (!LoginTest.isLoggedIn()) {
//            throw new SkipException("Login was not successful. Skipping checkout tests.");
//        }
//    }


    @Test(dependsOnGroups = {"src.test.java.login.LoginTest.testLoginStandardCredential"}, groups = {"checkout"})
    public void testCheckoutProcessForOneProduct(){
        HomePage homePage = new HomePage(getDriver());
        homePage.addProductToCartStream("Sauce Labs Bike Light");
        ShoppingCartPage shoppingCartPage = homePage.goShoppingCart();
        CheckoutPage checkoutPage = shoppingCartPage.goCheckout();
        checkoutPage.typeFirstName("george");
        checkoutPage.typeLastName("example");
        checkoutPage.typeZip("1234");
        CheckoutOverviewPage checkoutOverviewPage = checkoutPage.clickContinueButton();
        assertTrue(checkoutOverviewPage.isTitlePresent(), "Title of Checkout Overview page is not present");
    }
//    @Test
//    public void testLastNameFieldEmpty(){
//        CheckoutPage checkoutPage = goCheckOutPage();
//        checkoutPage.enterFirstName("example");
//        checkoutPage.enterLastName("");
//        checkoutPage.enterZip(1234);
//        checkoutPage.clickContinueButton();
//
//        //assertTrue(checkoutPage.isLastNameEmpty(),"Error: Last Name is required");
//        assertEquals(checkoutPage.textResult(),"Error: Last Name is required");
//    }
//    @Test
//    public void testZipFieldEmpty(){
//        CheckoutPage checkoutPage = goCheckOutPage();
//        checkoutPage.enterFirstName("example");
//        checkoutPage.enterLastName("example");
//        checkoutPage.enterZip();
//        checkoutPage.clickContinueButton();
//
//        //assertTrue(checkoutPage.isZipEmpty(),"Error: Postal Code is required");
//        assertEquals(checkoutPage.textResult(),"Error: Postal Code is required");
//    }
//    @Test
//    public void testZipFieldDataType(){
//        CheckoutPage checkoutPage = goCheckOutPage();
//        checkoutPage.enterFirstName("example");
//        checkoutPage.enterLastName("example");
//        checkoutPage.enterZip("");
//        checkoutPage.clickContinueButton();
//    }
//    @Test
//    public void testCancelButton(){
//        CheckoutPage checkoutPage = goCheckOutPage();
//        checkoutPage.clickCancelButton();
//        getWindowManager().goBack();
//    }



//    private CheckoutPage goCheckOutPage(){
//        LoginPage loginPage = new LoginPage(getDriver());
//        loginPage.setStandardUsername();
//        loginPage.setPassword();
//        return loginPage.clickLoginButton().goShoppingCart().goCheckout();
//    }
}
