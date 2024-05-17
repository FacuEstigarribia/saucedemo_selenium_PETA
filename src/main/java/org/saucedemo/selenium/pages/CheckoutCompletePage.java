package org.saucedemo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    private final WebDriver driver;
    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;
    public CheckoutCompletePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public HomePage clickBackHomeButton(){
        backHomeButton.click();
        return new HomePage(driver);
    }
}
