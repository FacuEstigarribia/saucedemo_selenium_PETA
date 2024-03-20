package org.saucedemo.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.saucedemo.selenium.pages.AboutPage;
import org.saucedemo.selenium.pages.HomePage;
import org.saucedemo.selenium.pages.LoginPage;

import java.time.Duration;

public class HoverMenu {
    private final WebDriver driver;
    private final WebElement menuOption;
    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsButton;
    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLinkButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutButton;
    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppButton;


    public HoverMenu(WebDriver driver, WebElement hoverElement) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.menuOption = hoverElement;
    }

    public boolean isMenuDisplayed(){
        return menuOption.isDisplayed();
    }
    public HomePage clickAllItems(){
        searchElement(allItemsButton);
        clickMenuOption(allItemsButton);
        return new HomePage(driver);
    }
    public AboutPage clickAboutLink(){
        searchElement(aboutLinkButton);
        clickMenuOption(aboutLinkButton);
        return new AboutPage(driver);
    }
    public LoginPage clickLogOut(){
        searchElement(logOutButton);
        clickMenuOption(logOutButton);
        return new LoginPage(driver);
    }
    public LoginPage clickResetApp(){
        searchElement(resetAppButton);
        clickMenuOption(resetAppButton);
        return new LoginPage(driver);
    }


    //Helper methods
    private void clickMenuOption(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }
    private void searchElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));

////          Another way with Javascript:
////        WebElement myElement = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(button));
////        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", myElement);
////        a.moveToElement(webElement).build().perform();
    }
}
