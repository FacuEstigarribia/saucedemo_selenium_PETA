package org.saucedemo.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {
    private WebDriver driver;
    @FindBy(id = "continue-shopping")
    private WebElement home;
    @FindBy(id = "checkout")
    private WebElement checkout;

    @FindBy(xpath = "//div[@data-test='inventory-item']")
    private List<WebElement> itemsList;

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public HomePage goHome(){
        home.click();
        return new HomePage(driver);
    }
    public CheckoutPage goCheckout(){
        checkout.click();
        return new CheckoutPage(driver);
    }

    public boolean isCartPageOpen(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html");
    }

    public boolean isProductInCart(String productName) {

        for (WebElement item : itemsList) {
            WebElement nameElement = item.findElement(By.xpath(".//div[@class='inventory_item_name']"));
            if (nameElement.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }
}
