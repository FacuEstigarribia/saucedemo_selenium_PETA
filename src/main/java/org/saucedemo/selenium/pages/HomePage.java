package org.saucedemo.selenium.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.selenium.utils.HoverMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    private final WebDriver driver;
    private WebElement hoverElement;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;
    @FindBy(css = "select.product_sort_container")
    private WebElement filter;
    @FindBy(css = "#shopping_cart_container > a")
    private WebElement cart;
    @FindBy(xpath = "//span[@class='title']")
    private WebElement title;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //Methods for menu
    public HoverMenu selectMenuOptions(){
        Actions action = new Actions(driver);
        action.moveToElement(menuButton).click().perform();
        return new HoverMenu(driver,hoverElement);
    }

    //Methods for filter
    public void selectFromDropdown(String option){
        findDropdownElement().selectByValue(option);
    }
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    //Methods for shopping cart
    public ShoppingCartPage goShoppingCart(){
        selectAndClickLocator(cart);
        return new ShoppingCartPage(driver);
    }
    public String check(){
        return title.getText();
    }

    //Helper methods
    private void selectAndClickLocator(WebElement locator){
        locator.click();
    }
    private Select findDropdownElement(){
        return new Select(filter);
    }

    public boolean isCartPresent(){
        return cart.isEnabled();
    }
}
