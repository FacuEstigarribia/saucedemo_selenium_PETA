package login;

import base.BaseTest;
import base.dataProvider.DataProviderClass;
import base.dataProvider.ItemsData;
import base.dataProvider.LoginData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.saucedemo.selenium.pages.LoginPage;
import org.saucedemo.selenium.pages.ShoppingCartPage;
import org.saucedemo.selenium.utils.PageUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.saucedemo.selenium.pages.HomePage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(base.Listener.class)
public class LoginTest extends BaseTest {
    protected static boolean isLoggedIn = false;

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

    @Test(dataProviderClass =  LoginData.class , dataProvider = "userDetail", groups = {"login"})
    public void testLoginStandardCredential(String user, String password){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.setUsernameDP(user);
        loginPage.setPasswordDP(password);
        HomePage homePage = loginPage.clickLoginButton();
        assertTrue(homePage.isHomePageOpen(), "Home page is not open");
        //isLoggedIn = true;
    }

//    public static boolean isLoggedIn(){
//        return isLoggedIn;
//    }
    @Test(dependsOnMethods = {"testLoginStandardCredential"})
    public void testAddItemToCart(){
        HomePage homePage = new HomePage(getDriver());
        homePage.addProductToCartStream("Sauce Labs Bolt T-Shirt");
        ShoppingCartPage shoppingCartPage = homePage.goShoppingCart();
        assertTrue(shoppingCartPage.isCartPageOpen(), "Cart page is not open");
    }

    @Test(dataProviderClass = ItemsData.class, dataProvider = "itemsDetail",dependsOnMethods = {"testLoginStandardCredential"})
    public void testAddMultipleItemsToCart(String[] items){
        HomePage homePage = new HomePage(getDriver());
        for (String item : items) {
            homePage.addProductsToCart(item);
        }

        ShoppingCartPage shoppingCartPage = homePage.goShoppingCart();
        assertTrue(shoppingCartPage.isCartPageOpen(), "Cart page is not open");

        for (String item : items) {
            assertTrue(shoppingCartPage.isProductInCart(item), "Product not found in cart: " + item);
        }
    }

    @Test(dependsOnMethods = {"testLoginStandardCredential"})
    public void testFindAndClickElement() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//button[contains(@class, 'btn')]"));

        // Find the first element with specific text and click it
        PageUtils.findAndActOnFirstElement(elements,
                element -> "Add to cart".equals(element.getText()),
                WebElement::click);

    }

    @Test(dependsOnMethods = {"testLoginStandardCredential"})
    public void testCountElements() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//button[contains(@class, 'btn')]"));

        // Count how many element has a specific class
        long count = PageUtils.countElements(elements,
                element -> element.getAttribute("class").contains("btn"));

        assertEquals(count, 6, "The count of elements with the expected class is incorrect.");
    }
}
