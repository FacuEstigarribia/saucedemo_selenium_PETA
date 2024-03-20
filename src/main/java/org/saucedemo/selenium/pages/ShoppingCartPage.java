package org.saucedemo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    private WebDriver driver;
    @FindBy(id = "continue-shopping")
    private WebElement home;
    @FindBy(id = "checkout")
    private WebElement checkout;

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
}
