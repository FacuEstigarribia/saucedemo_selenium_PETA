package org.saucedemo.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.saucedemo.selenium.utils.HoverMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;
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

    @FindBy(xpath = "(//div[@data-test='inventory-list'])//div[@class='inventory_item']")
    private List<WebElement> products;

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
        cart.click();
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

    public boolean isHomePageOpen(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    public void addProductToCartStream(String productName) {
        //String productName = "Sauce Labs Bike Light";

        // Find the product element by name
        WebElement productElement = products.stream()
                .filter(p -> {
                    WebElement nameElement = p.findElement(By.xpath(".//div[@data-test='inventory-item-name']"));
                    return nameElement != null && nameElement.getText().equals(productName);
                })
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));

        // Find the 'Add to Cart' button within the product element and click it
        WebElement addToCartButton = productElement.findElement(By.xpath(".//button[contains(@class, 'btn')]"));
        addToCartButton.click();
    }

    public void addProductsToCart(String productName) {
        Optional<WebElement> productToAdd = products.stream()
                .filter(product -> {
                    WebElement nameElement = product.findElement(By.xpath(".//div[@data-test='inventory-item-name']"));
                    return nameElement.getText().equals(productName);
                })
                .findFirst();

        if (productToAdd.isPresent()) {
            WebElement productElement = productToAdd.get();
            WebElement addToCartButton = productElement.findElement(By.xpath(".//button[contains(@class, 'btn')]"));

            if (addToCartButton.isDisplayed() && addToCartButton.getText().equals("Add to cart")) {
                addToCartButton.click();
            } else {
                throw new RuntimeException("Add to cart button is not available or has unexpected text.");
            }
        } else {
            throw new RuntimeException("Product not found: " + productName);
        }
    }

}
