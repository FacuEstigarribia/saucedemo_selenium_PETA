package home.cart;

import base.BaseTest;
//import base.dataProvider.CheckOutData;
import base.dataProvider.CheckoutData;
import base.dataProvider.DataProviderClass;
import org.saucedemo.selenium.pages.CheckoutOverviewPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.saucedemo.selenium.pages.CheckoutPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Listeners(base.Listener.class)
public class CheckoutTests extends BaseTest {
    @Test(dataProviderClass = DataProviderClass.class , dataProvider = "searchProvider")
    public void testData(String name, String surname, String zipCode, String message){
        CheckoutPage checkoutPage = goCheckOutPage();
        checkoutPage.typeFirstName(name);
        checkoutPage.typeLastName(surname);
        checkoutPage.typeZip(zipCode);
        CheckoutOverviewPage checkOutOverview = checkoutPage.clickContinueButton();

        if(message.isBlank()){
            assertEquals(checkOutOverview.check(),"Checkout: Overview");
        } else if (message.contains("First Name")) {
            assertEquals(checkoutPage.textResult(),"Error: First Name is required");
        } else if (message.contains("Last Name")) {
            assertEquals(checkoutPage.textResult(),"Error: Last Name is required");
        } else {
            assertEquals(checkoutPage.textResult(),"Error: Postal Code is required");
        }
    }
    //    @Test
//    public void testFirstNameFieldEmpty(){
//        CheckoutPage checkoutPage = goCheckOutPage();
//        checkoutPage.enterFirstName("");
//        checkoutPage.enterLastName("example");
//        checkoutPage.enterZip(1234);
//        checkoutPage.clickContinueButton();
//
//        //assertTrue(checkoutPage.isFirstNameEmpty(),"");
//        assertEquals(checkoutPage.textResult(),"Error: First Name is required");
//    }
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
    @Test
    public void testCancelButton(){
        CheckoutPage checkoutPage = goCheckOutPage();
        checkoutPage.clickCancelButton();
        getWindowManager().goBack();
    }



    private CheckoutPage goCheckOutPage(){
        loginPage.setStandardUsername();
        loginPage.setPassword();
        return loginPage.clickLoginButton().goShoppingCart().goCheckout();
    }
}
