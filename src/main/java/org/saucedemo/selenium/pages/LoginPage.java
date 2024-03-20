package org.saucedemo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;
    @FindBy(id = "user-name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "div.error-message-container")
    private WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void setStandardUsername(){
        username.sendKeys("standard_user");
    }
    public void setLockedUsername(){
        username.sendKeys("locked_out_user");
    }
    public void setProblemUsername(){
        username.sendKeys("problem_user");
    }
    public void setPerformanceUsername(){
        username.sendKeys("performance_glitch_user");
    }
    public void setPassword(){
        password.sendKeys("secret_sauce");
    }
    public HomePage clickLoginButton(){
        loginButton.click();
        return new HomePage(driver);
    }
    public String errorMessage(){
        return errorMessage.getText();
    }


    //Methods for data driver
    public void setUsernameDP(String user){
        username.sendKeys(user);
    }
    public void setPasswordDP(String password){
        this.password.sendKeys(password);
    }
}
